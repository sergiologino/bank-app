package ru.savkins.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.savkins.model.Accounts;

// интерфейс, расширяющий стандартный crud спринга для работы со счетами клиента (DAO)
public interface AccountsRepository extends CrudRepository<Accounts, Integer>, JpaRepository<Accounts, Integer> {
	@Query("select balance from Accounts where acctID = ?1")
	int findBalanceByAcctID(int acctID);

	@Transactional // аннотация для сохранения персистентности - если произойдет сбой, то откатятся все транзакции метода
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance+?2 where acctID=?1")
	void saveBalanceByAcctID(int acctID, int balance);

	@Transactional 
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance-?2 where acctID=?1")
	void takeMoneyByAcctID(int acctID, int balance);

}
