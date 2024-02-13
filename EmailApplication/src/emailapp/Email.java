package emailapp;

import java.util.Scanner;

public class Email 

{
	private String firstname;
	private String lastname;
	private String password;
	private String email;
	private int defaultPasswordLength =10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "csc.com";
	
	// constructor to receive the first and last name
	public Email(String firstname, String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		System.out.println("Email created: "+ this.firstname + " " + this.lastname);
		
		// call the method for asking department and return department 
		this.department = setDepartment();
		System.out.println("Department is: "+ this.department);
		
		// call the method which generates random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("You password is: "+this.password);
		
		// combine elements to generate email
		email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("Your email is: "+this.email);
	}
	// Ask for department
	private String setDepartment()
	{
		System.out.println("DEPARTMENT CODES\n1 for Sales\n2 for Devlopment\n3 for accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		if(deptChoice==1) { return "sales";}
		else if( deptChoice==2) { return "Devlopment";}
		else if(deptChoice==3) {return "Accounting";}
		else { return "";}
	}
	
	//generate a random string password
	private String randomPassword(int length)
	{
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUXYZ0123456789!@#$%";
		char[] password = new char[length];
	    for(int i=0; i<length ;i++)
	    {
	    	int rand = (int)(Math.random()*passwordSet.length());
	    	password[i] = passwordSet.charAt(rand);
	    }
	    return new String(password);
	}
	//set the mail box capacity
	public void setMailboxCapacity(int capacity)
	{
		this.mailboxCapacity = capacity;
	}
	
	//set the alternate email
	public void setAlternateEmail(String altEmail)
	{
		this.alternateEmail =altEmail;
	}
	
	// change the password
	public void changePassword(String password)
	{
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo()
	{
		return "DISPLAY NAME: " + firstname + " " + lastname +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " +mailboxCapacity + "mb";
	}
	
}
