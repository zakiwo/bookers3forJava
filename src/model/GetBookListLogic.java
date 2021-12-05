package model;
import java.util.List;
import dao.BookDAO;

//データベースからBookのデータを全て取得し、Listで返す
public class GetBookListLogic {
	public List<Book> execute(){
		BookDAO dao = new BookDAO();
		List<Book> bookList = dao.findAll();
		return bookList;
	}
}
