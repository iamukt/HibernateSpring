package dao;

import java.util.Date;
import java.util.List;

import hib_pojos.Book;

public interface BookDao {
	Integer addBook(Book b1) throws Exception;
	Book getBookById(Integer bookId) throws Exception;
	List<Book> getBooks() throws Exception;
	List<Book> updateBooks(String author,Date d1,double amt)throws Exception;
	//i/p detached pojo having changes dictated by user.
	//o/p detached --- BUT changes db state
	Book updateBook(Book b) throws Exception;
	List<Book> deleteBooks(String author) throws Exception;
	

}
