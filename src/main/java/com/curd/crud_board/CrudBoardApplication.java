package com.curd.crud_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CrudBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudBoardApplication.class, args);
    }

}
