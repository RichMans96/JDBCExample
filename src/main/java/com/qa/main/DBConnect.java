package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qa.utils.DBConfig;

public class DBConnect {
	private Connection connect;
	private Statement statement;

	public DBConnect() throws SQLException {
		connect = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
		this.statement = connect.createStatement();
	}

	// Create
	public void createProduct(String productName, int productPrice) throws SQLException {
		String sqlStatement = String.format("INSERT INTO products(`productName`, `productPrice`) VALUES ('%s', '%d')",
				productName, productPrice);
		statement.executeUpdate(sqlStatement);
		System.out.println("Created!");
	}

	// Read All
	public void readAll() throws SQLException {
		String sqlStatement = "SELECT * FROM products";
		ResultSet set = statement.executeQuery(sqlStatement);

		while (set.next()) {
			System.out.println("ID: " + set.getInt("productId") + " Product name: " + set.getString("productName")
					+ " Product Price: " + set.getInt("productPrice"));
		}
		System.out.println("No more records to read.");
	}

	public void readByName(String name) throws SQLException {
		String sql = String.format("SELECT * FROM products WHERE productName = ('%s')", name);
		ResultSet set = statement.executeQuery(sql);
		
		set.next();
		
		System.out.println("ID: " + set.getInt("productId") + " Product name: " + set.getString("productName")
				+ " Product Price: " + set.getInt("productPrice"));
	}

	public void topFiveByPrice() throws SQLException {
		String sql = "SELECT * FROM products ORDER BY productPrice DESC LIMIT 5;";
		ResultSet set = statement.executeQuery(sql);

		while (set.next()) {
			System.out.println("ID: " + set.getInt("productId") + " Product name: " + set.getString("productName")
					+ " Product Price: " + set.getInt("productPrice"));
		}
		System.out.println("No more records to read.");
	}

	// Update
	public void update(int productId, String productName, int productPrice) throws SQLException {
		String sqlStatement = String.format(
				"UPDATE products SET productName = ('%s'), productPrice = ('%d') WHERE productId = ('%d')", productName,
				productPrice, productId);
		statement.execute(sqlStatement);
		System.out.println("Updated!");
	}

	// DeleteById
	public void deleteProductById(int productId) throws SQLException {
		statement.executeUpdate("DELETE FROM products WHERE productId = " + productId);
		System.out.println("Deleted!");
	}

}
