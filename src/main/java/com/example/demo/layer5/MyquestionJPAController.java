package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Myquestion;
import com.example.demo.layer3.MyquestionRepositoryImpl;
import com.example.demo.layer4.MyquestionServiceImpl;


@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/Myquestion")
public class MyquestionJPAController {
	
	@Autowired
	MyquestionServiceImpl myQuestRServiceImpl;
	
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getQuestionByLevelSubjectID/{sid}/{lid}")
	public List<Myquestion> getQuestionBySubjectLevelID(@PathVariable long sid,@PathVariable long lid) {
		List<Myquestion> output=myQuestRServiceImpl.getQuestionBySubjectIdLevelIDService(sid,lid);
		return output;
		
	}

	

}
