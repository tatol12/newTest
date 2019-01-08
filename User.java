package HelloWeb;

import java.sql.Date;

//import java.util.ArrayList;

//import sun.util.calendar.BaseCalendar.Date;

public class User {
  private int sno;
  private String name;
  private String password;
  private java.sql.Date dob;
  private String country;
  private  String passport;
  private String qual;
  private int isvalid;
  public User(String name2, String password2, String country2, String passport2, String qual2, String dob) {
	// TODO Auto-generated constructor stub
	  this.setcountry(country2);
	  this.setname(name2);
	  this.setpassport(passport2);
	  this.setPassword(password2);
	  this.setqual(qual2);
	  this.setdob(dob);
	  
}
  
  public User(int sno2, String name2, String password2, String country2, String passport2, String qual2, int isvalid2, Date dob) {
	// TODO Auto-generated constructor stub
	  this.setSno(sno2);
	  this.setIsvalid(isvalid2);
	  this.setcountry(country2);
	  this.setname(name2);
	  this.setpassport(passport2);
	  this.setPassword(password2);
	  this.setqual(qual2);
	  this.setdobDate(dob);
}

public User(String name2, String password2, String country2, String passport2, String qual2, String sno2, String dob) {
	// TODO Auto-generated constructor stub
	this.setSnoStr(sno2);
	  //this.setIsvalid(isvalid2);
	  this.setcountry(country2);
	  this.setname(name2);
	  this.setpassport(passport2);
	  this.setPassword(password2);
	  this.setqual(qual2);
	  this.setdob(dob);
}


public User(String isvalid, String sno2) {
	// TODO Auto-generated constructor stub
	this.setSnoStr(sno2);
	this.setIsvalidStr(isvalid);
}

public User(String name, String password2,int i) {
	// TODO Auto-generated constructor stub
	this.setname(name);
	this.setPassword(password2);
}

public int getIsvalid() {
	return isvalid;
}

public void setIsvalid(int isvalid) {
	this.isvalid = isvalid;
}
public void setIsvalidStr(String isvalid) {
	this.isvalid = Integer.valueOf(isvalid);
}

public String getSno() {
	return String.valueOf(sno);
}


public void setSno(int sno) {
	this.sno = sno;
}

public void setSnoStr(String sno) {
	this.sno = Integer.valueOf(sno);
}
public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public java.sql.Date getdob() {
    return dob;
  }

  public void setdob(String date) {
    this.dob = java.sql.Date.valueOf(date);
  }

  public void setdobDate(Date date) {
	    this.dob = date;
	  }

  public String getcountry() {
    return country;
  }

  public void setcountry(String country) {
    this.country = country;
  }

  public String getpassport() {
    return passport;
  }

  public void setpassport(String passport) {
    this.passport = passport;
  }

  public String getqual() {
    return qual;
  }

  public void setqual(String qual) {
    this.qual = qual;
  }
}
