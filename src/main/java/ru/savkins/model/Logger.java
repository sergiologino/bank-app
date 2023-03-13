package ru.savkins.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

// здесь структура данных (модель) - свыойства отражают поля БД, + геттеры сеттеры и конструкторы
@Entity
public class Logger {
//	@EmbeddedId
//	private LoggerPk id; 
	@Id
	private int acctID;
	private String transacType;
	private String transacStatus;
	private int initBal;
	private int finalBal;
	private Date date_create;

	public Date getDate_create() {
		return date_create;
	}

	public void setDate_create(Date date_create) {
		this.date_create = date_create;
	}

	public Logger() {

	}

	public Logger(int acctID, String transacType, String transacStatus, int initBal, int finalBal, Date date_create) {
		super();
		this.acctID = acctID;
		this.transacType = transacType;
		this.transacStatus = transacStatus;
		this.initBal = initBal;
		this.finalBal = finalBal;
		this.date_create = date_create;
	}

	public int getAcctID() {
		return acctID;
	}

	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}

	public String getTransacType() {
		return transacType;
	}

	public void setTransacType(String transacType) {
		this.transacType = transacType;
	}

	public String getTransacStatus() {
		return transacStatus;
	}

	public void setTransacStatus(String transacStatus) {
		this.transacStatus = transacStatus;
	}

	public int getInitBal() {
		return initBal;
	}

	public void setInitBal(int initBal) {
		this.initBal = initBal;
	}

	public int getFinalBal() {
		return finalBal;
	}

	public void setFinalBal(int finalBal) {
		this.finalBal = finalBal;
	}

}
