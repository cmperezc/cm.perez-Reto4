package model.data_structures;


/**
 * @param <T>
 */
public class Node<T extends Comparable<T>> 
{
	/**
	 * Siguiente nodo.
	 */
	private Node<T> next;
	
	/**
	 * Elemento del nodo.
	 */
	private T element;
	
	/**
	 * Crea el nodo con el elemento.
	 * @param pElement Elemento del nodo. pElement != null.
	 */
	public Node (T pElement){
		element = pElement;
		next = null;
	}
	
	/**
	 * Crea el nodo con los valores por defecto.
	 */
	public Node (){
		element = null;
		next = null;
	}
	
	/**
	 * Retorna el siguiente nodo.
	 * @return Siguiente nodo.
	 */
	public Node<T> getNext(){ return next; }
	
	/**
	 * Modifica el siguiente nodo por el ingresado por parámetro.
	 * @param pElement Elemento del siguiente nodo. pElement != null.
	 */
	public void setNext(Node<T> pNode){ next = pNode; }
	
	/**
	 * Modifica el elemento del nodo por el dado por parámetro.
	 * @param pElement Nuevo elemento del nodo. pElement != null.
	 */
	public void setElement(T pElement){ element = pElement; }
	
	/**
	 * Retorna el elemento del nodo.
	 * @return Elemento del nodo.
	 */
	public T getElement() { return element; }
}
