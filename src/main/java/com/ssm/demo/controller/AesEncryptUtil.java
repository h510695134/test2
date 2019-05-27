package com.ssm.demo.controller;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

public class AesEncryptUtil {


    //密钥 (需要前端和后端保持一致)
    private static final String KEY = "nineturn@cn12345";
    //算法
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * aes加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String aesEncrypt(String content) throws Exception {
        return aesEncrypt(content, KEY);
    }


    public static String uRLEncode(String str) {
        try {
            return URLEncoder.encode(aesEncrypt(str), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


    /**
     * base 64 encode
     *
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    public static String base64Encode(byte[] bytes) {
//        return Base64.encodeToString(bytes, Base64.NO_WRAP);
        return Base64Encoder.encode(bytes);
    }


    /**
     * AES加密
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        return cipher.doFinal(content.getBytes("utf-8"));
    }


    /**
     * AES加密为base 64 code
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /*
     * 解密
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    public static String AESDncode(String data ,String key)throws Exception{
        byte[] encryptedData  =  Base64.getDecoder().decode(data);
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k =
                new SecretKeySpec(key.getBytes("utf-8"), "AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] decrypted = c.doFinal(encryptedData);
        return new String(decrypted);
    }


    /**
     * 测试
     */
    public static void main(String[] args) throws Exception {
        String s = aesEncrypt("123456");
        System.out.println(s);
        String s1 = AESDncode(s, "nineturn@cn12345");
        System.out.println(s1);
    }

}
