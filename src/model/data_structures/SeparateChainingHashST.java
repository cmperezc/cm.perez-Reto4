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
public class SeparateChainingHashST <K,V> implements IHashTable<K, V>{
	/**
	 * 
	 */
	private static final int INIT_CAPACITY = 5;

	/**
	 * Número de parejas llave-valor.
	 */
	private int n; 

	/**
	 * Tamaño de la tabla.
	 */
	private int m;     

	/**
	 * LinkedList de tablas de símbolos.
	 */
	private SequentialSearchST<K, V>[] st;  // array of linked-list symbol tables

	/**

	 * Inicializa la tabla vacía
	 */
	public SeparateChainingHashST() { this(INIT_CAPACITY);} 

	/**
	 * Inicializa la tabla con el tamaño dada por parámetro.
	 * @param m Tamaño inicial. m >= 0 && m != null.
	 */
	public SeparateChainingHashST(int m) {
		this.m = m;
		st = (SequentialSearchST<K, V>[]) new SequentialSearchST[m];
		for (int i = 0; i < m; i++)
			st[i] = new SequentialSearchST<K, V>();
	} 

	/**
	 * Ajusta el tamaño de la tabla de hash y vuelve a ubicar todos las parejas de acuerdo al tamaño dado por parámetro.
	 * @param chains Nuevo tamaño de la tabla de hash.
	 */
	private void rehash(int chains) {
		SeparateChainingHashST<K, V> temp = new SeparateChainingHashST<K, V>(chains);
		for (int i = 0; i < m; i++) {
			for (K key : st[i].keys()) {
				temp.put(key, st[i].get(key));
			}
		}
		this.m  = temp.m;
		this.n  = temp.n;
		this.st = temp.st;
	}

	/**
	 * Retorna el valor de hash de la llave dada por parámetro.
	 * @param key Llave. key != null.
	 * @return Valor de hash de la llave.
	 */
	private int hash(K key) { return (key.hashCode() & 0x7fffffff) % m;} 

	/**
	 * Retorna el número de parejas llave-valor que hay en la tabla.
	 * @return El número de parejas llave-valor que hay en la tabla.
	 */
	public int size() { return n; } 

	/**
	 * Retorna si la tabla está vacía o no.
	 * @return True si está vacía, y false de lo contrario.
	 */
	public boolean isEmpty() { return size() == 0; }
	/**
	 * Retorna si la llave está contenida en la tabla.
	 * @param  key Llave buscada. key != null.
	 * @return True si la llave está y false de lo contrario.
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(K key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	} 

	/**
	 * Retorna el valor de la llave dada por parámetro.
	 * @param  key LLave buscada. key != null
	 * @return El valor de la llave dada por parámetro.
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public V get(K key) {
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
		int i = hash(key);
		return st[i].get(key);
	} 

	/**
	 * Inserta la pareja llave-valor en la tabla.
	 * @param  key Llave. key != null
	 * @param  val Valor. val != null
	 */
	public void put(K key, V val) {
		if(key != null){
			if (val == null) {
				delete(key);
				return;
			}

			if (((double)n/m) > 0.6) rehash(2*m);

			int i = hash(key);

			if (!st[i].contains(key)) 
				n++;

			st[i].put(key, val);
		}
	} 

	/**
	 * Elimina la llave y su valor asociado.
	 * @param  key Llave. key != null
	 * @return El valor de la llave que se elimina
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public V delete(K key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		
		if (m > INIT_CAPACITY && n <= 2*m) rehash(m/2);

		int i = hash(key);
		if (st[i].contains(key)) n--;
		return st[i].delete(key);  
	} 

	/**
	 * Retorna las llaves como una tabla iterable.
	 */
	// return keys in symbol table as an Iterable
	public Iterable<K> keys() {
		Queue<K> queue = new Queue<K>();
		for (int i = 0; i < m; i++) {
			for (K key : st[i].keys())
				queue.enqueue(key);
		}
		return queue;
	} 
	/**
	 * Retorna el tamaño de la tabla.
	 * @return Tamaño de la tabla.
	 */
	public int getTableSize(){return m;}
}
