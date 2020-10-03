package com.dxctraining.testsmgt.dao;

import com.dxctraining.testsmgt.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ITestDao extends JpaRepository<Test,Integer> {
    public Test findByName(String name);
	
}
