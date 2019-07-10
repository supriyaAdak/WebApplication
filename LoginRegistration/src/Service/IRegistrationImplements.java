package Service;

//import java.net.PasswordAuthentication;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

//import javax.mail.Session;
//import javax.mail.PasswordAuthentication;


import javax.mail.*;    
import javax.mail.internet.*;    


import Dao.RegistrationDao;
import Dto.RegistraionDto;

public class IRegistrationImplements implements ILoginRegistration
{

	   boolean s = false;
	@Override
	public boolean  Registration(String fname, String lname, String Uname, String emailid, String pass) {
		try 
		{
			Connection con = RegistrationDao.RegDao();
		
			  
			
			String Query = "insert into Registration (FirstName,LastName,UserName,EmailId,Password)values(?,?,?,?,?)";
			  PreparedStatement ps=con.prepareStatement(Query);
			  ps.setString(1, fname);
			  ps.setString(2, lname);
			  ps.setString(3, Uname);
			  ps.setString(4, emailid);
			  ps.setString(5, pass);
		     int i=ps.executeUpdate();
		    
			if(i>0) 
			{
				 s= true;
			   
			    if(fname.isEmpty() || lname.isEmpty() || Uname.isEmpty() || 
			    		 emailid.isEmpty() || pass.isEmpty() ) 
			    {
			    	
				System.out.println("Successfully Not Registerd...fill all the fields..");
				}
			    else 
			    {
			    	
			    	System.out.println("successfully Registered ..");
			    }
				  
			}else
			{
				s= false;
				System.out.println("Not Registered");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return s;
	
		
	}
	@Override
	public boolean registration(RegistraionDto user) {
		try{
		Connection con = RegistrationDao.RegDao();
		 String fname = user.getFirstName();
		 String lname = user.getLastName();
		 String Uname = user.getUserName();
		 String emailid= user.getEmailId();
		 String pass = user.getPassword();
		
		String Query = "insert into Registration (FirstName,LastName,UserName,EmailId,Password,RegisterDate)values(?,?,?,?,?,?)";
		 
		LocalDate ld = LocalDate.now();
		DateTimeFormatter mydate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = ld.format(mydate);
		
		
		PreparedStatement ps=con.prepareStatement(Query);
		  ps.setString(1, fname);
		  ps.setString(2, lname);
		  ps.setString(3, Uname);
		  ps.setString(4, emailid);
		  ps.setString(5, pass);
		  ps.setString(6, formattedDate);
		  if(fname.isEmpty() || lname.isEmpty() || Uname.isEmpty() || 
		    		 emailid.isEmpty() || pass.isEmpty() ) 
		    {
			  System.out.println("fill all the fields...");
		    }
		  else 
		  {
	     int i=ps.executeUpdate();
		  
		if(i>0) 
		{
			 s= true;
		   
		    if(fname.isEmpty() || lname.isEmpty() || Uname.isEmpty() || 
		    		 emailid.isEmpty() || pass.isEmpty() ) 
		    {
		    	
			System.out.println("Successfully Not Registerd...fill all the fields..");
			}
		    else 
		    {
		    	
		    	System.out.println("successfully Registered ..");
		    }
			  
		}else
		{
			s= false;
			System.out.println("Not Registered");
		}
		  
		  
	}
		}
	catch(Exception e)
	{
		System.out.println(e);
	}

	return s;
	}
	
	
	
	
	@Override
	public boolean Login(RegistraionDto login) {
		boolean i = false ;
		 ResultSet rs = null;   
		 java.sql.Statement stmt = null; 
		try
		{ 
			Connection con = RegistrationDao.RegDao();
			String emailid= login.getEmailId();
			String pass = login.getPassword();
			
			String Query ="select * from Registration where EmailId='"+emailid+"'AND Password='"+pass+"'" ;
			
			stmt=con.createStatement();
			   
			rs = stmt.executeQuery(Query);	  
			
			 boolean more = rs.next();
			    
			 System.out.println("Your user name is " + emailid);          
		      System.out.println("Your password is " + pass);
		      System.out.println("Query: "+Query);
		      
			 if(!more) 
			 {
				 System.out.println("Sorry, you are not a registered user! Please Register first");
				 login.setValid(false);
			 }
			

				 else if (more) 
		         {
		            String firstName = rs.getString("FirstName");
		            String lastName = rs.getString("LastName");
			     	
		            System.out.println("Welcome " + firstName);
		            login.setFirstName(firstName);
		            login.setLastName(lastName);
		            login.setValid(true);
		         }
			 
		}
		catch(Exception e)
		{
				System.out.println(e);
			
		}
		
		return i;
	}
	
	
	
	
	
	
	@Override
	
		public void sendEmail(String from,String password,String to,String sub,String msg) {
	 
	        // sets SMTP server properties
		  Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465"); 
	 
	        // creates a new session with an authenticator
          Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
          {    
                  protected PasswordAuthentication getPasswordAuthentication()
                  {    
                  return new PasswordAuthentication(from,password);  
                  }    
           }
          );    
	 
          try {    
              MimeMessage message = new MimeMessage(session);    
              message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
              message.setSubject(sub);    
              message.setText(msg);    
              //send message  to user ..
              Transport.send(message);    
              System.out.println("Message Sent Successfully !!!......");    
             } catch (MessagingException e) {throw new RuntimeException(e);}  
              
   
	       
	 

	}
	
	
	
	
	@Override
	public boolean checkEmail(String email) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			RegistrationDao connection = new RegistrationDao();
			con = connection.RegDao();

			ps = con.prepareStatement("select * from Registration where EmailId=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {

				return true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				send("supriyakadak24@gmail.com", "SupriyaAkshata@243", email, "link",
						"http://localhost:8080/LoginRegistration/SetPassword.jsp");
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
	@Override
	public void send(String from, String password, String to, String sub, String msg) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	@Override
	public int setPassword(RegistraionDto user) 
	{
		int k = 0;
		RegistrationDao dao = new RegistrationDao();
		try {

		Connection con = dao.RegDao();

		String query = "select * from Registration where EmailId=?";

		String query1 = "update Registration set Password=? where EmailId=?";

		ResultSet rs = null;
		
		
			String email = user.getEmailId();
			String password = user.getPassword();

			PreparedStatement ps1 = con.prepareStatement(query);
			PreparedStatement ps = con.prepareStatement(query1);

			ps1.setString(1, email);

			//System.out.println("pass" + password);
			ps.setString(1, password);
			ps.setString(2, email);
			rs = ps1.executeQuery();


			if (rs.next()) {
				k = ps.executeUpdate();
				System.out.println();
				System.out.println("Password Updated...");

			}

		}
		catch (Exception e) 
		{
			System.out.println();
			System.out.println("password updation Failed....");
			e.printStackTrace();

		}

		
		return k;

		
	}
}
