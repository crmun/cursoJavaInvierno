package py.una.pol.cursojava;

public interface PersonaDML {
	/**
	 * Conectarse a la base de datos e imprimir informacion de debug usando el logger
	 */
	void conectar(String ip, String puerto, String usuario, String password);
	
	/**
	 * Buscar todas las personas e imprimirlos por consola usando el logger
	 */
	void buscarTodos();
	
	/**
	 * Buscar una persona por id e imprimir el mismo por consola usando el logger
	 * @param id
	 */
	void buscarPorId(int id);
	
	/**
	 * Actualizar una persona e imprimir informacion de debug usando el logger
	 * @param nombre
	 * @param apellido
	 */
	void actualizar(String nombre, String apellido);
	
	/**
	 * Eliminar una persona e imprimir informacion de debug usando el logger
	 * @param id
	 */
	void eliminar(int id);
	
	/**
	 * Desconectarse de la base de datos e imprimir informacion de debug usando el logger
	 */
	void cerrarConexion();
}
