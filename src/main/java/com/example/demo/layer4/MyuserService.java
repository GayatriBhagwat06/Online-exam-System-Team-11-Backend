package com.example.demo.layer4;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myuser;


@Service
public interface MyuserService {

	Myuser selectMyuserService(long userId);
	Myuser selectMyuserByEmailService(String email);
	void insertUserService(Myuser user);
}
