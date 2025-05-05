package mylab.book.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
	private List<Publication> items;
	
	public ShoppingCart() {
		items = new ArrayList<>();
	}
	public void addItem(Publication item) {
		items.add(item);
		System.out.println(item.getTitle() + "�� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.");
	}
	
	public boolean removeItem(String title) {
		for(Publication item : items) {
			if(item.getTitle().contentEquals(title)) {
				items.remove(item);
				System.out.println(title+"�̰� ��ٱ��Ͽ��� ���ŵǾ����ϴ�.");
			}
		}
		System.out.println(title+"�� ã�� ���� �����ϴ�. ");
		return false;
	}
	
	public void displayCart() {
		System.out.println("=== ��ٱ��� ��� ===");
		for(Publication item : items) {
			System.out.println(item);
		}
		 DecimalFormat df = new DecimalFormat("#,###");
	        System.out.println("�� ����: " + df.format(calculateTotalPrice()) + "��");
	        System.out.println("���� ���� ����: " + df.format(calculateDiscountedPrice()) + "��");
		
	}
	
	public int calculateTotalPrice() {
		int total = 0;
		for (Publication item : items) {
			total += item.getPrice();
		}
		return total;
	}
	public int calculateDiscountedPrice() {
		int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9;
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85;
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8;
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }
    public void printStatistics() {
        int magazineCount = 0, novelCount = 0, referenceCount = 0, others = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceCount++;
            } else {
                others++;
            }
        }
        System.out.println("=== ��ٱ��� ��� ===");
        System.out.println("����: " + magazineCount + "��");
        System.out.println("�Ҽ�: " + novelCount + "��");
        System.out.println("����: " + referenceCount + "��");
        System.out.println("��Ÿ: " + others + "��");
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Publication m1 = new Magazine("���мҳ�", "2024-01-10", 80, 12000, "����");
        Publication n1 = new Novel("���߿�", "2007-03-15", 300, 18000," ", "���");
        Publication r1 = new ReferenceBook("�ڹ��� ����", "2015-09-01", 600, 38000, "���α׷���");

        cart.addItem(m1);
        cart.addItem(n1);
        cart.addItem(r1);

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("���߿�");
        cart.displayCart();
    }
}
