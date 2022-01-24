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

public class MyPageUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "member/mypage.tiles";
		//요청페이지정보를 읽어오도록
        String uri = req.getRequestURI(); // equ2/memberList.do 요청정보에서 uri정보를 읽어오기
        String context= req.getContextPath();//edu2 정보 가져오기
        String requestUri = uri.substring(context.length());
		
		// 정보를 읽어와서 변경.
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		String mail = req.getParameter("mail");
		String name = req.getParameter("name");
		
		MemberVO vo = new MemberVO();
		vo.setPasswd(pw);
		vo.setMail(mail);
		vo.setName(name);
		vo.setId(id);
		
		MemberService service = new MemberDAO();
		if(service.memberUpdate(vo)) {
			req.setAttribute("member", vo);
		} else {
			req.setAttribute("member", null);
		}
		req.setAttribute("uri", requestUri);
		// mypage.jsp 로 변경된 정보를 전송.
		HttpUtil.forward(req, resp, path);
	}

}
