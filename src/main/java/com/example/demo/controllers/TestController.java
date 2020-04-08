package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TestController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<Object> index(){
		return new ResponseEntity<Object>("Day la test nhe nhe", HttpStatus.OK);
	}
}
