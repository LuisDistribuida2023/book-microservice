package com.distribuida.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
@ApplicationScoped
public class DbConfig {
   @Inject @ConfigProperty(name = "database.username")
    String username;
    @Inject @ConfigProperty(name = "database.password")
    String password;
    @Inject @ConfigProperty(name = "database.url")
    String databaseUrl;
        @Produces
    @ApplicationScoped
    public DataSource createDatasource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(databaseUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
