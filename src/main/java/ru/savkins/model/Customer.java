package ru.savkins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// здесь структура данных (модель) - свыойства отражают поля БД, + геттеры сеттеры и конструкторы
@Entity
public class Customer {
	@Id
	private int acctID;
	private String custname;
	private String city;
	private String state;
	private String country;
	private String phone_no;
	private String password;

	public Customer() {

	}

	public Customer(int acctID, String custname, String city, String state, String country, String phone_no,
			String password) {
		super();
		this.acctID = acctID;
		this.custname = custname;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone_no = phone_no;
		this.password = password;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public String getCustName() {
		return custname;
	}

	public void setCustName(String custname) {
		this.custname = custname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phone_no;
	}

	public void setPhoneNo(String phoneNo) {
		this.phone_no = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
