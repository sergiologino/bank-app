package ru.savkins.model;

import javax.persistence.Entity;
import javax.persistence.Id;
// здесь структура данных (модель, DAO) - свыойства отражают поля БД, + геттеры сеттеры и конструкторы
@Entity
public class Accounts {
	@Id
	private int acctID;
	private int balance;
	private String acctStatus;

	public Accounts() {

	}

	public Accounts(int acctID, int balance, String acctStatus) {
		super();
		this.acctID = acctID;
		this.balance = balance;
		this.acctStatus = acctStatus;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAcctStatus() {
		return acctStatus;
	}

	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

}
