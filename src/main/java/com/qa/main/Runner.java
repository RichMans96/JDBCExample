package com.qa.main;

import java.sql.SQLException;

public class Runner {
	
	public static void main(String[] args) throws SQLException {
		DBConnect db = new DBConnect();
//		db.createProduct("book2", 5);
//		db.createProduct("book3", 21);
//		db.createProduct("book4", 1);
//		db.readAll();
//		db.update(2, "Big Table", 20);
//		db.deleteProductById(2);
//		db.readAll();
//		db.topFiveByPrice();
		db.readByName("chair");
	}
}

