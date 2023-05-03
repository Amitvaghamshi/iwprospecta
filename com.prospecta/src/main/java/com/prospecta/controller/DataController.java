package com.prospecta.controller;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.prospecta.model.Data;
import com.prospecta.model.Entity;

@RestController
public class DataController {
	
	@Autowired
	private RestTemplate template;
	
	/**
	 * 
	 * @param category
	 * @return entity of data
	 */

	@GetMapping("/category/{cat}")
	public ResponseEntity<Entity> getDataByCategory(@PathVariable("cat") String category){
		   HttpHeaders hh=new HttpHeaders();
		   hh.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		   
		   // fetching data by category and takes category from user
		   
		   HttpEntity<Entity>  entity=new HttpEntity<>(hh);
		   ResponseEntity<Entity> res=template.exchange("https://api.publicapis.org/entries?category="+category, HttpMethod.GET,entity,Entity.class);
		   		   
		   return res;
	}
	
	
	
	/**
	 * 
	 * @return  added data 
	 */
	
	@PostMapping("/add")
	public ResponseEntity<Entity> addEntityHandler(){
		
		//  dummy Entry for adding the data 
		//  NOTE : Hear we can take from user also
		Entity en=new Entity();
		Data d1=new Data();
		d1.setCategory("Animals");
		d1.setApi("ssdyhf");
		d1.setDescription("dummy  description");
		Data d2=new Data();
		d2.setCategory("Animal");
		d2.setApi("efefef");
		d2.setDescription("dummy discription");
		
		// adding the data to entity 
		en.getEntries().add(d1);
		en.getEntries().add(d2);
		
		HttpHeaders hh=new HttpHeaders();
		hh.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		   
		   // careating category
		   HttpEntity<Entity>  entity=new HttpEntity<>(en,hh);
		   
		   ResponseEntity<Entity> res=template.exchange("https://api.publicapis.org/entries", HttpMethod.POST,entity,Entity.class);
		   
		return res;
		
	}
	
	/* 
 3) what are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?

 —> While creating api first we should define what are the request parameter and what are the path variable we should provide according to need.

→ while developing api we should check whether the who is fating the data this person is authenticated person or not  for that we can apply different type of authentication like basic auth or JWT token

→ At the time developing api we should provide appropriate status code that consumer can under stand the problem

→ At time of creating api also we should return ResponseEntity so that if any Error occurs so then user can understand what is error and what is message 

→ whatever the input is coming from api we should validate and if any irrelevant input comes 
Then we should throw exception

—> While Consuming any api we should pass appropriate path variables and request parameters otherwise we will not get Appropriate Response

→  According to response status code we can perform required operations

	 */
	
	
	
}
