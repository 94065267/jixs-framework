package com.jixs.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * http请求工具类
 *
 * @author jixs
 * @date 2022-01-19 11:49
 */
@Slf4j
public class HttpUtil {

    /**
     * http get请求
     *
     * @param reqUrl 请求地址
     * @return HttpResponse
     */
    public static HttpResponse doGet(String reqUrl) {
        return HttpUtil.doGet(reqUrl, null);
    }

    /**
     * http get请求
     *
     * @param reqUrl    请求地址
     * @param reqHeader 请求报文头
     * @return HttpResponse
     */
    public static HttpResponse doGet(String reqUrl, Map<String, String> reqHeader) {
        HttpGet httpGet = new HttpGet(reqUrl);
        if (reqHeader != null && !reqHeader.isEmpty()) {
            reqHeader.forEach(httpGet::setHeader);
        }
        HttpResponse response = null;
        try {
            response = HttpUtil.getHttpClient().execute(httpGet);
        } catch (IOException e) {
            log.error("{}请求报错：", reqUrl, e);
        }
        return response;
    }

    /**
     * http post请求
     *
     * @param reqUrl  请求地址
     * @param reqBody 请求报文体
     * @return HttpResponse
     */
    public static HttpResponse doPost(String reqUrl, String reqBody) {
        return HttpUtil.doPost(reqUrl, reqBody, null);
    }

    /**
     * http post请求
     *
     * @param reqUrl    请求地址
     * @param reqBody   请求报文体
     * @param reqHeader 请求报文头
     * @return HttpResponse
     */
    public static HttpResponse doPost(String reqUrl, String reqBody, Map<String, String> reqHeader) {
        if (reqHeader == null) {
            reqHeader = new HashMap<>(4);
        }
        if (reqHeader.get("Content-Type") == null || "".equals(reqHeader.get("Content-Type").trim())) {
            reqHeader.put("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        }

        HttpPost httpPost = new HttpPost(reqUrl);
        StringEntity reqEntity = new StringEntity(reqBody, "utf-8");
        reqEntity.setContentType(reqHeader.get("Content-Type"));
        reqHeader.forEach(httpPost::setHeader);
        httpPost.setEntity(reqEntity);
        HttpResponse response = null;
        try {
            response = HttpUtil.getHttpClient().execute(httpPost);
        } catch (IOException e) {
            log.error("{}请求报错：", reqUrl, e);
        }
        return response;
    }

    /**
     * http post请求
     *
     * @param reqUrl    请求地址
     * @param reqBody   请求报文体
     * @param reqHeader 请求报文头
     * @return HttpResponse
     */
    public static HttpResponse doPost(String reqUrl, MediaType mediaType, String reqBody, Map<String, String> reqHeader) {
        if (reqHeader == null) {
            reqHeader = new HashMap<>(4);
        }
        if (reqHeader.get("Content-Type") == null || "".equals(reqHeader.get("Content-Type").trim())) {
            reqHeader.put("Content-Type", MediaType.APPLICATION_JSON_VALUE + "; charset=" + "utf-8");
        }

        HttpPost httpPost = new HttpPost(reqUrl);
        StringEntity reqEntity = new StringEntity(reqBody, "utf-8");
        reqEntity.setContentType(reqHeader.get("Content-Type"));
        reqHeader.forEach(httpPost::setHeader);
        httpPost.setEntity(reqEntity);
        HttpResponse response = null;
        try {
            response = HttpUtil.getHttpClient().execute(httpPost);
        } catch (IOException e) {
            log.error("{}请求报错：", reqUrl, e);
        }
        return response;
    }

    /**
     * 获取httpclient
     *
     * @return HttpClient
     */
    private static HttpClient getHttpClient() {
        RegistryBuilder<ConnectionSocketFactory> schemeRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.getSocketFactory());
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sslcontext.init(null, new TrustManager[]{tm}, null);

            SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslcontext, NoopHostnameVerifier.INSTANCE);
            schemeRegistry.register("https", sf);

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }

        PoolingHttpClientConnectionManager conMan = new PoolingHttpClientConnectionManager(schemeRegistry.build());
        //对应池里允许的最大连接数100
        conMan.setMaxTotal(500);
        //每个域名允许最多20个连接
        conMan.setDefaultMaxPerRoute(100);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5 * 1000)
                .setConnectionRequestTimeout(30 * 1000)
                .setSocketTimeout(6 * 1000).build();
        return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(conMan)
                .setConnectionTimeToLive(-1 * 1000, TimeUnit.MILLISECONDS)
                .build();
    }

    public static void main(String[] args) {
        String url = "https://172.18.234.217:8092/wsg/call/def/com_sitech_iom_so_atom_inter_IQueryOrderInfoAoSvc_queryOrderList";
        String reqBody = "{\"ROOT\":{\"BODY\":{\"BUSI_INFO\":{\"PAGE_NUM\":\"1\",\"PAGE_SIZE\":\"5\",\"ORD_ID\":\"1234567890\",\"ACC_NBR\":\"\",\"EXT_ORD_ID\":\"\",\"ICCID\":\"\"},\"OPR_INFO\":{\"OP_CODE\":\"2004\"}}}}";

        HttpResponse httpResponse = HttpUtil.doPost(url,reqBody);

        try {
            StatusLine status = httpResponse.getStatusLine();
            int statusCode = status.getStatusCode();
            String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            log.debug("status={}，result={}", statusCode, result);
        } catch (IOException e) {
            log.error("返回处理报错：", e);
        }
    }

}
