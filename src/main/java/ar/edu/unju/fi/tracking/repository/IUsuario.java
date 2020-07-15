package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Usuario;
/**
 * Interface Usuario que permite acceder a los usuarios guardados
 * @author RODOLFO
 *
 */
@Repository
public interface IUsuario extends JpaRepository<Usuario, Long>{
	/**
	 * Metodo que permite obtener los usuarios almacenados en la BD
	 * @return una lista de los usuarios 
	 */
	//Permite ordenar la tabla por atributo nombre Real
	@Query("from Usuario e order by e.nombreReal")
	public List<Usuario> obtenerUsuarios();
}
