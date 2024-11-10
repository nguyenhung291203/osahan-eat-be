package com.develop.osahaneatbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OsahanEatBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsahanEatBeApplication.class, args);
    }
}
