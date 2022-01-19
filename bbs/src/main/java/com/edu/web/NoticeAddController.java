package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.NoticeService;
import com.edu.serviceImpl.NoticeDAO;
import com.edu.vo.NoticeVO;

public class NoticeAddController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "noticeList.do";
		
		NoticeVO vo = new NoticeVO();
		vo.setNtcTitle(req.getParameter("title"));
		vo.setNtcContent(req.getParameter("content"));
		
		NoticeService service = new NoticeDAO();
		service.insert(vo);
		
		HttpUtil.forward(req, resp, path);
	}

}
