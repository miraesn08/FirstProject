package kr.co.miraesn08.firstproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.co.miraesn08.firstproject.common.DBUtil;
import kr.co.miraesn08.firstproject.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public boolean add(ProductDTO dto) {
		boolean returnValue = false;

		DBUtil db = DBUtil.getInstance();
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConnection(true);
			
			String sql = "insert into products values (products_seq.nextval,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getProductCode());
			ps.setString(2, dto.getProductName());
			ps.setString(3, dto.getProductUnitName());
			
			returnValue = (ps.executeUpdate() == 1);
			
			sql = "select products_seq.CURRVAL from dual";
			ps2 = conn.prepareStatement(sql);
			rs = ps2.executeQuery();
			rs.next();
			int id = rs.getInt(1);
			dto.setProductId(id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			db.close(conn, ps);
		}
		
		return returnValue;
	}

	@Override
	public ProductDTO get(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean set(ProductDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductDTO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> listByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
