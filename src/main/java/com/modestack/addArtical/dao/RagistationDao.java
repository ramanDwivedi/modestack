package com.modestack.addArtical.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modestack.addArtical.model.Ragistration;
@Repository
public interface RagistationDao extends JpaRepository<Ragistration, Integer>{

}
