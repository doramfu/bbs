package com.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.ShopItemService;
import com.edu.serviceImpl.ShopDAO;
import com.edu.vo.ShopItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ItemListJsonController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		ShopItemService service = new ShopDAO();
		List<ShopItem> list = service.itemList();
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(list));
	}

}
