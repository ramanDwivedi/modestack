package com.modestack.addArtical.serviceImpl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.modestack.addArtical.dao.LoginDao;
import com.modestack.addArtical.dao.RagistationDao;
import com.modestack.addArtical.dto.RagistrationDto;
import com.modestack.addArtical.model.Login;
import com.modestack.addArtical.model.Ragistration;
import com.modestack.addArtical.service.RagistrationService;
@Service
public class RagistrationServiceImpl implements RagistrationService{
	@Autowired
	LoginDao logindao;
    @Autowired
    RagistationDao ragistrationDao;
    @Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Override
	public RagistrationDto saveDetails(RagistrationDto ragistrationInfo) throws Exception {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Login userInfo=logindao.findByUsername(ragistrationInfo.getUsername());
		if(userInfo !=null)
		{
			throw new Exception("user already available");
		}
		Ragistration ragistration=mapper.map(ragistrationInfo, Ragistration.class);
		Login login=new Login();
		login.setUsername(ragistrationInfo.getUsername());
		login.setPassword(bCryptPasswordEncoder.encode(ragistrationInfo.getPassword()));
		login=logindao.save(login);
        ragistration=ragistrationDao.save(ragistration);
        return mapper.map(ragistration, RagistrationDto.class);
	}

}
