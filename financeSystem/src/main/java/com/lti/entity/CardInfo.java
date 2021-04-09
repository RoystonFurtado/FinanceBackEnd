package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "card_info")
public class CardInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cardNoSeq")
	@SequenceGenerator(sequenceName = "card_no_seq",allocationSize = 1,name = "cardNoSeq")
	@Column(name = "card_no")
	private int cardNo;
	
	@Column(name="card_balance")
	private double cardBalance;
	
	@Column(name = "card_expiry_date")
	private LocalDate cardExpiryDate;
	
	@Column(name = "card_credit_used")
	private double cardCreditUsed;
	
	@OneToOne(mappedBy="cardInfo")
	private User user;

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public double getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(double cardBalance) {
		this.cardBalance = cardBalance;
	}

	public LocalDate getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(LocalDate cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public double getCardCreditUsed() {
		return cardCreditUsed;
	}

	public void setCardCreditUsed(double cardCreditUsed) {
		this.cardCreditUsed = cardCreditUsed;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
