package com.longjun.cto.framework.common.utils.security;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author carson deng
 * @date 2019/11/9 16:34
 */
public final class AESUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtil.class);

    public static final String UTF_8 = "UTF-8";

    public static final String SECRET_KEY = "eimsCQCAESUtils!";

    /**
     * 加密
     * @param content
     * @return
     */
    public static String encrypt(String content) {
        try {
            byte[] raw = SECRET_KEY.getBytes(UTF_8);
            if (raw.length != 16) {
                throw new IllegalArgumentException("Invalid key size." + SECRET_KEY);
            }
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));
            byte[] encry = cipher.doFinal(content.getBytes(UTF_8));
            return Base64.encodeBase64String(encry);
        } catch (Exception e) {
            LOGGER.error("encrypt failed,content:{}",content,e);
        }
        return null;
    }

    /**
     * 解密
     * @param content
     * @return
     */
    public static String decrypt(String content) {
        try {
            byte[] contentByte = Base64.decodeBase64(content);
            byte[] raw = SECRET_KEY.getBytes(UTF_8);
            if (raw.length != 16) {
                throw new IllegalArgumentException("Invalid key size. " + SECRET_KEY);
            }
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(new byte[16]));
            byte[] original = cipher.doFinal(contentByte);

            return new String(original, UTF_8);
        } catch (Exception e) {
            LOGGER.error("decrypt failed,content:{}",content,e);
        }
        return null;
    }
}
