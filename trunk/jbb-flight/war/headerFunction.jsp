<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
Date connexionDate = new Date(request.getSession().getCreationTime() );
SimpleDateFormat sdf = new SimpleDateFormat("hh:mm dd/MM/yyyy");
String connexionTime = sdf.format(connexionDate);
%>
<br/>
<p style="margin-left: 20%;"> Connected since :  <%=connexionTime %> </p>
<% %>