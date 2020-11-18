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
 * 
 */

/**
 * Clase que representa una lista.
 */
public class LinkedList<T extends Comparable<T>> implements ILinkedList<T> 
{
	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------
	/**
	 * Primer nodo de la lista.
	 */
	private Node<T> first;

	/**
	 * Nodo actual de la lista.
	 */
	private Node<T> current;

	/**
	 * Tamaño de la lista.
	 */
	private int size;
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Crea la lista vacía.
	 */
	public LinkedList() {
		first = null;
		current = null;
		size = 0;
	}
	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------
	/** Agrega un elemento a la lista
	 * @param elemento elemento a agregar. element != null
	 */
	public void add(T element) {
		if(element == null) throw new NullPointerException("Se recibe un elemento nulo");
		else {
			if(first == null) {
				first = new Node<T>(element);
				current = first;
				size++;
			}
			else {
				Node<T> nuevo = new Node<T>(element);
				if(first.getElement().compareTo(element) >= 0) {
					if(first.getNext() == null)
						current = first;

					nuevo.setNext(first);
					first = nuevo;
					size++;
					return;
				}

				else if(current.getElement().compareTo(element) <= 0){
					nuevo.setNext(current.getNext());
					current.setNext(nuevo);
					current = nuevo;
					size++;
					return;
				}
				else {
					current.setNext(nuevo);
					current = nuevo;
					size++;					
				}
			}
		}
	}

	/** Agrega ordenadamente a la lista.
	 * @param element elemento a agregar. element != null
	 */
	public void addOrder(T element)
	{
		if(first == null) {
			first = new Node<T>(element);
			current = first;
			size++;
		}
		else {
			Node<T> nuevo = new Node<T>(element);
			if(first.getElement().compareTo(element) >= 0) {
				if(first.getNext() == null)
					current = first;

				nuevo.setNext(first);
				first = nuevo;
				size++;
				return;
			}

			else if(current.getElement().compareTo(element) <= 0) {
				nuevo.setNext(current.getNext());
				current.setNext(nuevo);
				current = nuevo;
				size++;
				return;
			}
			else {
				Node<T> anterior = null;
				Node<T> actual = first;
				while(actual != null) {					
					int comp = actual.getElement().compareTo(element);
					if((comp <= 0 && actual.getNext() == null) || (comp <= 0 && comp >= 0))	{
						nuevo.setNext(actual.getNext());
						actual.setNext(nuevo);
						size++;
						return;
					}					

					else if(comp <= 0 && comp >= 0) {
						nuevo.setNext(actual.getNext());
						actual.setNext(nuevo);
						size++;
						return;
					}

					else if(comp > 0 ) {
						nuevo.setNext(actual);
						anterior.setNext(nuevo);
						size++;
						return;
					}

					else {
						anterior = actual;
						actual = actual.getNext();
					}
				}			

			}
		}
	}

	/**
	 * Ordena por el metodo merge.
	 */
	public Node<T> merge_sort(Node<T> head) {
		if(head == null || head.getNext() == null)  return head; 

		Node<T> middle = getMiddle(head);    
		Node<T> sHalf = middle.getNext(); 
		middle.setNext(null);   

		return merge(merge_sort(head),merge_sort(sHalf));  
	}

	//Merge subroutine to merge two sorted lists
	/**
	 * Junta de forma ordenada dos sublistas ordenadas
	 * @param a. Primer nodo lista a a != null.
	 * @param b. Primer nodo lista b b != null.
	 * @return Una lista ordenada.
	 */
	public Node<T> merge(Node<T> a, Node<T> b) {
		Node<T> dummyHead, curr; dummyHead = new Node<T>(); curr = dummyHead;
		while(a !=null && b!= null) {
			if(a.getElement().compareTo(b.getElement()) <= 0 ) { 
				curr.setNext(a);
				a = a.getNext(); 
			}
			else { 
				curr.setNext(b);
				b = b.getNext(); 
			}
			curr = curr.getNext();
		}
		curr.setNext((a == null) ? b : a);
		return dummyHead.getNext();
	}

	/**
	 * Encuentra el nodo de la mitad de la lista para dividirla.
	 * @param head. Cabeza de la lista head != null.
	 * @return Nodo de la mitad
	 */
	public Node<T> getMiddle(Node<T> head) {
		if(head == null) return head; 

		Node<T> slow, fast; 
		slow = fast = head;

		while(fast.getNext() != null && fast.getNext().getNext() != null) 
			slow = slow.getNext(); fast = fast.getNext().getNext();

			return slow;
	}

	/** Elimina el elemento recibido por paramétro de la lista. 
	 * @param element elemento a elminar. element != null
	 */
	@Override
	public void delete(T element) {
		if(first != null){
			if(first.getElement().compareTo(element)==0){
				first = first.getNext();
				size--;
			}
			else {
				Node<T> anterior = first;
				Node<T> actual = anterior.getNext();
				while(actual != null) {					
					if(actual.getElement().toString().compareTo(element.toString()) == 0) {
						current = anterior;
						anterior.setNext(actual.getNext());
						size--;
					}
					anterior = actual;
					actual = actual.getNext();
				}
			}
		}
	}
	/** Retorna el elemento si coincide con el elemento recibido por paramétro.
	 * @param element elemento a buscar. element != null
	 * @return element elemento encontrado.
	 */
	@Override
	public T get(T element) {
		if(first != null){
			Node<T> actual = first;
			while(actual != null){
				if(actual.getElement().compareTo(element) == 0)
					return actual.getElement();

				actual = actual.getNext();
			}
		}
		return null;
	}
	/** Retorna el número de elementos de la lista.
	 * @return size tamaño de la lista.
	 */
	@Override
	public int size() {return size;}
	
	/** Retorna el elemento que se encuentra en la posición recibida por paramétro.
	 * @param position posición del elemento a buscar.
	 * @return elemento de la posición buscada.
	 */
	@Override
	public T get(int position) {
		if(first != null){
			Node<T> actual = first;
			int pos = 0;
			while(actual != null && pos <= position){
				if(pos == position)
					return actual.getElement();

				pos++;
				actual = actual.getNext();
			}
		}
		return null;
	}

	/**
	 * Actualiza el nodo actual al primero.
	 */
	@Override
	public void listing() {current = first;}

	/** Retorna el elemento del nodo actual.
	 * @return elemento del nodo actual.
	 */
	@Override
	public T getCurrent() {
		if(current != null)
			return current.getElement();
		else
			return null;
	}
	/** Retorna el elemento del nodo siguiente al actual.
	 * @return elemento del nodo siguiente al actual.
	 */
	@Override
	public T next() {
		if(current.getNext() != null)
			return current.getNext().getElement();
		else
			return null;
	}
	/** Retorna si el elemento recibido por paramétro ya existe en la lista.
	 * @param element elemento buscado. element != null
	 * @return true si el elemento ya existe, false de lo contrario.
	 */
	@Override
	public boolean contains(T element) {
		if(first != null){
			Node<T> actual = first;
			while(actual != null){
				if(actual.getElement().compareTo(element) == 0)
					return true;

				actual = actual.getNext();
			}
		}
		return false;
	}
	/** Actualiza el elemento del nodo en la posicion recibida por paramétro.
	 * @param pos posicion del nodo a actualizar.
	 * @param element elemento a actualizar.
	 */
	@Override
	public void set(int pos, T element) 
	{
		if(first != null){
			Node<T> actual = first;
			int position = 0;
			while(actual != null && pos >= position){
				if(pos == position)
					actual.setElement(element);

				position++;
				actual = actual.getNext();
			}
		}
	}


	/** Retorna el primer nodo de la lista.
	 * @return Nodo<T> primer nodo de la lista
	 */
	public Node<T> getFirst() { return first; }
}
