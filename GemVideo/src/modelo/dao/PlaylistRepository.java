package modelo.dao;
import org.springframework.data.repository.CrudRepository;

import entidades.Usuario;

public interface PlaylistRepository extends CrudRepository<Usuario, String> {

}
