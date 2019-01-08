package HelloWeb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import jbr.springmvc.controller.User;

//import org.springframework.ui.ModelMap;

@Controller
public class HelloController {
	//@Autowired
	//Admin admin;
	String name3;
	String name4;
	DbUpdate dbu = new DbUpdate();
	DbConnection Db = new DbConnection();
	List<User> list;
	List<User> archivelist;
	public void listUsers(List<User> list, ModelAndView model) throws SQLException
	{
		list = Db.listAllUsers();
		System.out.println(list.size());
		model.addObject("listUser", list);
	}
	public void archiveUsers(List<User> archivelist, ModelAndView model) throws SQLException
	{
		archivelist = Db.archiveAllUsers();
		model.addObject("archiveUser", archivelist);
	}
	DbConnectionOrder DbO = new DbConnectionOrder();
	List<Order> order;
	List<Order> archiveorder;
	public void listOrders(List<Order> order, ModelAndView model) throws SQLException
	{
		order = DbO.listAllOrders();
		System.out.println(order.size());
		model.addObject("listOrder", order);
	}
	public void archiveOrders(List<Order> archiveorder, ModelAndView model) throws SQLException
	{
		archiveorder = DbO.archiveAllOrders();
		model.addObject("archiveOrder", archiveorder);
	}
	List<Item> item;
	List<Item> archiveitem;
	List<Sum>  archivedate;
	List<SumM>  archivemonth;
	public void listItems(List<Item> item, ModelAndView model) throws SQLException
	{
		item = DbO.listAllItems();
		System.out.println(item.size());
		model.addObject("listItem", item);
	}
	public void archiveMonth(List<SumM> archivemonth, ModelAndView model) throws SQLException
	{
		archivemonth = DbO.archiveMonth();
		model.addObject("archiveMonth", archivemonth);
	}
	public void archiveItems(List<Item> archiveitem, ModelAndView model) throws SQLException
	{
		archiveitem = DbO.archiveAllItems();
		model.addObject("archiveItem", archiveitem);
	}
	public void archiveDate(List<Sum> archivedate, ModelAndView model) throws SQLException
	{
		archivedate = DbO.archiveDate();
		model.addObject("archiveDate", archivedate);
	}
	//home page code
   @RequestMapping(value="/" ,method = RequestMethod.GET)													
   public ModelAndView showHello() throws SQLException{  
       System.out.println("aaaa");   
       
      ModelAndView model1 = new ModelAndView("loginOption");
      listUsers(list,model1);
      archiveUsers(list,model1);
      return model1;
  }
   @RequestMapping(value="/regProcess" ,method = RequestMethod.GET)
   public ModelAndView showHell() throws SQLException{  
       System.out.println("aaaa");   
       
      ModelAndView model1 = new ModelAndView("helloworld");
      listUsers(list,model1);
      archiveUsers(list,model1);
      return model1;
  }
   //code for registering t	he entry
   @RequestMapping(value="/registerProcess" ,method = RequestMethod.POST, params="register")
   public ModelAndView submitRegistrationForm(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		
	    String name = reqPar.get("name");
		String password = reqPar.get("password");
		String country= reqPar.get("country");
		String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String dob = reqPar.get("dob");
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
        User user = new User(name,password,country,passport,qual,dob);
		ModelAndView model1 = new ModelAndView("helloworld");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		Db.insertUser(user);
		System.out.println("registered");
		listUsers(list,model1);
		archiveUsers(archivelist,model1);
			return model1;
	}
   @RequestMapping(value="/loginRequestProcess" ,method = RequestMethod.POST, params="loginA")
   public ModelAndView showStaffForm(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
        
		ModelAndView model1 = new ModelAndView("login1");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		
			return model1;
	}
   @RequestMapping(value="/loginRequestProcess" ,method = RequestMethod.POST, params="loginS")
   public ModelAndView showAdminForm(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
        
		ModelAndView model1 = new ModelAndView("login2");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		
			return model1;
	}
   @RequestMapping(value="/loginProcess" ,method = RequestMethod.GET)
   public ModelAndView showLogin() throws SQLException{  
       System.out.println("aaaa");   
       
      ModelAndView model1 = new ModelAndView("login");
      //listUsers(list,model1);
      //archiveUsers(list,model1);
      return model1;
   }
   @RequestMapping(value="/validationProcess" ,method = RequestMethod.POST, params="login")
   public ModelAndView submitLoginForm(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		
	   String name1 = reqPar.get("name");

		String password = reqPar.get("password");
		System.out.println("This: "+name1+", "+password);
	    //User user = new User(name,password,1);
		Pattern pat = Pattern.compile("aaa");
		Matcher mat = pat.matcher(password);
		//ModelAndView model2 = new ModelAndView("hello");
		//List<User> list;
		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		//list=Db.loginAllUsers(user);
		if(mat.find())
		{
			System.out.println("Success");
		    //admin.admin_id=name;
			name4=name1;
			dbu.insertStaff(name4);
			ModelAndView model1 = new ModelAndView("orderstatus2");
			listOrders(order,model1);
			
			//System.out.println("List size: "+list.size());
			archiveOrders(archiveorder,model1);
			return model1;
		}
ModelAndView model1 = new ModelAndView("login1");
		
		System.out.println("not valid user");
			return model1;
	}
   @RequestMapping(value="/validationProcessAdmin" ,method = RequestMethod.POST, params="login")
   public ModelAndView submitLoginFormAdmin(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		
	    String name1 = reqPar.get("name");

		String password = reqPar.get("password");
		System.out.println("This: "+name1+", "+password);
	    //User user = new User(name,password,1);
		Pattern pat = Pattern.compile("aaa");
		Matcher mat = pat.matcher(password);
		//ModelAndView model2 = new ModelAndView("hello");
		//List<User> list;
		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		//list=Db.loginAllUsers(user);
		if(mat.find())
		{
			System.out.println("Success");
		    //admin.admin_id=name;
			name3=name1;
			dbu.insertAdmin(name3);
			ModelAndView model1 = new ModelAndView("itemStatus");
			listItems(item,model1);
			//System.out.println("List size: "+list.size());
			archiveItems(archiveitem,model1);
			return model1;
		}
		ModelAndView model1 = new ModelAndView("login2");
		
		System.out.println("registered");
			return model1;
	}
   //code for updating entry
   @RequestMapping(value="/registerProcess" ,method = RequestMethod.POST, params="update")
   public ModelAndView updateRegistrationForm(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		System.out.println("update complete");
	    String name = reqPar.get("name");
		String password = reqPar.get("password");
		String country= reqPar.get("country");
		String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String sno = reqPar.get("sno");
		String dob= reqPar.get("dob");
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
        User user = new User(name,password,country,passport,qual,sno,dob);
		ModelAndView model1 = new ModelAndView("helloworld");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		Db.updateUser(user);
		
		listUsers(list,model1);
		archiveUsers(archivelist,model1);
			return model1;
	}
   //code for deleting the entry
   @RequestMapping(value="/registerProcess" ,method = RequestMethod.POST, params="delete")
   public ModelAndView deleteRow(@RequestParam Map<String,String> reqPar) throws SQLException, IOException {
	String text = reqPar.get("test6");
		//String text = reqPar.get("field1");
		System.out.println("Hello: "+text);
		Pattern pat = Pattern.compile("[0-9]+");
		Matcher mat = pat.matcher(text);
		while(mat.find())
		{	System.out.println("Match: " + mat.group());
        User user = new User("1",mat.group());
		Db.deleteUser(user);
        }
		ModelAndView model1 = new ModelAndView("helloworld");
		//Db.deleteUser(user);
		listUsers(list,model1);
		//System.out.println("List size: "+list.size());
		archiveUsers(archivelist,model1);
		//System.out.println("archiveList size: "+archivelist.size());
		System.out.println("deletion complete");
		
			return model1;
	}
 //code for registering the order
   @RequestMapping(value="/registerOrder" ,method = RequestMethod.POST, params="register")
   public ModelAndView submitOrder(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		
	    String id = reqPar.get("id");
		String status= reqPar.get("status");
		/*String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String dob = reqPar.get("dob");
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;*/
        Order order1 = new Order(id, status);
		ModelAndView model1 = new ModelAndView("orderstatus2");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		DbO.insertOrder(order1);
		System.out.println("registered");
		listOrders(order,model1);
		archiveOrders(archiveorder,model1);
			return model1;
	}
   //code for updating entry
   @RequestMapping(value="/registerOrder" ,method = RequestMethod.POST, params="update")
   public ModelAndView updaterowOrder(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		System.out.println("update complete");
	    String id = reqPar.get("id");
		String status= reqPar.get("status");
		System.out.println(id+status);
		/*String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String sno = reqPar.get("sno");
		String dob= reqPar.get("dob");*/
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
        Order order1 = new Order(id, status);
		ModelAndView model1 = new ModelAndView("orderstatus2");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		DbO.updateOrder(order1);
		dbu.addOrder(name4, order1);
		listOrders(order,model1);
		archiveOrders(archiveorder,model1);
			return model1;
	}
   //code for deleting the entry
   @RequestMapping(value="/registerOrder" ,method = RequestMethod.POST, params="delete")
   public ModelAndView deleteRowOrder(@RequestParam Map<String,String> reqPar) throws SQLException, IOException {
	String text = reqPar.get("test6");
		//String text = reqPar.get("field1");
		System.out.println("Hello: "+text);
		Pattern pat = Pattern.compile("[0-9]+");
		Matcher mat = pat.matcher(text);
		while(mat.find())
		{	System.out.println("Match: " + mat.group());
        Order user = new Order(mat.group());
		DbO.deleteOrder(user);
		System.out.println("id:"+name4+"order:"+user.id);
		dbu.addOrder(name4, user);
        }
		ModelAndView model1 = new ModelAndView("orderstatus2");
		//Db.deleteUser(user);
		listOrders(order,model1);
		//System.out.println("List size: "+list.size());
		archiveOrders(archiveorder,model1);
		//System.out.println("archiveList size: "+archivelist.size());
		System.out.println("deletion complete");
		
			return model1;
	}
   @RequestMapping(value="/dTable",method = RequestMethod.GET)
   @ResponseBody
   public JSONObject listWithDatatable() throws SQLException
   {
	   JSONObject res = new JSONObject(); 
	   res = Db.listAllUsersDb();
		//res=res.toS;
	   //ModelAndView model1;\
	   System.out.println(res);
		return res;
   }

   @RequestMapping(value="/dTable2",method = RequestMethod.GET)
   @ResponseBody
   public JSONObject listWithDatatable2() throws SQLException
   {
	   JSONObject res = new JSONObject(); 
	   res = Db.archiveAllUsersDb();
		//res=res.toS;
	   //ModelAndView model1;\
	   System.out.println(res);
		return res;
   }

   //Code for activating the entry
   @RequestMapping(value="/registerProcess" ,method = RequestMethod.POST, params="activate")
   public ModelAndView activateRow(@RequestParam Map<String,String> reqPar) throws SQLException {
//	   System.out.println(params);
	   String text = reqPar.get("test5");
		System.out.println(text);
		Pattern pat = Pattern.compile("[0-9]+");
		Matcher mat = pat.matcher(text);
		while(mat.find())
		{	System.out.println("Match: " + mat.group());
       User user = new User("1",mat.group());
		Db.activateUser(user);
       }
		ModelAndView model1 = new ModelAndView("helloworld");
		//Db.activateUser(user);
		listUsers(list,model1);
		archiveUsers(archivelist,model1);
		System.out.println("activation complete");
			return model1;
	}     
   
   @RequestMapping(value="/registerItem" ,method = RequestMethod.POST, params="reg")
   public ModelAndView submitItem(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		System.out.println("Hello");
	    String item_id = reqPar.get("item_id");
		String name= reqPar.get("name");
		String price= reqPar.get("price");
		String description= reqPar.get("description");
		String quantity= reqPar.get("quantity");
		
		/*String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String dob = reqPar.get("dob");
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;*/
        Item item1 = new Item(item_id, name, price, description, quantity);
		ModelAndView model1 = new ModelAndView("itemStatus");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		DbO.insertItem(item1);
		System.out.println("Item added id="+item1.item_id);
		dbu.insertOrder(name3, item1);
		System.out.println("registered");
		listItems(item,model1);
		archiveItems(archiveitem,model1);
			return model1;
	}
   //code for updating entry
   @RequestMapping(value="/registerItem" ,method = RequestMethod.POST, params="update")
   public ModelAndView updaterowItem(@RequestParam Map<String,String> reqPar) throws SQLException {
	   // ArrayList<String> qual = new ArrayList<String>();
		System.out.println("update complete");
		String item_id = reqPar.get("item_id");
		String name= reqPar.get("name");
		String price= reqPar.get("price");
		String description= reqPar.get("description");
		String quantity= reqPar.get("quantity");
		//System.out.println(id+status);
		/*String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String sno = reqPar.get("sno");
		String dob= reqPar.get("dob");*/
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
		Item item1 = new Item(item_id, name, price, description, quantity);
		ModelAndView model1 = new ModelAndView("itemStatus");
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		DbO.updateItem(item1);
		dbu.insertOrder(name3, item1);
		listItems(item,model1);
		archiveItems(archiveitem,model1);
			return model1;
	}
   @RequestMapping(value="/registerItem" ,method = RequestMethod.POST, params="date")
   public ModelAndView showDate(@RequestParam Map<String,String> reqPar) throws SQLException {
	   
		//System.out.println(id+status);
		/*String passport = reqPar.get("passport");
		String qual = reqPar.get("test3");
		String sno = reqPar.get("sno");
		String dob= reqPar.get("dob");*/
		//String qual = reqPar.get(qual1+"qual");
		//qual1=qual1+", "+qual2;
		//Item item1 = new Item(item_id, name, price, description, quantity);
		ModelAndView model1 = new ModelAndView("date");
		
		//ModelAndView model2 = new ModelAndView("hello");

		//model.addObject("msg","Details provided :: Name: "+name+ ", Hobby: " + hobby);
		//DbO.updateItem(item1);
		//dbu.insertOrder(name3, item1);
		//listItems(item,model1);
		archiveDate(archivedate,model1);
		archiveMonth(archivemonth,model1);
			return model1;
	}
   
   @RequestMapping(value="/registerItem" ,method = RequestMethod.POST, params="delete")
   public ModelAndView deleteRowItem(@RequestParam Map<String,String> reqPar) throws SQLException, IOException {
	String text = reqPar.get("test6");
		//String text = reqPar.get("field1");
		System.out.println("Hello: "+text);
		Pattern pat = Pattern.compile("[0-9]+");
		Matcher mat = pat.matcher(text);
		while(mat.find())
		{	System.out.println("Match: " + mat.group());
        Item user = new Item(mat.group());
		DbO.deleteItem(user);
		dbu.insertOrder(name3, user);
        }
		ModelAndView model1 = new ModelAndView("itemStatus");
		//Db.deleteUser(user);
		listItems(item,model1);
		//System.out.println("List size: "+list.size());
		archiveItems(archiveitem,model1);
		//System.out.println("archiveList size: "+archivelist.size());
		System.out.println("deletion complete");
		
			return model1;
	}
}

