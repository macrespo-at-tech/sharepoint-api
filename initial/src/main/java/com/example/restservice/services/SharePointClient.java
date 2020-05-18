package com.example.restservice.services;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.restservice.services.model.SpList;

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
//    	headers.add("Accept", "application/json;odata=nometadata");
//    	headers.add("Content-Type", "application/json;odata=verbose");
    	
    	headers.add("Accept", "application/xml");
    	headers.add("Content-Type", "application/xml");
    	
    	HttpEntity<String> rq = new HttpEntity<>(null, headers);

    	// Acceder a todas las listas
//    	ResponseEntity<String> rs =
//    			this.restTemplate.exchange("https://spclh.sharepoint.com/_api/web/lists", HttpMethod.GET, rq, String.class);
    	
    	//Acceder a una lista
//    	ResponseEntity<String> rs =
//    			this.restTemplate.exchange("https://spclh.sharepoint.com/_api/web/lists/GetByTitle('listone')", HttpMethod.GET, rq, String.class);

    	ResponseEntity<String> rs2 =
    			this.restTemplate.exchange("https://spclh.sharepoint.com/_api/web/lists/GetByTitle('newListone')", HttpMethod.GET, rq, String.class);

    	
//    	JSONObject json = new JSONObject(rs.getBody());
//    	String xml = XML.toString(json);
    	
//    	System.out.println("XML: " + xml);
//    	System.out.println("StatusCode: " + rs.getStatusCode());
//    	System.out.println("toString: " + rs.toString());
//    	System.out.println("Body: " + rs.getBody());
    	System.out.println(rs2);
    }
    
    public void updateList(String list_guid) {
    	
    	HttpHeaders headers = new HttpHeaders();

    	headers.add("Authorization", "Bearer " + token);
    	headers.add("Accept", "application/json;odata=nometadata");
    	headers.add("Content-Type", "application/json;odata=verbose");
    	headers.add("X-HTTP-Method", "MERGE");
    	headers.add("If-Match", "*");

    	SpList spList = new SpList();
    	
    	spList.setTitle("newListone");
    	
    	HttpEntity<SpList> rq = new HttpEntity<>(spList, headers);
    	
    	ResponseEntity<String> rs =
    			this.restTemplate.exchange(
    					"https://spclh.sharepoint.com/_api/web/lists(guid'1a14020b-dd74-456d-ac69-2965e3ca44be')", 
    					HttpMethod.POST, 
    					rq, 
    					String.class);
    	
    	System.out.println(rs);
    	
    }

}
