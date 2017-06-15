package controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import entidades.Usuario;
import modelo.negocio.UsuarioGestion;

@Controller
@SessionAttributes(names={"usuario"})
public class UsuarioController {

	@Autowired
	UsuarioGestion usuarioGestion;
	
	@RequestMapping("/login.do")
	public String precargaLogin(Model model){
		model.addAttribute("loginCommand", new Usuario());
		return "login";
	}
	
	@PostMapping("/login.do")
	public String login(@ModelAttribute("loginCommand")Usuario usuario,
			BindingResult binding, Model modelo) {
		if (!binding.hasErrors()) {
			Usuario user= usuarioGestion.login(usuario);
			if (user!=null) {
				modelo.addAttribute("usuario", user);  //al estar sessionAtributte anotado, lo añade a la sesion
				return "redirect:/home.do";
			} else {
				binding.rejectValue("nombre", "loginerror");
				return "login";
			}
		}
		return "login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(SessionStatus status, Model model){
		status.setComplete();  //limpia sesión
		model.asMap().remove("usuario");  //hay que eliminarlo también del model
		return "redirect:/login.do";
	}
	
	@RequestMapping("/registro.do")
	public String precargaRegistro(Model modelo) {
		modelo.addAttribute("registroCommand", new Usuario());
		return "registro";
	}

	@PostMapping("/registro.do")
	public String registro(@ModelAttribute("registroCommand")Usuario usuario, BindingResult binding) {
		if (!binding.hasErrors()) {
			if (usuarioGestion.registro(usuario)) {
				return "redirect:/login.do";
			} else {
				binding.rejectValue("nombre", "nombrerepetido");
				return "registro";
			}
		}
		return "registro";
	}
	
	@RequestMapping("/crearPlaylist.do")
	public String crearPlaylist(@RequestParam("nombrePlaylist")String nombrePlaylist,
			@SessionAttribute("usuario")Usuario usuario){		
		
		usuarioGestion.crearPlaylist(nombrePlaylist, usuario.getNombre());
		
		return "playVideo";
	}
	
	@RequestMapping("/actualizarArtistaFavorito.do")
	public String actualizarArtista(@RequestParam("idArtista")Integer idArtist,
			@SessionAttribute("usuario")Usuario usuario){
		
			usuarioGestion.actualizarArtistaFavorito(idArtist,usuario.getNombre());
			
			return "mostrarArtista";
	}
	
}
