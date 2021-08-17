package com.example.demo.layer3;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myscore;
import com.example.demo.layer2.Myuser;

@Repository
@Transactional
public class MyscoreRepositoryImpl extends BaseRepository implements MyScoreRepository {

	@Override
	public List<Myscore> getReport(long userId) {
		
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery(" from Myscore where user_id=:userId");
		Myuser myuser=new Myuser();
		myuser.setUserId(userId);
		query.setParameter("userId",userId);
		List<Myscore> output=query.getResultList();
		System.out.println(output.get(0));
		return output;
	}
	@Transactional
	public List<Myscore> getReportBySubjectId(long userId,long subjectId){
		EntityManager entityManager=getEntityManager();

		Query query=entityManager.createQuery("select r from Myscore r where r.myuser=:userId and r.myexam=:subjectId");
		Myuser myuser=new Myuser();
		myuser.setUserId(userId);
		query.setParameter("userId",myuser);
		Myexam myexam=new Myexam();
		myexam.setSubjectId(subjectId);
		query.setParameter("subjectId",myexam);
		List<Myscore> output=query.getResultList();
		return output;
	}


	


	@Transactional
	public void addMyuserScore(Myscore score,long userId, long subjectId) {
		
		Myuser user = getEntityManager().find(Myuser.class, userId);
		Myexam exam = getEntityManager().find(Myexam.class, subjectId);
		score.setMyuser(user);
		score.setMyexam(exam);
		getEntityManager().merge(score);
	}

	
	

		
	}






