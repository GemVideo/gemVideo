package controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import modelo.negocio.ArtistaGestion;
import modelo.negocio.VideoGestion;

@Controller
@SessionAttributes(names={"usuario"})
public class VideoController {

	@Autowired
	VideoGestion videoGestion;
	@Autowired
	ArtistaGestion artistaGestion;
	
	@RequestMapping("/home.do")
	public String obtenerVideos(Model model){
		
		//el usuario ya debe estar en sesión
		return "home";
	}
	
	@RequestMapping("/playVideo.do")
	public String playVideo(@RequestParam("idVideo")Integer idVideo, Model model){
		
		Video video = videoGestion.playVideo(idVideo);
		model.addAttribute("video", video); //lo añado para cogerlo desde el request en la vista
		
		return "playVideo";
	}
	

	//para actualizarla le añado el video a la playlist, sin tocar el usuario, que se
	//refresca en sesion al retornar a playVideo.jsp (con interceptor)
	@RequestMapping("/actualizarPlaylist.do")
	public String actualizarPlaylist(@RequestParam("idPlaylist")Integer idPlaylist,
			@RequestParam("idVideo")Integer idVideo, Model model){
		
		videoGestion.actualizarPlaylist(idPlaylist, idVideo);
		
		return "playVideo";
	}
	
	@PostMapping("/buscar.do")
	public String buscar(HttpServletRequest req,Model model){ //¿podria recibirse de otra forma?
		String busqueda = req.getParameter("busqueda");
		
		List<Video> videos = videoGestion.buscarVideos(busqueda);
		List<Artista> artistas = artistaGestion.buscarArtistas(busqueda);
		
		model.addAttribute("videosBuscados",videos);
		model.addAttribute("artistasBuscados", artistas);
		
		return "resultBusqueda";
	}
	
	
}
