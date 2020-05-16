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

import com.modestack.addArtical.dto.LoginDto;
import com.modestack.addArtical.dto.ResponseDTO;
import com.modestack.addArtical.model.Response;
import com.modestack.addArtical.service.LoginService;


@RestController
public class LoginController {
	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	LoginService loginService;
	
	@PostMapping(path = "/userlogin")
	public ResponseDTO userLogin(@RequestBody LoginDto logininfo) throws Exception {
		logininfo = loginService.userLogin(logininfo);
		Response<LoginDto> response=new Response<>();
		List<String> list=new ArrayList<>();
		list.add("successfully login::");
		response.setCode(HttpStatus.CREATED.value());
		response.setData(logininfo);
		response.setMessage(list);
		logger.debug("user Login successfully::");
		return response;
	}

}
