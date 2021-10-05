package model;

public class Item {
	private String name;
	private int price;
	private String category;

	public Item(String name, int price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getname() {
		return this.name;
	}
	public int getprice() {
		return this.price;
	}
	public String getcategory() {
		return this.category;
	}
}
