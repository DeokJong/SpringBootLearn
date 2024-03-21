package com.jjinjjin.learnspringframework.examples.c1;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService{

	private DataService dataService;

	public  int findMax(){
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

	public BusinessCalculationService(DataService service) {
		super();
		dataService = service;
	}

}

