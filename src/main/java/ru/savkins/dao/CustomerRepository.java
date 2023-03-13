package ru.savkins.dao;

import org.springframework.data.repository.CrudRepository;
import ru.savkins.model.Customer;
// интерфейс, расширяющий стандартный crud спринга для работы с аккаунтом клиента  (DAO)
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
