package model.data_structures;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Proyecto 1 201810 Estructura de datos sección 2 y 3
 * Autoras: Maria Ocampo y Leidy Romero 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

/**
 * Abstract Data Type for a linked list of generic objects
 * This ADT should contain the basic operations to manage a list
 * add: add a new element T 
 * delete: delete the given element T 
 * get: get the given element T (null if it doesn't exist in the list)
 * size: return the the number of elements
 * get: get an element T by position (the first position has the value 0) 
 * listing: set the listing of elements at the firt element
 * getCurrent: return the current element T in the listing (return null if it doesn´t exists)
 * next: advance to next element in the listing (return if it exists)
 * @param <T>
 */
public interface ILinkedList <T extends Comparable<T>> 
{
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------
	/**
	 * Agrega un elemento al final de la lista.
	 * @param element Elemento nuevo. elemento != null.
	 */
	void add(T element);

	/**
	 * Elimina el elemento dado por parámetro.
	 * @param element Elemento a elimimar. elemeto != null.
	 */
	public void delete(T element);

	/**
	 * Retorna el elemento dado por parámetro si lo ecuentra en la lista.
	 * @param element Elemento a busar. element != null.
	 * @return El elemento si lo encuentra en la lista y null de lo contrario.
	 */
	public T get(T element);

	/**
	 * Retorna la cantidad de nodos de la lista.
	 * @return Cantidad de nodos.
	 */
	public int size();

	/**
	 * Retorna el elemento en la posición dada por parámetro.
	 * @param pos Posición del a buscar. pos != null && pos > 0.
	 * @return Retorna el elemento en la posición dada.
	 */
	public T get(int pos);

	/**
	 * Cambia el elemento actual por el primero.
	 */
	public void listing();

	/**
	 * Retorna el elemento actual.
	 * @return Elemento actual.
	 */
	public T getCurrent();

	/**
	 * Retorna el siguiente elemento.
	 * @return Siguiente elemento.
	 */
	public T next();

	/**
	 * Retorna si la lista contiene o no el elemento.
	 * @param element Elemento a buscar. element != null;
	 * @return True si el elemento está en la lista y false de lo contrario.
	 */
	public boolean contains(T element);

	/** Actualiza el elemento del nodo en la posición recibida por paramétro.
	 * @param pos posicion del nodo a actualizar.
	 * @param element elemento a actualizar.
	 */
	public void set(int pos, T element);

	/** Agrega en orden a la lista
	 * @param element elemento a agregar.
	 */
	public void addOrder(T element);

	/** Ordena la lista por el método merge.
	 * @param head. Cabeza de la lista head!=null.
	 * @return La lista ordenada.
	 */
	public Node<T> merge_sort(Node<T> head);

	/** Retorna el primer nodo de la lista.
	 * @return Node primer nodo de la lista
	 */
	public Node<T> getFirst();
}
