package model;
import dao.BookDAO;

public class PostBookLogic {
	public void execute(Book book) {
		BookDAO dao = new BookDAO();
		dao.create(book);
	}
}
