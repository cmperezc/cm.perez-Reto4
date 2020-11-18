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

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * @param <K>
 */
public class Queue<K> implements Iterable<K> {
	private class Node<T>{
		/**
		 * Siguiente nodo.
		 */
		private Node<T> next;

		/**
		 * Elemento del nodo.
		 */
		private T element;

//		/**
//		 * Crea el nodo con el elemento.
//		 * @param pElement Elemento del nodo. pElement != null.
//		 */
//		public Node (T pElement){
//			element = pElement;
//			next = null;
//		}

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
		public T getElement(){ return element; }
	}
	private Node<K> first;    // beginning of queue
	private Node<K> last;     // end of queue
	private int n;               // number of elements on queue

	// helper linked list class

	/**
	 * Initializes an empty queue.
	 */
	public Queue() {
		first = null;
		last  = null;
		n = 0;
	}

	/**
	 * Returns true if this queue is empty.
	 *
	 * @return {@code true} if this queue is empty; {@code false} otherwise
	 */
	public boolean isEmpty() { return first == null; }

	/**
	 * Returns the number of items in this queue.
	 *
	 * @return the number of items in this queue
	 */
	public int size() { return n; }

	/**
	 * Returns the item least recently added to this queue.
	 *
	 * @return the item least recently added to this queue
	 * @throws NoSuchElementException if this queue is empty
	 */
	public K peek() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		return first.getElement();
	}

	/**
	 * Adds the item to this queue.
	 *
	 * @param  item the item to add
	 */
	public void enqueue(K item) {
		Node<K> oldlast = last;
		last = new Node<K>();
		last.setElement(item);;
		last.setNext(null);;
		if (isEmpty()) first = last;
		else           oldlast.setNext(last);
		n++;
	}

	/**
	 * Removes and returns the item on this queue that was least recently added.
	 *
	 * @return the item on this queue that was least recently added
	 * @throws NoSuchElementException if this queue is empty
	 */
	public K dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		K item = first.getElement();
		first = first.getNext();
		n--;
		if (isEmpty()) last = null;   // to avoid loitering
		return item;
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the sequence of items in FIFO order, separated by spaces
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (K item : this) {
			s.append(item);
			s.append(' ');
		}
		return s.toString();
	} 

	/**
	 * Returns an iterator that iterates over the items in this queue in FIFO order.
	 *
	 * @return an iterator that iterates over the items in this queue in FIFO order
	 */
	public Iterator<K> iterator()  { return new ListIterator<K>(first);   }

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) { current = first; }

		public boolean hasNext()  { return current != null;                     }
		public void remove()      { throw new UnsupportedOperationException();  }

		public Item next() {
			// if (!hasNext()) throw new NoSuchElementException();
			Item item = null;
			if(current != null){
				item = current.getElement();
				current = current.getNext(); 
			}
			return item;
		}
	}
}
