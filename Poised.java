package capstone1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Poised {

	public static void main(String[] args) throws FileNotFoundException {

		//all attributes and variables for all classes

		Project Project;
		String projname, type, address, projnum, erf, date, projdate, pstatus, status;
		double totalfee, atd, newamt, cost, ncost;
		int currentdate;

		Client Client;
		String cname, cemail, caddress, ctel_num;


		Contractor Contractor;
		String name_c, email_c, address_c, tel_num_c, name_newc, email_newc, address_newc, tel_num_newc;

		Architect Architect;
		String name_a, email_a, address_a, tel_num_a;

		int answer, choice, choice1, option1, select;

		//menu options

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Choose an option below:\n(1)Projects \n(2)New Contractor \n(3)New Architect \n(4)Edit \n(5)Exit");
		answer = sc.nextInt();

		//sub-menu for option 1
		
		if (answer == 1) {
			System.out.println("Please choose an option below from the submenu:\n(1)New Project \n(2)Finalize Project \n(3)View All Projects \n(4)View all Incompleted Projects");
			select = sc.nextInt();
			
			//new project module for capturing a new project

			if (select == 1) {
				sc.nextLine();
				System.out.println("Enter in the project number:");
				projnum = sc.nextLine();
				System.out.println("Enter in the project name:");
				projname = sc.nextLine();
				System.out.println("Enter in the building type eg(Apartment, House):");
				type = sc.nextLine();
				System.out.println("Enter in the address of the building:");
				address = sc.nextLine();
				System.out.println("Enter in the ERF number:");
				erf = sc.nextLine();
				System.out.println("Enter in the initial date(YYYMMDD):");
				projdate = sc.nextLine();
				System.out.println("Enter in the deadline date(YYYYMMDD):");
				date = sc.nextLine();
				System.out.println("Enter in the total amount of the project:");
				totalfee = sc.nextDouble();
				System.out.println("Enter in the amount paid in to date:");
				atd = sc.nextDouble();
				System.out.println("Please enter the current date(YYYYMMDD):");
				currentdate = sc.nextInt();


				//calculation for the total cost owing by the client 

				cost = totalfee - atd;
				if (cost == 0) { 
					pstatus = "Complete";
				}else {
					pstatus = "Incomplete";
				}
				//checks if project is overdue or not

				int d = Integer.parseInt(date);
				if (currentdate > d) {
					status = "Overdue";
				}else {
					status = "Within due date";
				}

				File p = new File("Project.txt");
				try {
					FileWriter fr = new FileWriter(p,true);
					BufferedWriter br = new BufferedWriter(fr);
					PrintWriter writer = new PrintWriter(br);
					Project = new Project(projnum,projname,type,address,erf,date,projdate,totalfee,atd,cost,pstatus,status);
					writer.println(Project);
					writer.close();
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				Project = new Project(projnum,projname,type,address,erf,date,projdate,totalfee,atd,cost,pstatus,status);
				System.out.println(Project);

				//captures all the details of the client

				sc.nextLine();
				System.out.println("Enter in the Clients Name:");
				cname = sc.nextLine();
				System.out.println("Enter in the Email Address of the Client:");
				cemail = sc.nextLine();
				System.out.println("Enter in the Physical Address of the Client:");
				caddress = sc.nextLine();
				System.out.println("Enter in the Clients telephone number:");
				ctel_num = sc.nextLine();

				File cl = new File("Client.txt");
				try {
					FileWriter fr = new FileWriter(cl,true);
					BufferedWriter br = new BufferedWriter(fr);
					PrintWriter writer = new PrintWriter(br);
					Client = new Client(cname, cemail, caddress, ctel_num, cost, date);
					writer.println(Client);	
					writer.close();
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Client = new Client(cname, cemail, caddress, ctel_num, cost, date);
				System.out.println(Client);	
			}
			//module for finalizing the project and creates an invoice via a text file
			//also if the balance is zero displays no invoice needed

			if (select == 2) {
				sc.nextLine();
				System.out.println("Do you wish to finalize the project? (1)Yes or (2)No: ");
				option1 = sc.nextInt();
				if (option1 == 1) {
					sc.nextLine();
					String l;
					String search;
					PrintWriter writer = new PrintWriter("Completed Project.txt");
					BufferedReader br = new BufferedReader(new FileReader("Client.txt"));
					System.out.println("Please enter in the clients name of the project you wish to finalize: ");
					search = sc.nextLine();       	 
					try {
						while ((l = br.readLine())!= null) {
							if (l.contains(search)){
								String[] array = l.split(",");
								String a = array[0];
								String b = array[1];
								String c = array[2];
								String d = array[3];
								String e = array[4];
								String f = array[5];
								String g = array[6];
								System.out.println(a);
								System.out.println(b);
								System.out.println(c);
								System.out.println(d);
								System.out.println(e);
								System.out.println(f);
								System.out.println(g);
								writer.println("####Invoice####\n");
								writer.println(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g );
								writer.close();

							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}



				}
				if (option1 == 2) {
					System.out.println("Thank you the project is marked: completed.");
				}

			}
			
			//view all projects and also adds an object to the selected project
			
			if (select == 3) {
				try(BufferedReader br = new BufferedReader(new FileReader("Project.txt"))){
					String line;
					while((line = br.readLine())!= null) {
						String[] array = line.split(",");
						for (String a : array)
							System.out.println(a);
					}
					br.close();

					System.out.println("Do you wish to add an object to a project (1)Yes (2)No: ");
					choice = sc.nextInt();
					if (choice == 1) {
						sc.nextLine();
						String l;
						String search;
						String Input;
						BufferedReader b = new BufferedReader(new FileReader("Project.txt"));
						System.out.println("Please enter in the project number eg Px to add an object to: ");
						search = sc.nextLine().toUpperCase();       	 
						while ((l = b.readLine())!= null) {
							if (l.contains(search)){
								ArrayList<String>Obj = new ArrayList<String>();
								Obj.add(l);
								System.out.println(Obj);
								System.out.println("Please enter an object you wish to add to the project: " );
								Input = sc.nextLine();                	
								Obj.add(Input);
								StringBuffer sb = new StringBuffer();
								for (String s : Obj) {
									sb.append(s);
									sb.append("");
								}
								String str = sb.toString();
								System.out.println(str);
								Scanner s = new Scanner(new File("Project.txt"));
								StringBuffer buff = new StringBuffer();
								while (s.hasNextLine()) {
									buff.append(s.nextLine()+System.lineSeparator());
								}
								String contents = buff.toString();
								s.close();
								String oldrec = l;
								String newrec = str;
								contents = contents.replaceAll(oldrec, newrec);
								FileWriter writer = new FileWriter("Project.txt");
								writer.append(contents);
								writer.flush();
								writer.close();
							}
						}
						b.close(); 
					}
					else {
						if (choice == 2) {
							System.out.println("Thank you - Goodbye!!");
						}
					}
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
			}

			//views all incomplete projects
			
			if (select == 4) {
				try(BufferedReader br = new BufferedReader(new FileReader("Project.txt"))){
					String line;
					while((line = br.readLine())!= null) {
						if (line.contains("incomplete")){
							String[] array = line.split(",");
							for (String a : array)
								System.out.println(a);                		                              
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			//views all overdue projects
			
			if (select == 5) {
				try(BufferedReader br = new BufferedReader(new FileReader("Project.txt"))){
					String line;
					while((line = br.readLine())!= null) {
						if (line.contains("Overdue")){
							String[] array = line.split(",");
							for (String a : array)
								System.out.println(a);



						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
		}
		
		//captures the contractors details

		if (answer == 2) {

			sc.nextLine();
			System.out.println("Enter in the Contractors Name:");
			name_c = sc.nextLine();
			System.out.println("Enter in the Email Address of the Contractor:");
			email_c = sc.nextLine();
			System.out.println("Enter in the Physical Address of the Contractor:");
			address_c = sc.nextLine();
			System.out.println("Enter in the Contractors telephone number:");
			tel_num_c = sc.nextLine();

			File c = new File("Contractor.txt");
			try {
				FileWriter fr = new FileWriter(c,true);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter writer = new PrintWriter(br);
				Contractor = new Contractor(name_c, email_c, address_c, tel_num_c);
				writer.println(Contractor);	
				writer.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Contractor = new Contractor(name_c, email_c, address_c, tel_num_c);
			System.out.println(Contractor);
		}

		// captures the architects details

		if (answer == 3) {
			sc.nextLine();	
			System.out.println("Enter in the Architects Name: ");
			name_a = sc.nextLine();
			System.out.println("Enter in the Email Address of the Architect: ");
			email_a = sc.nextLine();
			System.out.println("Enter in the Physical Address of the Architect: ");
			address_a = sc.nextLine();
			System.out.println("Enter in the Architects telephone number: ");
			tel_num_a = sc.nextLine();

			File a = new File("Architect.txt");
			try {
				FileWriter fr = new FileWriter(a,true);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter writer = new PrintWriter(br);
				Architect = new Architect(name_a, email_a, address_a, tel_num_a);
				writer.println(Architect);
				writer.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Architect = new Architect(name_a, email_a, address_a, tel_num_a);
			System.out.println(Architect);
		}	

		//edit option for updating the contractors details, deadline date and amount to be paid

		if (answer == 4) {
			System.out.println("Please choose an option below:\n(1)Update Contractors details\n(2)Update due date\n(3)Update amount to be paid");
			choice = sc.nextInt();

			if (choice == 1) {

				try{
					BufferedReader br = new BufferedReader(new FileReader("Contractor.txt"));

					StringBuffer clist = new StringBuffer();
					String line;
					while ((line = br.readLine()) != null) {	
						clist.append(line);
						clist.append("\n");

					}
					br.close();
					String newname = clist.toString();
					String newemail = clist.toString();
					String newaddress = clist.toString();
					String newtel_num = clist.toString();
					System.out.println(clist);

					sc.nextLine();
					System.out.println("What would you like to update?\n(1)Contractors name\n(2)Contractors Email Address\n(3)Contractors Physical Address\n(4)Contractors Telephone Number");
					choice1 = sc.nextInt();
					if(choice1 == 1) {
						sc.nextLine();
						System.out.println("Enter in the old info for Contractors Name: ");
						name_c = sc.nextLine();
						System.out.println("Enter in the new info for Contractors Name: ");
						name_newc = sc.nextLine();
						newname = newname.replace(name_c, name_newc);
						FileOutputStream f = new FileOutputStream("Contractor.txt");
						f.write(newname.getBytes());
						f.close();
					}
					if(choice1 == 2) {
						sc.nextLine();
						System.out.println("Enter in the old info for Contractors Email Address: ");
						email_c = sc.nextLine();
						System.out.println("Enter in the new info for Contractors Email Address: ");
						email_newc = sc.nextLine();
						newemail = newemail.replace(email_c, email_newc);
						FileOutputStream f = new FileOutputStream("Contractor.txt");
						f.write(newemail.getBytes());
						f.close();
					}
					if(choice1 == 3) {
						sc.nextLine();
						System.out.println("Enter in the old info for Contractors Physical Address: ");
						address_c = sc.nextLine();
						System.out.println("Enter in the new info for Contractors Physical Address: ");
						address_newc = sc.nextLine();
						newaddress = newaddress.replace(address_c, address_newc);
						FileOutputStream f = new FileOutputStream("Contractor.txt");
						f.write(newaddress.getBytes());
						f.close();
					}
					if(choice1 == 4) {
						sc.nextLine();
						System.out.println("Enter in the old info for Contractors Telephone number: ");
						tel_num_c = sc.nextLine();
						System.out.println("Enter in the new info for Contractors Telephone number: ");
						tel_num_newc = sc.nextLine();
						newtel_num = newtel_num.replace(tel_num_c, tel_num_newc);
						FileOutputStream f = new FileOutputStream("Contractor.txt");
						f.write(newtel_num.getBytes());
						f.close();
					}
					System.out.println("Details updated");

				}
				catch (Exception e) {
					System.out.println("Problem reading file. File does not exist or corrupt");
				}



			}	

			//updates the deadline dates
			
			if (choice == 2) {

				try{
					BufferedReader br = new BufferedReader(new FileReader("Project.txt"));

					StringBuffer plist = new StringBuffer();
					String line;
					while ((line = br.readLine()) != null) {	
						plist.append(line);
						plist.append("\n");

					}
					br.close();
					String newdate = plist.toString();
					String ndate = plist.toString();
					System.out.println(plist);

					sc.nextLine();
					String l;
					String search;
					BufferedReader b = new BufferedReader(new FileReader("Project.txt"));
					System.out.println("Please enter in the project number eg Px to update: ");
					search = sc.nextLine().toUpperCase();       	 
					while ((l = b.readLine())!= null) {
						if (l.contains(search)){
							String[] array = l.split(",");
							for (String a : array)
								System.out.println(a);

						}
					}
					b.close(); 

					sc.nextLine();
					System.out.println("Enter in the old deadline date: ");
					date = sc.nextLine();
					System.out.println("Enter in the new deadline date: ");
					ndate = sc.nextLine();
					newdate = newdate.replace(date, ndate);
					FileOutputStream f = new FileOutputStream("Project.txt");
					f.write(newdate.getBytes());
					f.close();


					System.out.println("Details updated");

				}
				catch (Exception e) {
					System.out.println("Problem reading file. File does not exist or corrupt");
				}	
			}

			//updates the amount paid to date and the total amount outstanding

			if (choice == 3) {
				try{
					BufferedReader br = new BufferedReader(new FileReader("Project.txt"));

					StringBuffer atdlist = new StringBuffer();
					String line;
					while ((line = br.readLine()) != null) {	
						atdlist.append(line);
						atdlist.append("\n");

					}

					br.close();
					String newatd = atdlist.toString();
					System.out.println(atdlist);

					sc.nextLine();
					String l;
					String search;
					BufferedReader b = new BufferedReader(new FileReader("Project.txt"));
					System.out.println("Please enter in the project number eg Px to update: ");
					search = sc.nextLine().toUpperCase();       	 
					while ((l = b.readLine())!= null) {
						if (l.contains(search)){
							String[] array = l.split(",");
							for (String a : array)
								System.out.println(a);

						}
					}
					b.close(); 
					sc.nextLine();
					System.out.println("Enter in the old amount paid to date: ");
					atd = sc.nextDouble();
					System.out.println("Enter in the new amount paid to date: ");
					newamt = sc.nextDouble();
					System.out.println("The new amount paid is: R" + newamt);
					String oldatd = "" + atd;
					String natd = "" + newamt;
					newatd = newatd.replace(oldatd,natd);
					FileOutputStream f = new FileOutputStream("Project.txt");
					f.write(newatd.getBytes());
					f.close();


					sc.nextLine();
					System.out.println("Enter in the current amount outstanding: ");
					cost = sc.nextDouble();
					System.out.println("What is the total fee of the project: ");
					totalfee = sc.nextDouble();
					ncost = totalfee - newamt;
					System.out.println("The new amount outstanding is: R" + ncost);
					String total = "" + ncost;
					String oldcost = "" + cost;
					newatd = newatd.replace(oldcost,total);

					System.out.println("Details updated");

					FileOutputStream file = new FileOutputStream("Project.txt");
					file.write(newatd.getBytes());
					file.close();

				}
				catch (Exception e) {
					System.out.println("Problem reading file. File does not exist or corrupt");
				}
			}
		}


		//exit option from program

		if (answer == 5) {
			System.out.println("You have exited.\nGoodbye!!");
		}
	}
}




