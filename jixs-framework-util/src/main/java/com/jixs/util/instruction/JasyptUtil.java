package com.jixs.util.instruction;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * 说明：文件说明
 *
 * @author jixs_bj
 * @date 2023/8/23 8:45
 */
@Slf4j
public class JasyptUtil {
    public static String encode(String secretKey, String pwdPlaintext) {
        log.debug("密钥：{}，明文：{}", secretKey, pwdPlaintext);
        // jasypt
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(secretKey);
        // 加密
        return "ENC(" + textEncryptor.encrypt(pwdPlaintext) + ")";
    }

    public static String decode(String secretKey, String pwdCiphertext) {
        log.debug("密钥：{}，密文：{}", secretKey, pwdCiphertext);
        // jasypt
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(secretKey);
        // 解密
        if (pwdCiphertext.startsWith("ENC(")) {
            String decryptPassword = pwdCiphertext.substring(4, pwdCiphertext.length() - 1);
            log.debug("decryptPassword={}", decryptPassword);
            return textEncryptor.decrypt(decryptPassword);
        } else {
            return textEncryptor.decrypt(pwdCiphertext);
        }
    }

    public static void main(String[] args) {
        String plaintextSecretKey = "9KOl0SWEKYf8feYjv7dwWIobCXEuMz8t88xahe2IujJsjrWcZXjs6RNAU";
        String pwdPlaintext = "jdbc:mysql://137.0.17.232:8070/iomord?useUnicode=true&characterEncoding=utf-8";
        log.info("{}加密后：{}", pwdPlaintext, JasyptUtil.encode(plaintextSecretKey, pwdPlaintext));

        String ciphertextSecretKey = "9KOl0SWEKYf8feYjv7dwWIobCXEuMz8t88xahe2IujJsjrWcZXjs6RNAU";
        String pwdCiphertext = "ENC(Fs21CL3ut2eb1jLxj3AkdW9M4dhGH8tFHg1EL3DSr74=)";

        log.info("{}解密后：{}", pwdCiphertext, JasyptUtil.decode(ciphertextSecretKey, pwdCiphertext));
    }
}
