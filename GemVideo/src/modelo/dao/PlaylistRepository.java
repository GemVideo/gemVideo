package modelo.dao;
import org.springframework.data.repository.CrudRepository;

import entidades.PlayList;
import entidades.Usuario;

public interface PlaylistRepository extends CrudRepository<PlayList, Integer> {

}
