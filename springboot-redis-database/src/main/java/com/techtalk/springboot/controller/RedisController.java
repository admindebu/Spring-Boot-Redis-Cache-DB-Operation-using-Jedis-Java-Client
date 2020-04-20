package com.techtalk.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtalk.springboot.model.Pincode;
import com.techtalk.springboot.service.PincodeService;

@RestController
@RequestMapping("/redis/pincode")
public class RedisController {

	@Autowired
	private PincodeService pincodeService;

	@PostMapping
	public String saveNewPincode(@RequestBody Pincode pincode) {
		pincodeService.save(pincode);
		return "Successfully added : " + pincode.getPincodeVal() + " pincode";
		
	}

	@Cacheable(key="#id", value="picondes", unless = "#result.id < 1200")
	@GetMapping(path = "/{id}")
	public Pincode fetchStudent(@PathVariable("id") long id) {
		return pincodeService.find(id);
	}
	
	@CacheEvict(key="#id",value="picondes")
	@DeleteMapping(path = "/{id}")
	public String deleteOldPincode(@PathVariable("id") long id) {
		pincodeService.delete(id);
		return "Successfully removed #pincode with id : " + id;  
	}
	
	/*@Cacheable(key="#id", value="students", unless = "#result.id < 1200")*/
	@GetMapping
	public  Map<Long, Pincode> fetchAllPincodes() {
		return pincodeService.findAllPincodes();
	}
	
	//@CachePut - Update a Cache. Use it with PutMapping 
	/*@CachePut(key="#id",cacheNames="pincode")
	@PutMapping(path = "{id}")
	public String updateOldPincode(@PathVariable("id") long id,@RequestBody Pincode pincode) {
		pincodeService.update(id,pincode);
		return "Successfully update #pincode with id : " + id;  
	}
	*/
	
}