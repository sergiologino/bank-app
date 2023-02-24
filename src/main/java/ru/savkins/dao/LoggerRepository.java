package ru.savkins.dao;

import org.springframework.data.repository.CrudRepository;

import ru.savkins.model.Logger;

public interface LoggerRepository extends CrudRepository<Logger, Integer> {

}
