package com.unittesting.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ItemControllerITTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = testRestTemplate.getForObject("/items-db", String.class);
		JSONAssert.assertEquals(""
				+ "["
				+ "{id:101, name:laptop, price:1000, quantity:2},"
				+ "{id:102, name:phone, price:600, quantity:3},"
				+ "{id:103, name:TV, price:700, quantity:4},"
				+ "{id:104, name:AC, price:800, quantity:5}"
				+ "]",
				response, false);
	}

}