<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="content-nav">
	<div class="logo">
		<a href="login.do">gemVideo</a>
	</div>
	<% 
	if(session.getAttribute("usuario")!=null)	{%>
		<%@include file="busqueda.jsp"%>
	<%} %>
	<div class="social">
		<i class="fa fa-instagram fa-2x" aria-hidden="true"></i><i
			class="fa fa-twitter-square fa-2x" aria-hidden="true"></i> <i
			class="fa fa-facebook-square fa-2x" aria-hidden="true"></i>
	</div>
</div>