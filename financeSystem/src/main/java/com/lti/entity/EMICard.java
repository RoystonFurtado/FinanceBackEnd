package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="emi_card")
public class EMICard {
	@Id
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "card_limit")
	private double cardLimit;
	
	@Column(name = "validity_period")
	private int validityPeriod;
	
	@Column(name = "joining_fee")
	private double joiningFee;
	
	@OneToMany(mappedBy="emiCard")
	private List<User> users;

	
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public int getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(int validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public double getJoiningFee() {
		return joiningFee;
	}

	public void setJoiningFee(double joiningFee) {
		this.joiningFee = joiningFee;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
