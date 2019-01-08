package HelloWeb;
import java.util.*;
public class SumM {
	String month;
	String cost;
	public int profit;
	public int getRaw() {
		return raw;
	}
	public void setRaw(int raw) {
		this.raw = raw;
	}
	public int raw=250;
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public SumM(String date2, String sum) {
		// TODO Auto-generated constructor stub
		Random r = new Random();
		int x=r.nextInt(Integer.valueOf(sum));
		this.setCost(sum);
		this.setMonth(date2);
		this.setRaw(x);
		this.setProfit(Integer.valueOf(sum)-x);
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String date) {
		this.month = date;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
}
