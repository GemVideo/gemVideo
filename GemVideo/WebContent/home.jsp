<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List, entidades.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<% %>

<%@ include file="templates/head.jsp"%>

<body class="body">
	<div class="container">
		<%@ include file="templates/nav.jsp"%> 
		<%@ inlcude file="templates/usuario.jsp" %>
		<div class="videos">
			<h2>Videos mas recomendados</h2>
			<div class="videos-lista">
			<%  List<Video> videosHome=request.getAttribute("videosHome");
				if(videosHome==null){
					out.print("<h1>no se encontro resultado de la buqueda</h1><br><h2>intenta de nuevo</h2>");
				}else{	%>
			<%for(Video p: videosHome){ %>			
				<div class="item">
					<a href="playVideo.do?id=<%=p.getId()   %>"> <img src="<%=p.getThumbnail() %>" alt=""></a>
					<div class="titulo">
						<h3><%= p.getTitulo()  %></h3>
					</div>
				</div>
				  <%}
			  } %>	
								
			</div>
		</div>
	</div>
	<%@ include file="templates/copy.jsp"%>
	<%@ include file="templates/linkLib.jsp"%>
</body>

</html>