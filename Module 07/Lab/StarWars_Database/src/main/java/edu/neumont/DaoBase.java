package edu.neumont;

import edu.neumont.dtos.DtoBase;
import edu.neumont.interfaces.IRepository;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public abstract class DaoBase<T extends DtoBase> implements IRepository<T>
{
    JdbcTemplate jdbcTemplate;

    public DaoBase()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/demo");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
