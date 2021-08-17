package com.example.demo.layer4;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.layer2.Myquestion;


@Service
public interface MyquestionService {
	List<Myquestion >getQuestionBySubjectIdLevelIDService(long subjectId,long levelId);
	

}
