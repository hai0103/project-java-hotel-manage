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

import com.example.demo.dtos.DeviceDTO;
import com.example.demo.dtos.ResponseDataDTO;
import com.example.demo.services.DeviceService;
import com.example.demo.utils.Constants;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DeviceController {
	 @Autowired
	  DeviceService deviceService;
	  
		@GetMapping(value = "/device/all")
		public ResponseDataDTO<Object> getAll(){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
			try {
				response.setData(deviceService.all());
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

	    @PostMapping(value = "/device/create")
	    public ResponseDataDTO<Object> create(@RequestBody DeviceDTO device){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(deviceService.create(device));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @PutMapping(value= "/device/update")
	    public ResponseDataDTO<Object> update(@RequestBody DeviceDTO device, int id){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(deviceService.update(id, device));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
	    @DeleteMapping(value= "/device/delete")
	    public ResponseDataDTO<Object> delete(@RequestBody int[] ids){
	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
	    	try {
	    		response.setData(deviceService.delete(ids));
	    		response.setCode(Constants.OK);
	    		response.setMessage(Constants.SUCCESS);
	    	} catch(Exception e) {
	    		response.setData(null);
				response.setCode(Constants.BAD_REQUEST);
				response.setMessage(Constants.FAILED);
	    	}
	    	return response;
	    }
	    
//	    @GetMapping(value= "/device/search")
//	    public ResponseDataDTO<Object> search(String DeviceName, String DeviceNo, String nation, String identityCard,
//				Date dob, String phone, String email, Integer page, Integer size ){
//	    	ResponseDataDTO<Object> response = new ResponseDataDTO<> ();
//	    	if(page==null)
//	    		page=0;
//	    	if(size==null)
//	    		size=9999;
//	    	try {
//	    		response.setData(deviceService.search(DeviceName, DeviceNo, nation, identityCard, dob,phone, email, page, size));
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
