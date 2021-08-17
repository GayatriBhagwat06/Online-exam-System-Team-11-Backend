package com.example.demo.layer3;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Myuser;

@Repository
public interface MyuserRepository {
	Myuser selectMyuser(long userId);
	Myuser selectMyuserByEmail(String email);
	void insertUser(Myuser user);
}
