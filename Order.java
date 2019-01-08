package HelloWeb;

public class Order {
	public int id;
	public String status; 
	public String items;
	public int cost;
	
	public Order(int id, String status, String items) {
		// TODO Auto-generated constructor stub
		this.setId(id);
		this.setStatus(status);
		this.setItems(items);
	}
	public Order(String id2, String status2) {
		// TODO Auto-generated constructor stub
		int id3 = Integer.valueOf(id2);
		this.setId(id3);
		
		this.setStatus(status2);
		//this.setItems(items);
		System.out.println(id3+status2);
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Order(String id) {
		// TODO Auto-generated constructor stub
		int id4 = Integer.valueOf(id);
		this.setId(id4);
	}
	public Order(int id2, String status2, String items2, int cost2) {
		// TODO Auto-generated constructor stub
		this.setId(id2);
		this.setStatus(status2);
		this.setItems(items2);
		this.setCost(cost2);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getItems() {
		return items;
	}
	
}
