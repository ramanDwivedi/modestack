package com.modestack.addArtical.service;

import com.modestack.addArtical.dto.LoginDto;

public interface LoginService {

	LoginDto userLogin(LoginDto logininfo) throws Exception;

}
