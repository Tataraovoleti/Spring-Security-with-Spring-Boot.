package com.tata.springboot;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Tatarao voleti
* @date   May 24, 2015
*/

@RestController
public class WelcomeController {
	
	@RequestMapping(value= "/",produces={MediaType.APPLICATION_JSON_VALUE})
	public String inded(){
		
		return "welcome ";
	}

}

