package kr.co.miraesn08.firstproject.dto;

public class PhoneBookDTO {
	private int id;
	private String name;
	private String phone;
	private String regDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "PhoneBookDTO [id=" + id + ", name=" + name + ", phone=" + phone + ", regDate=" + regDate + "]";
	}
}
