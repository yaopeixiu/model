package com.example.demo0116.util;

import java.security.MessageDigest;

/**
 * MD5加密
 */
public class MD5 {
    /**
     * @param bytes 字节数组
     * @return MD5加密32位小写
     */
    public static String encrypt32(byte[] bytes) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(bytes);
            return byteArrayToHexString(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * MD5加密32位
     *
     * @param param 需要加密参数
     * @return 加密结果
     */
    public static String encrypt32(String param) {
        return encrypt32(param.getBytes());
    }

    /**
     * 将byte[]转16进制
     *
     * @param b 字节数组
     * @return 16进制字符
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (byte aB : b) {
            String hex = Integer.toHexString(aB & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            result.append(hex);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = encrypt32("s");
        System.out.println(s);

    }
}
