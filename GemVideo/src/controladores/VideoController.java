package controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import entidades.Artista;
import entidades.Video;
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
		
		List<Video> videosHome = videoGestion.obtenerPeliculasHome();
		model.addAttribute("videosHome", videosHome);
		
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
	@RequestMapping( "/actualizarPlaylist.do")
	public String actualizarPlaylist(@RequestParam("idPlaylist")Integer idPlaylist,
			@RequestParam("idVideo")Integer idVideo, Model model){
		
		videoGestion.actualizarPlaylist(idPlaylist, idVideo);
		
		return "playVideo";
	}
	
	@RequestMapping("/buscar.do")
	public String buscar(@RequestParam("busqueda")String busqueda, Model model){		
		
		List<Video> videos = videoGestion.buscarVideos(busqueda);
		List<Artista> artistas = artistaGestion.buscarArtistas(busqueda);
		
		model.addAttribute("videosBuscados",videos);
		model.addAttribute("artistasBuscados", artistas);
		
		return "resultBusqueda";
	}
	
	
}
