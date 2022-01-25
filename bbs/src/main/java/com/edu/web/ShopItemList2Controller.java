package com.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.common.HttpUtil;
import com.edu.service.ShopItemService;
import com.edu.serviceImpl.ShopDAO;
import com.edu.vo.ShopItem;

public class ShopItemList2Controller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//똑같은 페이지 jsp방식.
		
		//전체 데이터 조회하고 결과를 attrivbute에 저장.
		// shopItemList2.jsp 페이지에 같은결과 나타나도록 작성.
		ShopItemService service = new ShopDAO();
		List<ShopItem> list = service.itemList();
		
		req.setAttribute("shopList", list);
		
		String path = "shop/shopItemList2.tiles";
		HttpUtil.forward(req, resp, path);
	}

}
