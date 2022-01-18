package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.BulletinVO;

public class BulletinSelectController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "bulletin/bulletin.tiles";
		
		String id = req.getParameter("id");
		
		BulletinService service = new BulletinDAO();
		BulletinVO vo = service.selectONe(Integer.parseInt(id));
		
		req.setAttribute("bulletin", vo);
		
		HttpUtil.forward(req, resp, path);
	}

}
