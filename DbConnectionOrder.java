package HelloWeb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

public class DbConnectionOrder {
  
  User user;
  String url = "jdbc:mysql://localhost/canteenfinal?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
  String userID = "root";
  String password = "battlefront";
  ResultSet Results;
  Connection Db;
  

  int count;
   JSONObject result = new JSONObject();
  public DbConnectionOrder(){
  try {
  Class.forName( "com.mysql.jdbc.Driver");
  Db = DriverManager.getConnection(url,userID,password);
  }
  catch (ClassNotFoundException e) {
  System.err.println(
  "Unable to load the JDBC/ODBC bridge." + e);
  System.exit(1);
  }
  catch (SQLException e1) {
  System.err.println("Cannot connect to the database." + e1);
  System.exit(2);
  }}
  public boolean insertOrder(Order user) throws SQLException 

{
    String sql = "INSERT INTO order_list (id, status) VALUES (?, ?)";
     
    PreparedStatement statement = Db.prepareStatement(sql);
    statement.setInt(1,user.getId());
    statement.setString(2, user.getStatus());
     
    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    //disconnect();
    return rowInserted;
}
  public JSONObject listAllUsersDb() throws SQLException {
      List<User> listUser = new ArrayList<User>();
      count=0;
      //JSONArray arrayObj = new JSONArray();
      JSONArray data = new JSONArray();
      String sql = "SELECT * FROM t4 WHERE isvalid='1' ORDER by tr_dt desc";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
    	  count++;
    	  JSONObject ja = new JSONObject();
          int sno = resultSet.getInt("sno");
          String name = resultSet.getString("name");
          String password = resultSet.getString("pwd");
          String country = resultSet.getString("country");
          String passport = resultSet.getString("passport");
          String qual = resultSet.getString("qual");
          Date dob = resultSet.getDate("dob");
          int isvalid = resultSet.getInt("isvalid");
          Date tr_dt = resultSet.getDate("tr_dt");
          ja.put(0, sno);
          ja.put(1,name);
          ja.put(2,password);
          ja.put(3,country);
          ja.put(4, dob);
          ja.put(5,passport);
          ja.put(6,qual);
          ja.put(7, tr_dt);
          //data.clear();
          data.add(ja);
          User user = new User(sno, name,password, country, passport, qual, isvalid, dob);
          listUser.add(user);
      }
      result.put("aaData", data);
      result.put("sEcho",1);
      result.put("iTotalRecords",count);
      result.put("iTotalDisplayRecords", count);


         System.out.println("Res:"+result);
       System.out.flush();
      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return result;
  }
  public JSONObject archiveAllUsersDb() throws SQLException {
      List<User> listUser = new ArrayList<User>();
      count=0;
      //JSONArray arrayObj = new JSONArray();
      JSONArray data = new JSONArray();
      String sql = "SELECT * FROM t4 WHERE isvalid='0' ORDER by tr_dt desc";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
    	  count++;
    	  JSONObject ja = new JSONObject();
          int sno = resultSet.getInt("sno");
          String name = resultSet.getString("name");
          String password = resultSet.getString("pwd");
          String country = resultSet.getString("country");
          String passport = resultSet.getString("passport");
          String qual = resultSet.getString("qual");
          Date dob = resultSet.getDate("dob");
          int isvalid = resultSet.getInt("isvalid");
          Date tr_dt = resultSet.getDate("tr_dt");
          ja.put(0, sno);
          ja.put(1,name);
          ja.put(2,password);
          ja.put(3,country);
          ja.put(4, dob);
          ja.put(5,passport);
          ja.put(6,qual);
          ja.put(7, tr_dt);
          //data.clear();
          data.add(ja);
          User user = new User(sno, name,password, country, passport, qual, isvalid, dob);
          listUser.add(user);
      }
      result.put("aaData", data);
      result.put("sEcho",1);
      result.put("iTotalRecords",count);
      result.put("iTotalDisplayRecords", count);


         System.out.println("Res:"+result);
       System.out.flush();
      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return result;
  }

  public List<Order> listAllOrders() throws SQLException {
      List<Order> listOrder = new ArrayList<Order>();
      
      String sql = "SELECT * FROM order_list WHERE isReady='1' ORDER by TIME desc";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
    	  count++;
    	  JSONArray ja = new JSONArray();
          int id = resultSet.getInt("order_id");
          String status = resultSet.getString("status");
          String items = resultSet.getString("items");
          int cost = resultSet.getInt("cost");
         // System.out.println(items);
          
          Order order = new Order(id, status, items, cost);
          System.out.println(order.items);
          System.out.println(order.cost);
          //System.out.println(order.data1);
          listOrder.add(order);
      }


      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return listOrder;
  }

  public List<User> loginAllUsers(User user) throws SQLException {
      List<User> passwordUser = new ArrayList<User>();
       
      String sql = "select * from order_list where name='" + user.getname() + "' and pwd='" + user.getPassword()
      + "'";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
          //String name = resultSet.getString("name");
          String password = resultSet.getString("pwd");
          //User user1 = new User(password);
          //passwordUser.add(user1);
      }
      //boolean rowInserted = statement.executeUpdate() > 0;
     // statement.close();
      //disconnect();
     // return rowInserted;   
      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return passwordUser;
  }
  public List<Order> archiveAllOrders() throws SQLException {
      List<Order> archiveOrder = new ArrayList<Order>();
       
      String sql = "SELECT * FROM order_list WHERE isReady='0' ORDER by TIME desc";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
          int id = resultSet.getInt("order_id");
          String status = resultSet.getString("status");
          
          Order order = new Order(id, status, "");
          archiveOrder.add(order);
      }
       
      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return archiveOrder;
  }
  public boolean updateOrder(Order user) throws SQLException {
      String sql = "UPDATE order_list SET status = ?, TIME= NOW() WHERE order_id = ?";
      //connect();
       
      PreparedStatement statement = Db.prepareStatement(sql);
      
      statement.setString(1, user.getStatus());
      statement.setInt(2, user.getId());
       
      boolean rowUpdated = statement.executeUpdate() > 0;
      statement.close();
    //  disconnect();
      return rowUpdated;     
  }
  public boolean deleteOrder(Order user) throws SQLException {
      String sql = "UPDATE order_list SET isready='0' , TIME= NOW() WHERE order_id = ?";
      //connect();
      System.out.println("deleting..."); 
      PreparedStatement statement = Db.prepareStatement(sql);
      System.out.println(user.getId());
      statement.setInt(1, user.getId());
       
      boolean rowUpdated = statement.executeUpdate() > 0;
      statement.close();
      return rowUpdated;     
  }
public boolean activateOrder(Order order) throws SQLException {
	// TODO Auto-generated method stub
	String sql = "UPDATE order_list SET isReady='1' , TIME= NOW() WHERE order_id = ?";
       
    PreparedStatement statement = Db.prepareStatement(sql);
    /*statement.setString(1, user.getname());
    statement.setString(2, user.getPassword());
    statement.setString(3, user.getcountry());
    statement.setString(4, user.getpassport());
    statement.setString(5, user.getqual());*/
    System.out.println("inside db");
    statement.setInt(1, order.getId());
     
    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
  //  disconnect();
    return rowUpdated;
}


public boolean insertItem(Item item) throws SQLException 

{
    String sql = "INSERT INTO menu (item_id, name, price, description, quantity) VALUES (?, ?, ?, ?, ?)";
     
    PreparedStatement statement = Db.prepareStatement(sql);
    
    statement.setString(1, item.getItem_id());
    statement.setString(2, item.getName());
    statement.setInt(3, item.getPrice());
    statement.setString(4, item.getDescription());
    statement.setInt(5, item.getQuantity());
    boolean rowInserted = statement.executeUpdate() > 0;
    statement.close();
    //disconnect();
    return rowInserted;
}

public List<Item> listAllItems() throws SQLException {
    List<Item> listItem = new ArrayList<Item>();
     
    String sql = "SELECT * FROM menu WHERE isValid='1' ";
     
   // connect();
     
    Statement statement = Db.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
     
    while (resultSet.next()) {
  	  count++;
  	  JSONArray ja = new JSONArray();
        String item_id = resultSet.getString("item_id");
        String name = resultSet.getString("name");
        int price = resultSet.getInt("price");
        String description = resultSet.getString("description");
        int quantity = resultSet.getInt("quantity");
        /*String password = resultSet.getString("pwd");
        String country = resultSet.getString("country");
        String passport = resultSet.getString("passport");
        String qual = resultSet.getString("qual");
        Date dob = resultSet.getDate("dob");
        int isvalid = resultSet.getInt("isvalid");*/
        
        Item item = new Item(item_id, name, price, description, quantity);
        listItem.add(item);
    }


    resultSet.close();
    statement.close();
     
    //disconnect();
     
    return listItem;
}

public List<Item> archiveAllItems() throws SQLException {
    List<Item> archiveItem = new ArrayList<Item>();
     
    String sql = "SELECT * FROM menu WHERE isValid='0'";
     
   // connect();
     
    Statement statement = Db.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
     
    while (resultSet.next()) {
    	String item_id = resultSet.getString("item_id");
        String name = resultSet.getString("name");
        int price = resultSet.getInt("price");
        String description = resultSet.getString("description");
        int quantity = resultSet.getInt("quantity");
        
        Item item = new Item(item_id, name, price, description, quantity);
        archiveItem.add(item);
    }
     
    resultSet.close();
    statement.close();
     
    //disconnect();
     
    return archiveItem;
}
public boolean updateItem(Item user) throws SQLException {
    String sql = "UPDATE menu SET name = ?, price = ?, description = ?, quantity = ? WHERE item_id = ?";
    //connect();
     
    PreparedStatement statement = Db.prepareStatement(sql);
    
    statement.setString(1, user.getName());
    statement.setInt(2, user.getPrice());
    statement.setString(3, user.getDescription());
    statement.setInt(4, user.getQuantity());
    statement.setString(5, user.getItem_id());
    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
  //  disconnect();
    return rowUpdated;     
}
public boolean deleteItem(Item user) throws SQLException {
    String sql = "UPDATE menu SET isValid='0' WHERE item_id = ?";
    //connect();
     
    PreparedStatement statement = Db.prepareStatement(sql);

    statement.setString(1, user.getItem_id());
     
    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
    return rowUpdated;     
}
public boolean activateItem(Item order) throws SQLException {
	// TODO Auto-generated method stub
	String sql = "UPDATE menu SET isValid='1' WHERE item_id = ?";
     
  PreparedStatement statement = Db.prepareStatement(sql);
  /*statement.setString(1, user.getname());
  statement.setString(2, user.getPassword());
  statement.setString(3, user.getcountry());
  statement.setString(4, user.getpassport());
  statement.setString(5, user.getqual());*/
  System.out.println("inside db");
  statement.setString(1, order.getItem_id());
   
  boolean rowUpdated = statement.executeUpdate() > 0;
  statement.close();
//  disconnect();
  return rowUpdated;
}

public List<Sum> archiveDate() throws SQLException {
    List<Sum> archiveItem = new ArrayList<Sum>();
     
    String sql = "SELECT date(time),sum(cost) FROM order_list GROUP BY date(time)";
     
   // connect();
     
    Statement statement = Db.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
     
    while (resultSet.next()) {
    	String date = resultSet.getString("date(time)");
        String sum = resultSet.getString("sum(cost)");
        //int price = resultSet.getInt("price");
        //String description = resultSet.getString("description");
        //int quantity = resultSet.getInt("quantity");
        
        Sum item = new Sum(date, sum);
        System.out.println(item.cost);
        archiveItem.add(item);
    }
     
    resultSet.close();
    statement.close();
     
    //disconnect();
     
    return archiveItem;
}
public List<SumM> archiveMonth() throws SQLException {
    List<SumM> archiveItem = new ArrayList<SumM>();
     
    String sql = "SELECT month(time),sum(cost) FROM order_list GROUP BY month(time)";
     
   // connect();
     
    Statement statement = Db.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);
     
    while (resultSet.next()) {
    	String month = resultSet.getString("month(time)");
        String sum = resultSet.getString("sum(cost)");
        //int price = resultSet.getInt("price");
        //String description = resultSet.getString("description");
        //int quantity = resultSet.getInt("quantity");
        
        SumM item = new SumM(month, sum);
        archiveItem.add(item);
    }
     
    resultSet.close();
    statement.close();
     
    //disconnect();
     
    return archiveItem;
}
}
