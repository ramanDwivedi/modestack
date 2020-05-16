package com.modestack.addArtical.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.addArtical.dto.ArticalDto;
import com.modestack.addArtical.dto.LoginDto;
import com.modestack.addArtical.dto.ResponseDTO;
import com.modestack.addArtical.model.Response;
import com.modestack.addArtical.service.AddArticalService;

@RestController
public class AddArticalController {
	private static final Logger logger=LoggerFactory.getLogger(AddArticalController.class);
	@Autowired
	AddArticalService addArticalService;
	
	@PostMapping(path = "/addArtical")
	public ResponseDTO addArtical(@RequestBody ArticalDto articalInfo) throws Exception {
		articalInfo = addArticalService.addArtical(articalInfo);
		Response<ArticalDto> response=new Response<>();
		List<String> list=new ArrayList<>();
		list.add("successfully added::");
		response.setCode(HttpStatus.CREATED.value());
		response.setData(articalInfo);
		response.setMessage(list);
		logger.debug("user Login successfully::");
		return response;
	}

}
