package cn.sdut.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class BaseDao {
	public  Connection con = getConn();
	protected QueryRunner runner = new QueryRunner();

	public Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf-8", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

}
