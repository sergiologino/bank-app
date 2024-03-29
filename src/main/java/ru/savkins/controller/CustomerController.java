package ru.savkins.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.savkins.model.Customer;
import ru.savkins.service.CustomerService;

@Tag(name = "Клиенты", description = "Добавление, удаление, получение клиентов по id")
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;

	@Operation(summary = "Создать клиента",description = "Создание клиента")
	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		accountController.createAccount(customer.getAcctID(), 0, "Active");
	}
	@Operation(summary = "Получить инфо по клиенту",description = "Получить инфо по клиенту")
	@GetMapping("/customer/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		return customerService.getCustomerInfo(acctID);
	}

	@DeleteMapping("/customer/{acctID}")
	public void deleteCustomer(@PathVariable int acctID) {
		customerService.deleteCustomer(acctID);
	}

}
