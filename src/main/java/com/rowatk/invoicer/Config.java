package com.rowatk.invoicer;

import com.rowatk.invoicer.respositories.EntityRepository;
import com.rowatk.invoicer.respositories.InvoiceRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackageClasses = {InvoiceRepository.class, EntityRepository.class}, basePackages = {"com.rowatk.invoicer.dao"})
public class Config {

//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgres.Driver");
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/invoicer-dev");
//        dataSourceBuilder.username("pgrowan");
//        dataSourceBuilder.password("password");
//        dataSourceBuilder.
//    }


}
