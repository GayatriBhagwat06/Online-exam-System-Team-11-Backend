package com.example.demo.layer4;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myscore;
@Service
public interface MyscoreService {
	List<Myscore> getReportService(long userId);
	List<Myscore> getReportBySubjectIdService(long userId,long subjectId);
	void addMyuserScoreService(Myscore score, long userId, long subjectId);
	


}
