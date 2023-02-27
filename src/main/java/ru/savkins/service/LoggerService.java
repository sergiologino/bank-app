package ru.savkins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.savkins.dao.LoggerRepository;
import ru.savkins.model.Logger;
// здесь сервисный слой - бизнес-логика сервиса, хотя здесь ее минимум
@Service
public class LoggerService {
	@Autowired
	LoggerRepository loggerRepository;

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
