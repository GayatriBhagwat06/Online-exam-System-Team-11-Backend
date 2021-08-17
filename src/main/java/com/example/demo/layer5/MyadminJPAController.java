package com.example.demo.layer5;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.layer2.Myadmin;
import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Mylevel;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myscore;
import com.example.demo.layer2.Myuser;
import com.example.demo.layer3.MyadminRepositoryImpl;
import com.example.demo.layer4.MyadminServiceImpl;



@CrossOrigin(origins = "*")
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/Myadmin")
public class MyadminJPAController {

	@Autowired
	MyadminServiceImpl myadminService;
	
	public MyadminJPAController() {
		super();
		System.out.println("MyAdminJPAController() created...");
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/greet")
	String greetMyuser() {
		return "Welcome Admin"; //connect to the DB also via spring JPA
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAdmin/{uno}")
	public Myadmin getMyuser(@PathVariable long uno)  {
		System.out.println("getMyadmin()...Controller layer ");
		return myadminService.selectMyadminService(uno);
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllAdmins")
	public List<Myadmin> getAdmins() {
	System.out.println("getAdmins()...Controller layer ");
	return myadminService.selectAllAdminsService();
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getAdminByEmail/{uEmail}")
	public Myadmin getMyadminByEmail(@PathVariable String uEmail) {
		System.out.println("getMyadminByEmail()...Controller layer ");
		return myadminService.selectMyadminByEmailService(uEmail);
		
	}


	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllSubjects")
	public List<Myexam> getAllSubjects() {
	System.out.println("getSubjects() ");
	return myadminService.selectAllSubjectsService();
	} 
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllUserWithScore")
	public List<Myuser> getAllUserWithScore()  {
	System.out.println("getUsers() ");
	return myadminService.selectUserWithScoreService();
	
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllQuestions")
	public List<Myquestion> getAllQuestions() {
	System.out.println("getQuestions() ");
	return myadminService.selectAllQuestionsService();
	
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/getAllLevels")
	public List<Mylevel> getAllLevels() {
	System.out.println("getQuestions() ");
	return myadminService.selectAllLevelsService();
	
	}
	@ResponseBody
	@DeleteMapping(value="/deleteQuestions/{qno}")
	public void deleteQuestions(@PathVariable long qno)  {
		System.out.println("deleteQuestions()...method ");
		myadminService.deleteQuestionsService(qno);
		
		
	}	
	
	@ResponseBody
	@PostMapping(path="/addQuestions/{levelId}/{examId}")
	public void addQuestions(@PathVariable long levelId,@PathVariable long examId,@RequestBody Myquestion newques) {
	
	System.out.println("adding question controller");
	myadminService.addQuestionsService(newques, levelId, examId);
		
	}
	
	
	
	
}