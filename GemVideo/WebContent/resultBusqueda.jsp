<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, entidades.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="templates/head.jsp"%>
<body class="body">
	<div class="container">
		<%@ include file="templates/nav.jsp"%>
		<%@ include file="templates/usuario.jsp"%>
		<!-- resultBusqueda-->
		<div class="result">
			<div class="result-espacio">
				<h2>ARTISTAS</h2>
				<div class="result-espacio-content">
					<%
						List<Artista> artistas = (List<Artista>) request.getAttribute("artistasBuscados");
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
				<h2>VIDEOS</h2>
				<div class="result-espacio-content">
					<%
						List<Video> videos = (List<Video>) request.getAttribute("videosBuscados");
						if (videos != null) {
							for (Video v : videos) {
					%>

					<div class="item">
						<a href="playVideo.do?id=<%=v.getId()%>"> <img
							src="<%=v.getThumbnail()%>" alt="">
						</a> <span class="titulo"><%=v.getTitulo()%>/span> 
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

		<!-- resultBusqueda-->
	</div>
	<%@ include file="templates/copy.jsp"%>
	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>