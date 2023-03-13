package ru.savkins.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import ru.savkins.model.Logger;
// интерфейс, расширяющий стандартный crud спринга для работы с транзакциями  (DAO)
@Repository
public interface LoggerRepository extends CrudRepository<Logger, Integer> {

}
