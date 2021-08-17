package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the MYQUESTION database table.
 * 
 */
@Entity
@Table(name="Myquestion")
@NamedQuery(name="Myquestion.findAll", query="SELECT m FROM Myquestion m")
public class Myquestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="QUESTION_ID")
	private long questionId;

	private String answer;

	@Column(name="OPTION_1")
	private String option1;

	@Column(name="OPTION_2")
	private String option2;

	@Column(name="OPTION_3")
	private String option3;

	@Column(name="OPTION_4")
	private String option4;

	private String question;

	//bi-directional many-to-one association to Myexam
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Myexam myexam;

	//bi-directional many-to-one association to Mylevel
	@ManyToOne
	@JoinColumn(name="LEVEL_ID")
	private Mylevel mylevel;

	

	public long getQuestionId() {
		return this.questionId;
	}

	

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOption1() {
		return this.option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return this.option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return this.option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return this.option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Myexam getMyexam() {
		return this.myexam;
	}

	public void setMyexam(Myexam myexam) {
		this.myexam = myexam;
	}
	
	public Mylevel getMylevel() {
		return this.mylevel;
	}

	public void setMylevel(Mylevel mylevel) {
		this.mylevel = mylevel;
	}
//	public Myquestion() {
//		this.mylevel=level;
//		this.myexam=exam;
//		this.question=ques;
//		this.option1=opt1;
//		this.option2=opt2;
//		this.option3=opt3;
//		this.option4=opt4;
//		this.answer=ans;
//		
//		
//		
//		}
	public Myquestion() {}


	public Myquestion(Mylevel level, String ques, String opt1, String opt2, String opt3,
			String opt4, String ans) {
		this.mylevel=level;
	
		this.question=ques;
		this.option1=opt1;
		this.option2=opt2;
		this.option3=opt3;
		this.option4=opt4;
		this.answer=ans;}
	public Myquestion(Mylevel level,Myexam exam, String ques, String opt1, String opt2, String opt3,
			String opt4, String ans) {
		this.mylevel=level;
		this.myexam=exam;
		this.question=ques;
		this.option1=opt1;
		this.option2=opt2;
		this.option3=opt3;
		this.option4=opt4;
		this.answer=ans;}



	public Myquestion(Myexam exam, String ques, String opt1, String opt2, String opt3,
			String opt4, String ans) {
		this.myexam=exam;
	
		this.question=ques;
		this.option1=opt1;
		this.option2=opt2;
		this.option3=opt3;
		this.option4=opt4;
		this.answer=ans;}


}