package capstone1;
public class Contractor {

	//attributes and variables for Contractor class

	String name_c,email_c,address_c,tel_num_c;

	//constructor for Contractor class

	public Contractor(String name_c,  String email_c, String address_c, String tel_num_c) {
		this.name_c = name_c;
		this.email_c = email_c;
		this.address_c = address_c;
		this.tel_num_c = tel_num_c;
	}

	//method for Contractor class

	public String getname() {
		return name_c;
	}

	public String getemail() {
		return email_c;
	}
	public String getaddress() {
		return address_c;
	}
	public String gettel_num() {
		return tel_num_c;
	}

	//toString method for Contractor class

	public String toString() {
		String output = "Name: " + name_c + ",";
		output += "Email Address: " + email_c + ",";
		output += "Physical Address: " + address_c + ",";
		output += "Telephone Number: " + tel_num_c + "\n";
		return output;
	}
}


