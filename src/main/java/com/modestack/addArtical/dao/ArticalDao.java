package com.modestack.addArtical.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modestack.addArtical.model.Artical;
@Repository
public interface ArticalDao extends JpaRepository<Artical, Integer>{

}
