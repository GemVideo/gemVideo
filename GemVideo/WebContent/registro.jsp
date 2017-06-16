<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="templates/head.jsp"%>

<body>
	<div class="content">
		<img class="content-bodyVideo filter1" src="images/imagen1.jpeg"
			alt="">

		<%@ include file="templates/nav.jsp"%>

		<div class="content-header">
			<h2>Registro de usuario</h2>
			<form:form modalAttribute="usuario">
				<div class="field">
					<i class="fa fa-hand-o-right fa-2x" aria-hidden="true"></i>
					<form:errors path="nombre" />
					<form:input path="nombre" placeholder="contraseña" require />
					<br>
				</div>
				<div class="field">
					<i class="fa fa-key fa-2x" aria-hidden="true"></i>
					<form:errors path="password" />
					<form:input path="password" placeholder="contraseña" require />
					<br>
				</div>
				<input class="btnRegistro" type="submit" value="REGISTRAR">
			</form:form>

		</div>
		<%@ include file="templates/copy.jsp"%>
	</div>

	<%@ include file="templates/linkLib.jsp"%>
</body>