package com.prekes.web.prekesweb.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.prekes.web.prekesweb.PrekesWebApplication;
import com.prekes.web.prekesweb.model.Pirkimas;

//Part1: Initialize and launch SpringBoot application
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@LocalServerPort
//private int port;

//Part2: Invoke url /zmones/1/pirkimai/1-3-2021-09-02
//private TestRestTemplate template = new TestRestTemplate();


@SpringBootTest(classes = PrekesWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ZmogusRestControllerIT {
	@LocalServerPort
	private int port;
	
	@Test
	void test() {
		System.out.println("PORT=" + port);
	}

	// 1 budas, kai negalime nustatyti requesto headeriu
	@Test
	void testRetrieveDetailsForPirkimas1() throws Exception {
		String url = "http://localhost:" + port	+ "/zmones/1/pirkimai/1-3-2021-09-02";
		TestRestTemplate restTemplate = new TestRestTemplate();

		// Invote GET request on url, get response and convert it to object of String.class
		String response = restTemplate.getForObject(url, String.class);
		
		System.out.println("RESPONSE_1:" + response);
		
		String expected = "{\"zmogausId\":1,\"prekesKodas\":3,\"vnt\":5,\"date\":\"2021-09-02\",\"prekesPav\":null}";

		// JSONAssert is part of Spring Boot
		JSONAssert.assertEquals(expected, response, false);
	}

	// 2 budas, kai galime nustatyti requesto headerius
	@Test
	void testRetrieveDetailsForPirkimas2() throws Exception {
		String url = "http://localhost:" + port	+ "/zmones/1/pirkimai/1-3-2021-09-02";
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		// set value of request header to Accept: application/json
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		// create request with null body and given headers
		HttpEntity<String> entity = new HttpEntity<String>(null, headers); // request body is null
		
		// Invote GET request on url:
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		System.out.println("RESPONSE_2:" + response.getBody());
		
		String expected = "{\"zmogausId\":1,\"prekesKodas\":3,\"vnt\":5,\"date\":\"2021-09-02\",\"prekesPav\":null}";

		// JSONAssert is part of Spring Boot
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	void testFindPirkimaiForZmogus() {
		String url = "http://localhost:" + port	+ "/zmones/1/pirkimai";
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		// Set value of request header to Accept: application/json
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			
		// Create request with null body and given headers
		HttpEntity<String> entity = new HttpEntity<String>(null, headers); // request body is null

		// Invote GET request on url:
		ResponseEntity<List<Pirkimas>> response = restTemplate.exchange(url, HttpMethod.GET, entity,
	                new ParameterizedTypeReference<List<Pirkimas>>() {});

		System.out.println("RESPONSE_3:" + response.getBody());
			
			
		Pirkimas sample = new Pirkimas(1, 3, 5, "2021-09-02");

		assertTrue(response.getBody().contains(sample));
	}

	@Test
	void testAddPirkimasToZmogus() {
		System.out.println("~~~ PORT=" + port);
		String url = "http://localhost:" + port	+ "/zmones/1/pirkimai";
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		// Set value of request header to Accept: application/json
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		Pirkimas pirk = new Pirkimas(1, 2, 200, "2025-02-20");

		// Create request with given body and given headers
		HttpEntity<Pirkimas> entity = new HttpEntity<Pirkimas>(pirk, headers);

		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		// get URI of new created resource from header
		String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0); 
		
		//"/zmones/1/pirkimai/1-3-2021-09-02"
		System.out.println("NEW RESOURCE URI: " + actual); 
		
		assertTrue(actual.contains("/zmones/1/pirkimai/1-2-2025-02-20")); // pirk.getPirkimasId()
	}
	
	@Test
	void testZmonesJson() {
		//fail("Not yet implemented");
	}

	@Test
	void testZmogusById() {
		//fail("Not yet implemented");
	}

}
