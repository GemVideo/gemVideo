package modelo.dao;
import org.springframework.data.repository.CrudRepository;

import entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>  {

}
