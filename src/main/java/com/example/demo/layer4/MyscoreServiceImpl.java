package com.example.demo.layer4;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myexam;
import com.example.demo.layer2.Myscore;
import com.example.demo.layer2.Myuser;
import com.example.demo.layer3.BaseRepository;
import com.example.demo.layer3.MyscoreRepositoryImpl;

@Service
public class MyscoreServiceImpl extends BaseRepository implements MyscoreService {
	
	
	@Autowired
	MyscoreRepositoryImpl scoreRepo;

	@Transactional
	public void addMyuserScoreService(Myscore score, long userId, long subjectId) {
		scoreRepo.addMyuserScore(score, userId, subjectId);
	}

	
	

	@Override
	public List<Myscore> getReportService(long userId) {
		return scoreRepo.getReport(userId);
	}

	@Override
	public List<Myscore> getReportBySubjectIdService(long userId, long subjectId) {
		return scoreRepo.getReportBySubjectId(userId, subjectId);
	}
	


}
