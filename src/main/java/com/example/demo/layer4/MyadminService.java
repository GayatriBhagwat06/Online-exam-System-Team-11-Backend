package com.example.demo.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myadmin;
import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Mylevel;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myuser;

@Service
public interface MyadminService {
	Myadmin selectMyadminService(long userId);
	List<Myadmin> selectAllAdminsService();
	Myadmin selectMyadminByEmailService(String userEmail);
	
	public List<Myexam> selectAllSubjectsService();
	public List<Mylevel> selectAllLevelsService();
	void deleteQuestionsService(long qno);
	public List<Myquestion> selectAllQuestionsService();
	public List<Myuser> selectUserWithScoreService() ;


}
