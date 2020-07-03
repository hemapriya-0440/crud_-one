package com.example.crudEx1.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudEx1.filtering.bean.somebean;

@RestController
public class filteringController {
	@GetMapping("/filtering")
public somebean retrieve() {
	return new somebean("value1","value2","value3");
}
	@GetMapping("/filtering-list")
public List<somebean> retrieveall() {
	return Arrays.asList(new somebean("value1", "value2", "value3"),
			new somebean("value12", "value22", "value32"));
}
}