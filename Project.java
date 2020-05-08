package capstone1;

public class Project {

	//attributes and variables for Project class

	String projnum,projname,type,address,erf,date,projdate,pstatus,status;
	double totalfee, atd, cost;
	//constructor for Project class

	public Project(String projnum,String projname, String type, String address,String erf, String date, String projdate, double totalfee, double atd, double cost, String pstatus, String status) {

		this.projnum = projnum;
		this.projname = projname;
		this.type = type;
		this.address = address;
		this.erf = erf;
		this.date = date;
		this.projdate = projdate;
		this.totalfee = totalfee;
		this.atd = atd;
		this.cost = cost;
		this.pstatus = pstatus;
		this.status = status;
	}

	//methods for Project class

	public String getprojnum() {
		return projnum;
	}
	public String getprojname(){
		return projname;
	}
	public String gettype() {
		return type;
	}
	public String getaddress() {
		return address;
	}
	public String geterf() {
		return erf;
	}
	public String getprojdate() {
		return projdate;
	}
	public String getdate() {
		return date;
	}
	public double gettotalfee() {
		return totalfee;
	}
	public double getatd() {
		return atd;
	}
	public double getcost() {
		return cost;
	}
	public String getpstatus() {
		return pstatus;
	}
	public String getstatus() {
		return status;
	}
	//toString method for Project class

	public String toString() {
		String output = "Project number: " + projnum +",";
		output += "Project name: " + projname +",";
		output += "Building type: " + type +",";
		output += "Physical address of building: " + address +",";
		output += "ERF Number: " + erf +",";
		output += "Date of Initial project: " + projdate +",";
		output += "Deadline date for project completion: " + date +",";
		output += "Total Fee for Project: R" + totalfee +",";
		output += "Amount paid to date: R" + atd +",";
		output += "Amount outstanding is: R" + cost +",";
		output += "Project Status: " + pstatus + ",";
		output += "Deadline Status: " + status +"\n";
		
		return output;
	}

}


