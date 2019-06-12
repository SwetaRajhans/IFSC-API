package com.bank.ifsc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_details")
public class BankModel {
	
	
	String bank;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String ifsc;
	String branch;
	String address;
	String contact;
	String city;
	String district;
	String state;
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BankModel(String bank, String ifsc, String branch, String address, String contact, String city,
			String district, String state) {
		super();
		this.bank = bank;
		this.ifsc = ifsc;
		this.branch = branch;
		this.address = address;
		this.contact = contact;
		this.city = city;
		this.district = district;
		this.state = state;
	}
	public BankModel() {
		super();
	}
	
	
	
	

}
