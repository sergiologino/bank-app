package ru.savkins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.savkins.dao.AccountsRepository;
import ru.savkins.model.Accounts;
// здесь сервисный слой - бизнес-логика сервиса, хотя здесь ее минимум
@Service
public class AccountService {

	private AccountsRepository accountRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int acctID) {
		return accountRepository.findById(acctID).orElse(null);
	}

	public void deleteAccount(int acctID) {
		accountRepository.deleteById(acctID);
	}

	public int getBalance(int acctID) {
		return accountRepository.findBalanceByAcctID(acctID);
	}

	public void putMoney(int acctID, int amount) {
		accountRepository.saveBalanceByAcctID(acctID, amount);
	}

	public void takeMoney(int acctID, int amount) {
		accountRepository.takeMoneyByAcctID(acctID, amount);
	}

	public void sendMoney(int acctID, int destAcctID, int amount) {
		accountRepository.takeMoneyByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}

}
