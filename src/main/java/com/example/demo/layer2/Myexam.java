package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MYEXAM database table.
 * 
 */
@Entity
@Table(name="Myexam")
@NamedQuery(name="Myexam.findAll", query="SELECT m FROM Myexam m")
public class Myexam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUBJECT_ID")
	private long subjectId;

	

	@Column(name="SUBJECT_NAME")
	private String subjectName;

	//bi-directional many-to-one association to Myquestion
	@OneToMany( fetch = FetchType.EAGER,mappedBy="myexam")
	private List<Myquestion> myquestions;

	//bi-directional many-to-one association to Myscore
	@OneToMany(cascade = CascadeType.ALL,  mappedBy="myexam")
	private List<Myscore> myscores;

	public Myexam() {
	}

	public long getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
@JsonIgnore
	public List<Myquestion> getMyquestions() {
		return this.myquestions;
	}

	public void setMyquestions(List<Myquestion> myquestions) {
		this.myquestions = myquestions;
	}

	public Myquestion addMyquestion(Myquestion myquestion) {
		getMyquestions().add(myquestion);
		myquestion.setMyexam(this);

		return myquestion;
	}

	public Myquestion removeMyquestion(Myquestion myquestion) {
		getMyquestions().remove(myquestion);
		myquestion.setMyexam(null);

		return myquestion;
	}
@JsonIgnore
	public List<Myscore> getMyscores() {
		return this.myscores;
	}

	public void setMyscores(List<Myscore> myscores) {
		this.myscores = myscores;
	}

	public Myscore addMyscore(Myscore myscore) {
		getMyscores().add(myscore);
		myscore.setMyexam(this);

		return myscore;
	}

	public Myscore removeMyscore(Myscore myscore) {
		getMyscores().remove(myscore);
		myscore.setMyexam(null);

		return myscore;
	}

}