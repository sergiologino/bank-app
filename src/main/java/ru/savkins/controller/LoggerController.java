package ru.savkins.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.savkins.model.Logger;
import ru.savkins.service.LoggerService;

import java.util.Date;
import java.util.Optional;

@Tag(name = "История операций", description = "показать историю, удалить историю")
@RestController
public class LoggerController {
	@Autowired
	private LoggerService loggerService;

	// addLog
	public void addLog(Logger logger) {
		loggerService.addLog(logger);
	}

	// showLog
	@Operation(summary = "получить историю по id", description = "Получить историю операций по id")
	@GetMapping("/account/{acctID}/logs")
	public Logger showLog(@PathVariable int acctID) {
		return loggerService.showLog(acctID);
	}

	public void deleteLog(int acctID) {
		loggerService.deleteLog(acctID);
	}

	// getAccountHistorybyDates
	@Operation(summary = "получить историю по интервалу", description = "Получить историю операций по id и интервалу дат")
	@GetMapping("/logger/{acctID}/{dateFrom}/{dateTo}")
	public Optional<Object> getLogDates(@PathVariable int acctID, Date dateFrom, Date dateTo) {
		return LoggerService.getLogInfo(acctID, dateFrom, dateTo);
	}
}
