package edu.neumont.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DaoBase
{
    JdbcTemplate jdbcTemplate;

    public DaoBase()
    {
        // creatre a datasource
        // defines the address  to where we connect
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/northwind");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
