package ru.savkins.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import ru.savkins.model.Customer;
// интерфейс, расширяющий стандартный crud спринга для работы с аккаунтом клиента  (DAO)
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
