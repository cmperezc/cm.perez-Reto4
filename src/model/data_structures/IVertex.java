package model.data_structures;
/**
 * Interfaz utilizada para implementar el elemento de un vértice
 * @param <K> Tipo del id del vértice
 */
public interface IVertex <K>{
	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------
	/**
	 * Devuelve el ID del vértice
	 * @return Identificador del vértice
	 */
	public K getKey( );
}

