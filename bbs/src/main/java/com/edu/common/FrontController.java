package com.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.web.BulletinAddController;
import com.edu.web.BulletinFormController;
import com.edu.web.BulletinListController;
import com.edu.web.BulletinSelectController;


public class FrontController extends HttpServlet {
	
	Map<String,Controller> map = null;
	
	@Override
	public void init() throws ServletException {
		map = new HashMap<String,Controller>();
		// url패턴 - 컨트롤러 등록
		map.put("/main.do", new MainController());
		
		// 게시판 컨트롤 
		map.put("/bulletinList.do", new BulletinListController());
		map.put("/bulletinForm.do", new BulletinFormController());
		map.put("/bulletinAdd.do", new BulletinAddController());
		map.put("/bulletinSelect.do", new BulletinSelectController());
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글처리.
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI(); // /edu2/memberList.do
		String context = req.getContextPath(); //  /edu2
		String path = uri.substring(context.length());
		
		Controller control = map.get(path);
		control.execute(req, resp);
	}
	
}
