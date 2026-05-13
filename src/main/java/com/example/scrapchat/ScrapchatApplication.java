package com.example.scrapchat;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class ScrapchatApplication implements CommandLineRunner {

	private final DataSource dataSource;

	public ScrapchatApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScrapchatApplication.class, args);
	}

	// Test DB connection
	@Override
	public void run(String... args) {
		log.info("Datasource: " + dataSource);
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.execute("select 1");
		} catch (CannotGetJdbcConnectionException e) {
			log.info("Exception while setting jdbcTemplate");
			e.printStackTrace();
		}

	}
}
