package com.example.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CustomerDTO;
import com.example.demo.dtos.ResponseDataDTO;
import com.example.demo.services.CustomerService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerController {
	
	  @Autowired
	  CustomerService customerService;
	  
		@GetMapping(value = "/customer/all")
		public ResponseDataDTO<Object> getAll(){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
			try {
				response.setData(customerService.all());
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

	    @PostMapping(value = "/customer/create")
	    public ResponseDataDTO<Object> create(@RequestBody CustomerDTO customer){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(customerService.create(customer));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @PutMapping(value= "/customer/update")
	    public ResponseDataDTO<Object> update(@RequestBody CustomerDTO customer, int id){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(customerService.update(id, customer));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @DeleteMapping(value= "/customer/delete")
	    public ResponseDataDTO<Object> delete(@RequestBody int[] ids){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(customerService.delete(ids));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @GetMapping(value= "/customer/search")
	    public ResponseDataDTO<Object> search(String customerName, String customerNo, String nation, String identityCard,
				Date dob, String phone, String email, Integer page, Integer size ){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	if(page==null)
	    		page=0;
	    	if(size==null)
	    		size=9999;
	    	try {
	    		response.setData(customerService.search(customerName, customerNo, nation, identityCard, dob,phone, email, page, size));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
				e.printStackTrace();
	    	}
	    	return response;
	    }
	 
}
