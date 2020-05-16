package com.modestack.addArtical.serviceImpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.modestack.addArtical.dao.ArticalDao;
import com.modestack.addArtical.dto.ArticalDto;
import com.modestack.addArtical.model.Artical;
import com.modestack.addArtical.service.AddArticalService;
@Service
public class AddArticalServiceImpl implements AddArticalService{
	private static final Logger logger=LoggerFactory.getLogger(AddArticalServiceImpl.class);
	@Autowired
	ArticalDao articalDao;
	@Override
	public ArticalDto addArtical(ArticalDto articalInfo) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Artical artical=mapper.map(articalInfo, Artical.class);
		artical=articalDao.save(artical);
		return mapper.map(artical, ArticalDto.class);
	}
	@Override
	public List<ArticalDto> getAllArticals() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<Artical> detials=articalDao.findAll();
		Type targetType = new TypeToken<List<ArticalDto>>() {
		}.getType();
		return modelMapper.map(detials,targetType);
	}
	

}
