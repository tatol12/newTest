package HelloWeb;
import java.util.*;
public class Sum {
	String date;
	String cost;
	public int profit;
	public int getRaw() {
		return raw;
	}
	public void setRaw(int raw) {
		this.raw = raw;
	}
	public int raw;
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public Sum(String date2, String sum) {
		// TODO Auto-generated constructor stub
		Random r = new Random();
		int x=r.nextInt(Integer.valueOf(sum)/2)+Integer.valueOf(sum)/3;
		this.setCost(sum);
		System.out.println("hello "+sum);
		this.setDate(date2);
		this.setRaw(x);
		this.setProfit(Integer.valueOf(sum)-x);
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
}
