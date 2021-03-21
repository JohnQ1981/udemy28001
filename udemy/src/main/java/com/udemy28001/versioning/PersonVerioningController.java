package com.udemy28001.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVerioningController {
	@GetMapping("/v1/person")
	public PersonV1 personv1() {
		return new PersonV1("Bob Joshua");
	}
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Joshua"));
	}
	
	@GetMapping(value="/person/param",params="version=1") // param versioninning
	public PersonV1 paramV1() {
		return new PersonV1("Bob John");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Joshua"));
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob John");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Joshua"));
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 headerpV1() {
		return new PersonV1("Bob John");
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public PersonV2 headerpV2() {
		return new PersonV2(new Name("Bob", "Joshua"));
	}
		
}

