package modelo.dao;


import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import entidades.Video;


public interface VideoRepository extends CrudRepository<Video, Integer>{
	
	@Query("select v from Video v where v.titulo like %:nombre%")
	List<Video> findByTitulo(@Param("nombre")String nombreVideo);
	void deleteByTitulo(String nombreVideo);

	List<Video> findFirst12();
	
}
