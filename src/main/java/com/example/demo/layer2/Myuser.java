package com.example.demo.layer2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Myuser")

public class Myuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="CITY")
	private String city;

	@Column(name="COUNTRY")
	private String country;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MOBILE_NO")
	private String mobileNo;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="QUALIFICATION")
	private String qualification;

	@Column(name="STATE")
	private String state;

	@Column(name="YEAR_OF_COMPLETION")
	private BigDecimal yearOfCompletion;

	public Myuser() {
		super();
		System.out.println("Myuser() ctor...");
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getYearOfCompletion() {
		return this.yearOfCompletion;
	}

	public void setYearOfCompletion(BigDecimal yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}
	//bi-directional many-to-one association to Myscore
		@OneToMany(cascade = CascadeType.ALL, mappedBy="myexam")
		private List<Myscore> myscores;
        @JsonIgnore
		public List<Myscore> getMyscores() {
			return myscores;
		}

		public void setMyscores(List<Myscore> myscores) {
			this.myscores = myscores;
		}


}