package com.rowatk.invoicer;

import com.rowatk.invoicer.respositories.CompanyRepository;
import com.rowatk.invoicer.respositories.InvoiceRepository;
import com.rowatk.invoicer.respositories.ItemRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {InvoiceRepository.class, CompanyRepository.class, ItemRepository.class})
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
