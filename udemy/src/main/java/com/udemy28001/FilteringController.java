package com.udemy28001;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return  Arrays.asList( new SomeBean("value1","value2","value3"),
				new SomeBean("value12","value22","value32"),new SomeBean("value123","value223","value323"));
	}

	
	@GetMapping("/filteringd")
	public MappingJacksonValue retrieveDynamic() {
		SomeBeanTwo somebean2= new SomeBeanTwo(10,15,20);
		
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanTwoFilter", filter);
		
		MappingJacksonValue mapping =  new MappingJacksonValue(somebean2);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filtering-listd")
	public MappingJacksonValue retrieveListOfSomeBeand() {
		List<SomeBeanTwo> list= Arrays.asList( new SomeBeanTwo(100	,200,300),
				new SomeBeanTwo(500	,800,3000),new SomeBeanTwo(1200	,2200,3300));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanTwoFilter", filter);
		
		MappingJacksonValue mapping =  new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return  mapping;
		
	}
	
	
}
