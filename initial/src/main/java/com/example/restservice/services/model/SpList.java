package com.example.restservice.services.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpList {
	
	private SpMetadata __metadata;
	
	@JsonProperty("Title")
	private String Title;
	
	
	public SpList() {
		this.__metadata = new SpMetadata("SP.List");
	}

	public SpMetadata get__metadata() {
		return __metadata;
	}

	@JsonProperty("Title")
	public String getTitle() {
		return Title;
	}

	@JsonProperty("Title")
	public void setTitle(String title) {
		Title = title;
	}

}
