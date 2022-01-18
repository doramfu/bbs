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

public class BulletinAddController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 입력값을 디비에 저장 처리결과 : 게시판 리스트
		String path = "bulletinList.do";
		
		BulletinVO vo = new BulletinVO();
		vo.setBbsWriter(req.getParameter("writer"));
		vo.setBbsContent(req.getParameter("content"));
		vo.setBbsTitle(req.getParameter("title"));
		vo.setBbsImage(req.getParameter("image"));
		
		BulletinService service = new BulletinDAO();
		service.insert(vo);
		
		HttpUtil.forward(req, resp, path);
		
	}

}
