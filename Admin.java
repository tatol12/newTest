package HelloWeb;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
public class Admin {
	public String admin_id;
	public String name;
	public String getAdmin_id() {
		return admin_id;
	}
	@Autowired
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

