package beans;

import java.text.SimpleDateFormat;
import java.util.List;

import hib_pojos.Book;
import dao.BookDao;
import dao.BookDaoImpl;

public class BookBean {
	private String title, author;
	private int quantity;
	private double bookPrice;
	private String pubDate;
	// dao
	private BookDao dao;
	// to display added book dtls from jsp
	private Book addedBook;

	private static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
	}

	public BookBean() {
		dao = new BookDaoImpl();
		System.out.println("bean created");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	// B.L
	public Book getAddedBook() throws Exception {
		// create TRANSIENT Book pojo
		Book b1 = new Book(title, author, bookPrice, quantity,
				sdf.parse(pubDate));

		return (addedBook = dao.addBook(b1));
	}

	// B.L
	public List<Book> getBooksByAuthor() throws Exception {
		return dao.getBooksByAuthorNDate(author, sdf.parse(pubDate));
	}

}
