package com.aboutClass.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.alibaba.fastjson.JSONObject;

public abstract class AbstractController {
	private static final Logger log = LoggerFactory.getLogger(AbstractController.class);
	
	/**
	 * 格式输出结果 
	 * @param status 状态（0=成功，大于0表示失败 ）
	 * @param msg 描述
	 * @param data 数据 
	 * @return
	 */
	protected JSONObject FmtResult(int status,String msg,Object data) {
		JSONObject json = new JSONObject();
		json.put("status", status);// 状态
		json.put("msg", msg);// 描述
		json.put("data", data);//数据 
		return json;
	}
	/**
	 * 格式输出结果
	 * @param status 状态（0=成功，大于0表示失败 ）
	 * @param msg 描述
	 * @param pageNumber 当前页
	 * @param pageSize 页大小
	 * @param total 总记录数
	 * @param rows 当前页数据
	 * @return
	 */
	protected JSONObject FmtResult(int status,String msg,long pageNumber, long pageSize,long total ,Object rows) {
		if(pageSize<=0){
			pageSize=1;
		}
		JSONObject json = new JSONObject();
		json.put("status", status);// 状态
		json.put("msg", msg);// 描述
		json.put("pageNumber", pageNumber); //当前页
		json.put("pageSize", pageSize);//页大小
		json.put("pageCount", total/pageSize+(total%pageSize==0?0:1));//总页数
		json.put("total", total);//总记录数
		json.put("rows", rows);//当前页数据
		return json;
	}
	/**
	 * 前台输出数据
	 * @param response
	 * @param json
	 * @throws IOException
	 */
	protected void toWeb(HttpServletResponse response, String json) throws IOException{
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(json.toString());
	}
	/**
	 * APP json跨域请求
	 * @param response
	 * @param json
	 * @param callback
	 * @throws IOException
	 */
	protected void toWeb(HttpServletResponse response, String json,String callback) throws IOException{
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(callback+"("+json.toString()+")");
	}
	
	/**
	 * 解析uri编码
	 * @param str 需要编码的字符串
	 * @return 如果编码错误，则返回null
	 */
	protected String decode(String str){
		String target = null;
		try {
			target = URLDecoder.decode(str, "utf-8");
		} catch (Exception e) {
			log.error("param decode error");
		}
		return target;
	}
	
	public boolean checkToken(String token){
		boolean flag = false;
		if(StringUtils.isBlank(token)){
			flag = true;
		}
		return flag;
	}
	
	public boolean checkCall(String callId){
		boolean flag = false;
		if(StringUtils.isBlank(callId)){
			flag = true;
		}
		return flag;
	}
	/**
	 * 获得 session
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Map getSession(){
		Map session=(Map) getRequest().getSession();
		return session;
	}

	/**
	 * 获得request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 获得 response
	 * @return
	 */
	protected HttpServletResponse getResponse(){
		HttpServletResponse response = ((ServletWebRequest)RequestContextHolder.getRequestAttributes()).getResponse();
		return response;
	}

	/**
	 * 得到 系统路径
	 * @return
	 */
	protected String getRealPath(){
		return getRequest().getSession().getServletContext().getRealPath("/");
	}
	/**
	 * 获得全部路径
	 * @return
	 */
	protected String getBasePath(){
		return getRequest().getScheme()+"://"+getRequest().getServerName()+":"+getRequest().getServerPort()+getRequest().getContextPath()+"/";
	}
}
