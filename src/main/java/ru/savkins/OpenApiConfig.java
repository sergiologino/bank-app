package ru.savkins;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Bank Api",
                description = "Bank Transactions", version = "1.1.0",
                contact = @Contact(
                        name = "Savkin Sergey",
                        email = "savkin-sergey@yandex.ru",
                        url = "savkins.ru (under construction)"
                )
        )
)
public class OpenApiConfig {

}
