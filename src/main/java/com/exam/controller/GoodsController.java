package com.exam.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dto.GoodsDTO;
import com.exam.service.GoodsService;

@Controller
@SessionAttributes("gCode")
public class GoodsController {

	private final GoodsService goodsService;

	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	// 상품 추가 폼 페이지로 이동
	@GetMapping("/addGoods")
	public String showAddGoodsPage() {
		return "addGoods"; // addGoods.jsp 페이지로 이동
	}

	
	
	
	
	@PostMapping("/addGoods")
	public String addGoods(@ModelAttribute GoodsDTO goodsDTO) {
	    if (goodsDTO.getgCode() == null || goodsDTO.getgCode().isEmpty()) {
	        // gCode가 null이거나 빈 값일 경우 처리할 로직
	        return "redirect:/addGoods"; // 다시 상품 추가 페이지로 리다이렉트
	    }

	    // 상품 추가 서비스 호출
	    goodsService.addGoods(goodsDTO); 
	    
	    return "redirect:/main"; // 상품 목록 페이지로 리다이렉트
	}

	
	
	
	

	// 상품 상세 조회
	@GetMapping("/goodsRetrieve")
	public ModelAndView goodsRetrieve(@RequestParam(required = false) String gCode, Model m) {
		// gCode가 없으면 세션에서 가져옵니다.
		if (gCode == null) {
			gCode = (String) m.getAttribute("gCode");
		}

		// 상품목록에서 자세히보기로 요청한 경우에 gCode를 세션에 저장.
		m.addAttribute("gCode", gCode);

		GoodsDTO dto = goodsService.goodsRetrieve(gCode);

		ModelAndView mav = new ModelAndView();
		// 모델 저장
		mav.addObject("goodsRetrieve", dto);

		// 뷰 저장
		mav.setViewName("goodsRetrieve");

		return mav;
	}
}
