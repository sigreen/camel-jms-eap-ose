package org.jboss.fuse.examples.jdbc;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Bean that creates the database table
 */
public class DatabaseBean {

	private static final Logger LOG = LoggerFactory.getLogger(DatabaseBean.class);
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create() throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		String sequence = "CREATE SEQUENCE contact_id AS int start WITH 1";
		String sql = "create table CONTACTS (\n" + "  contact_id integer primary key,\n" + "  contact_firstname varchar(60),\n" + "  contact_lastname varchar(60),\n" + "  contact_email varchar(60),\n" + "  contact_phone varchar(60)\n" + ")";
		LOG.info("Creating table CONTACTS ...");

		try {
			jdbc.execute("drop table CONTACTS");
		} catch (Throwable e) {
			// ignore
		}

		try {
			jdbc.execute("drop sequence contact_id");
		} catch (Throwable e) {
			// ignore
		}
		
		jdbc.execute(sequence);
		jdbc.execute(sql);

		LOG.info("... created table CONTACTS");
	}

	public void destroy() throws Exception {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		try {
			jdbc.execute("drop table CONTACTS");
		} catch (Throwable e) {
			// ignore
		}
	}
}