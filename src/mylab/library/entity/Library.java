package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public Book findBookByTitle(String title) {
		for (Book b : books) {
			if(b.getTitle().equalsIgnoreCase(title)) {
				return b;
			}
		}
		return null;
	}
	public Book findBookByAuthor(String author) {
		for (Book b : books) {
			if(b.getAuthor().equalsIgnoreCase(author)) {
				return b;
			}
		}
		return null;
	}
	public Book findBookByISBN(String isbn) {
		for (Book b : books) {
			if(b.getIsbn().equalsIgnoreCase(isbn)) {
				return b;
			}
		}
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		Book book = findBookByISBN(isbn);
		return book != null && book.returnBook();
	}
	public boolean returnBook(String isbn) {
		Book book = findBookByISBN(isbn);
		return book != null && book.returnBook();
	}
	
	public List<Book> getAvailableBooks(){
		List<Book> available = new ArrayList<>();
		for (Book b : books) {
			if (b.isAvailable()) {
				available.add(b);
			}
		}
		return available;
	}
	
}
