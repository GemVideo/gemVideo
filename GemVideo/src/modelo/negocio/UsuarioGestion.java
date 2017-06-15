package modelo.negocio;

public class UsuarioGestion {

	UsuarioRepo usuarioRepo;
	
	public Usuario login(Usuario usuario){
		
		Usuario usuarioDDBB = usuarioRepo.find(usuario.getNombre());
		
		if(usuarioDDBB != null && usuarioDDBB.getPassword.equals(usuario.getPassword())){
			return usuarioDDBB;
		}else
			return null;
	}
	
	public boolean registro(Usuario usuario){
		
		// en funcion a lo que devuelva 
		usuarioRepo.save(usuario);
	}
	
	public Usuario obtenerPerfil(String nombre){
		Usuario usuario = usuarioRepo.find(nombre);
		return usuario;
	}
	
	
	public void crearPlaylist(String nombrePlaylist,Usuario usuario){
		usuario = usuarioRepo.find(usuario.getNombre());
		PlayList playlist = new PlayList();
		playlist.setNombre(nombrePlaylist);
		usuario.getPlayLists().add(playlist);
		
		usuarioRepo.save(usuario);
	}
	
	
	
}
