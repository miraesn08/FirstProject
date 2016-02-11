package test;

import kr.co.miraesn08.firstproject.common.DBConnection;
import kr.co.miraesn08.firstproject.dao.PhoneBookDAO;
import kr.co.miraesn08.firstproject.dao.PhoneBookDAOImpl;

public class PhoneBookDAOTest {

	public static void main(String[] args) {
		String line = "===================================";
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();

		// db connection
		//System.out.println("url  : " + DBConnection.url);
		//System.out.println("user : " + DBConnection.user);
		//System.out.println("pwd  : " + DBConnection.password);
		System.out.println(line);
		
		// create
		//System.out.println("create : " + dao.create());
		System.out.println(line);
		
		// drop
		//System.out.println("drop : " + dao.drop());
		System.out.println(line);
	}

}
