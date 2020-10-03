package com.dxctraining.testsmgt.service;



import com.dxctraining.testsmgt.entities.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITestService {

	public Test findTestById(int id);
	public Test save(Test test);
	public void remove(int id);
	public Test findByName(String name);
	public List<Test> allTest();
}
