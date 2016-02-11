package test;

import kr.co.miraesn08.firstproject.common.DBConnection;
import kr.co.miraesn08.firstproject.dao.PhoneBookDAO;
import kr.co.miraesn08.firstproject.dao.PhoneBookDAOImpl;
import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookDAOTest {

	public static void main(String[] args) {
		String line = "===================================";
		
		PhoneBookDTO dto = new PhoneBookDTO();
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		int id = 0;
		
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
		
		// add
		dto.setName("향단이");
		dto.setPhone("010-8765-4321");
		if (dao.add(dto)) {
			System.out.println("add : " + true);
			System.out.println(dto);
			id = dto.getId();
		} else {
			System.out.println("add : " + false);
		}
		System.out.println(line);
		
		// get
		if (id > 0) {
			PhoneBookDTO getDto = null;
			getDto = dao.get(id);
			if (getDto != null) {
				System.out.println("get(" + id + "): " + true);
				System.out.println(getDto);
			} else {
				System.out.println("get(" + id + "): " + false);
			}
		}
		System.out.println(line);
	}

}
