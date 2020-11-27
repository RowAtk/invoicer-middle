package com.rowatk.invoicer;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.rowatk.invoicer.dao.postgres")
public class Config {

}
