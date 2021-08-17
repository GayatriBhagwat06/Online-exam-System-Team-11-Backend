package com.example.demo.layer3;
import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Mylevel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myuser;

@Repository
public class MyquestionRepositoryImpl  extends BaseRepository implements MyquestionRepository{

	

	@Override 
	public List<Myquestion>selectQuestionByLevelIdSubjectId(long sid,long lid) {
		EntityManager entityManager=getEntityManager();
		Query query = entityManager.createQuery("select s from Myquestion s where s.myexam =:sid and s.mylevel=:lid");
		Myexam exam = new Myexam();
		exam.setSubjectId(sid);
		query.setParameter("sid", exam);
		Mylevel level=new Mylevel();
		level.setLevelId(lid);
		query.setParameter("lid",level);
		List<Myquestion> result=query.getResultList();
		return result;

	}

	


	

}
