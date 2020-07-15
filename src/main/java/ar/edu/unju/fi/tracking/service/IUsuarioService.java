package ar.edu.unju.fi.tracking.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tracking.model.Usuario;

/**
 * Interface que permite desarrollar la logica del proyecto. Permite conectarse
 * con los datos almacenados en algun repositorio para su modificacion,
 * visualizacion o busqueda
 * 
 */
public interface IUsuarioService {

	/**
	 * Metodo que permite guardar un Usuario en el gestor de Base de datos
	 * 
	 * @param Usuario objeto de tipo Usuario que se desea guardar
	 */
	public void guardarUsuario(Usuario usuario);

	/**
	 * Metodo que permite listar los Usuarios almacenados
	 * 
	 * @return la lista de Usuarios encontrados
	 */
	public List<Usuario> obtenerUsuarios();

	/**
	 * Metodo para hacer una busqueda de Usuario por su id ingresado por parametro
	 * 
	 * @param id de Usuario a buscar
	 * @return Usuario encontrado
	 */
	public Optional<Usuario> obtenerUnUsuario(Long id);

	/**
	 * Metodo para hacer una eliminacion de un Usuario almacenado en la Base de
	 * datos
	 * 
	 * @param id de Usuario a eliminar
	 */
	public void eliminarUsuario(Long id);
}
