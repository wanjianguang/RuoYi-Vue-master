package com.ruoyi.analysis.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * http 网络访问工具
 *
 * @author wonderful.
 * @version 3.0.0
 */
public class HttpClient {

    public static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    private String method = null;
    private String CONTENT_TYPE = null; //默认
    private String Platform=null;//默认
    
    /**
     * 默认POST
     *
     * @return String
     */
    public String getMethod() {
        if (method == null) {
            return "POST";
        }
        return method;
    }

    public String getCONTENT_TYPE() {
		return CONTENT_TYPE;
	}

	public void setCONTENT_TYPE(String cONTENT_TYPE) {
		CONTENT_TYPE = cONTENT_TYPE;
	}

	public String getPlatform() {
		return Platform;
	}

	public void setPlatform(String platform) {
		Platform = platform;
	}

	/**
     *  POST 或 GET 
     *
     * @param method .
     */
    public void setMethod(String method) {
        this.method = method;
    }
    
    /**
     * 执行调用 serviceURL地址 方法
     * @param serviceURL webService地址.
     * @param param String.
     * @param ContentType 请求的与实体对应的MIME信息   如：Content-Type: application/x-www-form-urlencoded,application/json,application/xml  
     * @return String.
     */
    public String pub(String serviceURL, String param,String contentType) {
        CONTENT_TYPE = contentType;
        return pub(serviceURL,param);
    }
    /**
     * 执行调用 serviceURL地址 方法
     * @param serviceURL webService地址.
     * @param param String.
     * @return String.
     */
    public String pub(String serviceURL, String param) {
        URL url = null;
        HttpURLConnection connection = null;
        StringBuffer buffer = new StringBuffer();
        LOGGER.info("request:" + serviceURL + "?" + param);
        try {
            url = new URL(serviceURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(getMethod());
            connection.setConnectTimeout(5000);//30秒连接
            connection.setReadTimeout(5*60*1000);//5分钟读数据
            connection.setRequestProperty("Content-Length", param.length() + "");
            if(CONTENT_TYPE != null){
                connection.setRequestProperty("Content-Type", CONTENT_TYPE);
            }           
            if(Platform != null){
                connection.setRequestProperty("Platform", Platform);
            } 
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(param.getBytes("UTF-8"));

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            reader.close();
        } catch (IOException e) {
            LOGGER.info(null, e);
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }

        LOGGER.info("response:" + buffer.toString());
        return buffer.toString();
    }
    
    
    
     public String doGet(String url) throws Exception{
        CloseableHttpClient httpclient = wrapClient(url); 
        CloseableHttpResponse  response = null;
        try {
			
        	 HttpGet httpGet = new HttpGet();
        	 httpGet.setURI(new URI(url));
        	 RequestConfig config = RequestConfig.custom()  
    					.setConnectTimeout(5000) //表示建立连接的timeout时间
    					.setSocketTimeout(10000).build();//表示数据传输处理时间
        	httpGet.setConfig(config);
        	response =  httpclient.execute(httpGet);
    		HttpEntity entity = response.getEntity();
			InputStream instreams = entity.getContent();
			return convertStreamToString(instreams);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(),e);
			throw new Exception(e.getMessage());
		}finally{
		    if(response != null){
               response.close();
            }
            if(httpclient != null){
               httpclient.close();
            }
		 }
     }
    
     
     private String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			is.close();
		}
		return sb.toString();
	}
    
    
    /**
     * 获取 HttpClient
     * @param host
     * @param path
     * @return
     */
    private  CloseableHttpClient wrapClient(String path) {
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (path != null && path.startsWith("https://")) {
            return sslClient();
        }
        return httpClient;
    }
    
	/**
     * 在调用SSL之前需要重写验证方法，取消检测SSL
     * 创建ConnectionManager，添加Connection配置信息
     * @return HttpClient 支持https
     */
    private  CloseableHttpClient sslClient() {
        try {
            // 在调用SSL之前需要重写验证方法，取消检测SSL
            X509TrustManager trustManager = new X509TrustManager() {
                @Override public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override public void checkClientTrusted(X509Certificate[] xcs, String str) {}
                @Override public void checkServerTrusted(X509Certificate[] xcs, String str) {}
            };
            SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
            ctx.init(null, new TrustManager[] { trustManager }, null);
            SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            // 创建Registry
            RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
                    .setExpectContinueEnabled(Boolean.TRUE).setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM,AuthSchemes.DIGEST))
                    .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https",socketFactory).build();
            // 创建ConnectionManager，添加Connection配置信息
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(requestConfig).build();
            return closeableHttpClient;
        } catch (KeyManagementException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }
 
    
    public String doPost(String url, String param) throws Exception {		 
		 
    	URI uri = new URI(url);
	    // 声明httpPost请求
		CloseableHttpClient httpclient = wrapClient(url);  
		CloseableHttpResponse  response = null;
		try {
			HttpPost httpPost = new HttpPost(uri);
			
			httpPost.addHeader("ContentType", "application/json;charset=UTF-8");
			httpPost.addHeader("Accept", "*/*");
			httpPost.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");			
			httpPost.addHeader("Accept-Encoding", "gzip, deflate, br");
			httpPost.addHeader("Connection", "keep-alive");
			httpPost.addHeader("anti-content", "0apWtxUkM_VeBfEmMppQPSL00TgpIeR1V7JVeazd4QejUa6nZ_EnTvYPEOGkl8lQCEnKKsxKLpFKlZGEYN-tdAkHq2YXLvyPbUyFolYiETYNYtXNKoy5JQXadVxHzVJtmsbfqF9OpZBoL2ypmRb10wocwZnLetFs9npuqIXnbocKz1YNjlpmwJzsVOGSTTYyUXdmzElSzplUgfqvjtpN9apujQX0x5FhTCluMUVSNgZf7AOk6_Im6ZOD6tZm6kKkM51D8ZMm64Om64Ze715kZgwb40ZhBU-C6t-kMvZey7xmJ3zkF3QKHL1SK60_UUw3CS-xw1RfwI64SK6jV122dndDbvGnxll4uW0V1YvNlwFrNapCzlUuYjUnavlmbNwExNAZkYnrBwBiidFrPxl4WWnKoYuzPjXfYygT_ldwjniwjlXZWgscnp5dG584K8f2cWGTlQv51q0yGqNVZ0XTncb984JKrXpzXWFmGnFaNqna-_XirGfgItzdVUBsa7VesWQ4hGUefBsFzlKIPDbpL7tc8-GAI4_7PMQcLAUhIJcpoBcUlEdt_9k2ag2rXY1HLfsDa9");
			httpPost.addHeader("Cookie", "_nano_fp=XpExn5dxlpUjnpT8n9_OSG2vueFbk2b1ihqe9GvX; api_uid=rBUU+WDy4K5dkQ2VwlKIAg==; _crr=ad3okzUBPMsJTm9aRH80tRSLFZ4k90vq; _bee=ad3okzUBPMsJTm9aRH80tRSLFZ4k90vq; _f77=61b59a69-adcc-478e-affd-1861095174e8; _a42=59e2a0ba-208c-464f-95e9-a6333b06d1ce; rcgk=ad3okzUBPMsJTm9aRH80tRSLFZ4k90vq; rckk=ad3okzUBPMsJTm9aRH80tRSLFZ4k90vq; ru1k=61b59a69-adcc-478e-affd-1861095174e8; ru2k=59e2a0ba-208c-464f-95e9-a6333b06d1ce; accesstoken=95657606ce0b606d87310bd990caaba37298c0546bbf; SUB_PASS_ID=x_eyJ0IjoiR2o2WkE1V3VLRUdTbjdkN3VtUzlGTm9YdXNCVDR1UFBiVnp5elJJWld1UzJrNG45eG1ZZU81UUpmekNiemlsVSIsInYiOjEsInMiOjEwMDcsInUiOjM1MTk2NTkyMDYzfQ==");
			
			//设置请求body
			StringEntity reqEntity = new StringEntity(param);
			reqEntity.setContentType("application/json;charset=UTF-8");
			httpPost.setEntity(reqEntity);

			RequestConfig config = RequestConfig.custom()  
					.setConnectTimeout(10000).setConnectionRequestTimeout(3000)  
					.setSocketTimeout(18000).build();  
			
			httpPost.setConfig(config);
			response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			InputStream instreams = entity.getContent();
			String str = convertStreamToString(instreams);
			return str;
		  } finally{
			  if(response != null){
	                try {
	                    response.close();
	                } catch (IOException e) {
	                	throw new IOException();
	                }
	            }
	            if(httpclient != null){
	                try {
	                    httpclient.close();
	                } catch (IOException e) {
	                	throw new IOException();
	                }
	            }
		 }
	}
    
    public static void main(String[] args) {
    	HttpClient client = new HttpClient();
    	
    	String param = "{\"id\":1001302,\"global_args\":{\"time_range\":\"30m\",\"start_time\":null,\"end_time\":null,\"start_date\":\"2021-08-25\",\"end_date\":\"2021-08-25\",\"sids\":\"9409\",\"abn_rsn\":\"false\",\"sortTypes\":\"-123456\",\"sortOosStates\":\"1,2,3\",\"monitormode\":\"1\"},\"data_type\":0,\"page_id\":3485,\"request_id\":\"万工-3608-1630142756301\",\"version\":\"4.0\"}";
    	
    	try {
			String sb = client.doPost("https://ddmc.pinduoduo.com/caspian/sms/api/data/queryChart",param);
			System.out.println(sb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
