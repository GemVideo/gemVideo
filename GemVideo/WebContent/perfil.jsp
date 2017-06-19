<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, entidades.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="templates/head.jsp"%>
<body class="body">
	<div class="container">
		<%@ include file="templates/nav.jsp"%>
		<%@ include file="templates/usuario.jsp"%>

		<!-- perfil-->
		<div class="result">
			
			<div class="result-usuario">
				<i class="fa fa-android fa-2x" aria-hidden="true"></i>
				<div class="datos">
					<h4>Datos del usuario</h4>
					<span><%=usuario.getNombre()%></span>
				</div>
			</div>
			<div class="result-espacio">
				<h2>LISTA DE ARTISTAS FAVORITOS</h2>
				<div class="result-espacio-content">
					<%
						List<Artista> artistas = usuario.getArtistasFavoritos();
						if (artistas != null) {
							for (Artista a : artistas) {
					%>
					<div class="itemArtista">
						<a href="mostrarArtista.do?id=<%=a.getId()%>"> <img
							src="<%=a.getImagen()%>" alt="">
						</a> <span><%=a.getNombre()%></span>
					</div>

					<%
						}
						} else {
							out.print("<h2>NO SE ENCOTRARON ARTISTAS</h2>");
						}
					%>
				</div>
			</div>
			<div class="result-espacio">
				<h2>LISTA DE PLAYLIST</h2>
				<div class="result-espacio-content">
					<%
						List<PlayList> playList = (List<PlayList>) usuario.getPlayLists();
						if (playList != null) {
							for (PlayList p : playList) {
					%>
					<div class="item">
						<a href="reprodPlaylist.do?id=<%=p.getId()%>"> 
						<img src="<%=p.getThumbnail()%>" alt="">
						</a> 
						<span class="titulo"><%=p.getNombre()%></span> 
					</div>

					<%
						}
						} else {
							out.print("<h2>NO SE ENCOTRARON VIDEOS</h2>");
						}
					%>
				</div>
			</div>
		</div>

		<!-- perfil-->
	</div>
	<%@ include file="templates/copy.jsp"%>
	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>