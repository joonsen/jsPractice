<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String findStr = request.getParameter("findStr");
	Connection conn = new DBConn("classicmodels").getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	JSONArray jsonArray = new JSONArray();
	String sql = "select e.employeeNumber, e.lastName, o.phone, e.email from employees e join offices o on e.officeCode = o.officeCode where e.employeeNumber like ? or e.lastName like ?";
	ps = conn.prepareStatement(sql);
	ps.setString(1, "%" + findStr + "%");
	ps.setString(2, "%" + findStr + "%");
	
	rs = ps.executeQuery();
	while(rs.next()){
		JSONObject obj = new JSONObject();
		obj.put("employeeNumber", rs.getString("employeeNumber"));
		obj.put("lastName", rs.getString("lastName"));
		obj.put("phone", rs.getString("phone"));
		obj.put("email", rs.getString("email"));
		
		jsonArray.add(obj);
	}
	out.print(jsonArray.toJSONString());


%>






