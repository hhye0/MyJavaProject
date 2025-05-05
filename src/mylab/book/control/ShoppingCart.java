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
		System.out.println(item.getTitle() + "이 장바구니에 추가되었습니다.");
	}
	
	public boolean removeItem(String title) {
		for(Publication item : items) {
			if(item.getTitle().contentEquals(title)) {
				items.remove(item);
				System.out.println(title+"이가 장바구니에서 제거되었습니다.");
			}
		}
		System.out.println(title+"을 찾을 수가 없습니다. ");
		return false;
	}
	
	public void displayCart() {
		System.out.println("=== 장바구니 목록 ===");
		for(Publication item : items) {
			System.out.println(item);
		}
		 DecimalFormat df = new DecimalFormat("#,###");
	        System.out.println("총 가격: " + df.format(calculateTotalPrice()) + "원");
	        System.out.println("할인 적용 가격: " + df.format(calculateDiscountedPrice()) + "원");
		
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
        System.out.println("=== 장바구니 통계 ===");
        System.out.println("잡지: " + magazineCount + "권");
        System.out.println("소설: " + novelCount + "권");
        System.out.println("참고서: " + referenceCount + "권");
        System.out.println("기타: " + others + "권");
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Publication m1 = new Magazine("과학소년", "2024-01-10", 80, 12000, "월간");
        Publication n1 = new Novel("빠삐용", "2007-03-15", 300, 18000," ", "드라마");
        Publication r1 = new ReferenceBook("자바의 정석", "2015-09-01", 600, 38000, "프로그래밍");

        cart.addItem(m1);
        cart.addItem(n1);
        cart.addItem(r1);

        cart.displayCart();
        cart.printStatistics();

        cart.removeItem("빠삐용");
        cart.displayCart();
    }
}
