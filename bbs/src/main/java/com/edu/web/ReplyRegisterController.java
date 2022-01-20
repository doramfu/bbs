package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.ReplyVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReplyRegisterController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String bbsId = req.getParameter("bbsId");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		System.out.println(bbsId);
		
		// insertReply 매가값으로 사용.
		ReplyVO vo = new ReplyVO();
		vo.setBbsId(Integer.parseInt(bbsId));
		vo.setReplyWriter(writer);
		vo.setReplyContent(content);
		
		BulletinService service = new BulletinDAO();
		service.insertReply(vo);
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(vo));
		
	}

}
