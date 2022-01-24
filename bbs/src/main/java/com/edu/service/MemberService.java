package com.edu.service;

import java.util.List;

import com.edu.vo.MemberVO;

public interface MemberService {
	// 회원관련..
	// public 회원가입
	public boolean memberInsert(MemberVO vo);
	
	// 회원정보수정
	public boolean memberUpdate(MemberVO vo);
	//회원리스트
	public List<MemberVO> memberList();
	//회원조회
	public MemberVO memberSelect(String id);
	//로그인
	public MemberVO login(String id, String pw);
}
