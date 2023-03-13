package ru.savkins.service;

import org.springframework.stereotype.Service;
import ru.savkins.dao.LoggerRepository;
import ru.savkins.model.Logger;

import java.util.Date;
import java.util.Optional;

// здесь сервисный слой - бизнес-логика сервиса, хотя здесь ее минимум
@Service
public class LoggerService {
	static LoggerRepository loggerRepository;

	public static Optional<Object> getLogInfo(int acctID, Date dateFrom, Date dateTo)
	{ return loggerRepository.findByIdAndDate(acctID, dateFrom, dateTo); }

	public void addLog(Logger logger) {
		loggerRepository.save(logger);
	}

	public Logger showLog(int acctID) {
		return loggerRepository.findById(acctID).orElse(null);
	}

	public void deleteLog(int acctID) {
		loggerRepository.deleteById(acctID);
	}

}
