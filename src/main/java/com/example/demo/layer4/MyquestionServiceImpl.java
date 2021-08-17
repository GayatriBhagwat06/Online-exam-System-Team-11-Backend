package com.example.demo.layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myquestion;
import com.example.demo.layer3.MyquestionRepositoryImpl;
@Service
public class MyquestionServiceImpl implements MyquestionService {
	
	@Autowired
	MyquestionRepositoryImpl myQuestRepoImpl;
	@Override
	public List<Myquestion> getQuestionBySubjectIdLevelIDService(long subjectId, long levelId) {
		
		return myQuestRepoImpl.selectQuestionByLevelIdSubjectId(subjectId,levelId);
	}

}
