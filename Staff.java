package HelloWeb;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
public class Staff {
	public String staff_id;
	public String name;
	public String getAdmin_id() {
		return staff_id;
	}
	@Autowired
	public void setAdmin_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

