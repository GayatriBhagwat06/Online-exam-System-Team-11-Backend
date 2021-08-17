package com.example.demo.layer4;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myadmin;
import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Mylevel;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myuser;
import com.example.demo.layer3.MyadminRepositoryImpl;

@Service
public class MyadminServiceImpl implements MyadminService {
	@Autowired
	MyadminRepositoryImpl myAdminRepo;
	
	@Override
	public Myadmin selectMyadminService(long userId) {
		System.out.println("getMyadmin()...Service layer ");
			return myAdminRepo.selectMyadmin(userId);
			
	
	}
	
	public Myadmin selectMyadminByEmailService(String email) {
		System.out.println("getMyadminByEmail()... Service Layer");
		
			return myAdminRepo.selectMyadminByEmail(email);
		
	}

	
	@Override
	public List<Myadmin> selectAllAdminsService() {
		return myAdminRepo.selectAllAdmins();
	}
	
	@Transactional
	public List<Myexam> selectAllSubjectsService() {
		
		return myAdminRepo.selectAllSubjects();
	}
	@Transactional
	public void deleteQuestionsService(long qno) {
			myAdminRepo.deleteQuestions(qno);
		
	
	}
	
	@Transactional
	public List<Myquestion> selectAllQuestionsService() {
		
		return myAdminRepo.selectAllQuestions();
	}
	
	@Transactional
	public List<Myuser> selectUserWithScoreService() {
		
		return myAdminRepo.selectUserWithScore();
	}
	@Transactional
	public  void addQuestionsService(Myquestion qObj, long levelId, long examId) {
		myAdminRepo.addQuestion(qObj,levelId,examId);
		
	}
	
	@Transactional
	public List<Mylevel> selectAllLevelsService() {
		return myAdminRepo.selectAllLevels();
	}


}
