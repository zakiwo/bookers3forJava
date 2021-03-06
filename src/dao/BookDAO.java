package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	//データベース接続に必要な情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/bookers3";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	//データベース上のBookデータを全て取得し、bookListに格納
	public List<Book> findAll(){
		List<Book> bookList = new ArrayList<>();
		
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//SQL文の準備
			String sql = "SELECT ID, TITLE, BODY FROM BOOK ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文実行
			ResultSet rs = pStmt.executeQuery();
			
			//select文の結果をbookListに格納
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String body = rs.getString("BODY");
				Book book = new Book(id, title, body);
				bookList.add(book);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return bookList;
	}
	
	//データベースに新規登録する処理
	public boolean create(Book book) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//insert文の準備
			String sql = "INSERT INTO BOOK(TITLE, BODY) VALUES(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//insert文の?を入れる
			pStmt.setString(1,  book.getTitle());
			pStmt.setString(2, book.getBody());
			
			//insert文を実行、resultにはSQLを実行した行数が入る
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch (SQLException e) {
			return false;
		}
		return true;
	}
}
