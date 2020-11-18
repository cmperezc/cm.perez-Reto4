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
public class HashNode<K,V> 
{
	/**
	 * Siguiente nodo.
	 */
	private HashNode<K,V> next;
	
	/**
	 * Llave del nodo.
	 */
	private K key;
	
	/**
	 * Valor del nodo
	 */
	private V value;
	
	/**
	 * Crea el nodo con los valores dados por parámetro.
	 * @param pKey Llave del nodo. pKey != null
	 * @param pValue Valor del nodo. pValue != null
	 * @param pNext Nodo siguiente. pNext != null
	 */
	public HashNode (K pKey, V pValue, HashNode<K,V> pNext){
		key = pKey;
		value = pValue;
		next = pNext;
	}
	
	/**
	 * Crea el nodo con los valores por defecto.
	 */
	public HashNode (){
		key = (K) "";
		value = null;
		next = null;
	}
	
	/**
	 * Retorna el siguiente nodo.
	 * @return Siguiente nodo.
	 */
	public HashNode<K,V> getNext(){ return next; }
	
	/**
	 * Modifica el siguiente nodo por el ingresado por parámetro.
	 * @param pNext Siguiente nodo. pNext != null.
	 */
	public void setNext(HashNode<K,V> pNext){ next = pNext; }
	
	/**
	 * Modifica la llave del nodo por la dada por parámetro.
	 * @param pKey Nueva llave del nodo. pKey != null.
	 */
	public void setKey(K pKey){ key = pKey; }
	
	/**
	 * Modifica el valor del nodo por el dado por parámetro.
	 * @param pValue Nuevo valor del nodo. pValue != null.
	 */
	public void setValue(V pValue){ value = pValue; }
	
	/**
	 * Retorna el valor del nodo.
	 * @return Valor del nodo.
	 */
	public V getValue(){ return value;}
	
	/**
	 * Retorna la llave del nodo.
	 * @return Llave del nodo.
	 */
	public K getKey(){ return key; }
}
