package ru.savkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.savkins.model.Accounts;
import ru.savkins.model.Logger;
import ru.savkins.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoggerController loggerController;

	// createAccount вызывается при создании клиента, не имеет http вызова
	public void createAccount(int acctID, int balance, String acctStatus) {
		Accounts acct = new Accounts(acctID, balance, acctStatus);
		accountService.createAccount(acct);
	}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// depositAmount
	@PutMapping("/account/{acctID}/putmoney/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.putMoney(acctID, amount);
		Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount);
		loggerController.addLog(logger);
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/takeMoney/{amount}")
	public void takeMoney(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.takeMoney(acctID, amount);
		Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount);
		loggerController.addLog(logger);
	}

	// transferAmount
	@PutMapping("/account/{acctID}/sendmoney/{destAcctID}/{amount}")
	public void sendMoney(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.sendMoney(acctID, destAcctID, amount);
		Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		loggerController.addLog(loggerSender);
		Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		loggerController.addLog(loggerReceiver);
	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
		accountService.deleteAccount(acctID);
		loggerController.deleteLog(acctID);
	}

	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}

}
