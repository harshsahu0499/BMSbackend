package fr.epita.bms.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

public class DatabaseConnection {

    @Bean(name = "main-ds")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        //dataSource.setUrl("jdbc:h2:tcp://localhost/./test"); //how to set lock timeout value for this -- having issue with data storage
        dataSource.setPassword("test");
        dataSource.setUsername("sa");
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean factory(@Qualifier("main-ds")DataSource ds){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        String packages = "fr.epita.domain";
        sessionFactoryBean.setPackagesToScan(packages);
        sessionFactoryBean.setDataSource(ds);
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create");
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

}
