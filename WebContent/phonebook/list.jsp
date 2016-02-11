<%@page import="java.util.List"%>
<%@page import="kr.co.miraesn08.firstproject.dao.PhoneBookDAO"%>
<%@page import="kr.co.miraesn08.firstproject.dao.PhoneBookDAOImpl"%>
<%@page import="kr.co.miraesn08.firstproject.dto.PhoneBookDTO"%>
<%@page import="kr.co.miraesn08.firstproject.result.PhoneBookListResult"%>
<%@page import="kr.co.miraesn08.firstproject.common.DBError"%>
<%@ page language="java" contentType="application/json"
    pageEncoding="UTF-8"%>
<%@page import="com.google.gson.Gson"%>
<%
	PhoneBookListResult result = new PhoneBookListResult();

	try {
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookDTO> list = dao.getList();
		if (list != null) {
			result.setErrorCode(DBError.ERROR_CODE_OK);
			result.setErrorMessage("success");
			result.setPhoneBookList(list);
		} else {
			result.setErrorCode(DBError.ERROR_CODE_NO_DATA);
			result.setErrorMessage("자료가 없습니다.");
		}
	} catch(Exception e) {
		result.setErrorCode(DBError.ERROR_CODE_INVALID_PARAMETER);
		result.setErrorMessage("검색 값을 확인하세요.");
	}

	out.write( new Gson().toJson(result) );
%>