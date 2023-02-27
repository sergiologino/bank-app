Банковский сервис с использованием REST API на  Spring Boot и JPA

Можно посылать деньги, класть и снимать. Создавать клиента и счет к нему (аккаунт), смотреть историю операций

Использовал фреймворк Spring, БД PostgresSQL, Maven.

В процессе разработки конечно смотрел аналогичные задачи, советовался с программистами из моей командыи (работаю аналитиком в банке, стек такой же -java spring, postgres, kafka)

Можно проверять через постман (после запуска дампа БД)

Запросы для постмана:

GET
// getAccountInfo	"/account/{acctID}"
// getBalance	"/account/{acctID}/balance"
//getCustomerInfo "/customer/{acctID}"

DELETE
//deleteCustomer "/customer/{acctID}"
// deleteAccount	"/account/{acctID}"

PUT
// sendMoney "/account/{acctID}/sendmoney/{destAcctID}/{amount}"
// takeMoney	"/account/{acctID}/withdraw/{amount}"
// putMoney  "/account/{acctID}/putmoney/{amount}"

POST
// create customer "/customer"
{
     "acctID": "int",
	"custName": "String",
	"city": "String",
	"state": "String",
	"country": "String",
	"phoneNo": "String",
	"password": "String"
}

![image](https://user-images.githubusercontent.com/90287274/221712348-ae238654-f815-4089-9c56-79ae752f2481.png)
