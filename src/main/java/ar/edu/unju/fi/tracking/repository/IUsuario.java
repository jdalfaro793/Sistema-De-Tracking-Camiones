package ar.edu.unju.fi.tracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.tracking.model.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Long>{
	//Permite ordenar la tabla por atributo nombre Real
	@Query("from Usuario e order by e.nombreReal")
	public List<Usuario> obtenerUsuarios();
}
