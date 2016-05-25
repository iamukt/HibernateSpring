package dao;

import java.util.Date;
import java.util.List;

import hib_pojos.Book;

public interface BookDao {
	Book addBook(Book b) throws Exception;

	List<Book> getBooksByAuthorNDate(String author, Date pubDate)
			throws Exception;

}
