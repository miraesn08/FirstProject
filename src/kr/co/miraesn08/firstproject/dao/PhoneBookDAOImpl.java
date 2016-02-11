package kr.co.miraesn08.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.miraesn08.firstproject.common.DBUtil;
import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookDAOImpl implements PhoneBookDAO {

	@Override
	public boolean add(PhoneBookDTO phoneBook) {
		boolean returnValue = false;

		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			
			String sql = "insert into phonebooks(name,phone,reg_date) values (?,?,getdate())";
			ps = conn.prepareStatement(sql);
			ps.setString(1, phoneBook.getName());
			ps.setString(2, phoneBook.getPhone());
			
			returnValue = (ps.executeUpdate() == 1);
			
			if (returnValue) {
				sql = "select top 1 id,reg_date from phonebooks where name=? and phone=? order by id desc";
				ps2 = conn.prepareStatement(sql);
				ps2.setString(1, phoneBook.getName());
				ps2.setString(2, phoneBook.getPhone());
				rs = ps2.executeQuery();
				rs.next();
				phoneBook.setId(rs.getInt(1));
				phoneBook.setRegDate(rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps2 != null) ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			db.close(conn, ps);
		}
		
		return returnValue;
	}

	@Override
	public boolean update(PhoneBookDTO dto) {
		boolean returnValue = false;

		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = db.getConnection();
			String sql = "update phonebooks set name=?,phone=? where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getPhone());
			ps.setInt(3, dto.getId());
			returnValue = (ps.executeUpdate() > 0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		
		return returnValue;
	}

	@Override
	public boolean delete(int id) {
		boolean returnValue = false;
		
		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = db.getConnection(); 
			String sql = "delete from phonebooks where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			returnValue = (ps.executeUpdate() > 0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps);
		}
		
		return returnValue;
	}

	@Override
	public PhoneBookDTO get(int id) {
		PhoneBookDTO dto = null;

		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String sql = "select id,name,phone,reg_date from phonebooks where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				dto = new PhoneBookDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setRegDate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps, rs);
		}

		return dto;
	}

	@Override
	public List<PhoneBookDTO> getList() {
		List<PhoneBookDTO> dtoList = new ArrayList<PhoneBookDTO>();
		
		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			String sql = "select id,name,phone,reg_date"
					+ " from phonebooks"
					+ " order by id";
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				PhoneBookDTO dto = new PhoneBookDTO();
				
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setRegDate(rs.getString(4));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, ps, rs);
		}
		
		return dtoList;
	}

	@Override
	public List<PhoneBookDTO> getListByName(String searchName) {
		List<PhoneBookDTO> dtoList = new ArrayList<PhoneBookDTO>();
		
		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection();
			String sql = "select id,name,phone,reg_date"
					+ " from phonebooks" 
					+ " where name like '%" + searchName + "%'" 
					+ " order by id";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PhoneBookDTO dto = new PhoneBookDTO();
				
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setRegDate(rs.getString(4));
				
				dtoList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(conn, stmt, rs);
		}
		
		return dtoList;
	}

	@Override
	public List<PhoneBookDTO> getListByField(String fieldName, String searchValue) {
		List<PhoneBookDTO> dtoList = new ArrayList<PhoneBookDTO>();
		
		if (fieldName.length() > 0 && searchValue.length() > 0) {
			DBUtil db = DBUtil.getInstance();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = db.getConnection();
				String sql = "select id,name,phone,reg_date"
						+ " from phonebooks" 
						+ " where " + fieldName + " like '%" + searchValue + "%'" 
						+ " order by id";
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					PhoneBookDTO dto = new PhoneBookDTO();
					
					dto.setId(rs.getInt(1));
					dto.setName(rs.getString(2));
					dto.setPhone(rs.getString(3));
					dto.setRegDate(rs.getString(4));
					
					dtoList.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.close(conn, stmt, rs);
			}
		}
		
		return dtoList;
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
