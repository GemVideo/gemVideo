package modelo.dao;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import entidades.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, Integer>{

	@Query("select a from Artista a where a.nombre like %:nombre%")
	List<Artista> findByNombre(@Param("nombre")String nombreArtista);
	
	void deleteByNombre(String nombreArtista);
	
}

