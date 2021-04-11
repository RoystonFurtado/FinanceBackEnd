package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_data")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userIdSeq")
	@SequenceGenerator(sequenceName = "user_id_seq",allocationSize = 1,name = "userIdSeq")
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "mobile_no")
	private long mobileNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	private String password;
	private String address;
	private LocalDate dob;
	
	@Column(name="document_id")
	private int documentId;
	
	@Column(name =  "profile_status")
	private String profileStatus;
	
	@ManyToOne
	@JoinColumn(name = "card_type")
	private EMICard emiCard;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "card_no")
	private CardInfo cardInfo;
	
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	public EMICard getEmiCard() {
		return emiCard;
	}

	public void setEmiCard(EMICard emiCard) {
		this.emiCard = emiCard;
	}

	public CardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
