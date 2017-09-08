package db;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DaoBooks;
import dao.DaoOrders;
import dao.DaoUsers;
import entity.Books;
import entity.Orders;
import entity.Users;

public class WorkDB {

	public static int createDB() {
		DB db = DB.getDb();
		try {
			db.update("CREATE DATABASE " + DB.prop.getProperty("db.name"));
			db.update("USE " + DB.prop.getProperty("db.name"));
			db.update("CREATE TABLE users (id_user INT AUTO_INCREMENT," + "login VARCHAR(50) UNIQUE,"
					+ "pass VARCHAR(50) NOT NULL," + "role INT(1) DEFAULT 1," + "del_status INT(1) DEFAULT 1,"
					+ "PRIMARY KEY(id_user))");

			db.update("CREATE TABLE books (id_book INT AUTO_INCREMENT," + "author VARCHAR(50) NOT NULL,"
					+ "name VARCHAR(50) NOT NULL," + "price INT(1) DEFAULT 1," + "del_status INT(1) DEFAULT 1,"
					+ "PRIMARY KEY(id_book))");

			db.update("CREATE TABLE orders (id_order INT AUTO_INCREMENT," + "order_number INT(10) NOT NULL,"
					+ "id_user INT(10) NOT NULL," + "id_book INT(10) NOT NULL," + "order_status INT(1) DEFAULT 1,"
					+ "FOREIGN KEY (id_user) REFERENCES users(id_user),"
					+ "FOREIGN KEY (id_book) REFERENCES books(id_book)," + "PRIMARY KEY(id_order))");

			DaoUsers du = new DaoUsers();
			du.insert(new Users(1, "admin", "admin", 2, 1));
			du.insert(new Users("admin2", "admin"));
			du.insert(new Users("admin3", "admin"));
			du.insert(new Users("admin4", "admin"));

			DaoBooks dBooks = new DaoBooks();
			dBooks.insert(new Books("Гомер", "Одиссея", 100, 1));
			dBooks.insert(new Books("Гомер", "Илиада", 100, 1));
			dBooks.insert(new Books("Чарльз Диккенс", "Приключения Оливера Твиста", 100, 1));
			dBooks.insert(new Books("Джейн Остин", "Гордость и предубеждение", 100, 1));
			dBooks.insert(new Books("Иоганн Вольфганг фон Гете", "Фауст", 100, 1));
			dBooks.insert(new Books("Эрих Мария Ремарк", "Триумфальная арка", 100, 1));
			dBooks.insert(new Books("Федор Михайлович Достоевский", "Преступление и наказание", 100, 1));
			dBooks.insert(new Books("Лев Николаевич Толстой", "Война и мир", 100, 1));
			dBooks.insert(new Books("Габриэль Гарсиа Маркес", "Сто лет одиночества", 100, 1));
			dBooks.insert(new Books("Хулио Кортасар", "Игра в классики", 100, 1));
			dBooks.insert(new Books("Джером Сэлинджер", "Над пропастью во ржи", 100, 1));
			dBooks.insert(new Books("Уильям Голдинг", "Повелитель мух", 100, 1));
			dBooks.insert(new Books("Харпер Ли", "Убить пересмешника", 100, 1));
			dBooks.insert(new Books("Рэй Брэдбери", "451 градус по Фаренгейту", 100, 1));
			dBooks.insert(new Books("Герман Гессе", "Степной волк", 100, 1));
			dBooks.insert(new Books("Олдос Хаксли", "О дивный новый мир", 100, 1));
			dBooks.insert(new Books("Ивлин Во", "Мерзкая плоть", 100, 1));
			dBooks.insert(new Books("Кен Кизи", "Пролетая над гнездом кукушки", 100, 1));
			dBooks.insert(new Books("Ирвин Уэлш", "На игле", 100, 1));

			DaoOrders dOrders = new DaoOrders();
			dOrders.insert(new Orders(1, 1, 1));
			dOrders.insert(new Orders(1, 1, 2));
			dOrders.insert(new Orders(1, 1, 3));
			dOrders.insert(new Orders(1, 1, 4));
			dOrders.insert(new Orders(2, 2, 1));
			dOrders.insert(new Orders(2, 2, 2));
			dOrders.insert(new Orders(2, 2, 3));
			dOrders.insert(new Orders(2, 2, 4));

			ResultSet rs = db.query("SELECT * FROM users");
			db.showTable(rs);

			System.out.println();
			System.out.println(du.get(2));

			return 1;
		} catch (SQLException e) {
			if (e.getErrorCode() == 1007) {
				// Database already exists error
				System.out.println(e.getMessage());
				return 2;
			} else if (e.getErrorCode() == 1008) {
				// Some other problems, e.g. Server down, no permission, etc
				System.out.println(e.getMessage());
				return 3;
			} else {
				// Some other problems, e.g. Server down, no permission, etc
				e.printStackTrace();
				return 0;
			}
		}
	}

	public static int deleteDB() {
		DB db = DB.getDb();
		try {
			db.update("DROP DATABASE " + DB.prop.getProperty("db.name"));
			return 1;
		} catch (SQLException e) {
			if (e.getErrorCode() == 1008) {
				return 2;
			} else
				return 0;
		}
	}

}
