package com.aboutClass.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtils {
	private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);
	/**
	 * 发送Http Request
	 * @param restUrl
	 * @param param
	 * @return String, 结果
	 */
	public String sendPost(String restUrl, String param) {
		HttpURLConnection httpurlconnection = null;
		try {
			String proy=PropetiesUtils.getKeyInfo("es.properties", "proy").toString();
			String port=PropetiesUtils.getKeyInfo("es.properties", "port").toString();
			String USE_PROY=PropetiesUtils.getKeyInfo("es.properties", "USE_PROY").toString();
			URL url = new URL(restUrl);
			if("true".equals(USE_PROY)){//使用代理
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proy, Integer.parseInt(port)));
				httpurlconnection = (HttpURLConnection) url.openConnection(proxy);
			}else{//不使用代理
				httpurlconnection = (HttpURLConnection) url.openConnection();
			}
			httpurlconnection.setRequestProperty("content-type", "text/html");
			httpurlconnection.setRequestProperty("Accept-Charset", "utf-8");
			httpurlconnection.setRequestProperty("contentType", "utf-8");
			httpurlconnection.setRequestMethod("POST");
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setDoInput(true);
			httpurlconnection.setUseCaches(false);
			httpurlconnection.getOutputStream().write(param.getBytes());
			httpurlconnection.getOutputStream().flush();
			httpurlconnection.getOutputStream().close();
			logger.info("send Post:【" + restUrl + "】.");
			logger.info("send Param:【" + param + "】.");
			if (200 == httpurlconnection.getResponseCode()) {
				return readContents(httpurlconnection);
			} else {
				//sendPost(restUrl, param);// 非正常情况 重发一次
				httpurlconnection.disconnect();
			}
		} catch (Exception e) {
			logger.error("send Post:【" + restUrl + "---" + param + "】 error.", e);
			//sendPost(restUrl, param);// 出错 重发一次
			httpurlconnection.disconnect();
		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();
		}
		return "";
	}

	/**
	 * 读取相应的内容
	 * @param httpurlconnection
	 * @return String,内容
	 * @throws IOException
	 */
	public static String readContents(HttpURLConnection httpurlconnection) throws IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
			StringBuffer temp = new StringBuffer();
			String inputLine = in.readLine();
			while (inputLine != null) {
				temp.append(inputLine.trim());
				inputLine = in.readLine();
			}
			return temp.toString();
		} catch (IOException e) {
			logger.error("readContents error", e.getMessage());
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				logger.error("readContents close BufferedReader error", e.getMessage());
				throw e;
			}
		}
	}
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
