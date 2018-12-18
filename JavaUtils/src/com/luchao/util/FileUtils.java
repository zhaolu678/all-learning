package com.luchao.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class FileUtils extends org.apache.commons.io.FileUtils {
	
	protected static Logger logger = Logger.getLogger(FileUtils.class);

	/**
	 * 判断文件是否为图片
	 * @param file
	 * @return
	 */
	public static Boolean isFileImage(File file) {
		try {
			BufferedImage image = ImageIO.read(file);  
		    return image != null;
		} catch(Exception e) {
			
		}
		return false;
	}
	
	/**
	 * 根据图片url，找出匹配的url，前提是必须生成按规格命名的缩略图
	 * @param sourceUrl
	 * @param suffix 如 -thumbnail
	 * @return
	 */
	public static String getImageType(String sourceUrl, String suffix) {
		if(StringUtils.isNotBlank(sourceUrl)) {
			if(sourceUrl.contains("-source") && !sourceUrl.contains(suffix)) {
				String extension = "jpg";
				String prefix = sourceUrl.substring(0, sourceUrl.lastIndexOf("-source"));
				return prefix + suffix + "." + extension;
			} else if(sourceUrl.contains("-large") && !sourceUrl.contains(suffix)) {
				String extension = "jpg";
				String prefix = sourceUrl.substring(0, sourceUrl.lastIndexOf("-large"));
				return prefix + suffix + "." + extension;
			} else if(sourceUrl.contains("-medium") && !sourceUrl.contains(suffix)) {
				String extension = "jpg";
				String prefix = sourceUrl.substring(0, sourceUrl.lastIndexOf("-medium"));
				return prefix + suffix + "." + extension;
			} else if(sourceUrl.contains("-thumbnail") && !sourceUrl.contains(suffix)) {
				String extension = "jpg";
				String prefix = sourceUrl.substring(0, sourceUrl.lastIndexOf("-thumbnail"));
				return prefix + suffix + "." + extension;
			}
		}
		return sourceUrl;
	}
	
	/**
	 * 根据图片url，找出匹配的缩略图url，前提是必须生成按规格命名的缩略图
	 * @param sourceUrl
	 * @return
	 */
	public static String getImageThumbnail(String sourceUrl) {
		return getImageType(sourceUrl, "-thumbnail");
	}
	
	/**
	 * 根据图片url，找出匹配的中等大小缩略图url，前提是必须生成按规格命名的缩略图
	 * @param sourceUrl
	 * @return
	 */
	public static String getImageMedium(String sourceUrl) {
		return getImageType(sourceUrl, "-medium");
	}
	
	/**
	 * 根据图片url，找出匹配的大缩略图url，前提是必须生成按规格命名的缩略图
	 * @param sourceUrl
	 * @return
	 */
	public static String getImageLarge(String sourceUrl) {
		return getImageType(sourceUrl, "-large");
	}
	
	/**
	 * 根据图片http地址获取图片并生成临时文件
	 * @param strUrl
	 * @return
	 */
	public static File getImageFileFromNetByUrl(String strUrl) {
		try {
			File file = File.createTempFile(System.currentTimeMillis() + "-img", ".tmp");
			FileUtils.copyURLToFile(new URL(strUrl), file);
			
			return file;
		} catch(Exception e) {
			logger.error("getImageFileFromNetByUrl error: ", e);
		}
		
		return null;
	}
	
	/** 
     * 根据地址获得数据的字节流 
     * @param strUrl 网络连接地址 
     * @return 
     */  
    public static byte[] getImageFromNetByUrl(String strUrl) {
        try {  
            URL url = new URL(strUrl);  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5 * 1000);  
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
            return btImg;  
        } catch (Exception e) {  
            logger.error("error: ", e);
        }  
        return null;  
    }
    
    /** 
     * 从输入流中获取数据 
     * @param inStream 输入流 
     * @return 
     * @throws Exception 
     */  
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len=inStream.read(buffer)) != -1 ){  
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    }
	
	public static void main(String[] args) {
		System.out.println("===" + getImageThumbnail("http://aa.bb.cc/aa-source-aa.jpg"));
	}
	
}
