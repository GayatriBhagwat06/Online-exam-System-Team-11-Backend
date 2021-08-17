package com.example.demo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Myadmin;
import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Mylevel;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myscore;
import com.example.demo.layer2.Myuser;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.MyadminRepositoryImpl;
import com.example.demo.layer3.MyscoreRepositoryImpl;
import com.example.demo.layer3.MyuserRepositoryImpl;
import com.example.demo.layer3.MyscoreRepositoryImpl;

@SpringBootTest
class OnlineExamProjectApplicationTests extends BaseRepository {
	@Autowired
	MyscoreRepositoryImpl scoreRepo;
	@Autowired
	MyadminRepositoryImpl adminRepo;
	@Autowired
	MyuserRepositoryImpl userRepo;


	@Test
	void contextLoads() {

	}
	@Test
	public void DisplayUserScoresTest() {
	List<Myscore> scoreob = scoreRepo.getReport(1);
	for(Myscore s: scoreob){
	System.out.print(s.getScore_id()+"\t");
	System.out.print(s.getL1Score()+"\t");
	System.out.print(s.getL2Score()+"\t");
	System.out.print(s.getMyexam().getSubjectName()+"\n");
	}
}
        
         @Test
         public void getUSerScoreBySubjectId(){
         System.out.println("Loading users and their scores...");
         List<Myscore> userList = scoreRepo.getReportBySubjectId(1,1);
         for (Myscore ques : userList) {
         System.out.print("Question : "+ques.getScore_id()+"\t");
         System.out.print(ques.getMyexam().getSubjectId()+"\t");
         System.out.print(ques.getMyexam().getSubjectName()+"\t");
         System.out.print(ques.getMyuser().getFirstName()+"\n");
         }
         }
         @Test
     	void selectUserTest()
     	{
     		System.out.println("Loading user...");
     		Myuser user = userRepo.selectMyuser(2);
     		System.out.println("------User Details------\n");
     		System.out.println("User ID	      : "+user.getUserId());
     		System.out.println("First Name    : "+user.getFirstName());
     		System.out.println("Last Name     : "+user.getLastName());
     		System.out.println("Date of Birth : "+user.getDateOfBirth());
     		System.out.println("Qualification : "+user.getQualification());
     		System.out.println("Mobile No.    : "+user.getMobileNo());
     		System.out.println("City          : "+user.getCity());
     		System.out.println("State         : "+user.getState());
     		System.out.println("Country       : "+user.getCountry());
     		System.out.println("Email ID      : "+user.getEmail());
     		System.out.println("\n------------------------");
     	}
     	
     	@Test
     	void selectUserByEmailTest() 
     	{
     		System.out.println("Loading user...");
     		Myuser user = userRepo.selectMyuserByEmail("jack@gmail.com");
     		System.out.println("------User Details------\n");
     		System.out.println("User ID	      : "+user.getUserId());
     		System.out.println("First Name    : "+user.getFirstName());
     		System.out.println("Last Name     : "+user.getLastName());
     		System.out.println("Date of Birth : "+user.getDateOfBirth());
     		System.out.println("Qualification : "+user.getQualification());
     		System.out.println("Mobile No.    : "+user.getMobileNo());
     		System.out.println("City          : "+user.getCity());
     		System.out.println("State         : "+user.getState());
     		System.out.println("Country       : "+user.getCountry());
     		System.out.println("Email ID      : "+user.getEmail());
     		System.out.println("\n------------------------");
     	}
     	
     	@Test
     	void selectAdminTest() 
     	{
     		System.out.println("Loading Admin...");
     		Myadmin admin = adminRepo.selectMyadmin(1);
     		System.out.println("------Admin Details------\n");
     		System.out.println("Admin ID	  : "+admin.getAdminId());
     		System.out.println("First Name    : "+admin.getFirstName());
     		System.out.println("Last Name     : "+admin.getLastName());
     		System.out.println("Mobile No.    : "+admin.getMobileNo());
     		System.out.println("Email ID      : "+admin.getUserEmail());
     		System.out.println("\n-------------------------");
     	}
     	
     	@Test
     	void selectAdminByEmailTest() 
     	{
     		System.out.println("Loading Admin...");
     		Myadmin admin = adminRepo.selectMyadminByEmail("Dinesh@gmail.com");
     		System.out.println("------Admin Details------\n");
     		System.out.println("Admin ID      : "+admin.getAdminId());
     		System.out.println("First Name    : "+admin.getFirstName());
     		System.out.println("Last Name     : "+admin.getLastName());
     		System.out.println("Mobile No.    : "+admin.getMobileNo());
     		System.out.println("Email ID      : "+admin.getUserEmail());
     		System.out.println("\n-------------------------");
     	}
     	LocalDate localDate=LocalDate.now();
    	
    	Date sqlDate=Date.valueOf(localDate);
    	int yearInt=2020;
    	BigDecimal year=BigDecimal.valueOf(yearInt);

    	
    	@Autowired
    	MyuserRepositoryImpl myUserRepo;
    	
    	@Test
    	void insertUserTest() {
    		System.out.println("Loading a User...");
    		Myuser user=new Myuser();
    		user.setCity("Mumbai");
    		user.setUserId(13);
    		user.setCountry("India");
    		user.setDateOfBirth(sqlDate);
    		user.setFirstName("Ishan");
    		user.setLastName("B");
    		user.setMobileNo("987676765");
    		user.setEmail("abc@gmail.com");
    		user.setPassword("56556457");
    		user.setState("Maha");
    		user.setQualification("btech");
    		user.setYearOfCompletion(year);
    		
    		myUserRepo.insertUser(user);
    	}
    	int num=80;
    	int num1 =90;
    	BigDecimal b=BigDecimal.valueOf(num);
    	BigDecimal b1=BigDecimal.valueOf(num1);
    	@Autowired
    	BaseRepositoryImpl base;
    	@Test
    	public void insertMyuserLevel2ScoreTest(){

    	    Myuser user=new Myuser();
    	    Myexam exam=new Myexam();
    	    exam.setSubjectId(3);
    	    user.setUserId(1);
    	    Myscore newscore=new Myscore(exam,user,b,b1);
    	    base.saveRecord(newscore);

    	}
    	int num4=80;
    	BigDecimal b2=BigDecimal.valueOf(num);
    	 
    	@Test
    	public void insertMyuserLevel1ScoreTest(){

    	    Myuser user=new Myuser();
    	    Myexam exam=new Myexam();
    	    exam.setSubjectId(3);
    	    user.setUserId(1);
    	    Myscore newscore=new Myscore(exam,user,b2);
    	    base.saveRecord(newscore);

    	}
    	int num7=80;
    	int num5 =90;
    	int num6=80;
    	BigDecimal b4=BigDecimal.valueOf(num7);
    	BigDecimal b5=BigDecimal.valueOf(num5);
    	BigDecimal b6=BigDecimal.valueOf(num6);
    	@Test
    	public void insertMyuserLevel3ScoreTest(){

    	    Myuser user=new Myuser();
    	    Myexam exam=new Myexam();
    	    exam.setSubjectId(3);
    	    user.setUserId(1);
    	    Myscore newscore=new Myscore(exam,user,b4,b5,b6);
    	    base.saveRecord(newscore);

    	}

    	
    	@Test
    	void addQuestions() {
    		Mylevel level=new Mylevel();
    		level.setLevelId(3);
    		Myexam exam=new Myexam();
    		exam.setSubjectId(6);
    		Myquestion newques=new Myquestion(level,exam,"new question inserted?","Option1","Option2","Option3"
    					,"Option4","Option4");
    			
    		base.saveRecord(newques);
    			
    			
    		}
    	@Test
    	void addQuestionswithoutlevelid() {
    			
    		Myexam exam=new Myexam();
    		exam.setSubjectId(6);
    		Myquestion newques=new Myquestion(exam,"new question inserted?","Option1","Option2","Option3"
    					,"Option4","Option4");
    			
    		base.saveRecord(newques);
    			
    			
    		}
    	@Test
    	void addQuestionswithoutsubjectid() {
    		Mylevel level=new Mylevel();
    		level.setLevelId(3);	
    		Myquestion newques=new Myquestion(level,"new question inserted?","Option1","Option2","Option3"
    					,"Option4","Option4");
    			
    		base.saveRecord(newques);
    			
    			
    	}
    	@Test
    	void selectAllQuestions()
   		{
    		System.out.println("Loading all the questions...");
    		List<Myquestion> quesList = adminRepo.selectAllQuestions();
    		System.out.println("quesList "+quesList.size());
    		for (Myquestion ques : quesList) {
    			System.out.println("Question : "+ques.getQuestion());
    		}
    	}

 }

    
         
   

