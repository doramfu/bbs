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

public class NoticeSelectController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "notice/notice.tiles";
		
		String id = req.getParameter("id");
		
		NoticeService service = new NoticeDAO();
		NoticeVO vo = service.selectONe(Integer.parseInt(id));
		
		req.setAttribute("notice", vo);
		
		HttpUtil.forward(req, resp, path);
		
	}

}
