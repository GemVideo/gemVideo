package importarVideos;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Artista;
import entidades.Video;
import modelo.negocio.ArtistaGestion;
import modelo.negocio.VideoGestion;


@Service
public class ProcesarFicheros { 
	private Integer  numVideos;
	private Integer  numFechas; 
	//private String channelId ;
	private String url ;
	private String after;
	private String before;
	
	public Integer getNumVideos() {
		return numVideos;
	}
	public void setNumVideos(Integer numVideos) {
		this.numVideos = numVideos;
	}
	public Integer getNumFechas() {
		return numFechas;
	}
	public void setNumFechas(Integer numFechas) {
		this.numFechas = numFechas;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAfter() {
		return after;
	}
	public void setAfter(String after) {
		this.after = after;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public ArtistaGestion getArtistaGestion() {
		return artistaGestion;
	}
	public void setArtistaGestion(ArtistaGestion artistaGestion) {
		this.artistaGestion = artistaGestion;
	}
	public VideoGestion getVideoGestion() {
		return videoGestion;
	}
	public void setVideoGestion(VideoGestion videoGestion) {
		this.videoGestion = videoGestion;
	}
	public String getKeyApiYouTube() {
		return keyApiYouTube;
	}
	public void setKeyApiYouTube(String keyApiYouTube) {
		this.keyApiYouTube = keyApiYouTube;
	}
	public String getKeyApiLastFm() {
		return keyApiLastFm;
	}
	public void setKeyApiLastFm(String keyApiLastFm) {
		this.keyApiLastFm = keyApiLastFm;
	}



	@Autowired
	ArtistaGestion  artistaGestion;
	@Autowired
	VideoGestion  videoGestion;
	
	private String keyApiYouTube ;
	private String keyApiLastFm ;
	
	
	public ProcesarFicheros(){
	
	}
	
//	public ProcesarFicheros(){
//		this.numVideos=40;
//		this.numFechas=1;
//		
//		this.keyApiYouTube ="AIzaSyCjcuqTbqoDs7PMRz9AB3v--LJNWkIzGdM";
//		this.keyApiLastFm ="1e7628d355341dccc256c1c7b60cd480";
//		
//	
//	}
//	public void robar() {
//		// TODO Auto-generated method stub
//		
//		ProcesarFicheros procesarFicheros= new ProcesarFicheros();
//		
//		procesarFicheros.procesarVideos();
//		
//		//procesarFicheros.procesarArtistas("Elvis Presley");
//		
//
//	}
	
	
	public ResultadosArtista procesarArtistas(String nombreArtista){
		
		//Si el nombretrase blancos, se reemplazan.
		nombreArtista=nombreArtista.trim();
		nombreArtista=nombreArtista.replace(" ","%20");
		nombreArtista=nombreArtista.replace("\"","");
		
		
		
		this.url="http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + nombreArtista + "&lang=ES&api_key=" + this.keyApiLastFm + "&format=json";
		
		
		ClientConfig config = new ClientConfig();
		
		//Creamos el cliente rest con la clase ClientBuilder pasandole la config por defecto al metodo new Client 
		Client client = ClientBuilder.newClient(config);
		
		// Creamos el objeto que representa el servicio al que vamos a hacer las solicitudes
		WebTarget target = client.target(getBaseURI());   
		
		//getBaseURI es un método propio que hemos definido más abajo y nos devuelve la url a nuestros servicios.
		//para realizar la solicitud: 
		ResultadosArtista response = target.path("").//indicamos el PATH 
							request().// Creamos el request al path definido (devuelve un constructor (builder) de requests)                             accept(MediaType.TEXT_HTML).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional) get(Response.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuesta
							accept(MediaType.APPLICATION_JSON).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional)
							get(ResultadosArtista.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuesta
		
		
		System.out.println( "finalizado llamar artista." );
		System.out.println( "url: " + this.url );
//		if (response!=null) {
//			System.out.println("getArtist().getName                           : " +  response.getArtist().getName());
//			System.out.println("getArtist().getImage().size                   : " +  response.getArtist().getImage().size());
//			System.out.println("getArtist().getImage.get(3).getText           : " +  response.getArtist().getImage().get(3).getText());
//			System.out.println("response.getArtist().getImage().get(3).getSize: " +  response.getArtist().getImage().get(3).getSize());
//		}
		System.out.println("");
		System.out.println("fin proceso de llamada artista");
		return response;
		
	}
	
	
	public void procesarVideos(){
		
		this.numVideos=50;
		this.numFechas=10;
		
		this.keyApiYouTube ="AIzaSyCjcuqTbqoDs7PMRz9AB3v--LJNWkIzGdM";
		this.keyApiLastFm ="1e7628d355341dccc256c1c7b60cd480";
		
		ArrayList<Resultados> resultadosAll= new ArrayList();
		Resultados cancionesFinales= new Resultados ();
		ArrayList<Videos> videosFinales= new ArrayList();
		Resultados resultados;
		ResultadosArtista artistaOk=null; 
		
		Fechas fechas=new Fechas(numFechas);
		resultados=new Resultados();
		LocalDate day= LocalDate.now();
		while(day.getYear()!=2014){
			
			String after=day.minusWeeks(1).toString();
			String before=day.minusWeeks(4).toString();
			this.url="https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=" + numVideos + "&order=rating&publishedAfter=" + after + "T00%3A00%3A00Z&publishedBefore=" + before + "T00%3A00%3A00Z&q=VEVO+(OFFICIAL%2BVIDEO)&fields=items(id%2FvideoId%2Csnippet(description%2Cthumbnails%2Ctitle))&key=" + this.keyApiYouTube;
			day= day.minusWeeks(4);
			System.out.println("url: " + url);
			resultados = procesarVideosImportarDatos(numVideos);
			resultadosAll.add(resultados);
	
		}
		System.out.println("****************************************************************");
		System.out.println("toltal videos:"+resultadosAll.size());
		System.out.println("****************************************************************");
		String artista="";
		boolean videoProcesado=false;
		for (Resultados r : resultadosAll) {
				for (Videos item : r.getItems()) {
					videoProcesado=false;
					String titulo =  item.getSnippet().getTitle();
					
					 if (titulo.indexOf( "-" )>0) {
						String[] autores= item.getSnippet().getTitle().split("-");
						if (autores.length>0){
							String[] artistasVideo= autores[0].split(",");
							if(artistasVideo.length==0)
								artistasVideo[0]=autores[0];
							for (int contArtista=0;contArtista<artistasVideo.length;contArtista++){
								  artista=artistasVideo[contArtista];
									artistaOk=procesarArtistas(artista);
									
									if (artistaOk.getArtist()!=null){	 
										 if (artistaOk.getArtist().getImage().get(3).getText()!=""){
											//Procesar artista.
											 procesarArtista(item,artistaOk);
											 }
									 }
								}
						}
					 }		
					
					
				}
			}
				
	}
		

	
	
	public void procesarArtista(Videos video,ResultadosArtista artista){
		Video videoNuevo= new Video();
		Video videoCreado= new Video(); 
		
		Artista artistaNuevo=new Artista();
		
		
		
		//public Video( String titulo, String descripcion, String thumbnail, String url) {
		
		videoNuevo.setTitulo(video.getSnippet().getTitle());
		videoNuevo.setDescripcion(video.getSnippet().getDescription());
		videoNuevo.setUrl(video.getId().getVideoId());
		videoNuevo.setThumbnail(video.getSnippet().getThumbnails().get(0).getHigh().getUrl());
		
		
		List<Video> existeVideo = new ArrayList();
		//grabar video
		String titulo=videoNuevo.getTitulo();
		videoCreado=videoGestion.registro(videoNuevo);
		
		//grabar artista.
				
			artistaNuevo.setNombre(artista.getArtist().getName());
			artistaNuevo.setImagen(artista.getArtist().getImage().get(3).getText());
			List<Artista> artistaActual=artistaGestion.buscarArtista(artistaNuevo);
			
			List<Video> videos = new ArrayList();
			if (artistaActual.size() == 0){
				videos.add(videoCreado);
				artistaNuevo.setListaVideos(videos);
				artistaGestion.registro(artistaNuevo);
			}
			else{
				artistaNuevo=artistaActual.get(0);
				videos=artistaNuevo.getListaVideos();
				videos.add(videoCreado);
				artistaNuevo.setListaVideos(videos);
				artistaGestion.actualiza(artistaNuevo);
			}
		
		
	}
	public  Resultados procesarVideosImportarDatos(int numVideos) {
		this.numVideos=numVideos;
		
		//Creamos la configuracion (por defecto) 
		ClientConfig config = new ClientConfig();
		
		//Creamos el cliente rest con la clase ClientBuilder pasandole la config por defecto al metodo new Client 
		Client client = ClientBuilder.newClient(config);
		
		// Creamos el objeto que representa el servicio al que vamos a hacer las solicitudes
		WebTarget target = client.target(getBaseURI());   
		
		//getBaseURI es un método propio que hemos definido más abajo y nos devuelve la url a nuestros servicios.
		//para realizar la solicitud: 
		Resultados response = target.path("").//indicamos el PATH 
							request().// Creamos el request al path definido (devuelve un constructor (builder) de requests)                             accept(MediaType.TEXT_HTML).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional) get(Response.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuesta
							accept(MediaType.APPLICATION_JSON).// Al builder le indicamos el tipo de la respuesta que aceptamos(opcional)
							get(Resultados.class);//al builder le decimos que construya un get request y le indicamos en que tipo de objeto queremos que nos empaquete la respuesta
		
//		System.out.println( "finalizado 1" );
//		
//		System.out.println("eeee " +  response.getItems().size());
//		System.out.println("");
//		System.out.println("fin proceso de llamada");
		return response;
		
		
//		HttpURLConnection conn0 = null;
//		try {
//			conn0 = (HttpURLConnection) new URL(this.url ).openConnection();
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		conn0.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
//		
//		String regs = null;
//		try {
//			regs = new String( IOUtils.toByteArray( conn0.getInputStream() ) );
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		 JSONArray array = new JSONArray(jsonStr); 
//		 
//		 for(int i=0; i<array.length(); i++){
//		        JSONObject jsonObj  = array.getJSONObject(i);
//		        System.out.println(jsonObj.getString("No"));
//		        System.out.println(jsonObj.getString("Name"));
//		    }
//		 
		 
		//System.out.println( "Los últimos 15 vídeos del canal <canal> " + regs );
		
//		
//		if (resetUsuarios()){
//			 for (Usuario item:response.getResults()){
//				 crearUsuario(item);
//				 //System.out.println(item.getName().getTitle() + " " + item.getName().getFirst()  + " " + item.getName().getLast());
//			 }
//			 System.out.println("Importados " + response.getResults().size() + " elementos.");
//		}
//		 else
//			 System.out.println("error borrando");
//		
//		 
//		 
//		 List <Usuario> usuarios= recuperarUsuarios();
//		 
//		 System.out.println("registros: " + usuarios.size());
		
		
	}
		
	
	
	private  URI getBaseURI() {  
	 //Construimos un Objeto URI(que representa una URL) con //dirección a nuestro proyecto       
		//this.url="https://www.googleapis.com/youtube/v3/activities?part=snippet&maxResults=" + this.numVideos + "&channelId=" + this.channelId + "VEVO&key=AIzaSyBnbMfQgqjMviCj-DaqXbLiKGoewb-5kZA";
		return UriBuilder.fromUri(this.url).build();
		//return UriBuilder.fromUri("https://randomuser.me/api/?results=" + this.numVideos).build();
	} 

}
