package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myuser;
import com.example.demo.layer3.MyquestionRepositoryImpl;
import com.example.demo.layer3.MyuserRepositoryImpl;
import com.example.demo.layer4.MyuserServiceImpl;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/Myuser")
public class MyuserJPAController {

	
	@Autowired
	MyuserServiceImpl userService;
	
	
	public MyuserJPAController() {
		super();
		System.out.println("MyUserJPAController() created...");
	}
	

	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/greet")
	String greetMyuser() {
		return "Welcome User"; //connect to the DB also via spring JPA
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getUser/{uno}")
	public Myuser getMyuser(@PathVariable long uno) {
		System.out.println("getMyuser()... Controller layer ");
		return userService.selectMyuserService(uno);
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getUserByEmail/{uEmail}")
	public Myuser getMyuserByEmail(@PathVariable String uEmail) {
		System.out.println("getMyuserByEmail()...Controller layer ");
		
		return userService.selectMyuserByEmailService(uEmail);
	}
	@PostMapping("/register")
	public ResponseEntity insertUser( @RequestBody Myuser user)
	{
		 userService.insertUserService(user);
		//return "Registration Successful";
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
}


