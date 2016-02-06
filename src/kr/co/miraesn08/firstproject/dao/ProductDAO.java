package kr.co.miraesn08.firstproject.dao;

import java.util.List;

import kr.co.miraesn08.firstproject.dto.ProductDTO;

public interface ProductDAO {
	public ProductDTO add(ProductDTO dto);
	public ProductDTO get(int productId);
	public boolean set(ProductDTO dto);
	public boolean delete(int productId);
	
	public List<ProductDTO> listAll();
	public List<ProductDTO> listByName(String productName);
}
