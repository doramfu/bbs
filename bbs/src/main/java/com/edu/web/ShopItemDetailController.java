package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.ShopItemService;
import com.edu.serviceImpl.ShopDAO;
import com.edu.vo.ShopItem;

public class ShopItemDetailController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "shop/shopItemDetail.tiles";
		String id = req.getParameter("id");
		
		ShopItemService service = new ShopDAO();
		
		ShopItem vo = service.selectItem(Integer.parseInt(id));
		
		req.setAttribute("shopItem", vo);
		
		HttpUtil.forward(req, resp, path);
		
	}

}
