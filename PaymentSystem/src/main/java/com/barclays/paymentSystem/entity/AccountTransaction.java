package com.barclays.paymentSystem.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class AccountTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ColumnDefault("150")
	private Integer	trans_ref_num;
	private  Integer sequence_id;
	private LocalDate date;
	private Integer amount;
	private  String transaction_type;
	private Integer bill_ref_num;
	private String description;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "billSequenceId", unique = true)
//	private Bill bill;
	
//	public Bill getBill() {
//		return bill;
//	}
//	public void setBill(Bill bill) {
//		this.bill = bill;
//	}
	public Integer getBill_ref_num() {
		return bill_ref_num;
	}
	public void setBill_ref_num(Integer bill_ref_num) {
		this.bill_ref_num = bill_ref_num;
	}
	public Integer getSequence_id() {
		return sequence_id;
	}
	public void setSequence_id(Integer sequence_id) {
		this.sequence_id = sequence_id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public Integer getTrans_ref_num() {
		return trans_ref_num;
	}
	public void setTrans_ref_num(Integer trans_ref_num) {
		this.trans_ref_num = trans_ref_num;
	}

	@Override
	public String toString() {
		return "AccountTransaction [trans_ref_num=" + trans_ref_num + ", sequence_id=" + sequence_id + ", date="
				+ date + ", amount=" + amount + ", transaction_type=" + transaction_type + ", bill_ref_num="
				+ bill_ref_num + ", description=" + description + "]";
	}
	
	

}
