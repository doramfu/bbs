package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;

public class BulletinDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//입력값 -> 삭제 -> 리스트.
		String id = req.getParameter("id");
		
		BulletinService service = new BulletinDAO();
		service.delete(Integer.parseInt(id));
		
		resp.sendRedirect("bulletinList.do");
	}

}
