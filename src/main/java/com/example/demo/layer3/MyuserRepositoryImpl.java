package com.example.demo.layer3;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Myuser;

@Repository
public class MyuserRepositoryImpl extends BaseRepository implements MyuserRepository {
	
	@Transactional
	public Myuser selectMyuser(long userId) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Myuser.class, userId);
	}
	
	@Transactional
	public Myuser selectMyuserByEmail(String email)  {
		EntityManager entityManager = getEntityManager();
		TypedQuery<Myuser> query = entityManager.createQuery("from Myuser m where m.email=:vemail",Myuser.class);
		query.setParameter("vemail", email);
		return query.getSingleResult();
	}
	@Transactional
	public void insertUser(Myuser user) {
		EntityManager entityManager = getEntityManager();
		entityManager.merge(user);
		}
}
