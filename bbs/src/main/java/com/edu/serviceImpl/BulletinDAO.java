package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.BulletinService;
import com.edu.vo.BulletinVO;

public class BulletinDAO extends DAO implements BulletinService {
	
	
	@Override
	public List<BulletinVO> selectList() {
		connect();
		String sql = "SELECT * FROM bbs order by 1";
		List<BulletinVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BulletinVO bulletin = new BulletinVO();
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				
				list.add(bulletin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public BulletinVO selectONe(int bbsId) {
		connect();
		String sql = "SELECT * FROM bbs WHERE bbs_id=?";
		BulletinVO bulletin = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bbsId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bulletin = new BulletinVO();
				bulletin.setBbsId(rs.getInt("bbs_id"));
				bulletin.setBbsTitle(rs.getString("bbs_title"));
				bulletin.setBbsContent(rs.getString("bbs_content"));
				bulletin.setBbsImage(rs.getString("bbs_image"));
				bulletin.setBbsHit(rs.getInt("bbs_hit"));
				bulletin.setBbsCreateDate(rs.getString("bbs_create_date"));
				bulletin.setBbsWriter(rs.getString("bbs_writer"));
				
				//카운트 증가.
				updateCount(bbsId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return bulletin;
	}
	
	// 조회수 증가.
	public void updateCount(int id) {
		connect();
		String sql = "UPDATE bbs SET bbs_hit = bbs_hit + 1 WHERE bbs_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public BulletinVO insert(BulletinVO vo) {
		connect();
		String sql1 = "SELECT bbs_id_seq.nextval FROM dual";
		String sql = "INSERT INTO bbs(bbs_id,bbs_title,bbs_content,bbs_writer,bbs_image,bbs_create_date,bbs_hit)"
				+ " values(?,?,?,?,?,sysdate,0)";
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			psmt.setString(2, vo.getBbsTitle());
			psmt.setString(3, vo.getBbsContent());
			psmt.setString(4, vo.getBbsWriter());
			psmt.setString(5, vo.getBbsImage());
			int r = psmt.executeUpdate();
			System.out.println(r + "입력.");
		
			// 입력값에 bbs_id값만 추가해서 반환.
			vo.setBbsId(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public BulletinVO update(BulletinVO vo) {
		connect();
		String sql = "UPDATE bbs SET bbs_title=?, bbs_content=?, bbs_image=nvl(?, bbs_image) WHERE bbs_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBbsTitle());
			psmt.setString(2, vo.getBbsContent());
			psmt.setString(3, vo.getBbsImage());
			psmt.setInt(4, vo.getBbsId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건변경.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	@Override
	public int delete(int bbsId) {
		connect();
		String sql = "DELETE FROM bbs WHERE bbs_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bbsId);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건삭제되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return bbsId;
	}
	
}
