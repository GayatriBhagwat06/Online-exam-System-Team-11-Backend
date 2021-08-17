package com.example.demo.layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Myquestion;

@Repository
public interface MyquestionRepository {
	List<Myquestion> selectQuestionByLevelIdSubjectId(long sid,long lid);

}
