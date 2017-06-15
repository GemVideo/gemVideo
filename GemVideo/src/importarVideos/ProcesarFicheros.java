package importarVideos;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.ClientConfig;



public class ProcesarFicheros { 
	private Integer  numVideos; 
	private String channelId ;
	private String url ;
	
	public ProcesarFicheros(){
		numVideos=15;
		channelId = "UC2pmfLm7iq6Ov1UwYrWYkZA"; //VEVO
		
		this.url="https://www.googleapis.com/youtube/v3/activities?part=snippet&maxResults=" + this.numVideos + "&channelId=" + this.channelId + "&key=AIzaSyBnbMfQgqjMviCj-DaqXbLiKGoewb-5kZA";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcesarFicheros procesarFicheros= new ProcesarFicheros();
		procesarFicheros.importarDatos(13);

	}
	
	public  void importarDatos(int numVideos) {
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
		
		System.out.println( "finalizado 1" );
		
		HttpURLConnection conn0 = null;
		try {
			conn0 = (HttpURLConnection) new URL(this.url ).openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn0.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401");
		
		String regs = null;
		try {
			regs = new String( IOUtils.toByteArray( conn0.getInputStream() ) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		 JSONArray array = new JSONArray(jsonStr); 
//		 
//		 for(int i=0; i<array.length(); i++){
//		        JSONObject jsonObj  = array.getJSONObject(i);
//		        System.out.println(jsonObj.getString("No"));
//		        System.out.println(jsonObj.getString("Name"));
//		    }
//		 
		 
		System.out.println( "Los últimos 15 vídeos del canal <canal> " + regs );
		
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
		System.out.println("fin proceso de llamada");
		
	}
		
	
	
	private  URI getBaseURI() {  
	 //Construimos un Objeto URI(que representa una URL) con //dirección a nuestro proyecto       
		//this.url="https://www.googleapis.com/youtube/v3/activities?part=snippet&maxResults=" + this.numVideos + "&channelId=" + this.channelId + "VEVO&key=AIzaSyBnbMfQgqjMviCj-DaqXbLiKGoewb-5kZA";
		return UriBuilder.fromUri(this.url).build();
		//return UriBuilder.fromUri("https://randomuser.me/api/?results=" + this.numVideos).build();
	} 

}
