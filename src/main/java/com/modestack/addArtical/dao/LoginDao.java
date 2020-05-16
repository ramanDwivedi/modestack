package com.modestack.addArtical.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modestack.addArtical.model.Login;
@Repository
public interface LoginDao extends JpaRepository<Login, Integer>{

	Login findByUsername(String username);

}
