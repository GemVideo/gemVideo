<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, entidades.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="templates/head.jsp"%>

<body class="body">
	<div class="container">
		<%@ include file="templates/nav.jsp"%>
		<%@ include file="templates/usuario.jsp"%>
		<!-- mostrarArtista-->
		  <div class="artistaContent">
		  <% 
		  	Artista artista=(Artista)request.getAttribute("artista");%>
            <div class="artistaContent-artista">
                <h3>ARTISTA</h3>
                <div class="artista">
                <%if(artista.getImagen()==null){%>
                	<img src="images/users.png" alt="">
               <%}else{ %>
                        <img src="<%=artista.getImagen() %>" alt="">
                        <%} %>
                    <a class="favorito" href="actualizarArtistaFavorito.do?id=<%=artista.getId()%>">
                    <%if(usuario.getArtistasFavoritos().contains(artista)){%>
                    	<i class="fa fa-heart fa-2x colorFavorito" aria-hidden="true"></i>
                    	<%                    	
                    	}else{%>
                    <i class="fa fa-heart fa-2x" aria-hidden="true"></i>
                    <%} %>
                    </a>

                    <span><%=artista.getNombre() %></span>
                </div>
            </div>
            <div class="artistaContent-videos">
                <h3>VIDEOS</h3>
                <div class="videosArtista">
                <%for(Video v:artista.getListaVideos()){ %>
                    <div class="videosArtista-video">
                        <a href="playVideo.do?id=<%=v.getId()%>">
                           <img src="<%=v.getThumbnail() %>" alt="">
                        </a>
                        <span><%=v.getTitulo() %></span>
                    </div>
                    <%} %>
                </div>
            </div>
        </div>
		
		<!-- mostrarArtista-->
	</div>
	<%@ include file="templates/copy.jsp"%>
	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>