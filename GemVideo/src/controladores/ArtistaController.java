package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entidades.Artista;
import modelo.negocio.ArtistaGestion;

@Controller
public class ArtistaController {

	@Autowired
	ArtistaGestion artistaGestion;
	
	@RequestMapping("/mostrarArtista.do")
	public String mostrarArtista(@RequestParam("idArtista")Integer idArtista,Model model){
		Artista artista = artistaGestion.mostrarArtista(idArtista);
		model.addAttribute("artista",artista);
		
		return "mostrarArtista";
	}

	public ArtistaGestion getArtistaGestion() {
		return artistaGestion;
	}

	public void setArtistaGestion(ArtistaGestion artistaGestion) {
		this.artistaGestion = artistaGestion;
	}

	
}
