package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.MemberService;
import com.edu.serviceImpl.MemberDAO;
import com.edu.vo.MemberVO;

public class MyPageController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "member/mypage.tiles";
		// sessionId 값을 활용해서
		// 요청정보의 parameter를 활용.
		// session정보에 있는 sessionId
		String id = req.getParameter("id");
		MemberService service = new MemberDAO();
		MemberVO member = service.memberSelect(id);
		
		req.setAttribute("member", member);
		
		HttpUtil.forward(req, resp, path);
		
	}

}
