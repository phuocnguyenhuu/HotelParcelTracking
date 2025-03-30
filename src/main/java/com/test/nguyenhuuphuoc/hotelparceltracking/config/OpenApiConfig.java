package com.test.nguyenhuuphuoc.hotelparceltracking.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI hotelParcelTrackingAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hotel Parcel Tracking API")
                        .description("API for managing hotel parcels and check-ins")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Nguyen Huu Phuoc")
                                .email("nhphuocworld@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}