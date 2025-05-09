package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class Control {
	public static void main(String[] args) {
		Library library = new Library("중앙 도서관");

		addSampleBooks(library);
		testFindBook(library);
		testCheckOut(library);
		testReturn(library);
		displayAvailableBooks(library);
	}

	public static void addSampleBooks(Library library) {
		library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
		library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
		library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
		library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
		library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
		library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
		System.out.println("도서가 추가되었습니다.");

	}

	public static void testFindBook(Library library) {
		System.out.println("===== 도서 검색 테스트 =====");

		System.out.println("제목으로 검색 결과:");
		Book b1 = library.findBookByTitle("자바의 정석");
		if (b1 != null) System.out.println(b1);
		System.out.println();

		System.out.println("저자로 검색 결과:");
		Book b2 = library.findBookByAuthor("Robert C. Martin");
		if (b2 != null) System.out.println(b2);
		System.out.println();
	}

	public static void testCheckOut(Library library) {
		System.out.println("===== 도서 대출 테스트 =====");
		if (library.checkOutBook("978-89-01-14077-4")) {
		    System.out.println("도서 대출 성공!");
		    System.out.println("대출된 도서 정보:");
		    System.out.println(library.findBookByISBN("978-89-01-14077-4"));
		} else {
		    System.out.println("도서 대출 실패");
		}
	}

	public static void testReturn(Library library) {
		System.out.println("===== 도서 반납 테스트 =====");
		if (library.returnBook("978-89-01-14077-4")) {
		    System.out.println("도서 반납 성공!");
		    System.out.println("반납된 도서 정보:");
		    System.out.println(library.findBookByISBN("978-89-01-14077-4"));
		} else {
		    System.out.println("도서 반납 실패");
		}
	}

	public static void displayAvailableBooks(Library library) {
		System.out.println("\n대출 가능한 도서 목록: ");
		for (Book b : library.getAvailableBooks()) {
			System.out.println(b);
		}
	}

}
