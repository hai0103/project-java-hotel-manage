package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.PostDto;
import com.example.demo.dtos.ResponseDataDTO;
import com.example.demo.entities.PostEntity;
import com.example.demo.services.impls.PostService;
import com.example.demo.utils.Constants;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class PostController {

    @Autowired
    PostService postService;
	@GetMapping(value = "/post/all")
	public ResponseDataDTO<Object> getAll(){
    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
		try {
			response.setData(postService.getAll());
			response.setCode(Constants.OK);
			response.setMessage(Constants.SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			response.setData(null);
			response.setCode(Constants.BAD_REQUEST);
			response.setMessage(Constants.FAILED);
		}

		return response;
	}

    @PostMapping(value = "/post/create")
    public ResponseDataDTO<Object> create(@RequestBody PostDto post){
    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
    	try {
    		response.setData(postService.create(post));
    		response.setCode(Constants.OK);
    		response.setMessage(Constants.SUCCESS);
    	} catch(Exception e) {
    		response.setData(null);
			response.setCode(Constants.BAD_REQUEST);
			response.setMessage(Constants.FAILED);
    	}
    	return response;
    }
 
}
