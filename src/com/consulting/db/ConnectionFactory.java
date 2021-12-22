package com.consulting.db;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import org.apache.log4j.Logger;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class ConnectionFactory {
	private static Logger log = Logger.getLogger(ConnectionFactory.class);

	private static BasicDataSource ds = null;

	private static final String DB_PROPS = "/db.properties";

	private static final ConnectionFactory _instance = new ConnectionFactory();

	private static ConnectionFactory connectionFactory = new ConnectionFactory();

	private static void ConnectionFactory() {
		Properties props = new Properties();

		try {
			InputStream in = connectionFactory.getClass().getResourceAsStream(DB_PROPS);
			props.load(in);
		} catch (Exception e1) {
			log.error("Unable to load db.properties", e1);
			return;
		}
		/*
		 * System.out.println(""+props.getProperty("driver"));
		 * System.out.println(""+props.getProperty("user"));
		 * System.out.println(""+props.getProperty("password"));
		 * System.out.println(""+props.getProperty("url")); System.out.println("5");
        */
	    ds = new BasicDataSource();
        ds.setDriverClassName(props.getProperty("driver"));
		ds.setUsername(props.getProperty("user"));
		ds.setPassword(props.getProperty("password"));
		ds.setUrl(props.getProperty("url"));
		  //int maxActive=Integer.parseInt(props.getProperty("maxActive"));
		ds.setMaxActive(100);  
		  // int  maxIdle=Integer.parseInt(props.getProperty("maxIdle")); ds.setMaxIdle(10);
		  //int maxWait=Integer.parseInt(props.getProperty("maxWait"));
		ds.setMaxWait(10000); ds.setLogAbandoned(true);
        log.info(ds.getMaxActive());
     }

	public static Connection getConnection() {
		Connection con = null;
		ConnectionFactory();
		try {
			// System.out.println("URL "+ds.getUrl());
			// java.sql.DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());		 
			con = ds.getConnection();
        } catch (Exception e) {
			e.printStackTrace();
			log.error("Error while geting connecting from datasource: " + e.getMessage());
		}
		return con;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
