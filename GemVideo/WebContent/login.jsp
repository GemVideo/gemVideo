<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="templates/head.jsp"%>

<body>
	<div class="content">
		<video class="content-bodyVideo" autoplay loop>
			<source src="videos/concert.mp4" type="video/mp4">
		</video>

		<%@ include file="templates/nav.jsp"%>

		<div class="content-header">
			<h2>Login</h2>
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
					<form:password path="password" placeholder="contraseña" require />
					<br>
				</div>

				<input type="submit" value="Entrar">
			</form:form>

			<div class="registro">
				<a href="registro.do">Registrate en gemVideo</a>
			</div>
		</div>
		<div class="text">
			<p>Reproduce tu vida en una PlayList</p>
		</div>
		<%@ include file="templates/copy.jsp"%>
	</div>

	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>