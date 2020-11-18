package model.data_structures;


public class Vertex< K, V > {

	/**
	 * 
	 */
	private K key;

	/**
	 * 
	 */
	private V value;

	/**
	 * 
	 */
	private boolean mark;

	/**
	 * 
	 */
	private int idDelComponenete;

	/**
	 * 
	 */
	private SeparateChainingHashST<K, Edge<K,V>> edges;

	/**
	 * 
	 */
	public Vertex() {
		key = null;
		value = null;
		edges = new SeparateChainingHashST<K,Edge<K,V>>();
		mark = false;
		idDelComponenete =  0;
	}

	/**
	 * 
	 * @param pKey
	 * @param pValue
	 */
	public Vertex(K pKey, V pValue)
	{
		key = pKey;
		value = pValue;
		edges = new SeparateChainingHashST<K,Edge<K,V>>();
		mark = false;
		idDelComponenete = 0;
	}

	/**
	 * 
	 * @return
	 */
	public V getValue()
	{
		return value;
	}

	/**
	 * 
	 */
	public K getKey() {
		return key;
	}

	/**
	 * 
	 * @return
	 */
	public SeparateChainingHashST<K, Edge<K,V>> getEdges()
	{
		return edges;
	}

	/**
	 * 
	 * @param pEdge
	 */
	public void addEdge(K pKey, Edge<K,V> pEdge)
	{
		if(!edges.contains(pKey))
		{
			edges.put(pKey, pEdge);
		}
	}
	/**
	 * 
	 * @param pKey
	 * @return
	 */
	public Edge<K,V> getEdge(K pKey)
	{
		if (key == null) throw new IllegalArgumentException("argument to get() is null");
		return edges.get(pKey);
	}

	/**
	 * 
	 * @param pKey
	 */
	public void setKey(K pKey)
	{
		key = pKey;
	}

	/**
	 * 
	 * @param pValue
	 */
	public void setValue(V pValue)
	{
		value = pValue;
	}

	/**
	 * 
	 */
	public void setMark(boolean pMark)
	{
		mark = pMark;
	}

	/**
	 * 
	 */
	public boolean getMark()
	{
		return mark;
	}

	/**
	 * 
	 */
	public Iterable<K> getAdj()
	{
		Queue<K> adj = new Queue<K>();
		for(K edge: edges.keys())
		{
			adj.enqueue(edges.get(edge).darVerticeDestino().getKey());
		}

		return adj;
	}
	public Iterable<Edge> getAdj1()
	{
		Stack<Edge	> adj = new Stack<Edge>();
		for(K edge: edges.keys())
		{
			adj.push(edges.get(edge));
			
		}

		return adj;
	}
	public int getIdDelComponenete() {
		return idDelComponenete;
	}

	public void setIdDelComponenete(int idDelComponenete) {
		this.idDelComponenete = idDelComponenete;
	}

}
