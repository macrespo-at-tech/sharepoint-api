package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SharePointClient {

	@Value("${sharepoint.token}")
    private String token;
	
    private RestTemplate restTemplate;
 
    @Autowired
    public SharePointClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public void getLists() {
        HttpHeaders headers = new HttpHeaders();

    	headers.add("Authorization", "Bearer " + token);
    	headers.add("Accept", "application/json;odata=nometadata");
    	headers.add("Content-Type", "application/json;odata=verbose");
    	
    	HttpEntity<String> rq = new HttpEntity<>(null, headers);

    	ResponseEntity<String> rs =
    			this.restTemplate.exchange("https://spclh.sharepoint.com/_api/web/lists", HttpMethod.GET, rq, String.class);
    	System.out.println(rs);
    }

}
