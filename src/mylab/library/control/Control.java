package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class Control {
	public static void main(String[] args) {
		Library library = new Library("�߾� ������");

		addSampleBooks(library);
		testFindBook(library);
		testCheckOut(library);
		testReturn(library);
		displayAvailableBooks(library);
	}

	public static void addSampleBooks(Library library) {
		library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
		library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
		library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
		library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
		library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
		library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
		System.out.println("������ �߰��Ǿ����ϴ�.");

	}

	public static void testFindBook(Library library) {
		System.out.println("===== ���� �˻� �׽�Ʈ =====");

		System.out.println("�������� �˻� ���:");
		Book b1 = library.findBookByTitle("�ڹ��� ����");
		if (b1 != null) System.out.println(b1);
		System.out.println();

		System.out.println("���ڷ� �˻� ���:");
		Book b2 = library.findBookByAuthor("Robert C. Martin");
		if (b2 != null) System.out.println(b2);
		System.out.println();
	}

	public static void testCheckOut(Library library) {
		System.out.println("===== ���� ���� �׽�Ʈ =====");
		if (library.checkOutBook("978-89-01-14077-4")) {
		    System.out.println("���� ���� ����!");
		    System.out.println("����� ���� ����:");
		    System.out.println(library.findBookByISBN("978-89-01-14077-4"));
		} else {
		    System.out.println("���� ���� ����");
		}
	}

	public static void testReturn(Library library) {
		System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
		if (library.returnBook("978-89-01-14077-4")) {
		    System.out.println("���� �ݳ� ����!");
		    System.out.println("�ݳ��� ���� ����:");
		    System.out.println(library.findBookByISBN("978-89-01-14077-4"));
		} else {
		    System.out.println("���� �ݳ� ����");
		}
	}

	public static void displayAvailableBooks(Library library) {
		System.out.println("\n���� ������ ���� ���: ");
		for (Book b : library.getAvailableBooks()) {
			System.out.println(b);
		}
	}

}
