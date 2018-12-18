package com.luchao.util;


import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class HttpUtils {
	
	protected static Logger logger = Logger.getLogger(HttpUtils.class);
	private static final int SOCKET_TIME_OUT = 6000;
	private static final int CONNECT_TIME_OUT = 6000;
	
	private static CloseableHttpClient getClient() {
		CloseableHttpClient client = HttpClients.createDefault();
		
		return client;
	}
	
	private static RequestConfig getRequestConfig(int socketTimeout, int connectTimeout) {
		return RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
	}
	
	private static RequestConfig getRequestConfig() {
		return getRequestConfig(SOCKET_TIME_OUT, CONNECT_TIME_OUT);
	}
	
	private static void checkParam(String url, Map<String, Object> param) {
		if(StringUtils.isNotBlank(url)) {
			String[] segs = url.split("\\?");
			if(segs.length > 1) {
				String[] segs2 = segs[1].split("&");
				if(segs2.length > 0) {
					for(String s : segs2) {
						String[] segs3 = s.split("=");
						if(segs3.length > 1) {
							param.put(segs3[0], segs3[1]);
						}
					}
				}
			}
		}
	}
	
	private static List<NameValuePair> createParam(Map<String, Object> param) {
		List<NameValuePair> nvps = new ArrayList <NameValuePair>();
		if(param != null) {
			for(String k : param.keySet()) {
				nvps.add(new BasicNameValuePair(k, param.get(k).toString()));
			}
		}
		
		return nvps;
	}
	
	private static HttpEntity sendGet(URI url) {
		CloseableHttpClient client = getClient();
		CloseableHttpResponse response = null;
		try {
			HttpGet req = new HttpGet(url);
			req.setConfig(getRequestConfig());
			
			response = client.execute(req);;
	        return response.getEntity();
		} catch(Exception e) {
			logger.error("sendGet error: ", e);
		}
		
		return null;
	}
	
	/**
	 * 发送 get 请求
	 * @param url 请求地址，如 http://www.baidu.com
	 * @param param 相关参数, 会附在URL后面
	 * @return
	 */
	public static String get(String url, Map<String, Object> param) {
		try {
			URIBuilder uri = new URIBuilder(url);
			param = param == null ? new HashMap<String, Object>() : param;
			checkParam(url, param);
			for(String k : param.keySet()) {
				uri.addParameter(k, param.get(k).toString());
			}
			
			HttpEntity entity = sendGet(uri.build());
			String result= EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
			return result;
		} catch(Exception e) {
			logger.error("get error: ", e);
		}
		
		return null;
	}
	
	/**
	 * 发送 get 请求
	 * @param url 请求地址，如 http://www.baidu.com
	 * @return
	 */
	public static String get(String url) {
		return get(url, null);
	}
	
	/**
	 * 请求url，并且结果为InputStream
	 * @param url
	 * @return
	 */
	public static HttpEntity getAsStream(String url) {
		try {
			URIBuilder uri = new URIBuilder(url);
			HttpEntity entity = sendGet(uri.build());
			
			return entity;
		} catch(Exception e) {
			logger.error("getAsStream error: ", e);
		}
		
		return null;
	}
	
	private static HttpEntity sendPost(String url, HttpEntity entity) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			HttpPost req = new HttpPost(url);
			req.setConfig(getRequestConfig());
			req.setEntity(entity);
			
			response = client.execute(req);
		    return response.getEntity();
		} catch(Exception e) {
			logger.error("sendPost error: ", e);
		} 
		
		return null;
	}
	
	/**
	 * 发送  post 请求
	 * @param url 请求地址，如 http://www.baidu.com
	 * @param param相关参数, 模拟form 提交
	 * @return
	 */
	public static String postForm(String url, Map<String, Object> param) {
		try {
			if(param != null) {
				HttpEntity entity = sendPost(url, new UrlEncodedFormEntity(createParam(param), Consts.UTF_8));
				String result= EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);
				return result;
			}
		} catch(Exception e) {
			logger.error("post error: ", e);
		} 
		
		return null;
	}
	
	/**
	 * 发送  post 请求
	 * @param url 请求地址，如 http://www.baidu.com
	 * @return
	 */
	public static String post(String url) {
		return postForm(url, null);
	}
	
	/**
	 * 发送  post 请求，并且结果为InputStream
	 * @param url
	 * @return
	 */
	public static HttpEntity postAsStream(String url) {
		try {
			HttpEntity entity = sendPost(url, null);
			return entity;
		} catch(Exception e) {
			logger.error("postAsStream error: ", e);
		} 
		
		return null;
	}
	
	/**
	 * 发送  post 请求
	 * @param url
	 * @param bodyText 写入到entity中
	 * @return
	 */
	public static String post(String url, String bodyText) {
		return post(url, bodyText, "text/plain");
	}
	
	/**
	 * 发送  post 请求
	 * @param url
	 * @param bodyText 写入到entity中
	 * @param contentType 默认为 text/plain
	 * @return
	 */
	public static String post(String url, String bodyText, String contentType) {
		try {
			ContentType ct = ContentType.create(contentType, "UTF-8");
			AbstractHttpEntity reqEntity = new StringEntity(bodyText, ct);
			reqEntity.setContentEncoding("UTF-8");
			HttpEntity entity = sendPost(url, reqEntity);
		    String result= EntityUtils.toString(entity, "UTF-8");
			EntityUtils.consume(entity);
			return result;
		} catch(Exception e) {
			logger.error("post error: ", e);
		} 
		
		return null;
	}
	
	private static String post(String url, String name, ContentBody... body) {
		try {
			if(body != null) {
				MultipartEntityBuilder builder = MultipartEntityBuilder.create();
				for(ContentBody cb : body) {
					builder.addPart(name, cb);
				}
				HttpEntity entity = sendPost(url, builder.build());
				String result= EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);
				return result;
			}
		} catch(Exception e) {
			logger.error("post error: ", e);
		} 
		
		return null;
	}
	
	/**
	 * 发送附件
	 * @param url 接收的url
	 * @param name 类似于文件域的名字
	 * @param file 支持多个文件
	 * @return
	 */
	public static String post(String url, String name, File... file) {
		if(file != null) {
			FileBody[] body = new FileBody[file.length];
			for(int i = 0 ; i < file.length ;i++) {
				body[i] = new FileBody(file[i]);
			}
			return post(url, name, body);
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("getTest:" + get("http://www.finalist.cn"));
	}

}
