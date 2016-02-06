package kr.co.miraesn08.firstproject.dto;

public class ProductDTO {

	private int productId;
	private String productCode;
	private String productName;
	private String productUnitName;
	
	public ProductDTO() {}
	public ProductDTO(int productId, String productCode, String productName, String productUnitName) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productUnitName = productUnitName;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUnitName() {
		return productUnitName;
	}
	public void setProductUnitName(String productUnitName) {
		this.productUnitName = productUnitName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName
				+ ", productUnitName=" + productUnitName + "]";
	}
	
}
