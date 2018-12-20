package com.smxy.healthmedical.serviceImpl;

import com.smxy.healthmedical.service.UploadService;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
@Service
public class UploadServiceImpl implements UploadService {

	@Override
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		try {
			PrintWriter out = response.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String realpath=request.getServletContext().getRealPath("/upload");	
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload fileUpload=new ServletFileUpload(factory);
		try {
			List<FileItem> items=fileUpload.parseRequest((RequestContext) request);
			Iterator<FileItem> iterator =items.iterator();
			while(iterator.hasNext()){
				FileItem item=iterator.next();
				if (!item.isFormField()){
				String filePath=item.getName();
				String fileName=filePath.substring(filePath.lastIndexOf("\\")+1, filePath.length());
				item.write(new File(realpath+"/"+fileName));
				System.out.println(realpath);
				System.out.println(fileName);
				}
			}		
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
