package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paymentIdSeq")
	@SequenceGenerator(sequenceName = "payment_id_seq",allocationSize = 1,name = "paymentIdSeq")
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name = "payment_date")
	private LocalDateTime paymentDate;
	
	@Column(name = "payment_amount")
	private double paymentAmount;
	
	@Column(name = "fine_amount")
	private double fineAmount;
	
	@OneToOne(mappedBy="payment")
	private Installment installment;

	
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Installment getInstallment() {
		return installment;
	}

	public void setInstallment(Installment installment) {
		this.installment = installment;
	}
	
	}