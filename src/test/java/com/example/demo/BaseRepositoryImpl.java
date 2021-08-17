package com.example.demo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.layer3.BaseRepository;

@Repository
public class BaseRepositoryImpl extends BaseRepository {
	public EntityManager getEntityManager(){
	EntityManager entityManager = super.getEntityManager();
	return entityManager;
	}
	
	@Transactional
	public void saveRecord(Object o) {
		getEntityManager().persist(o);
	}
}
