package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.NoticeService;
import com.edu.serviceImpl.NoticeDAO;
import com.edu.vo.NoticeVO;

public class NoticeUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String contnet = req.getParameter("content");
		System.out.println(id);
		System.out.println(title);
		System.out.println(contnet);
		
		NoticeVO vo = new NoticeVO();
		vo.setNtcId(Integer.parseInt(id));
		vo.setNtcTitle(title);
		vo.setNtcContent(contnet);
		
		NoticeService service = new NoticeDAO();
		service.update(vo);
		
		resp.sendRedirect("noticeList.do");
	}

}
