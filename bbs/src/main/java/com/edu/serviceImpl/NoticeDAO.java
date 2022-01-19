package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.NoticeService;
import com.edu.vo.NoticeVO;

public class NoticeDAO extends DAO implements NoticeService {

	@Override
	public List<NoticeVO> selectList() {
		connect();
		String sql = "SELECT * FROM notice1";
		List<NoticeVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				NoticeVO notice = new NoticeVO();
				notice.setNtcId(rs.getInt("notice_id"));
				notice.setNtcTitle(rs.getString("notice_title"));
				notice.setNtcContent(rs.getString("notice_content"));
				notice.setNtcDate(rs.getString("notice_wdate"));
				notice.setNtcHit(rs.getInt("notice_hit"));
				
				list.add(notice);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public NoticeVO selectONe(int ntcId) {
		connect();
		String sql = "SELECT * FROM notice1 WHERE notice_id=?";
		NoticeVO notice = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ntcId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				notice = new NoticeVO();
				notice.setNtcId(rs.getInt("notice_id"));
				notice.setNtcTitle(rs.getString("notice_title"));
				notice.setNtcContent(rs.getString("notice_content"));
				notice.setNtcDate(rs.getString("notice_wdate"));
				notice.setNtcHit(rs.getInt("notice_hit"));
				
				updateCount(ntcId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return notice;
	}
	
	// 조회수 기능
	public void updateCount(int id) {
		connect();
		String sql = "UPDATE notice1 SET notice_hit = notice_hit + 1 WHERE notice_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "조회수 증가");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public NoticeVO insert(NoticeVO vo) {
		connect();
		String sql1 = "SELECT notice_seq.nextval FROM dual";
		String sql = "INSERT INTO notice1 values (?,?,?,sysdate,0)";
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getNtcTitle());
			psmt.setString(3, vo.getNtcContent());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록");
			
			vo.setNtcId(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public NoticeVO update(NoticeVO vo) {
		connect();
		String sql = "UPDATE notice1 SET notice_title=?, notice_content=? WHERE notice_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getNtcTitle());
			psmt.setString(2, vo.getNtcContent());
			psmt.setInt(3, vo.getNtcId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public int delete(int ntcId) {
		connect();
		String sql = "DELETE FROM notice1 WHERE notice_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ntcId);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return ntcId;
	}

}
