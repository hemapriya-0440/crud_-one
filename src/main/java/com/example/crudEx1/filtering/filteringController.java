package com.example.crudEx1.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudEx1.filtering.bean.somebean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//field1 and 2 to be sent
@RestController
public class filteringController {
	@GetMapping("/filtering")
public MappingJacksonValue retrieve() {
	somebean bean= new somebean("value1","value2","value3");

	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

	FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

	MappingJacksonValue mapping = new MappingJacksonValue(bean);

	mapping.setFilters(filters);

	return mapping;
	}
	// field2, field3
		@GetMapping("/filtering-list")
		public MappingJacksonValue retrieveListOfSomeBeans() {
			List<somebean> list = Arrays.asList(new somebean("value1", "value2", "value3"),
					new somebean("value12", "value22", "value32"));

			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

			FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

			MappingJacksonValue mapping = new MappingJacksonValue(list);

			mapping.setFilters(filters);

			return mapping;
		}}