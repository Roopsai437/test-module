


package com.dxctraining.testsmgt.controller;


import com.dxctraining.testsmgt.dto.CreateTestRequest;
import com.dxctraining.testsmgt.dto.TestDto;
import com.dxctraining.testsmgt.entities.Test;
import com.dxctraining.testsmgt.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/tests")
public class TestRestController {

	@Autowired
	private ITestService testService;
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public TestDto create(@RequestBody CreateTestRequest data) {
		Test test = new Test(data.getName());
		test = testService.save(test);
		TestDto response = toDto(test);
		return response;
	}

	@GetMapping("/get/{id}")
	public TestDto findTest(@PathVariable("id") int id) {
		Test test = testService.findTestById(id);
		TestDto dto = toDto(test);
		return dto;
	}


	@GetMapping("/find/{name}")
	public TestDto findByName(@PathVariable("name") String name) {
		Test test = testService.findByName(name);
		TestDto dto = toDto(test);
		return dto;

	}

	@GetMapping("/findall")
	public List<TestDto> findall() {
		List<Test> test = testService.allTest();
		List<TestDto> result = new ArrayList<>();
		for(Test ar:test) {
			TestDto dto = toDto(ar);
			result.add(dto);
		}
		return  result;

	}

	@DeleteMapping("/delete/{id}")
	public void deleteTestById(@PathVariable("id") Integer id) {
		testService.remove(id);
	}

	public TestDto toDto(Test test) {
		TestDto dto = new TestDto();
		dto.setId(test.getId());
		dto.setName(test.getName());
		return dto;
	}



}

