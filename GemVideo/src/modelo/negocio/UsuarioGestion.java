package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Artista;
import entidades.PlayList;
import entidades.Usuario;
import modelo.dao.ArtistaRepository;
import modelo.dao.PlaylistRepository;
import modelo.dao.UsuarioRepository;

@Service
public class UsuarioGestion {

	@Autowired
	UsuarioRepository usuarioRepo;
	@Autowired
	ArtistaRepository artistaRepo;
	@Autowired
	PlaylistRepository playlistRepo;
	
	public Usuario login(Usuario usuario){
		
		Usuario usuarioDDBB = usuarioRepo.findOne(usuario.getNombre());
		
		if(usuarioDDBB != null && usuarioDDBB.getPass().equals(usuario.getPass())){
			return usuarioDDBB;
		}else
			return null;
	}
	
	@Transactional
	public boolean registro(Usuario usuario){
		
		if(usuarioRepo.findOne(usuario.getNombre()) != null)
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
		Usuario usuario = usuarioRepo.findOne(userName);
		PlayList playlist = new PlayList();
		playlist.setNombre(nombrePlaylist);
		playlist = playlistRepo.save(playlist);
		usuario.getPlayLists().add(playlist);
		usuarioRepo.save(usuario);
	}

	@Transactional
	public void actualizarArtistaFavorito(Integer idArtist, String userName) {
		
		Usuario usuario = usuarioRepo.findOne(userName);
		
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
			Artista artista = artistaRepo.findOne(idArtist);
			artistasFavs.add(artista);
		}
		
		usuario.setArtistasFavoritos(artistasFavs);
		usuarioRepo.save(usuario);
	}
	
	
	
}
