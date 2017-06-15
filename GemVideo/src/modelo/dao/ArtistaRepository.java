package modelo.dao;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import entidades.Artista;

public interface ArtistaRepository extends CrudRepository<Id, Integer>{

	List<Artista> findByName(String nombreArtista);
	void deleteByName(String nombreArtista);
	
}

