package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.services.SharePointClient;

@RestController
public class RestServiceController {

	private SharePointClient sharePointClient;
	
	@Autowired
	public RestServiceController(SharePointClient sharePointClient) {
		this.sharePointClient = sharePointClient;
	}
	
	@GetMapping("/list")
	public String greeting() {
		sharePointClient.getLists();
		return "ok";
	}
	
	@GetMapping("/update")
	public String greeting2() {
		sharePointClient.updateList(null);
		return "ok";
	}
	
}
