package capstone1;

public class Client {

	//attributes and variables for Client class

	String cname,cemail,caddress,ctel_num,date;
	double cost;
	//constructor for Client class

	public Client(String cname,  String cemail, String caddress, String ctel_num, double cost, String date) {
		this.cname = cname;
		this.cemail = cemail;
		this.caddress = caddress;
		this.ctel_num = ctel_num;
		this.cost = cost;
		this.date = date;
	}

	//method for Client class

	public String getname() {
		return cname;
	}

	public String getemail() {
		return cemail;
	}
	public String getaddress() {
		return caddress;
	}
	public String gettel_num() {
		return ctel_num;
	}
	public double getcost() {
		return cost;
	}
	public String getdate() {
		return date;
	}
	//toString method for Client class

	public String toString() {
		String output = "Name: " + cname + ",";
		output += "Email Address: " + cemail + ",";
		output += "Physical Address: " + caddress + ",";
		output += "Telephone Number: " + ctel_num + ",";
		output += "The Amount you owe is: R" + cost +",";
		output += "The completion date is:" + date + ",";
		output += "Project Status: Finalized";
		return output;
	}
}

