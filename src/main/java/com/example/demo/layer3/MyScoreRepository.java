package com.example.demo.layer3;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Myscore;

@Repository
public interface MyScoreRepository {
	List<Myscore> getReport(long userId);
	List<Myscore> getReportBySubjectId(long userId,long subjectId);
	void addMyuserScore(Myscore score, long userId, long subjectId);

}
