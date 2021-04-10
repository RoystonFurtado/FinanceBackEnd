package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

 @Entity
 public class Installment {
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "installment_id")
	 private int installmentId;
	 
	 @Column(name = "installment_no")
	 private int installmentNo;
	 
	 @Column(name = "due_date")
	 private LocalDate dueDate;
	 
	 @Column(name = "installment_status")
	 private String installmentStatus;
	 
	 @ManyToOne
	 @JoinColumn(name = "order_id")
	 private Order order;
	 
	 @OneToOne(cascade = CascadeType.MERGE)
	 @JoinColumn(name = "payment_id")
	 private Payment payment;

	public int getInstallmentId() {
		return installmentId;
	}

	public void setInstallmentId(int installmentId) {
		this.installmentId = installmentId;
	}

	public int getInstallmentNo() {
		return installmentNo;
	}

	public void setInstallmentNo(int installmentNo) {
		this.installmentNo = installmentNo;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getInstallmentStatus() {
		return installmentStatus;
	}

	public void setInstallmentStatus(String installmentStatus) {
		this.installmentStatus = installmentStatus;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}