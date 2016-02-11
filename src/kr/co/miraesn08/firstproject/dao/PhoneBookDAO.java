package kr.co.miraesn08.firstproject.dao;

import java.util.List;

import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public interface PhoneBookDAO {
	public boolean add(PhoneBookDTO phoneBook);
	public boolean update(PhoneBookDTO phoneBook);
	public boolean delete(int id);
	public PhoneBookDTO get(int id);
	
	public List<PhoneBookDTO> getList();
	public List<PhoneBookDTO> getListByName(String searchName);
	public List<PhoneBookDTO> getListByField(String fieldName, String searchValue);
	
	public boolean create();
	public boolean drop();
}
