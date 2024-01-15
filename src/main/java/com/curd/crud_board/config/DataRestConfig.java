package com.curd.crud_board.config;

import com.curd.crud_board.domain.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class DataRestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(){
        return RepositoryRestConfigurer.withConfig((repositoryRestConfiguration, corsRegistry) ->
                repositoryRestConfiguration.exposeIdsFor(UserAccount.class));
    }
}
