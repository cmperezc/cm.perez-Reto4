package model.data_structures;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Taller 6 201810 Estructura de datos sección 2 y 3
 * Autoras: Maria Ocampo y Leidy Romero 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
 /**
 * @param <K>
 * @param <V>
 */
public interface IHashTable <K,V> 
{
	/**
	 * @param key
	 * @param value
	 */
	public void put(K key, V value);
	/**
	 * @param key
	 * @return
	 */
	public V get (K key);
	/**
	 * @param key
	 * @return
	 */
	public V delete (K key);
	/**
	 * @return
	 */
	public Iterable<K> keys();
}
