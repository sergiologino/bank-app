package ru.savkins.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.savkins.model.Accounts;
import ru.savkins.model.Logger;
import ru.savkins.service.AccountService;

import java.util.Date;

@Tag(name="Счета клиентов", description="Управление счетами клиентов: добавление счетов, получение баланса, переводы")
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
	@Operation(summary = "Получить баланс",description = "Получить баланс по id счета")
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID) {
		return accountService.getBalance(acctID);
	}

	// depositAmount
	@Operation(summary = "Пополнить баланс",description = "Пополнить баланс по id счета и сумме")
	@PutMapping("/account/{acctID}/putmoney/{amount}")
	public void depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.putMoney(acctID, amount);
		Logger logger = new Logger(acctID, "Deposited", "Success", initBal, initBal + amount, new Date());
		loggerController.addLog(logger);
	}

	// снять деньги
	@Operation(summary = "Снять деньги с баланса",description = "Получить деньги  по id счета и сумме")
	@PutMapping("/account/{acctID}/takeMoney/{amount}")
	public void takeMoney(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountService.takeMoney(acctID, amount);
		Logger logger = new Logger(acctID, "Withdrawn", "Success", initBal, initBal - amount, new Date());
		loggerController.addLog(logger);
	}

	// transferAmount
	@Operation(summary = "Послать деньги",description = "Послать деньги по id счета отправителя, получателя и сумме")
	@PutMapping("/account/{acctID}/sendmoney/{destAcctID}/{amount}")
	public void sendMoney(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountService.sendMoney(acctID, destAcctID, amount);
		Logger loggerSender = new Logger(acctID, "Transferred", "Success", initBalSender, initBalSender - amount, new Date());
		loggerController.addLog(loggerSender);
		Logger loggerReceiver = new Logger(destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount, new Date());
		loggerController.addLog(loggerReceiver);
	}

	// deleteAccount
	@Operation(summary = "Удалить счет",description = "Удалить счет по id счета")
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
		accountService.deleteAccount(acctID);
		loggerController.deleteLog(acctID);
	}

	// getAccountInfo
	@Operation(summary = "Получить данные счета",description = "Получить данные счета по id счета")
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		return accountService.getAccountInfo(acctID);
	}


}
