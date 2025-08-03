package br.com.joao.payflux.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI().info(new Info()
                .title("API boleto")
                .description("API de pagamento de boleto")
                .contact(new Contact().name("João Marcos").email("joamarcosdev@gmail.com"))
                .version("1.0.0")
        );
    }
}
