package com.luchao.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class CryptUtils {

	protected static Logger logger = Logger.getLogger(CryptUtils.class);
	
	public static final String DEFAULT_KEY = "AES_DEFAULT_KEY_123_*&^";
	public static final String KEY_AES = "AES";
	public static final String KEY_DES = "DES";
	
	private static SecretKeySpec generateKey(String keyType, String keyStr) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(keyType);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(keyStr.getBytes());
			if(keyType.equals(KEY_AES)) {
				kgen.init(128, secureRandom);
			} else if(keyType.equals(KEY_DES)) {
				kgen.init(56, secureRandom);
			}
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			return  new SecretKeySpec(enCodeFormat, keyType);
		} catch (Exception e) {
			logger.error("generateKey error: ", e);
		}
		
		return null;
	}
	
	/**
	 * 加密
	 * @param type 算法类型 支持 AES,DES
	 * @param content 加密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String type, String content, String key) throws Exception {
		try{  
			type = type.toUpperCase();
            SecretKeySpec secretKey = generateKey(type, key);
            byte[] byteContent = content.getBytes("utf-8");
            Cipher cipher = Cipher.getInstance(type);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(byteContent);  
            return byteArr2Hex(result);
        }  
        catch (Exception e){  
        	throw new Exception("encryt error", e);
        }  
	}
	
	/**
	 * 加密
	 * @param type 算法类型 支持 AES,DES
	 * @param content 加密内容
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String type, String content) throws Exception {
		return encrypt(type, content, DEFAULT_KEY);
	}
	
	/**
	 * AES 加密
	 * @param content 加密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public static String encryptAES(String content, String key) throws Exception {
		return encrypt(KEY_AES, content, key);
	}
	
	/**
	 * AES 加密
	 * @param content 加密内容
	 * @return
	 * @throws Exception
	 */
	public static String encryptAES(String content) throws Exception {
		return encrypt(KEY_AES, content, DEFAULT_KEY);
	}
	
	/**
	 * DES 加密
	 * @param content 加密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public static String encryptDES(String content, String key) throws Exception {
		return encrypt(KEY_DES, content, key);
	}
	
	/**
	 * DES 加密
	 * @param content 加密内容
	 * @return
	 * @throws Exception
	 */
	public static String encryptDES(String content) throws Exception {
		return encrypt(KEY_DES, content, DEFAULT_KEY);
	}
	
	/**
	 * MD5 加密
	 * @param content 加密内容
	 * @param salt 盐值
	 * @return
	 */
	public static String encryptMD5(String content, String salt) {
		return DigestUtils.md5Hex(content + "{" + salt + "}");
	}
	
	/**
	 * MD5 加密
	 * @param content 加密内容
	 * @return
	 */
	public static String encryptMD5(String content) {
		return DigestUtils.md5Hex(content);
	}
	
	/**
	 * SHA 加密
	 * @param content 加密内容
	 * @param salt 盐值
	 * @return
	 */
	public static String encryptSHA(String content, String salt) {
		return DigestUtils.shaHex(content + "{" + salt + "}");
	}
	
	/**
	 * SHA 加密
	 * @param content 加密内容
	 * @return
	 */
	public static String encryptSHA(String content) {
		return DigestUtils.shaHex(content);
	}
	
	/**
	 * 解密
	 * @param type 解密算法, 支持 AES, DES
	 * @param content 解密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String type, String content, String key) throws Exception {
		try{  
			type = type.toUpperCase();
			SecretKeySpec secretKey = generateKey(type, key);
			Cipher cipher = Cipher.getInstance(type);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] result = cipher.doFinal(hex2ByteArr(content));
			return new String(result, "utf-8");
        }  
        catch (Exception e){  
        	throw new Exception("decrypt error", e);
        }  
	}
	
	/**
	 * 解密
	 * @param type 解密算法, 支持 AES, DES
	 * @param content 解密内容
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String type, String content) throws Exception {
		return decrypt(type, content, DEFAULT_KEY);
	}
	
	/**
	 * AES 解密
	 * @param content 解密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public static String decryptAES(String content, String key) throws Exception {
		return decrypt(content, key);
	}
	
	/**
	 * AES 解密
	 * @param content 解密内容
	 * @return
	 * @throws Exception
	 */
	public static String decryptAES(String content) throws Exception {
		return decrypt(KEY_AES, content, DEFAULT_KEY);
	}
	
	/**
	 * DES 解密
	 * @param content 解密内容
	 * @param key 密钥
	 * @return
	 * @throws Exception
	 */
	public static String decryptDES(String content, String key) throws Exception {
		return decrypt(content, key);
	}
	
	/**
	 * DES 解密
	 * @param content 解密内容
	 * @return
	 * @throws Exception
	 */
	public static String decryptDES(String content) throws Exception {
		return decrypt(KEY_DES, content, DEFAULT_KEY);
	}
	
	/**
	 * 字节数组转化成16进制字符串
	 * @param bytes
	 * @return
	 */
	public static String byteArr2Hex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++){  
            if (((int) bytes[i] & 0xff) < 0x10) sb.append("0");  
            sb.append(Long.toString((int) bytes[i] & 0xff, 16));  
        }  
        return sb.toString();  
	}
	
	/**
	 * 将表示16进制值的字符串转换为byte数组
	 * @param strIn
	 * @return
	 * @throws Exception
	 */
	public static byte[] hex2ByteArr(String strIn) {    
        byte[] arrB = strIn.getBytes();    
        int iLen = arrB.length;      
        byte[] arrOut = new byte[iLen / 2];    
        for (int i = 0; i < iLen; i = i + 2) {    
            String strTmp = new String(arrB, i, 2);    
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);    
        }    
        return arrOut;    
    }
	
	public static void main(String[] args) throws Exception {
		String str = "ABCDEFJHK23579Uabc";
		String hex = byteArr2Hex(str.getBytes());
		System.out.println("orginal string: "+ str);
		System.out.println("byteArr2Hex: "+ hex);
		System.out.println("hexStr2ByteArr: "+ new String(hex2ByteArr(hex)));
		
		String cryptStr = "ilovechina";
		String crypted = encryptAES(cryptStr);
		System.out.println("original string: " + cryptStr);
		System.out.println("AES encrypt: " + crypted);
		System.out.println("AES decrypt: " + decryptAES(crypted));
		
		cryptStr = "iloveUSA";
		String desCrypted = encryptDES(cryptStr);
		System.out.println("original string: " + cryptStr);
		System.out.println("DES encrypt: " + desCrypted);
		System.out.println("DES decrypt: " + decryptDES(desCrypted));
		
		System.out.println("MD5: " + encryptMD5(cryptStr));
		System.out.println("SHA: " + encryptSHA(cryptStr));
	}
	

}
