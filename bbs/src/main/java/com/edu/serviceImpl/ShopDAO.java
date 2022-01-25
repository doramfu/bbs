package com.edu.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.DAO;
import com.edu.service.ShopItemService;
import com.edu.vo.ShopItem;

public class ShopDAO extends DAO implements ShopItemService {

	@Override
	public List<ShopItem> itemList() {
		String sql = "SELECT * FROM shop_item ORDER BY 1";
		connect();
		List<ShopItem> itemList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ShopItem vo = new ShopItem();
				vo.setImage(rs.getString("image"));
				vo.setItemDesc(rs.getString("item_desc"));
				vo.setItemId(rs.getInt("item_id"));
				vo.setItemName(rs.getString("item_name"));
				vo.setLikeIt(rs.getDouble("like_it"));
				vo.setOriginPrice(rs.getInt("origin_price"));
				vo.setSalePrice(rs.getInt("sale_price"));
				itemList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); 
		}
		return itemList;
	}

	@Override
	public void insertItem(ShopItem vo) {
		String sql = "INSERT INTO shop_item VALUES(shop_item_seq.nextval,?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getItemName());
			psmt.setString(2, vo.getItemDesc());
			psmt.setDouble(3, vo.getLikeIt());
			psmt.setInt(4, vo.getOriginPrice());
			psmt.setInt(5, vo.getSalePrice());
			psmt.setString(6, vo.getImage());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public ShopItem selectItem(int itemid) {
		String sql = "SELECT * FROM shop_item WHERE item_id=?";
		connect();
		ShopItem item = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, itemid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				item = new ShopItem();
				item.setItemId(rs.getInt("item_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDesc(rs.getString("item_desc"));
				item.setImage(rs.getString("image"));
				item.setOriginPrice(rs.getInt("origin_price"));
				item.setSalePrice(rs.getInt("sale_price"));
				item.setLikeIt(rs.getDouble("like_it"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return item;
	}

}
