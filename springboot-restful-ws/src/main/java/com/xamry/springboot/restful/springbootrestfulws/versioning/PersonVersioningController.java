package com.xamry.springboot.restful.springbootrestfulws.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	// ** Ways to version APIs

	// 1. URI Versioning
	//Example: Twitter
	@GetMapping(path = "/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// 2. Request parameter versioning
	//Example: Amazon
	@GetMapping(path = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// 3. (Custom) Header Parameter versioning
	//Example: Microsoft
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")  //Header parameter SHOULD be in caps, using convention
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	//4. Content Negotiation or Accept Header Versioning or Mime type versioning 
	//(Works with Accept header parameter, very similar to other header parameters)
	//Example: Github
	@GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v1+json")  //Produces version 1 of API
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v2+json")  //Produces version 2 of API
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	// ** Factors to consider while choosing Versioning scheme
	// 1. URI Pollution  (3&4 pollute URI)
	// 2. Misuse of HTTP headers (1&2. Headers were not meant to be used for versioning)
	// 3. Caching (1&2 make it difficult to cache, because URL is the same)
	// 4. Can we execute the request on browser? (not possible for 1&2)
	// 5. API documentation (tough to generate for 1&2)
	
	//** There is no perfect solution
	//Finalize exception handling and versioning strategy before starting out

}
