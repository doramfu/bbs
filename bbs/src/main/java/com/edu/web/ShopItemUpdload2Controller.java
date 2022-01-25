package com.edu.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.Controller;
import com.edu.service.ShopItemService;
import com.edu.serviceImpl.ShopDAO;
import com.edu.vo.ShopItem;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ShopItemUpdload2Controller implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		//new MultipartRequest("요청정보","저장위치","maxSize","encoding","rename정책");
		MultipartRequest multi = new MultipartRequest(req,uploadPath,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
		// image1.PNG => image11.PNG  이미지 이름을 바꿈.
		ShopItem vo = new ShopItem();
		vo.setItemName(multi.getParameter("item_name"));
		vo.setItemDesc(multi.getParameter("item_desc"));
		vo.setImage(multi.getFilesystemName("image"));
		vo.setOriginPrice(Integer.parseInt(multi.getParameter("origin_price")));
		vo.setSalePrice(Integer.parseInt(multi.getParameter("sale_price")));
		vo.setLikeIt(Double.parseDouble(multi.getParameter("like_it")));
		
		ShopItemService service = new ShopDAO();
		service.insertItem(vo);
		System.out.println(vo);
		
		resp.sendRedirect("shopItemList2.do");
	}

}
