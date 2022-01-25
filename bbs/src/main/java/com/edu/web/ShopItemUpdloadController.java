package com.edu.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.google.gson.JsonObject;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ShopItemUpdloadController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = req.getServletContext();
		String uploadPath = context.getRealPath("/uploadItem");
		
		//new MultipartRequest("요청정보","저장위치","maxSize","encoding","rename정책");
		MultipartRequest multi = new MultipartRequest(req,uploadPath,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
		
		String name = null;
		String originalName = null;
		String fileType = null;
		String fileSystemName = null;
		String fileUrl = null;
		
		Enumeration names = multi.getFileNames();
		while(names.hasMoreElements()) {
			name = (String) names.nextElement();
			originalName = multi.getOriginalFileName(name);
			fileType = multi.getContentType(name);
			fileSystemName = multi.getFilesystemName(name);
			System.out.println("name : " + name);
			System.out.println("origin: " + originalName);
			System.out.println("type: " + fileType);
			System.out.println("system: " + fileSystemName);
			
			fileUrl = req.getContextPath() + "/uploadItem" + fileSystemName;
			
			// {"filename": fileSystemName, "uploaded": 1,"url":fileUrl}
			JsonObject json = new JsonObject();
			json.addProperty("fileName", fileSystemName);
			json.addProperty("uploaded", 1);
			json.addProperty("url", fileUrl);
			
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().print(json);
		}
	}

}
