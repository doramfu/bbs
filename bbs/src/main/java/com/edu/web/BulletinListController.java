package com.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.BulletinService;
import com.edu.serviceImpl.BulletinDAO;
import com.edu.vo.BulletinVO;

public class BulletinListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전체리스트 조회 => bulletin/bulletinList.jsp
		
		String path = "bulletin/dataTable.tiles";
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		
		//게시글 리스트.
		BulletinService service = new BulletinDAO();
		List<BulletinVO> list = service.selectList();//service.selectList(Integer.parseInt(page));
		int totalCnt = service.selectCnt();
		int endPage = (int) Math.ceil(totalCnt / 10.0); // 95/10 => 9.5
		// /bulletinList.do 요청정보를 bulletinList.jsp 페이지로 전달.
		req.setAttribute("bulletinList", list);
		req.setAttribute("endPage", endPage);
		
		HttpUtil.forward(req, resp, path);
	}

}
