package entidades;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Usuario {
	
	
	@Id
	private String nombre;
	private String pass;
	
	//si se ponen los dos a eager da error 
	//cannot simultaneously fetch multiple bags: [entidades.Usuario.artistasFavoritos, entidades.Usuario.PlayLists]
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Artista> artistasFavoritos;
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PlayList> PlayLists;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<Artista> getArtistasFavoritos() {
		return artistasFavoritos;
	}
	public void setArtistasFavoritos(List<Artista> artistasFavoritos) {
		this.artistasFavoritos = artistasFavoritos;
	}
	public List<PlayList> getPlayLists() {
		return PlayLists;
	}
	public void setPlayLists(List<PlayList> playLists) {
		PlayLists = playLists;
	}


		}