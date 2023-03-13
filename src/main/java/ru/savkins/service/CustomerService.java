package ru.savkins.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.savkins.dao.CustomerRepository;
import ru.savkins.model.Customer;
// здесь сервисный слой - бизнес-логика сервиса, хотя здесь ее минимум
@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElse(null);
	}

	public void deleteCustomer(int acctID) {
		customerRepository.deleteById(acctID);
	}

}
