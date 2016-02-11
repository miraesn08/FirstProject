package test;

import java.util.List;

import kr.co.miraesn08.firstproject.common.DBConnection;
import kr.co.miraesn08.firstproject.dao.PhoneBookDAO;
import kr.co.miraesn08.firstproject.dao.PhoneBookDAOImpl;
import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookDAOTest {

	public static void main(String[] args) {
		String line = "===================================";
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		
		// db connection
		//System.out.println("url  : " + DBConnection.url);
		//System.out.println("user : " + DBConnection.user);
		//System.out.println("pwd  : " + DBConnection.password);
		//System.out.println(line);
		
		// create
		//System.out.println("create : " + dao.create());
		//System.out.println(line);
		
		// drop
		//System.out.println("drop : " + dao.drop());
		//System.out.println(line);
		
/*		
		PhoneBookDTO dto = new PhoneBookDTO();
		PhoneBookDTO getDto = null;
		int id = 0;
		
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
			getDto = dao.get(id);
			if (getDto != null) {
				System.out.println("get(" + id + "): " + true);
				System.out.println(getDto);
			} else {
				System.out.println("get(" + id + "): " + false);
			}
		}
		System.out.println(line);
		
		// update
		if (id > 0) {
			dto.setName("오월이");
			dto.setPhone("010-1111-2222");

			if (dao.update(dto)) {
				getDto = dao.get(id);
				if (getDto != null) {
					System.out.println("update(" + id + "): " + true);
					System.out.println(getDto);
				} else {
					System.out.println("update1(" + id + "): " + false);
				}
			} else {
				System.out.println("update2(" + id + "): " + false);
			}
		}
		System.out.println(line);

		// delete
		if (id > 0) {
			if (dao.delete(id)) {
				getDto = dao.get(id);
				if (getDto == null) {
					System.out.println("delete(" + id + "): " + true);
				} else {
					System.out.println("delete1(" + id + "): " + false);
				}
			} else {
				System.out.println("delete2(" + id + "): " + false);
			}
		}
		System.out.println(line);
*/
		// getList
		System.out.println("getList : ");
		List<PhoneBookDTO> list;
		list = dao.getList();
		for (PhoneBookDTO item : list) {
			System.out.println(item);
		}
		System.out.println(line);
		
	}

}
