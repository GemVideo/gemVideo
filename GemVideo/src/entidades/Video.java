package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Video {
	@Id
	@GeneratedValue
	private Integer id;

	private String titulo;
	private String descripcion;
	private String  thumbnail;
	private String url;
	
	
	
	public Video() {
		
	}

	public Video(Integer id, String titulo, String descripcion, String thumbnail, String url) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.thumbnail = thumbnail;
		this.url = url;
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
