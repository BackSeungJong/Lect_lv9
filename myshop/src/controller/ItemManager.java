package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.Cart;
import model.Item;

public class ItemManager {

	public ArrayList<String> category = new ArrayList<>();
	public ArrayList<Item> item = new ArrayList<>();
	public ArrayList<Cart> cart = new ArrayList<>();

	public ItemManager() {
		// 아이탬생성
		category.add("상의");
		category.add("하의");
		category.add("아우터");
		category.add("잡화");
		// 상의
		item.add(new Item("티셔츠", 9900, "상의"));
		item.add(new Item("맨투맨", 29900, "상의"));
		item.add(new Item("카라티", 19900, "상의"));
		item.add(new Item("셔츠", 29900, "상의"));
		item.add(new Item("원피스", 59900, "상의"));
		// 하의
		item.add(new Item("청바지", 49900, "하의"));
		item.add(new Item("슬랙스", 39900, "하의"));
		item.add(new Item("치마", 39900, "하의"));
		// 아우터
		item.add(new Item("바람막이", 109900, "아우터"));
		item.add(new Item("패딩", 159900, "아우터"));
		item.add(new Item("청자켓", 59900, "아우터"));
		// 잡화
		item.add(new Item("캡모자", 59900, "잡화"));
		item.add(new Item("양말", 2000, "잡화"));
		item.add(new Item("시계", 290000, "잡화"));

	}

	public void printcategory() {
		System.out.println("[카테고리]");
		for (int i = 0; i < category.size(); i++) {
			System.out.printf("[%d] %s\n", i + 1, category.get(i));
			if (i == category.size() - 1) {
				System.out.println("[0] 뒤로가기");
			}
		}
	}

	public void printitem(int caID) {
		// TODO Auto-generated method stub
		int num = 1;
		for (int i = 0; i < item.size(); i++) {
			if (category.get(caID).equals(item.get(i).getcategory())) {
				System.out.printf("[%d] %s(%d)\n", num, item.get(i).getname(), item.get(i).getprice());
				num++;
			}
		}
	}

	public int addCart(String userID, int caID, int itID) {
		// TODO Auto-generated method stub
		int num = 0;
		for (int i = 0; i < item.size(); i++) {
			if (category.get(caID).equals(item.get(i).getcategory())) {
				num++;
				if (num == itID) {
					System.out.printf("%s(%d) 담기 성공!\n", item.get(i).getname(), item.get(i).getprice());
					cart.add(new Cart(userID, item.get(i)));
					return item.get(i).getprice();
				}
			}
		}
		return 0;
	}

	public void printcart(String userId) {
		// TODO Auto-generated method stub
		System.out.print(Shop.bar);

		int num = 1;
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getuserId().equals(userId)) {
				System.out.printf("[%d] %s(%d)\n", num, cart.get(i).itemname(), cart.get(i).itemprice());
				num++;
			}
		}
		if (num == 1) {
			System.out.println("비었음");
		}
		System.out.print(Shop.bar);

	}

	public void buyitem(String userId) {

	}

	public int deleteitem(String userId, int num) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getuserId().equals(userId)) {
				cnt++;
				if (cnt == num) {
					System.out.println("삭제완료");
					int price = cart.get(i).itemprice();
					cart.remove(i);
					return price;
				}
			}
		}
		return 0;
	}

	public void deletecart(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cart.size(); i++) {
			if (id.equals(cart.get(i).getuserId())) {
				cart.remove(i);
			}
		}
	}

	public void printallcategory() {
		// TODO Auto-generated method stub
		System.out.println("[카테고리]");
		for (int i = 0; i < category.size(); i++) {
			System.out.println(category.get(i));
		}

	}

	public void printallitem() {
		System.out.println("[아이템]");
		for (int i = 0; i < item.size(); i++) {
			System.out.printf("[%s] %s(%d)\n", item.get(i).getcategory(), item.get(i).getname(),
					item.get(i).getprice());
		}
	}

	public void printallcart() {
		System.out.println("[장바구니]");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%s -> %s(%d)\n", cart.get(i).getuserId(), cart.get(i).itemname(),
					cart.get(i).itemprice());
		}
	}

	public void cateAdd(String name) {
		// TODO Auto-generated method stub
		boolean check = true;
		for (int i = 0; i < category.size(); i++) {
			if (name.equals(category.get(i))) {
				check = false;
			}
		}
		if (check) {
			category.add(name);
		} else {
			System.out.println("[시스템] 중복된 이름");
		}

	}

	public void cateDelete(String name) {
		// TODO Auto-generated method stub
		int check = -1;
		for (int i = 0; i < category.size(); i++) {
			if (name.equals(category.get(i))) {
				check = i;
			}
		}
		if (check != -1) {
			category.remove(check);
			//아이탬도삭제
		} else {
			System.out.println("[시스템] 해당 카테고리가 존재하지않습니다.");
		}

	}

	public void itemAdd() {
		// TODO Auto-generated method stub
		System.out.print(Shop.bar);
		for (int i = 0; i < category.size(); i++) {
			System.out.printf("%s\n", category.get(i));
		}
		System.out.print(Shop.bar);
		System.out.print("카테고리 : ");
		String caName = Shop.sc.next();

		boolean check = false;
		for (int i = 0; i < category.size(); i++) {
			if (caName.equals(category.get(i))) {
				check = true;
			}
		}
		if (check) {
			System.out.print("아이템 이름 : ");
			String itName = Shop.sc.next();
			System.out.print("아이템 가격 : ");
			int itPrice = Shop.sc.nextInt();

			item.add(new Item(itName, itPrice, caName));

		} else {
			System.out.println("[시스템] 다시 확인해주세요.");
		}

	}

	public void itemDelete() {
		// TODO Auto-generated method stub
		System.out.print(Shop.bar);
		for (int i = 0; i < category.size(); i++) {
			System.out.printf("%s\n", category.get(i));
		}
		System.out.print(Shop.bar);
		System.out.print("카테고리 : ");
		String caName = Shop.sc.next();

		System.out.print(Shop.bar);
		for (int i = 0; i < item.size(); i++) {
			if (item.get(i).getcategory().equals(caName)) {
				System.out.println(item.get(i).getname());
			}
		}
		System.out.print(Shop.bar);
		System.out.print("아이템 이름 : ");
		String itName = Shop.sc.next();

		for (int i = 0; i < item.size(); i++) {
			if (caName.equals(item.get(i).getcategory()) && item.get(i).getname().equals(itName)) {
				item.remove(i);
			}
		}

	}
}
