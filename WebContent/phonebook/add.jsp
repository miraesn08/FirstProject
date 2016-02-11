<%@page import="kr.co.miraesn08.firstproject.dao.PhoneBookDAO"%>
<%@page import="kr.co.miraesn08.firstproject.dao.PhoneBookDAOImpl"%>
<%@page import="kr.co.miraesn08.firstproject.dto.PhoneBookDTO"%>
<%@page import="kr.co.miraesn08.firstproject.result.PhoneBookResult"%>
<%@page import="kr.co.miraesn08.firstproject.common.DBError"%>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%@page import="com.google.gson.Gson"%>
<%
	PhoneBookResult result = new PhoneBookResult();

	try {
		result.setErrorCode(DBError.ERROR_CODE_NO_DATA);
		result.setErrorMessage("자료가 없습니다.");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		if (name != null && name.length() >0 ) {
			if (phone != null && phone.length() > 0) {
				PhoneBookDAO dao = new PhoneBookDAOImpl();
				PhoneBookDTO dto = new PhoneBookDTO();
				
				dto.setName(name);
				dto.setPhone(phone);
				
				if (dao.add(dto)) {
					result.setErrorCode(DBError.ERROR_CODE_OK);
					result.setErrorMessage("자료를 등록했습니다.");
					result.setPhoneBook(dto);
				}
			}
		}
	} catch(Exception e) {
		result.setErrorCode(DBError.ERROR_CODE_INVALID_PARAMETER);
		result.setErrorMessage("입력 값을 확인하세요.");
	}

	out.write( new Gson().toJson(result) );
%>