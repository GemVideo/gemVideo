<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, entidades.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	
%>

<%@ include file="templates/head.jsp"%>

<body class="body">
	<div class="container">
		<%@ include file="templates/nav.jsp"%>
		<%@ inlcude file="templates/usuario.jsp"%>
		<!-- playVideo-->
		<div class="main">
			<%
				Usuario usuario = (Usuario) session.getAttribute("usuario");
				Video video = (Video) request.getAttribute("video");
			%>
			<div class="main-video">
				<iframe class="video"
					src="https://www.youtube.com/embed/<%=video.getUrl()%>">
				</iframe>
				
				<div class="detalleVideo">
					<div class="detalleVideo-up">
						<h2><%=video.getTitulo()%></h2>
						<div id="agregarVideo" class="agregarVideo">añade video</div>
						<div id="vista" class="contentAnadir isHide">
							<div class="playLists">
								<form  action="crearPlaylist.do" onsubmit="anadirEvento()"
									method="GET">
									<div class="fieldPlus">
										<i class="fa fa-plus fa-1x" aria-hidden="true"></i> <input
											type="text" placeholder="escribe nueva">
									</div>
								</form>
								<span>añadir a:</span>
								<ul id="playLists">
									<%
										for (PlayList pList : usuario.getPlayLists()) {
									%>
									<li><a href="actualizarPlayList.do?id=<%=pList.getId()%>&<%=video.getId()%>"><%=pList.getNombre()%></a></li>

									<%
										}
									%>
								</ul>
							</div>
						</div>
					</div>
					<p><%=video.getDescripcion()%></p>

				</div>
			</div>
			<div class="main-playList">
				<h3>Mis PlayList</h3>
				<div class="playLists">
					<ul id="playLists">
						<%
						for (PlayList pList : usuario.getPlayLists()) {
						%>
						<li><a href="playVideo.do"><%=pList.getNombre()%></a></li>

						<%
							}
						%>
					</ul>
				</div>
			</div>
		</div>


	</div>
	<%@ include file="templates/copy.jsp"%>
	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>