package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.ResponseDataDTO;
import com.example.demo.services.EmployeeService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {
	 @Autowired
	  EmployeeService employeeService;
	  
		@GetMapping(value = "/employee/all")
		public ResponseDataDTO<Object> getAll(){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
			try {
				response.setData(employeeService.all());
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

	    @PostMapping(value = "/employee/create")
	    public ResponseDataDTO<Object> create(@RequestBody EmployeeDTO employee){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(employeeService.create(employee));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @PutMapping(value= "/employee/update")
	    public ResponseDataDTO<Object> update(@RequestBody EmployeeDTO employee, int id){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(employeeService.update(id, employee));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @DeleteMapping(value= "/employee/delete")
	    public ResponseDataDTO<Object> delete(@RequestBody int[] ids){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(employeeService.delete(ids));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
//	    @GetMapping(value= "/employee/search")
//	    public ResponseDataDTO<Object> search(String employeeName, String employeeNo, String nation, String identityCard,
//				Date dob, String phone, String email, Integer page, Integer size ){
//	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
//	    	if(page==null)
//	    		page=0;
//	    	if(size==null)
//	    		size=9999;
//	    	try {
//	    		response.setData(employeeService.search(employeeName, employeeNo, nation, identityCard, dob,phone, email, page, size));
//	    		response.setCode(Constants.OK);
//	    		response.setMessage(Constants.SUCCESS);
//	    	} catch(Exception e) {
//	    		response.setData(null);
//				response.setCode(Constants.BAD_REQUEST);
//				response.setMessage(Constants.FAILED);
//				e.printStackTrace();
//	    	}
//	    	return response;
//	    }
}
