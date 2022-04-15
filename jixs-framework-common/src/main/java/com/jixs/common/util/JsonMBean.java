package com.jixs.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.*;

/**
 * JsonMBean 工具类
 *
 * @author jixs
 * @date 2022-04-15 9:44
 */
public class JsonMBean implements Map, Serializable {
    /**
     * json串转换成map对象
     */
    private Map map;
    /**
     * 初始化json串
     */
    private String jsonString;
    /**
     * 初始值是否发生变化
     */
    private boolean isChange = false;

    public JsonMBean() {
        map = new LinkedHashMap<String, Object>();
        isChange = true;
    }


    public JsonMBean(String in) {
        jsonString = in;
        map = JSON.parseObject(in, LinkedHashMap.class);
    }

    /**
     * 从json串获取节点值，支持A.B[index].C方式获取
     *
     * @param path  节点路劲
     * @param clazz 节点值类型
     * @param <T>   类型
     * @return 节点值
     */
    public <T> T getObject(String path, Class<T> clazz) {
        return (T) getObject(map, path);
    }

    /**
     * 从json串获取节点值，支持A.B[index].C方式获取
     *
     * @param path 节点路径
     * @return 节点值
     */
    public Object getObject(String path) {
        return getObject(map, path);
    }

    /**
     * 设置json节点值，支持A.B[index].C 方式设置
     *
     * @param path  节点路径
     * @param value 节点值
     */
    public void setObject(String path, Object value) {
        if (null == path || "".equals(path)) {
            return;
        }
        set(map, path, value);
    }

    /**
     * 节点值获取内部方方法
     *
     * @param map  map
     * @param path 节点路径
     * @return 节点值
     */
    private Object getObject(final Map map, final String path) {
        if (null == path || "".equals(path) || null == map) {
            return null;
        }
        Map subMap = map;
        String[] keys = path.split("\\.");
        if (keys.length < 2) {
            return subMap.get(path);
        }
        Map tmp;
        Object o;
        int index;
        int arrIndex;
        String tmpKey;
        String tmpIndex;
        for (int i = 0; i < keys.length - 1; i++) {
            if (null == subMap) {
                return null;
            }
            tmpKey = keys[i];
            index = tmpKey.indexOf('[');
            if (index > 0) {
                tmpIndex = tmpKey.substring(index + 1);
                tmpIndex = tmpIndex.substring(0, tmpIndex.length() - 1);
                tmpKey = tmpKey.substring(0, index);
                arrIndex = Integer.parseInt(tmpIndex);
                o = subMap.get(tmpKey);
                if (null == o) {
                    tmp = null;
                } else {
                    if (o instanceof List) {
                        tmp = (Map) ((List) o).get(arrIndex);
                    } else {
                        tmp = null;
                    }
                }
                subMap = tmp;
            } else {
                subMap = (Map) subMap.get(keys[i]);
            }
        }
        if (null == subMap) {
            return null;
        }
        return subMap.get(keys[keys.length - 1]);
    }

    /**
     * 节点值设置内部方法
     *
     * @param map   map
     * @param path  路径
     * @param value 值
     */
    private void set(final Map map, final String path, Object value) {
        if (null == path || "".equals(path)) {
            return;
        }
        isChange = true;
        Map subMap = map;
        String[] keys = path.split("\\.");
        if (keys.length < 2) {
            subMap.put(path, value);
            return;
        }
        Map tmp;
        Object o;
        int index;
        int arrIndex;
        String tmpKey;
        String tmpIndex;
        for (int i = 0; i < keys.length - 1; i++) {
            tmpKey = keys[i];
            index = tmpKey.indexOf('[');
            if (index > 0) {
                tmpIndex = tmpKey.substring(index + 1);
                tmpIndex = tmpIndex.substring(0, tmpIndex.length() - 1);
                tmpKey = tmpKey.substring(0, index);
                arrIndex = Integer.parseInt(tmpIndex);
                o = subMap.get(tmpKey);
                if (null == o) {
                    tmp = null;
                } else {
                    if (o instanceof List) {
                        tmp = (Map) ((List) o).get(arrIndex);
                    } else {
                        tmp = null;
                    }
                }
            } else {
                tmp = (Map) subMap.get(keys[i]);
            }
            if (null == tmp) {
                tmp = new LinkedHashMap();
                subMap.put(keys[i], tmp);
            }
            subMap = tmp;
        }
        subMap.put(keys[keys.length - 1], value);
    }

    @Override
    public String toString() {
        if (!isChange) {
            return jsonString;
        }
        jsonString = JSONObject.toJSONString(map);
        isChange = false;
        return jsonString;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return map.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        if (key instanceof String && value instanceof Map) {
            this.set(map, (String) key, value);
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return map.entrySet();
    }


    public static void main(String[] args) {
        JsonMBean mBean = new JsonMBean("{\"ROOT\":{\"HEADER\":{},\"BODY\":{\"RUN_IP\":\"172.18.234.218\",\"REQUEST_ID\":\"20220412134934597_20348_257\",\"RETURN_CODE\":\"0\",\"RETURN_MSG\":\"OK\",\"USER_MSG\":\"OK\",\"DETAIL_MSG\":\"OK\",\"OUT_DATA\":{\"TOTAL_COUNT\":112,\"PACKAGE_LIST\":[{\"PAG_ID\":\"542\",\"PAG_NAME\":\"DIA业务开通\",\"PAG_CODE\":\"DIAAutoOpen\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.9\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PL\",\"STATE_NAME\":\"已发布\",\"REMARKS\":\"DIA业务开通\",\"CREATE_TIME\":\"2022-04-02 10:39:14\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1229\",\"PAG_ID\":\"542\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-04-02 10:39:14\",\"SPENT_TIME\":64,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1230\",\"PAG_ID\":\"542\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-04-02 10:39:56\",\"SPENT_TIME\":475,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1231\",\"PAG_ID\":\"542\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-04-02 10:40:00\",\"SPENT_TIME\":1915,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"},{\"PROD_ID\":\"1232\",\"PAG_ID\":\"542\",\"OP_TYPE\":\"TS\",\"OP_TYPE_NAME\":\"测试\",\"OP_TIME\":\"2022-04-02 10:40:04\",\"SPENT_TIME\":1,\"OP_STAFF\":\"foster_wu\",\"OP_NOTES\":\"跳过编排包测试\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"测试完成\"},{\"PROD_ID\":\"1233\",\"PAG_ID\":\"542\",\"OP_TYPE\":\"FB\",\"OP_TYPE_NAME\":\"反馈\",\"OP_TIME\":\"2022-04-02 10:40:09\",\"SPENT_TIME\":1150,\"OP_STAFF\":\"foster_wu\",\"OP_NOTES\":\"编排包测试反馈\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"反馈成功\"},{\"PROD_ID\":\"1234\",\"PAG_ID\":\"542\",\"OP_TYPE\":\"PL\",\"OP_TYPE_NAME\":\"发布\",\"OP_TIME\":\"2022-04-02 10:40:13\",\"SPENT_TIME\":6,\"OP_STAFF\":\"foster_wu\",\"OP_NOTES\":\"编排包发布\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"发布成功\"}]},{\"PAG_ID\":\"541\",\"PAG_NAME\":\"5G业务切片开通PST\",\"PAG_CODE\":\"NET_SLICE_SIGN\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.15\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PA\",\"STATE_NAME\":\"已解析\",\"REMARKS\":\"5G业务切片开通PST\",\"CREATE_TIME\":\"2022-03-31 10:45:21\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1207\",\"PAG_ID\":\"541\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-31 10:45:21\",\"SPENT_TIME\":169,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1208\",\"PAG_ID\":\"541\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-31 10:45:47\",\"SPENT_TIME\":270,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1209\",\"PAG_ID\":\"541\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-31 10:45:55\",\"SPENT_TIME\":4604,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"}]},{\"PAG_ID\":\"540\",\"PAG_NAME\":\"IPT业务开通\",\"PAG_CODE\":\"IPTAutoOpen\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.5\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"FB\",\"STATE_NAME\":\"已反馈\",\"REMARKS\":\"IPT业务开通\",\"CREATE_TIME\":\"2022-03-30 06:54:01\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1202\",\"PAG_ID\":\"540\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-30 06:54:01\",\"SPENT_TIME\":4,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1203\",\"PAG_ID\":\"540\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-30 06:54:27\",\"SPENT_TIME\":243,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1204\",\"PAG_ID\":\"540\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-30 06:54:32\",\"SPENT_TIME\":1568,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"},{\"PROD_ID\":\"1205\",\"PAG_ID\":\"540\",\"OP_TYPE\":\"TS\",\"OP_TYPE_NAME\":\"测试\",\"OP_TIME\":\"2022-03-30 06:55:34\",\"SPENT_TIME\":1,\"OP_STAFF\":\"foster_wu\",\"OP_NOTES\":\"跳过编排包测试\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"测试完成\"},{\"PROD_ID\":\"1206\",\"PAG_ID\":\"540\",\"OP_TYPE\":\"FB\",\"OP_TYPE_NAME\":\"反馈\",\"OP_TIME\":\"2022-03-30 06:55:42\",\"SPENT_TIME\":1110,\"OP_STAFF\":\"foster_wu\",\"OP_NOTES\":\"编排包测试反馈\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"反馈成功\"}]},{\"PAG_ID\":\"535\",\"PAG_NAME\":\"切片资源勘查PST\",\"PAG_CODE\":\"SliceResourceExplorationPST\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.14\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PA\",\"STATE_NAME\":\"已解析\",\"REMARKS\":\"切片资源勘查PST\",\"CREATE_TIME\":\"2022-03-28 17:57:55\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1161\",\"PAG_ID\":\"535\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-28 17:57:55\",\"SPENT_TIME\":5,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1164\",\"PAG_ID\":\"535\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-28 17:58:06\",\"SPENT_TIME\":232,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1165\",\"PAG_ID\":\"535\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-28 17:58:11\",\"SPENT_TIME\":2654,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"}]},{\"PAG_ID\":\"534\",\"PAG_NAME\":\"5G业务切片开通PST\",\"PAG_CODE\":\"NET_SLICE_SIGN\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.12\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PA\",\"STATE_NAME\":\"已解析\",\"REMARKS\":\"5G业务切片开通PST\",\"CREATE_TIME\":\"2022-03-28 17:56:55\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1160\",\"PAG_ID\":\"534\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-28 17:56:55\",\"SPENT_TIME\":7,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1162\",\"PAG_ID\":\"534\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-28 17:58:00\",\"SPENT_TIME\":1324,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1163\",\"PAG_ID\":\"534\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-28 17:58:04\",\"SPENT_TIME\":1807,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"}]},{\"PAG_ID\":\"533\",\"PAG_NAME\":\"切片资源勘查PST\",\"PAG_CODE\":\"SliceResourceExplorationPST\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.13\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PA\",\"STATE_NAME\":\"已解析\",\"REMARKS\":\"切片资源勘查PST\",\"CREATE_TIME\":\"2022-03-28 13:50:06\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1157\",\"PAG_ID\":\"533\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-28 13:50:06\",\"SPENT_TIME\":7,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1158\",\"PAG_ID\":\"533\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-28 13:50:08\",\"SPENT_TIME\":219,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1159\",\"PAG_ID\":\"533\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-28 13:50:11\",\"SPENT_TIME\":892,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"}]},{\"PAG_ID\":\"532\",\"PAG_NAME\":\"5G业务切片开通PST\",\"PAG_CODE\":\"NET_SLICE_SIGN\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.11\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PA\",\"STATE_NAME\":\"已解析\",\"REMARKS\":\"5G业务切片开通PST\",\"CREATE_TIME\":\"2022-03-28 13:48:25\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1154\",\"PAG_ID\":\"532\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-28 13:48:25\",\"SPENT_TIME\":57,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1155\",\"PAG_ID\":\"532\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-28 13:48:30\",\"SPENT_TIME\":504,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1156\",\"PAG_ID\":\"532\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-28 13:48:35\",\"SPENT_TIME\":2305,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"}]},{\"PAG_ID\":\"531\",\"PAG_NAME\":\"5G业务切片开通PST\",\"PAG_CODE\":\"NET_SLICE_SIGN\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.10\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"DL\",\"STATE_NAME\":\"已下载\",\"REMARKS\":\"5G业务切片开通PST\",\"CREATE_TIME\":\"2022-03-28 11:01:26\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1151\",\"PAG_ID\":\"531\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-28 11:01:26\",\"SPENT_TIME\":3,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1152\",\"PAG_ID\":\"531\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-28 11:01:37\",\"SPENT_TIME\":218,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1153\",\"PAG_ID\":\"531\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-28 13:40:33\",\"SPENT_TIME\":0,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":1,\"RESULT_NOTES\":\"errCode:19811012000001130,errMsg:rfs包解析异常:errCode:19811012000001290,errMsg:当前包【531】中没有获取到res_obj_102730006412_V1.0.0对应的资源服务对象\"}]},{\"PAG_ID\":\"530\",\"PAG_NAME\":\"切片资源勘查PST\",\"PAG_CODE\":\"SliceResourceExplorationPST\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.12\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"PA\",\"STATE_NAME\":\"已解析\",\"REMARKS\":\"切片资源勘查PST\",\"CREATE_TIME\":\"2022-03-25 17:00:32\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1143\",\"PAG_ID\":\"530\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-25 17:00:32\",\"SPENT_TIME\":2,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1146\",\"PAG_ID\":\"530\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-25 17:01:09\",\"SPENT_TIME\":225,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1147\",\"PAG_ID\":\"530\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-25 17:01:13\",\"SPENT_TIME\":1403,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包解析成功\"}]},{\"PAG_ID\":\"529\",\"PAG_NAME\":\"5G业务切片开通PST\",\"PAG_CODE\":\"NET_SLICE_SIGN\",\"PAG_TYPE\":\"zip\",\"MAJOR_VERSION\":\"V1.0.9\",\"MINOR_VERSION\":\"\",\"REVISION_VERSION\":\"\",\"STATE\":\"DL\",\"STATE_NAME\":\"已下载\",\"REMARKS\":\"5G业务切片开通PST\",\"CREATE_TIME\":\"2022-03-25 17:00:22\",\"PATH\":\"/portal/tosca/\",\"IS_DOWN\":\"Y\",\"PACKAGE_OPDETAIL_LIST\":[{\"PROD_ID\":\"1142\",\"PAG_ID\":\"529\",\"OP_TYPE\":\"SC\",\"OP_TYPE_NAME\":\"订阅\",\"OP_TIME\":\"2022-03-25 17:00:22\",\"SPENT_TIME\":12,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包订阅\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包订阅成功\"},{\"PROD_ID\":\"1144\",\"PAG_ID\":\"529\",\"OP_TYPE\":\"DL\",\"OP_TYPE_NAME\":\"下载\",\"OP_TIME\":\"2022-03-25 17:00:44\",\"SPENT_TIME\":5605,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包下载\",\"OP_RESULT\":0,\"RESULT_NOTES\":\"编排包下载成功\"},{\"PROD_ID\":\"1145\",\"PAG_ID\":\"529\",\"OP_TYPE\":\"PA\",\"OP_TYPE_NAME\":\"解析\",\"OP_TIME\":\"2022-03-28 10:54:05\",\"SPENT_TIME\":0,\"OP_STAFF\":\"system\",\"OP_NOTES\":\"编排包解析\",\"OP_RESULT\":1,\"RESULT_NOTES\":\"errCode:19811012000001130,errMsg:rfs包解析异常:errCode:19811012000001290,errMsg:当前包【】中没有获取到529对应的资源服务对象\"}]}]},\"PROMPT_MSG\":\"\"}}}");
        mBean.setObject("ROOT.BODY.OUT_DATA.TOTAL_COUNT", 120);
        mBean.setObject("ROOT.BODY.OUT_DATA.PACKAGE_LIST[0].AAA", "AAA");

        System.out.println(mBean.toString());
        System.out.println(mBean.getObject("ROOT.BODY.OUT_DATA.TOTAL_COUNT"));
        System.out.println(mBean.getObject("ROOT.BODY.OUT_DATA.PACKAGE_LIST", List.class));
        System.out.println(mBean.getObject("ROOT.BODY.OUT_DATA.PACKAGE_LIST[0].AAA"));

    }
}
