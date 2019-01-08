package HelloWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUpdate {
	  //Admin admin;
	  //Item item;
	  String url = "jdbc:mysql://localhost/canteenfinal?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
	  String userID = "root";
	  String password = "battlefront";
	  ResultSet Results;
	  Connection Db;
	  
	  public DbUpdate(){
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
	  public boolean insertOrder(String name3, Item item) throws SQLException 

	  {
	      String sql = "INSERT INTO `update`(`ITEM_ID`, `ADMIN_ID`) VALUES (?,?)";
	       
	      PreparedStatement statement = Db.prepareStatement(sql);
	      statement.setString(1, item.getItem_id());
	      statement.setString(2,name3);
	      
	       
	      boolean rowInserted = statement.executeUpdate() > 0;
	      statement.close();
	      //disconnect();
	     return rowInserted;
	  }
	  public boolean insertAdmin(String name3) throws SQLException 

	  {
	      String sql = "INSERT INTO `admin`(`ADMIN_ID`) VALUES (?)";
	       
	      PreparedStatement statement = Db.prepareStatement(sql);
	      statement.setString(1,name3);
	      //statement.setString(2, item.getItem_id());
	       
	      boolean rowInserted = statement.executeUpdate() > 0;
	      statement.close();
	      //disconnect();
	      return rowInserted;
	  }
	  
	  public boolean addOrder(String name3, Order order) throws SQLException 

	  {
	      String sql = "INSERT INTO `delete`(`ORDER_ID`, `STAFF_ID`) VALUES (?,?)";
	       
	      PreparedStatement statement = Db.prepareStatement(sql);
	      statement.setInt(1, order.getId());
	      statement.setString(2,name3);
	      
	       
	      boolean rowInserted = statement.executeUpdate() > 0;
	      statement.close();
	      //disconnect();
	     return rowInserted;
	  }
	  public boolean insertStaff(String name3) throws SQLException 

	  {
	      String sql = "INSERT INTO `staff`(`STAFF_ID`) VALUES (?)";
	       
	      PreparedStatement statement = Db.prepareStatement(sql);
	      statement.setString(1,name3);
	      //statement.setString(2, item.getItem_id());
	       
	      boolean rowInserted = statement.executeUpdate() > 0;
	      statement.close();
	      //disconnect();
	      return rowInserted;
	  }

}
