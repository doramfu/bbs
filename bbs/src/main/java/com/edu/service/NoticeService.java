package com.edu.service;

import java.util.List;

import com.edu.vo.NoticeVO;

public interface NoticeService {
	// 기능정의만
		public List<NoticeVO> selectList();
		public NoticeVO selectONe(int ntcId);
		public NoticeVO insert(NoticeVO vo);
		public NoticeVO update(NoticeVO vo);
		public int delete(int ntcId);
}
