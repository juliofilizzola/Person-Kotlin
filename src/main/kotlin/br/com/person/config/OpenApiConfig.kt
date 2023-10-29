package br.com.person.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenApi(): OpenAPI{
        return OpenAPI()
            .info(
                Info().title("Person Kotlin").version("v1").description("Api in kotlin RESTful")

            )

    }
}