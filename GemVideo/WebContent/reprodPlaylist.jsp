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
		<%@ include file="templates/usuario.jsp"%>
		<!-- playVideo-->
		<div class="main">
			<%
			 PlayList plista=(PlayList)request.getAttribute("playlist");
			
				Video video = plista.getListaVideos().get(0);
			%>
			<div class="main-video">
				<iframe class="iframe"
					src="https://www.youtube.com/embed/<%=video.getUrl()%>"> </iframe>

				<div class="detalleVideo">
					<div class="detalleVideo-up">
						<h3><%=video.getTitulo()%></h3>
						<div id="play1" class="agregarVideo">play</div>
						<div id="play2" class="agregarVideo">aleatorio</div>

					</div>
					<p><%=video.getDescripcion()%></p>

				</div>

				<div class="main-playList">
					<h3>Mis PlayList</h3>
					<div class="playLists">
						<ul id="playLists" id="playLists">
							<%
								for (PlayList pList : usuario.getPlayLists()) {
							%>
							<li><i class="fa fa-th-list fa-1x" aria-hidden="true"></i><%=pList.getNombre()%></li>

							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="gabiPlay">
		
		<%for(Video v :plista.getListaVideos()){%>
			
		
			<div class="main2">
				<div class="main-video2">
					<img src="<%=v.getThumbnail() %>" alt="">
				</div>
				<div class="caja">
					<h3>Título:</h3>
					<%=v.getTitulo() %><br>
					<h3>Descripción:</h3>
					<span class="desc"><%=v.getDescripcion() %></span>
				</div>
			</div>
			<%} %>
		</div>
		<!-- playVideo-->
	</div>
	<script>
		$(document)
				.ready(
						function() {

							//https://www.youtube.com/embed/dpuIuJYfPi0?autoplay=1&loop=1&playlist=X0Y61bu0TKw,Vn6N184C2aQ,TPMEviaFWLg
									<%String codigoVideo="";
									for(Video v :plista.getListaVideos()){
										codigoVideo+=v.getId()+",";
									}
									String lista=codigoVideo.substring(0,codigoVideo.length()-1);
									%>
							$listaPlay="<% out.print(lista);%>";
							arrayVideos = [ 'dpuIuJYfPi0', 'Vn6N184C2aQ','TPMEviaFWLg' ];
							$urlInicial = "https://www.youtube.com/embed/";
							$primerVideo = "dpuIuJYfPi0";
							$configVideo = "?autoplay=1&loop=1&playlist=";
							$listaVideos = "X0Y61bu0TKw,Vn6N184C2aQ,TPMEviaFWLg";
							$('#play1')
									.click(
											function() {
												$('.iframe')
														.attr(
																"src",
																"https://www.youtube.com/embed/dpuIuJYfPi0?autoplay=1&loop=1&playlist="+$listaPlay);
											});
							$('#play2').click(
									function() {
										$('.iframe').attr("src",
												listaDesordenada(arrayVideos));

									});

							function listaDesordenada(arrayVideos) {
								return arrayVideos = arrayVideos
										.sort(function() {
											return Math.random() - 0.5
										});

								// return $urlInicial + $primerVideo + $configVideo + $listaVideos;

							}

						});
	</script>
	<%@ include file="templates/copy.jsp"%>
	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>