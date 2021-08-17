package com.example.demo.layer4;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myuser;
import com.example.demo.layer3.MyuserRepositoryImpl;
@Service
public class MyuserServiceImpl implements MyuserService {

	@Autowired
	MyuserRepositoryImpl myUserRepo;
	
	//@Override
	public Myuser selectMyuserService(long userId) {
		System.out.println("getMyuser()... Service Layer");
			return myUserRepo.selectMyuser(userId);
		 
	}
	
	public Myuser selectMyuserByEmailService(String email){
		System.out.println("getMyuserByEmail()... Service Layer");
			return myUserRepo.selectMyuserByEmail(email);
		
	}
	@Transactional
	public void insertUserService(Myuser user) {
		myUserRepo.insertUser(user);
	}


}
