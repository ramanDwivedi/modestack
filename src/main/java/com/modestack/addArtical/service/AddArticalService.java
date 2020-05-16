package com.modestack.addArtical.service;

import java.util.List;

import com.modestack.addArtical.dto.ArticalDto;

public interface AddArticalService {

	ArticalDto addArtical(ArticalDto articalInfo);

	List<ArticalDto> getAllArticals();

}
