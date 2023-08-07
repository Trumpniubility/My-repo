package com.cqupt.utils;


import java.security.MessageDigest;


public class MD5Utils {
    public static String encryptMd5AndSalt(String data, String salt) {
        try {
            String pwdSalt =mergePwdAndSalt(data,salt);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pwdSalt.getBytes());
            byte[] resultBytes=md5.digest();
            return fromBytesToHex(resultBytes);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }

    }

    public static String mergePwdAndSalt(String data,String salt){
        if(data==null){
            data="";
        }
        if(salt==null||"".equals(salt)){
            return data;

        }
        return data+"{"+salt+"}";
    }

    public static String fromBytesToHex(byte[] resultBytes){
        StringBuilder builder =new StringBuilder();
        for (byte aByte : resultBytes) {
            if(Integer.toHexString(0xff&aByte).length()==1){
                builder.append("0").append(Integer.toHexString(0xff&aByte));
            }
            builder.append(Integer.toHexString(0xff&aByte));
        }
        return builder.toString();
    }
}