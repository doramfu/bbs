package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.BulletinVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BulletinAddController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 입력값을 디비에 저장 처리결과 : 게시판 리스트
		String path = "bulletinList.do";
		
		ServletContext context = req.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		//new MultipartRequest("요청정보","저장위치","maxSize","encoding","rename정책");
		MultipartRequest multi = new MultipartRequest(req,uploadPath,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
		// image1.PNG => image11.PNG  이미지 이름을 바꿈.
		BulletinVO vo = new BulletinVO();
		vo.setBbsWriter(multi.getParameter("writer"));
		vo.setBbsContent(multi.getParameter("content"));
		vo.setBbsTitle(multi.getParameter("title"));
		vo.setBbsImage(multi.getFilesystemName("image"));
		System.out.println(vo);
		
		BulletinService service = new BulletinDAO();
		service.insert(vo);
		
		HttpUtil.forward(req, resp, path);
		
	}

}
