package Service;

import Dao.RegistrationDao;
import Dto.RegistraionDto;

public interface ILoginRegistration {
	
	public  boolean Registration(String fname, String lname,String Uname,String emailid,String pass) ;
	public boolean registration(RegistraionDto user);
	public boolean Login (RegistraionDto login);
	public void sendEmail(String from,String password,String to,String sub,String msg);
	public boolean checkEmail(String email);
	public void send(String from, String password, String to, String sub, String msg) ;
	public int setPassword(RegistraionDto user);


}
