package com.edu.service;

import java.util.List;

import com.edu.vo.BulletinVO;
import com.edu.vo.ReplyVO;

public interface BulletinService {
	
	// 기능정의만
//	public List<BulletinVO> selectList(int page);
	public List<BulletinVO> selectList();
	public int selectCnt();
	public BulletinVO selectONe(int bbsId);
	public BulletinVO insert(BulletinVO vo);
	public BulletinVO update(BulletinVO vo);
	public int delete(int bbsId);
	
	// 댓글관련.
	public List<ReplyVO> selectReplyList(int bbsId);
	public ReplyVO insertReply(ReplyVO vo);
	public boolean deleteReply(int rid);
}
