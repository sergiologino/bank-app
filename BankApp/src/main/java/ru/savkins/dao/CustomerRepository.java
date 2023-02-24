package ru.savkins.dao;

import org.springframework.data.repository.CrudRepository;

import ru.savkins.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
