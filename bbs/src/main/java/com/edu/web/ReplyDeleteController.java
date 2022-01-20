package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;

public class ReplyDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		BulletinService service = new BulletinDAO();
		// {"retCode" : "Success"} <-> {"retcode": "Fail"}
		if (service.deleteReply(Integer.parseInt(id))) {
			resp.getWriter().print("{\"retCode\" : \"Success\"}");
		}else {
			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
		
	}

}
