package com.techtalk.springboot.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.techtalk.springboot.model.Pincode;
import com.techtalk.springboot.repository.PincodeRepository;

@Service
public class PincodeService implements PincodeRepository {

	private static final String CACHE_NAME = "Pincode";

	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, Long, Pincode> hashOperations;

	@Autowired
	public PincodeService(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Pincode pincode) {
		hashOperations.put(CACHE_NAME, pincode.getId(), pincode);
	}

	@Override
	public Pincode find(Long id) {
		return hashOperations.get(CACHE_NAME, id);
	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(CACHE_NAME, id);

	}

	@Override
	public Map<Long, Pincode> findAllPincodes() {
		return hashOperations.entries(CACHE_NAME);
	}

}