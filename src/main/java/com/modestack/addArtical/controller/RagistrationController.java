package com.modestack.addArtical.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.modestack.addArtical.dto.RagistrationDto;
import com.modestack.addArtical.dto.ResponseDTO;
import com.modestack.addArtical.model.JwtRequest;
import com.modestack.addArtical.model.JwtResponse;
import com.modestack.addArtical.model.Ragistration;
import com.modestack.addArtical.model.Response;
import com.modestack.addArtical.security.JwtTokenUtil;
import com.modestack.addArtical.service.RagistrationService;
import com.modestack.addArtical.serviceImpl.LoginServiceImpl;

@RestController
public class RagistrationController {
	private static final Logger logger=LoggerFactory.getLogger(RagistrationController.class);
	@Autowired
	RagistrationService ragistationService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private LoginServiceImpl loginService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = loginService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping("/ragistration")
	public ResponseDTO ragistration(@RequestBody RagistrationDto ragistrationInfo) throws Exception {
		ragistrationInfo = ragistationService.saveDetails(ragistrationInfo);
		Response<RagistrationDto> response=new Response<>();
		List<String> list=new ArrayList<>();
		list.add("successfully signup");
		response.setCode(HttpStatus.CREATED.value());
		response.setData(ragistrationInfo);
		response.setMessage(list);
		logger.debug("successfully signup");
		return response;
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
