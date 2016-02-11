package kr.co.miraesn08.firstproject.result;

import kr.co.miraesn08.firstproject.dto.PhoneBookDTO;

public class PhoneBookResult {
	private int errorCode;
	private String errorMessage;
	private PhoneBookDTO dto;
	
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
		return dto;
	}
	public void setPhoneBook(PhoneBookDTO dto) {
		this.dto = dto;
	}
	
	@Override
	public String toString() {
		return "PhoneBookResult [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", phoneBook=" + dto
				+ "]";
	}
}
