package com.example.demo.layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the MYSCORE database table.
 * 
 */
@Entity
@Table(name="Myscore")
@NamedQuery(name="Myscore.findAll", query="SELECT m FROM Myscore m")
public class Myscore implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="score_id")
	private long score_id;

	public long getScore_id() {
		return score_id;
	}

	public void setScore_id(long score_id) {
		this.score_id = score_id;
	}

	@Column(name="L1_SCORE")
	private BigDecimal l1Score;

	@Column(name="L2_SCORE")
	private BigDecimal l2Score;

	@Column(name="L3_SCORE")
	private BigDecimal l3Score;

	//bi-directional many-to-one association to Myexam
	
	@ManyToOne
	@JoinColumn(name="SUBJECT_ID")
	private Myexam myexam;

	//bi-directional many-to-one association to Myuser
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Myuser myuser;

	public Myscore() {
	}

	public BigDecimal getL1Score() {
		return this.l1Score;
	}

	public void setL1Score(BigDecimal l1Score) {
		this.l1Score = l1Score;
	}

	public BigDecimal getL2Score() {
		return this.l2Score;
	}

	public void setL2Score(BigDecimal l2Score) {
		this.l2Score = l2Score;
	}

	public BigDecimal getL3Score() {
		return this.l3Score;
	}

	public void setL3Score(BigDecimal l3Score) {
		this.l3Score = l3Score;
	}
	
	public Myexam getMyexam() {
		return this.myexam;
	}

	public void setMyexam(Myexam myexam) {
		this.myexam = myexam;
	}
	
	public Myuser getMyuser() {
		return this.myuser;
	}

	public void setMyuser(Myuser myuser) {
		this.myuser = myuser;
	}
	//Myscore 
	public Myscore(Myexam exam, Myuser user, BigDecimal i, BigDecimal i1,BigDecimal i2) {
	        exam=this.myexam;
	        user=this.myuser;
	        this.l1Score=i;
	        this.l2Score=i1;
	        this.l3Score=i2;
	 
	    }
	public Myscore(Myexam exam, Myuser user, BigDecimal i) {
        exam=this.myexam;
        user=this.myuser;
        this.l1Score=i;
 
    }
	public Myscore(Myexam exam, Myuser user, BigDecimal i, BigDecimal i1) {
	        exam=this.myexam;
	        user=this.myuser;
	        this.l1Score=i;
	        this.l2Score=i1;
	    }

}