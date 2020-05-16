package com.modestack.addArtical.serviceImpl;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.modestack.addArtical.dao.LoginDao;
import com.modestack.addArtical.dto.LoginDto;
import com.modestack.addArtical.model.Login;
import com.modestack.addArtical.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService,UserDetailsService{
    private static final Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);
    @Autowired
    LoginDao loginDao;
    @Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Override
	public LoginDto userLogin(LoginDto logininfo) throws Exception {
		ModelMapper mapper = new ModelMapper();
		UserDetails details=loadUserByUsername(logininfo.getUsername());;
		if(details==null)
		{
			throw new Exception("invalid username and password");
		}
		return mapper.map(details, LoginDto.class);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login user = loginDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	

}
