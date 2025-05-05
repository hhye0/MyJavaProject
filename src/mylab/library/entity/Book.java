package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
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

	public String getIsbn() {
		return isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public boolean checkOut() {
		if (isAvailable) {
			isAvailable = false;
			return true;
		}
		return false;
	}
	
	public boolean returnBook() {
		if (!isAvailable) {
			isAvailable = true;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "å ����: " + title + "\t����: " + author + "\t ISBN: " + isbn + "\t ���ǳ⵵: " + publishYear
				+ "\t ���� ���� ����: " + (isAvailable ? "����":"���� ��");
	}
	
	
}
