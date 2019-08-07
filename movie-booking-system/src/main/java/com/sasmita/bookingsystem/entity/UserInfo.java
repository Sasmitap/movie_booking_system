package com.sasmita.bookingsystem.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="UserDetails")
public class UserInfo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id", length=10)
	private int userId;
	
	@Column(name="User_Name", length=150)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Date_Of_Birth", length=30)
	private Date dateOfBirth;
	
	@Column(name="MobNo", length=20)
	private String mobNo;
	
	@Column(name="EmailId", length=150)
	private String emailId;
	
	@Column(name="Sex", length=10)
	private String sex;
	
	@OneToMany(mappedBy="userInfo", fetch=FetchType.EAGER)
	private List<BookingInfo> bookingList;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public List<BookingInfo> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingInfo> bookingList) {
		this.bookingList = bookingList;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", mobNo=" + mobNo
				+ ", emailId=" + emailId + ", sex=" + sex + ", bookingList=" + bookingList + "]";
	}

}
