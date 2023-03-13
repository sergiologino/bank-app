package ru.savkins.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.savkins.model.Logger;

import java.util.Date;
import java.util.Optional;

// интерфейс, расширяющий стандартный crud спринга для работы с транзакциями  (DAO)
public interface LoggerRepository extends CrudRepository<Logger, Integer> {

    @Query("select acctID, initBal,finalBal,transacType,transacStatus,date_create from Logger where acctID = ?1 and date_create>=?2 and date_create<=?3 order by date_create")
      Optional<Object> findByIdAndDate(int acctID, Date dateFrom, Date dateTo);
}
