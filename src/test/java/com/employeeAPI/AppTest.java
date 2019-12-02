package com.employeeAPI;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
/*import org.springframework.boot.web.server.LocalServerPort;
*/import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.employeeAPI.model.*;
import org.junit.Test;
/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;*/

/**
 * Unit test for simple App.
 */
 @RunWith(SpringRunner.class) 

 @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 

public class AppTest {
	/*
	 * @LocalServerPort int randomServerPort;
	 */

	
	 @Test 
	 public void testGetEmployeeListSuccess() throws URISyntaxException {
		 String plainCreds = "admin:admin";
		 byte[] plainCredsBytes = plainCreds.getBytes();
		 byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		 String base64Creds = new String(base64CredsBytes);

		 HttpHeaders headers = new HttpHeaders();
		 headers.add("Authorization", "Basic " + base64Creds);
		 HttpEntity<String> request = new HttpEntity<String>(headers);
	  RestTemplate restTemplate = new RestTemplate();
	  
	  final String baseUrl = "http://localhost:8080/company/employees/"; 
	  URI uri = new URI(baseUrl);
	  
		/*
		 * ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		 */
	  ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, request, String.class);
	  
	 
	 Assert.assertEquals(200, response.getStatusCodeValue());
		/* Assert.assertEquals(true, response.getBody().contains("employeeList")); */ }
 


}
