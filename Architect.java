package capstone1;
public class Architect {

	//attributes and variables for Architect class

	String name_a,email_a,address_a,tel_num_a;

	//constructor for Architect class

	public Architect(String name_a,String email_a,String address_a,String tel_num_a) {
		this.name_a = name_a;
		this.email_a = email_a;
		this.address_a = address_a;
		this.tel_num_a = tel_num_a;
	}
	//method for Architect class

	public String getname() {
		return name_a;
	}

	public String getemail() {
		return email_a;
	}
	public String getaddress() {
		return address_a;
	}
	public String gettel_num() {
		return tel_num_a;
	}

	//toString method for Architect class

	public String toString() {
		String output = "Name: " + name_a + ",";
		output += "Email Address: " + email_a + ",";
		output += "Physical Address: " + address_a + ",";
		output += "Telephone Number: " + tel_num_a +"\n";
		return output;
	}
}


