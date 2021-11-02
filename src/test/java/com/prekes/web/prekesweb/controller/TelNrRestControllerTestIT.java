package com.prekes.web.prekesweb.controller;

import com.prekes.web.prekesweb.PrekesWebApplication;
import com.prekes.web.prekesweb.model.TelNr;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = PrekesWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TelNrRestControllerTestIT {
    @LocalServerPort
    private int port;

    @Test
    void test() {
        System.out.println("PORT=" + port);
    }

    @Test
    @Order(1)
    void testTelNrAllJson() throws Exception {
        String url = "http://localhost:" + port + "/numbers";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("RESPONSE:" + response.getBody());
        String expected = "[" +
                "{\"id\":1,\"telNr\":\"+370648\",\"userId\":1}," +
                "{\"id\":2,\"telNr\":\"+370658\",\"userId\":1}," +
                "{\"id\":3,\"telNr\":\"+370668\",\"userId\":1}," +
                "{\"id\":4,\"telNr\":\"+370678\",\"userId\":1}" +
                "]";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void testTelNrById() throws Exception {
        String url = "http://localhost:" + port + "/numbers/2";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("RESPONSE:" + response.getBody());
        String expected = "{\"id\":2,\"telNr\":\"+370658\",\"userId\":1}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void testAddTelNr() {
        String url = "http://localhost:" + port + "/numbers";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(singletonList(MediaType.APPLICATION_JSON));
        TelNr telNr = new TelNr(12, "+3712", 12);
        HttpEntity<TelNr> entity = new HttpEntity<>(telNr, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        System.out.println("NEW RESOURCE URI: " + actual);
        assertTrue(actual.contains("/numbers/12"));
    }

    @Test
    void testDeleteTelNrById() {
        String url = "http://localhost:" + port + "/numbers/1";
        TestRestTemplate restTemplate = new TestRestTemplate();
        restTemplate.delete(url, String.class);
    }
}