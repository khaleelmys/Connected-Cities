package com.assignment.khaleel.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.khaleel.controller.CityPairController;
import com.assignment.khaleel.service.CityPairService;

@SpringBootTest
class AssignmentApplicationTests {
	
	@Autowired
	private CityPairController controller;
	
	@Autowired
	private CityPairService service;

	@Test
	void contextLoads() {
		
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}

}
