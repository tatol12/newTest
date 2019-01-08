package HelloWeb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

public class DbConnection {
  
  User user;
  String url = "jdbc:mysql://localhost/bis?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
  String userID = "root";
  String password = "battlefront";
  ResultSet Results;
  Connection Db;
  

  int count;
   JSONObject result = new JSONObject();
  public DbConnection(){
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
  public boolean insertUser(User user) throws SQLException 

{
    String sql = "INSERT INTO t4 (name, pwd, country, dob, passport, qual) VALUES (?, ?, ?, ?, ?,?)";
     
    PreparedStatement statement = Db.prepareStatement(sql);
    statement.setString(1,user.getname());
    statement.setString(2, user.getPassword());
    statement.setString(3, user.getcountry());
    statement.setDate(4, user.getdob());
    statement.setString(5,user.getpassport());
    statement.setString(6, user.getqual());
     
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

  public List<User> listAllUsers() throws SQLException {
      List<User> listUser = new ArrayList<User>();
       
      String sql = "SELECT * FROM t4 WHERE isvalid='1' ORDER by tr_dt desc";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
    	  count++;
    	  JSONArray ja = new JSONArray();
          int sno = resultSet.getInt("sno");
          String name = resultSet.getString("name");
          String password = resultSet.getString("pwd");
          String country = resultSet.getString("country");
          String passport = resultSet.getString("passport");
          String qual = resultSet.getString("qual");
          Date dob = resultSet.getDate("dob");
          int isvalid = resultSet.getInt("isvalid");
          
          User user = new User(sno, name,password, country, passport, qual, isvalid, dob);
          listUser.add(user);
      }


      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return listUser;
  }

  public List<User> loginAllUsers(User user) throws SQLException {
      List<User> passwordUser = new ArrayList<User>();
       
      String sql = "select * from t4 where name='" + user.getname() + "' and pwd='" + user.getPassword()
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
  public List<User> archiveAllUsers() throws SQLException {
      List<User> archiveUser = new ArrayList<User>();
       
      String sql = "SELECT * FROM t4 WHERE isvalid='0' ORDER by tr_dt desc";
       
     // connect();
       
      Statement statement = Db.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
       
      while (resultSet.next()) {
          int sno = resultSet.getInt("sno");
          String name = resultSet.getString("name");
          String password = resultSet.getString("pwd");
          String country = resultSet.getString("country");
          String passport = resultSet.getString("passport");
          String qual = resultSet.getString("qual");
          int isvalid = resultSet.getInt("isvalid");
          Date dob = resultSet.getDate("dob");
          User user = new User(sno, name,password, country, passport, qual, isvalid, dob);
          archiveUser.add(user);
      }
       
      resultSet.close();
      statement.close();
       
      //disconnect();
       
      return archiveUser;
  }
  public boolean updateUser(User user) throws SQLException {
      String sql = "UPDATE t4 SET name = ?, pwd = ?, country = ?, dob= ?, passport = ?, qual = ? , tr_dt= NOW() WHERE sno = ?";
      //connect();
       
      PreparedStatement statement = Db.prepareStatement(sql);
      statement.setString(1, user.getname());
      statement.setString(2, user.getPassword());
      statement.setString(3, user.getcountry());
      statement.setDate(4, user.getdob());
      statement.setString(5,user.getpassport());
      statement.setString(6, user.getqual());
      statement.setString(7, user.getSno());
       
      boolean rowUpdated = statement.executeUpdate() > 0;
      statement.close();
    //  disconnect();
      return rowUpdated;     
  }
  public boolean deleteUser(User user) throws SQLException {
      String sql = "UPDATE t4 SET isvalid='0' , tr_dt= NOW() WHERE sno = ?";
      //connect();
       
      PreparedStatement statement = Db.prepareStatement(sql);

      statement.setString(1, user.getSno());
       
      boolean rowUpdated = statement.executeUpdate() > 0;
      statement.close();
      return rowUpdated;     
  }
public boolean activateUser(User user) throws SQLException {
	// TODO Auto-generated method stub
	String sql = "UPDATE t4 SET isvalid='1' , tr_dt= NOW() WHERE sno = ?";
       
    PreparedStatement statement = Db.prepareStatement(sql);
    /*statement.setString(1, user.getname());
    statement.setString(2, user.getPassword());
    statement.setString(3, user.getcountry());
    statement.setString(4, user.getpassport());
    statement.setString(5, user.getqual());*/
    System.out.println("inside db");
    statement.setString(1, user.getSno());
     
    boolean rowUpdated = statement.executeUpdate() > 0;
    statement.close();
  //  disconnect();
    return rowUpdated;
}

}
