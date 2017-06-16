<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="usuario">
	<div class="usuario-content">
		<span>
		<%Usuario usuario=session.getAttribute("usuario");
		out.print(usuario.getNonmbre());%>
		</span><br> <a href="obtenerPerdil.do">perfil</a>| <a
			class="logout" href="logout.do">Logout</a>
	</div>
</div>