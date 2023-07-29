package com.cg.mobilebilling.beans;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "mb_seq", sequenceName = "mb_seq", initialValue=700920000, allocationSize = 0)
public class PostpaidAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mb_seq")
	private long mobileNo;
	@OneToOne
	private Plan plan;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="postpaidAccount")
	private  Map<Integer, Bill> bills;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;
	
	public PostpaidAccount() {}
	public PostpaidAccount(Plan plan, Map<Integer, Bill> bills, Customer customer) {
		super();
		this.plan = plan;
		this.bills = bills;
		this.customer = customer;
	}
	
	public PostpaidAccount(long mobileNo, Plan plan, Map<Integer, Bill> bills, Customer customer) {
		super();
		this.mobileNo = mobileNo;
		this.plan = plan;
		this.bills = bills;
		this.customer = customer;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public Map<Integer, Bill> getBills() {
		return bills;
	}
	public void setBills(Map<Integer, Bill> bills) {
		this.bills = bills;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "PostpaidAccount [mobileNo=" + mobileNo + ", plan=" + plan + ", bills=" + bills + ", customer="
				+ customer + "]";
	}
	
}