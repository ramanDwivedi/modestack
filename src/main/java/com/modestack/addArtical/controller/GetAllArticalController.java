package com.modestack.addArtical.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.addArtical.dto.ArticalDto;
import com.modestack.addArtical.dto.ResponseDTO;
import com.modestack.addArtical.model.Response;
import com.modestack.addArtical.service.AddArticalService;

@RestController
public class GetAllArticalController {
	private static final Logger logger=LoggerFactory.getLogger(GetAllArticalController.class);
	@Autowired
	AddArticalService addArticalService;
	@GetMapping(path = "/getAllArticals")
	public ResponseDTO getAllArticals() {
		List<ArticalDto> list = null;
		list = addArticalService.getAllArticals();
		Response<List<ArticalDto>> response=new Response<>();
		List<String> message=new ArrayList<>();
		message.add("successfully retreive the details");
	    response.setCode(HttpStatus.OK.value());
	    response.setData(list);
	    response.setMessage(message);
		logger.debug("successfully retrieve ::");
		return response;
	}

}
