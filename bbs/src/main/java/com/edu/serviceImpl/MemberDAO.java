package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.MemberService;
import com.edu.vo.MemberVO;

public class MemberDAO extends DAO implements MemberService {

	@Override
	public boolean memberInsert(MemberVO vo) {
		return false;
	}

	@Override
	public boolean memberUpdate(MemberVO vo) {
		connect();
		String sql = "UPDATE members SET passwd=?,mail=?,name=? WHERE id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getMail());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경.");
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	@Override
	public List<MemberVO> memberList() {
		
		
		return null;
	}

	@Override
	public MemberVO login(String id, String pw) {
		String sql = "SELECT * FROM members WHERE id=? AND passwd=?";
		connect();
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

	@Override
	public MemberVO memberSelect(String id) {
		String sql = "SELECT * FROM members WHERE id=?";
		connect();
		MemberVO member = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setMail(rs.getString("mail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return member;
	}

}
