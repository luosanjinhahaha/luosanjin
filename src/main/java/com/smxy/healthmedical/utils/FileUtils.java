package com.smxy.healthmedical.utils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import sun.misc.BASE64Encoder;
public class FileUtils {
	/**
	 * 下载文件时根据不同浏览器进行附件名的编码
	 * @param filename
	 * @param agent
	 * @return 编码后的下载附件名
	 * @throws UnsupportedEncodingException 
	 */
	public static String encodeDownloadFilename(String filename, String agent) throws UnsupportedEncodingException{
		if(agent.contains("Firefox")){
			filename = "=?UTF-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
			filename = filename.replaceAll("\r\n", "");
		}else{
			filename = URLEncoder.encode(filename, "utf-8");
			filename = filename.replace("+"," ");
		}
		return filename;
		
	}
}
