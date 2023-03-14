Банковский сервис с использованием REST API на  Spring Boot и JPA

Можно посылать деньги, класть и снимать. Создавать клиента и счет к нему (аккаунт), смотреть историю операций, в т.ч. за период

Использовал фреймворк Spring, БД PostgresSQL, Maven. Java 1.8

В процессе разработки конечно смотрел аналогичные задачи, советовался с программистами из моей командыи (работаю аналитиком в банке, стек такой же -java spring, postgres, kafka)

SWAGGER:  http://localhost:8080/swagger-ui. (иногда не запускался)

Также развернул сервис в Yandex cloud. Подключение через терминал по SSH, ключ в папке _another проекта. В облаке компилится, запускается, но с доступом через постман капризничает. Периодически бывает refused или 501 ошибка.
ssh -i sergo sergiologino@51.250.18.175 -- подключиться к ВМ в Яндексе (IP статический)
git pull origin master - получить обновления
mvn spring-boot:run //  запустить приложение
 
Долго разбирался с деплоем в облаке и не успел поправить разные огрехи. Работа сервиса в целом неустойчивая. Для новичка маловато было времени чтобы все хорошо освоить и отладить. Долго провозился с багами, не доделал тесты и не успел сделать фронт на tomcat, на демо примере получалось.

Можно проверять через постман ( коллекция в проекте в папке '_another' после запуска дампа БД в папке DB проекта, файл dump-Bank-202302280219)

Запросы для постмана:

GET
// getAccountInfo	"/account/{acctID}"
// getBalance	"/account/{acctID}/balance"
//getCustomerInfo "/customer/{acctID}"
//logger/{acctID}/{dateFrom}/{dateTo}

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

