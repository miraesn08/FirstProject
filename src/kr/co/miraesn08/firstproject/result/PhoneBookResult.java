package kr.co.miraesn08.firstproject.result;

import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookResult {
	private int errorCode;
	private String errorMessage;
	private PhoneBookDTO phoneBook;
	
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
	public PhoneBookDTO getPhoneBook() {
		return phoneBook;
	}
	public void setPhoneBook(PhoneBookDTO phoneBook) {
		this.phoneBook = phoneBook;
	}
	
	@Override
	public String toString() {
		return "PhoneBookResult [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", phoneBook=" + phoneBook
				+ "]";
	}
}
