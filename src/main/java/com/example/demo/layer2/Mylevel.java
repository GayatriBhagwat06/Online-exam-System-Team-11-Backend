package com.example.demo.layer2;
import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
/**
 * The persistent class for the MYLEVEL database table.
 * 
 */
@Entity
@Table(name="Mylevel")
@NamedQuery(name="Mylevel.findAll", query="SELECT m FROM Mylevel m")
public class Mylevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LEVEL_ID")
	private long levelId;

	@Column(name="LEVEL_NAME")
	private String levelName;

	//bi-directional many-to-one association to Myquestion
	@OneToMany(mappedBy="mylevel")
	private List<Myquestion> myquestions;

	public Mylevel() {
	}

	public Mylevel(int i) {
		this.levelId=i;
	}

	public long getLevelId() {
		return this.levelId;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
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
		myquestion.setMylevel(this);

		return myquestion;
	}

	public Myquestion removeMyquestion(Myquestion myquestion) {
		getMyquestions().remove(myquestion);
		myquestion.setMylevel(null);

		return myquestion;
	}

}