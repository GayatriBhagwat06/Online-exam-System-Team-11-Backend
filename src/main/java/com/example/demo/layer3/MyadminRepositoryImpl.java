package com.example.demo.layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Myadmin;
import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Mylevel;
import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myuser;

@Repository
public class MyadminRepositoryImpl extends BaseRepository implements MyadminRepository {
	@Transactional
	public Myadmin selectMyadmin(long userId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Myadmin.class, userId);
	}
	@Transactional
	public List<Myadmin> selectAllAdmins() {
		EntityManager entityManager = getEntityManager();
		//EntityTransaction tx = entityManager.getTransaction();
		//tx.begin();
		Query query = entityManager.createQuery(" from Myadmin");
		List<Myadmin> adminList = query.getResultList();
		System.out.println("adminList "+adminList.size());
		for (Myadmin employee : adminList) {
			System.out.println("firstname "+employee. getFirstName());
			System.out.println("lastname "+employee. getLastName());
		}
		//tx.commit();
		return adminList;
	}
	
	@Transactional
	public Myadmin selectMyadminByEmail(String userEmail)  {
		EntityManager entityManager = getEntityManager();
		TypedQuery<Myadmin> query = entityManager.createQuery("from Myadmin m where m.userEmail=:vemail",Myadmin.class);
		query.setParameter("vemail", userEmail);
		return query.getSingleResult();
	}
	
	@Transactional
	public Myuser selectMyuser(long userId)  {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Myuser.class, userId);
	}
	@Transactional
	public List<Myexam> selectAllSubjects() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("from Myexam ");
		List<Myexam> userList = query.getResultList();
		System.out.println("userList "+userList.size());
		for (Myexam userlist : userList) {
			System.out.println("exam name:"+userlist.getSubjectName());
		}
		return userList;
	}
	
	
	@Transactional
	public List<Myquestion> selectAllQuestions() {
		EntityManager entityManager = getEntityManager();
	
		Query query = entityManager.createQuery("from Myquestion ");
		List<Myquestion> quesList = query.getResultList();
		System.out.println("quesList "+quesList.size());

		return quesList;
	}
	@Transactional
	public void deleteQuestions(long qno)  {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Myquestion foundQ = entityManager.find(Myquestion.class, qno); //find it 
		if(foundQ!=null)
			entityManager.remove(foundQ); // based on PK
		
		System.out.println("EntityManager: Question removed.. ");

	}
	
	@Transactional
	
	public void addQuestion(Myquestion newques, long levelId, long examId) {
		// TODO Auto-generated method stub
		Mylevel level = getEntityManager().find(Mylevel.class, levelId);
		Myexam exam = getEntityManager().find(Myexam.class, examId);
		newques.setMylevel(level);
		newques.setMyexam(exam);
	
		getEntityManager().merge(newques);

	}
	

	@Transactional
	public List<Myuser> selectUserWithScore() {
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("select u from Myscore u  ");
		List<Myuser> scoreList = query.getResultList();
		System.out.println("scoreList "+scoreList.size());

		return scoreList;
	}
	@Transactional
	public List<Mylevel> selectAllLevels() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("from Mylevel ");
		List<Mylevel> levelList = query.getResultList();
		System.out.println("levelList "+levelList.size());

		return levelList;
	}
	@Override
	public List<Myuser> selectAllUsers() {
		return null;
	}
}
