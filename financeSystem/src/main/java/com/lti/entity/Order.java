package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_data")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderIdSeq")
	@SequenceGenerator(sequenceName = "order_id_seq",allocationSize = 1,name = "orderIdSeq")
	@Column(name = "order_id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "amount_paid")
	private double amountPaid;
	
	@Column(name = "tenure_period")
	private int tenurePeriod;
	
	@Column(name = "purchase_date")
	private LocalDateTime purchaseDate;
	
	@Column(name = "amount_balance")
	private double amountBalance;
	
	@Column(name = "emi_months_paid")
	private int EMIMonthsPaid;
	
	@Column(name = "order_status")
	private String OrderStatus;
	
	@Column(name = "monthly_emi_amount")
	private double monthlyEMIAmount;
	
	@OneToMany(mappedBy="order")
	private List<Installment> installments;

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getTenurePeriod() {
		return tenurePeriod;
	}

	public void setTenurePeriod(int tenurePeriod) {
		this.tenurePeriod = tenurePeriod;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getAmountBalance() {
		return amountBalance;
	}

	public void setAmountBalance(double amountBalance) {
		this.amountBalance = amountBalance;
	}

	public int getEMIMonthsPaid() {
		return EMIMonthsPaid;
	}

	public void setEMIMonthsPaid(int eMIMonthsPaid) {
		EMIMonthsPaid = eMIMonthsPaid;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public double getMonthlyEMIAmount() {
		return monthlyEMIAmount;
	}

	public void setMonthlyEMIAmount(double monthlyEMIAmount) {
		this.monthlyEMIAmount = monthlyEMIAmount;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}

}
