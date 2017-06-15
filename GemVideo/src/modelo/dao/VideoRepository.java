package modelo.dao;


import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;


import entidades.Video;


public interface VideoRepository extends CrudRepository<Id, Integer>{

	List<Video> findByName(String nombreVideo);
	void deleteByName(String nombreVideo);

	List<Video> findFirst12();
	
}
