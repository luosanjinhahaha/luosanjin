package com.smxy.healthmedical.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	private int code;
	private String msg;
	
	//返回给用户的数据
	public Map<String, Object> extend = new HashMap<String, Object>();
	
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("处理成功！");
		return result;
	} 
	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(400);
		result.setMsg("处理失败！");
		return result;
	} 
	
	public Msg add(String key, Object value) {
		// TODO 自动生成的方法存根
		this.getExtend().put(key, value);
		return this;
	}

	public Msg() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Msg(int code, String msg, Map<String, Object> extend) {
		super();
		this.code = code;
		this.msg = msg;
		this.extend = extend;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
}
