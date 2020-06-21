package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "transaction")
@CrossOrigin
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

	private long transactionId;
	private double amount;
	private String paymentDate;
	private long transasction_type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	} 
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public long getTransasction_type() {
		return transasction_type;
	}
	public void setTransasction_type(long transasction_type) {
		this.transasction_type = transasction_type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		result = prime * result + (int) (transasction_type ^ (transasction_type >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transasction_type != other.transasction_type)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", transasction_type=" + transasction_type + "]";
	}
	
	public Transaction(long transactionId, double amount, String paymentDate, long transasction_type) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.transasction_type = transasction_type;
	}
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
}
