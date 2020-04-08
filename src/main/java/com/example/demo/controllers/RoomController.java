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
import com.example.demo.dtos.RoomDTO;
import com.example.demo.services.RoomService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RoomController {
	  @Autowired
	  RoomService roomService;
		@GetMapping(value = "/room/all")
		public ResponseDataDTO<Object> getAll(){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
			try {
				response.setData(roomService.all());
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

	    @PostMapping(value = "/room/create")
	    public ResponseDataDTO<Object> create(@RequestBody RoomDTO room){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(roomService.create(room));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @PutMapping(value= "/room/update")
	    public ResponseDataDTO<Object> update(@RequestBody RoomDTO room, int id){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(roomService.update(id, room));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @DeleteMapping(value= "/room/delete")
	    public ResponseDataDTO<Object> delete(@RequestBody int[] ids){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(roomService.delete(ids));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @GetMapping(value= "/room/search")
	    public ResponseDataDTO<Object> search(String roomNo, Integer roomTypeId, String status, String statusStay, Integer nop, Integer page, Integer size ){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	if(page==null)
	    		page=0;
	    	if(size==null)
	    		size=9999;
	    	try {
	    		response.setData(roomService.search(roomNo, roomTypeId, status, statusStay, nop, page, size));
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
