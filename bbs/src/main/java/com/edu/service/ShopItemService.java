package com.edu.service;

import java.util.List;

import com.edu.vo.ShopItem;

public interface ShopItemService {
	public List<ShopItem> itemList();
	public void insertItem(ShopItem vo);
	public ShopItem selectItem(int itemid);
}
