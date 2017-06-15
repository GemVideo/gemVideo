package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artista {

	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private String  imagen;	
	@OneToMany 
	private List<Video> listaVideos;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<Video> getListaVideos() {
		return listaVideos;
	}
	public void setListaVideos(List<Video> listaVideos) {
		this.listaVideos = listaVideos;
	}
	
	
}
