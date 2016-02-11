package kr.co.miraesn08.firstproject.result;

import java.util.List;

import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookListResult {
	private int errorCode;
	private String errorMessage;
	private List<PhoneBookDTO> phoneBookList;
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<PhoneBookDTO> getPhoneBookList() {
		return phoneBookList;
	}
	public void setPhoneBookList(List<PhoneBookDTO> phoneBookList) {
		this.phoneBookList = phoneBookList;
	}
	
	@Override
	public String toString() {
		return "PhoneBookListResult [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", phoneBookList="
				+ phoneBookList + "]";
	}
}
