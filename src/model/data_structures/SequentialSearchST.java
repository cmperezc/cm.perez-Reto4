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
 * @param <K>
 * @param <V>
 */
public class SequentialSearchST<K, V> 
{
	/**
	 * Número de parejas llave-valor
	 */
	private int n;           //Número de parejas llave-valor

	/**
	 * Primer nodo de la lista de parejas llave-valor
	 */
	private HashNode<K,V> first;      

	/**
	 * Inicializa la tabla de simbolos vacía.
	 */
	public SequentialSearchST() 
	{
		n = 0;
		first = null;
	}

	/**
	 * Retorna el número de parejas llave-valor de la tabla.
	 * @return El número de parejas llave-valor de la tabla.
	 */
	public int size() { return n; }

	/**
	 * Retorna si la tabla está vacía.
	 * @return True si la tabla está vacía, false de lo contrario.
	 */
	public boolean isEmpty()  { return size() == 0; }

	/**
	 * Returns true if this symbol table contains the specified key.
	 *
	 * @param  key the key
	 * @return {@code true} if this symbol table contains {@code key};
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(K key) 
	{
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");

		return get(key) != null;
	}

	/**
	 * Returns the value associated with the given key in this symbol table.
	 *
	 * @param  key the key
	 * @return the value associated with the given key if the key is in the symbol table
	 *     and {@code null} if the key is not in the symbol table
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public V get(K key) {
		if(key != null){ 
			for (HashNode<K,V> x = first; x != null; x = x.getNext()) {
				if (key.equals(x.getKey()))
					return x.getValue();
			}
		}
		return null;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old 
	 * value with the new value if the symbol table already contains the specified key.
	 * Deletes the specified key (and its associated value) from this symbol table
	 * if the specified value is {@code null}.
	 *
	 * @param  key the key
	 * @param  val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(K key, V val) {
		if (key == null) 
			throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		for (HashNode<K,V> x = first; x != null; x = x.getNext()) {
			if (key.equals(x.getKey())) {
				x.setValue(val);
				return;
			}
		}

		first = new HashNode<K,V>(key, val, first);
		n++;
	}

	/**
	 * Removes the specified key and its associated value from this symbol table     
	 * (if the key is in this symbol table).    
	 *
	 * @param  key the key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public V delete(K key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");

		if(key != null){
			V value = delete(first, key);
			return value;
		}
		return null;
	}

	// delete key in linked list beginning at Node x
	// warning: function call stack too large if table is large
	private V delete(HashNode<K,V> x, K key) {
		if (x == null) return null;

		if(x.equals(first)){
			n--;
			V value = first.getValue();
			first = first.getNext();
			return value;
		}

		else{
			while(x != null && x.getNext() != null){
				if (key.equals(x.getNext().getKey())) {
					n--;
					V value = x.getNext().getValue();
					x.setNext(x.getNext().getNext());
					return value;
				}

				x = x.getNext();
			}
		}

		return null;
	}


	/**
	 * Returns all keys in the symbol table as an {@code Iterable}.
	 * To iterate over all of the keys in the symbol table named {@code st},
	 * use the foreach notation: {@code for (Key key : st.keys())}.
	 *
	 * @return all keys in the symbol table
	 */
	public Iterable<K> keys()  {
		Queue<K> queue = new Queue<K>();

		for (HashNode<K,V> x = first; x != null; x = x.getNext())
			queue.enqueue(x.getKey());

		return queue;
	}
}