package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.layer2.Myadmin;
import com.example.demo.layer2.Mylevel;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myuser;


@Repository
public interface MyadminRepository {
	Myadmin selectMyadmin(long userId); 
	List<Myadmin> selectAllAdmins();
	Myadmin selectMyadminByEmail(String userEmail);
	
	Myuser selectMyuser(long userId); 
	List<Myuser> selectAllUsers();
	public List<Myuser> selectUserWithScore();
	public List<Myquestion> selectAllQuestions();
	List<Mylevel> selectAllLevels();


}
