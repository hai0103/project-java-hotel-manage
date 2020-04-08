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
import com.example.demo.dtos.ResponseDataDTO;
import com.example.demo.dtos.TypeRoomDTO;
import com.example.demo.services.TypeRoomService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TypeRoomController {
	  @Autowired
	  TypeRoomService typeRoomService;
		@GetMapping(value = "/typeroom/all")
		public ResponseDataDTO<Object> getAll(){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
			try {
				response.setData(typeRoomService.all());
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

	    @PostMapping(value = "/typeroom/create")
	    public ResponseDataDTO<Object> create(@RequestBody TypeRoomDTO typeRoom){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(typeRoomService.create(typeRoom));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @PutMapping(value= "/typeroom/update")
	    public ResponseDataDTO<Object> update(@RequestBody TypeRoomDTO typeRoom, int id){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(typeRoomService.update(id, typeRoom));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @DeleteMapping(value= "/typeroom/delete")
	    public ResponseDataDTO<Object> delete(@RequestBody int[] ids){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(typeRoomService.delete(ids));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @GetMapping(value= "/typeroom/search")
	    public ResponseDataDTO<Object> search(String name, String description, Integer page, Integer size ){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	if(page==null)
	    		page=0;
	    	if(size==null)
	    		size=9999;
	    	try {
	    		response.setData(typeRoomService.search(name, description, page, size));
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
