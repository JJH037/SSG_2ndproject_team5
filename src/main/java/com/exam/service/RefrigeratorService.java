package com.exam.service;

import java.util.List;

import com.exam.dto.GoodsDTO;
import com.exam.dto.RefrigeratorDTO;

public interface RefrigeratorService {

	public int refrigeratorAdd(RefrigeratorDTO dto);

	public List<RefrigeratorDTO> refrigeratorList(String userid);

	public int refrigeratorDelete(int num);

	public int getRefrigeratorStock(String userid, String gCode);

	public int updateRefrigeratorStock(RefrigeratorDTO dto);

	// 모든 냉자고의 재고 정보 조회
	public List<RefrigeratorDTO> getAllrStock();

}
