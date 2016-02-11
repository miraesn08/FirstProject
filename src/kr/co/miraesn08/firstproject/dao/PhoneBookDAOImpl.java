package kr.co.miraesn08.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import kr.co.miraesn08.firstproject.common.DBUtil;
import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookDAOImpl implements PhoneBookDAO {

	@Override
	public boolean add(PhoneBookDTO phoneBook) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PhoneBookDTO phoneBook) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PhoneBookDTO get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneBookDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneBookDTO> getListByField(String fieldName, String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneBookDTO> getListByName(String searchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create() {
		boolean returnValue = false;

		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = db.getConnection(); 
			String sql = "create table phonebooks("
						+ " id int identity(1,1)"
						+ ",name nvarchar(20)"
						+ ",phone nvarchar(50)"
						+ ",reg_date datetime"
						+ ")";
			stmt = conn.createStatement();
			stmt.execute(sql);
			returnValue = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, stmt);
		}
		
		return returnValue;
	}

	@Override
	public boolean drop() {
		boolean returnValue = false;

		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = db.getConnection(); 
			String sql = "drop table phonebooks";
			stmt = conn.createStatement();
			stmt.execute(sql);
			returnValue = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, stmt);
		}
		
		return returnValue;
	}

}
