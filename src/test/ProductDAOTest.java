package test;

import kr.co.miraesn08.firstproject.dao.ProductDAO;
import kr.co.miraesn08.firstproject.dao.ProductDAOImpl;
import kr.co.miraesn08.firstproject.dto.ProductDTO;

public class ProductDAOTest {

	public static void main(String[] args) {
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAOImpl();

		// add
		dto.setProductCode("testCode");
		dto.setProductName("testName");
		dto.setProductUnitName("testUnitName");
		dao.add(dto);
		System.out.println(dto);
	}

}
