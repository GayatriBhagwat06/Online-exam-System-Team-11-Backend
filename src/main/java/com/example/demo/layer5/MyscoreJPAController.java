package com.example.demo.layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Myquestion;
import com.example.demo.layer2.Myscore;
import com.example.demo.layer3.MyquestionRepositoryImpl;
import com.example.demo.layer3.MyscoreRepositoryImpl;
import com.example.demo.layer4.MyscoreServiceImpl;

@CrossOrigin(origins = "*")
@RestController 
@RequestMapping("/Myscore")
public class MyscoreJPAController {
	
	@Autowired
	MyscoreRepositoryImpl myScoreRepoImpl;
	@Autowired
	MyscoreServiceImpl myscoreServ;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getReports/{userid}")
	public List<Myscore> getUserReport(@PathVariable long userid) {
		System.out.println("getUserReport()...method ");
		
		List<Myscore> output = myscoreServ.getReportService(userid);
		 return output;
	}
	@ResponseBody
	@PostMapping(value="/addScore/{uid}/{sid}")
	public void addScore(@RequestBody Myscore score, @PathVariable long uid,@PathVariable long sid) {
		System.out.println("Adding score... Controller layer");
		myscoreServ.addMyuserScoreService(score, uid, sid);
	}
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getReportsBySubject/{userid}/{subjectid}")
	public List<Myscore> getUserReportBySUbjectId(@PathVariable long userid,@PathVariable long subjectid) {
		System.out.println("getUserReport()...method ");
		
		List<Myscore> output =  myscoreServ.getReportBySubjectIdService(userid,subjectid);
		 return output;
	}
	
	
	

}
