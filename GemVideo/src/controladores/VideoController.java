package controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import entidades.Artista;
import entidades.PlayList;
import entidades.Video;
import modelo.negocio.ArtistaGestion;
import modelo.negocio.VideoGestion;

@Controller
@SessionAttributes(names={"usuario","videosHome","video"})
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
	public String playVideo(@RequestParam("id")Integer idVideo, Model model){
		
		Video video = videoGestion.playVideo(idVideo);
		model.addAttribute("video", video); //lo añado para cogerlo desde el request en la vista
		
		return "videoPlay";
	}

	//para actualizarla le añado el video a la playlist, sin tocar el usuario, que se
	//refresca en sesion al retornar a playVideo.jsp (con interceptor)
	@RequestMapping( "/actualizarPlaylist.do")
	public String actualizarPlaylist(@RequestParam("idPlaylist")Integer idPlaylist,
			@RequestParam("idVideo")Integer idVideo, Model model){
		
		videoGestion.actualizarPlaylist(idPlaylist, idVideo);
		
		return "videoPlay";
	}
	
	

	@RequestMapping("/buscar.do")
	public String buscar(@RequestParam("busqueda")String busqueda, Model model){		
		
		List<Video> videos = videoGestion.buscarVideos(busqueda);
		List<Artista> artistas = artistaGestion.buscarArtistas(busqueda);
		
		model.addAttribute("videosBuscados",videos);
		model.addAttribute("artistasBuscados", artistas);
		
		return "resultBusqueda";
	}
	 
	@RequestMapping("/reprodPlaylist.do")
	public String reprodPlaylist(@RequestParam("id")Integer idVideo, Model model){
		PlayList playList = videoGestion.reprodPlaylist(idVideo);
		model.addAttribute("playlist", playList);
		return "reprodPlaylist";
	}
	
	public VideoGestion getVideoGestion() {
		return videoGestion;
	}

	public void setVideoGestion(VideoGestion videoGestion) {
		this.videoGestion = videoGestion;
	}

	public ArtistaGestion getArtistaGestion() {
		return artistaGestion;
	}

	public void setArtistaGestion(ArtistaGestion artistaGestion) {
		this.artistaGestion = artistaGestion;
	}
}
