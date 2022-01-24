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

}
