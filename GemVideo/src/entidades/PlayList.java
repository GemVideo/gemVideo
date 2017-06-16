package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlayList {
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Video> listaVideos;
	
	private String  thumbnail;
	
	
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
	public List<Video> getListaVideos() {
		return listaVideos;
	}
	public void setListaVideos(List<Video> listaVideos) {
		this.listaVideos = listaVideos;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}