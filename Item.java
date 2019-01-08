package HelloWeb;

public class Item {
	String item_id;
	String name;
	int price;
	String description;
	int quantity;
	public Item(String item_id2, String name2, String price2, String description2, String quantity2) {
		// TODO Auto-generated constructor stub
		this.setItem_id(item_id2);
		this.setName(name2);
		System.out.println(2);
		this.setDescription(description2);
		int price3 = Integer.valueOf(price2);
		this.setPrice(price3);
		int quantity3 = Integer.valueOf(quantity2);
		this.setQuantity(quantity3);
	}
	public Item(String item_id2, String name2, int price2, String description2, int quantity2) {
		// TODO Auto-generated constructor stub
		this.setItem_id(item_id2);
		this.setName(name2);
		this.setPrice(price2);
		this.setDescription(description2);
		this.setQuantity(quantity2);
	}
	public Item(String item_id) {
		// TODO Auto-generated constructor stub
		this.setItem_id(item_id);
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
