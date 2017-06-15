package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import controladores.Usuario;

@Service
public class UsuarioGestion {

	UsuarioRepotoy usuarioRepo;
	ArtistaRepository artistaRepo;
	
	public Usuario login(Usuario usuario){
		
		Usuario usuarioDDBB = usuarioRepo.find(usuario.getNombre());
		
		if(usuarioDDBB != null && usuarioDDBB.getPassword.equals(usuario.getPassword())){
			return usuarioDDBB;
		}else
			return null;
	}
	
	@Transactional
	public boolean registro(Usuario usuario){
		
		if(usuarioRepo.finOne(usuario.getNombre()) != null)
			return false;
		else{
			usuarioRepo.save(usuario);
			return true;
		}
	}
	
	public Usuario obtenerPerfil(String nombre){
		Usuario usuario = usuarioRepo.findOne(nombre);
		return usuario;
	}
	
	@Transactional
	public void crearPlaylist(String nombrePlaylist,String userName){
		Usuario usuario = usuarioRepo.find(userName);
		PlayList playlist = new PlayList();
		playlist.setNombre(nombrePlaylist);
		usuario.getPlayLists().add(playlist);
		usuarioRepo.save(usuario);
	}

	@Transactional
	public void actualizarArtistaFavorito(Integer idArtist, String userName) {
		
		Usuario usuario = usuarioRepo.find(userName);
		
		List<Artista> artistasFavs = usuario.getArtistasFavoritos();
			
		boolean esFav = false;
		for (Artista artista : artistasFavs) {
			if(artista.getId() == idArtist){
				esFav = true;
				artistasFavs.remove(artista);
				//si falla, coger este artista y removerlo fuera del for
				break;
			}
		}
		
		if(!esFav){
			Artista artista = artistaRepo.find(idArtist);
			artistasFavs.add(artista);
		}
		
		usuario.setArtistasFavoritos(artistasFavs);
		
		usuarioRepo.save(usuario);
	}
	
	
	
}
