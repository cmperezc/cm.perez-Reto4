package model.data_structures;



import org.junit.experimental.theories.FromDataPoints;

public class DirectedGraph <K, V > implements IDirectedGraph<K, V>{
	
	private int count;
	
	/**
	 * Número de vertices del grafo
	 */
	private int V;
	/**
	 * Número de arcos del grafo
	 */
	private int E;    
	/**
	 * Tabla de hash de los vertices.
	 */
	private Bag<Edge>[] adj; 	
	private SeparateChainingHashST<K, Vertex<K,V>> vertex;

	/**
	 * Inicializa un grafo vacío.
	 */
	public DirectedGraph() {
		V = 0;
		E = 0;
		vertex = new SeparateChainingHashST<>();
		count = 0;
		   adj = (Bag<Edge>[]) new Bag[300000];
	}
	/** Retorna el número de vértices del grafo
	 * @return Número de vértices
	 */
	public int V() {
		return V;
	}
	/** Retorna el número de arcos del grafo
	 * @return Número de arcos
	 */
	public int E() {
		return E;
	}
	/**Adiciona el arco del vertice IdVertexIni al vértice IdVertexFin. El arco tiene la información infoArc
	 * @param idVertexIni id del vértice de origen del arco.
	 * @param idVertexFin ide del vértice destino del arco.
	 * @param infoArc Información del arco
	 */
	public void addEdge(K v, K w, double cost) {
		Edge<K,V> nuevo = new Edge<K, V>(vertex.get(v), vertex.get(w), cost);
		vertex.get(v).addEdge(w, nuevo);
		vertex.get(w).addEdge(v, nuevo);
		E++; //Suma el arco
		
	}
	/** Retorna los identificadores de los vértices adyacentes a idVertex
	 * @param idVertex
	 * @return
	 */
	public Iterable<K> adj(K v) {
		return vertex.get(v).getAdj();
	}
	public Iterable<Edge> adj1(K v) {
		 	return vertex.get(v).getAdj1();
	}
		/**Adiciona un vértice con un Id único. El vértice tiene la información InfoVertex
	 * @param idVertex id del vértice.
	 * @param infoVertex información del vértice.
	 */
	public void addVertex(K idVertex, V infoVertex) {
		Vertex<K,V> nuevo = new Vertex<K,V>(idVertex, infoVertex);
		vertex.put(idVertex, nuevo); //Agrega el vértice a la tabla
		adj[V]=new Bag<Edge>();
		V++; //Suma el vértice
		
	}
	/** Obtener la información de un vértice
	 * @param idVertex id del vértice a buscar.
	 * @return Información del vértice encontrado.
	 */
	public V getInfoVertex(K idVertex) {
		if(vertex.get(idVertex) != null)
			return vertex.get(idVertex).getValue();
		return null;
	}
	/**  Modificar la información del vértice idVertex
	 * @param idVertex
	 * @param infoVertex
	 */
	public void setInfoVertex(K idVertex, V infoVertex) {
		Vertex<K, V> buscado = vertex.get(idVertex);
		if(buscado != null)
			vertex.get(idVertex).setValue(infoVertex);
	}
	/** Modificar la información del arco entre los vértices idVertexIni e idVertexFin
	 * @param idVertexIni
	 * @param idVertexFin
	 * @param infoArc
	 */
	public void setCostArc(K idVertexIni, K idVertexFin, double costo) {
		if(vertex.get(idVertexIni).getEdge(idVertexFin)!=null)
			vertex.get(idVertexIni).getEdge(idVertexFin).setCosto(costo);
	}
	public void setCostComparendo(K idVertexIni, K idVertexFin, int costo) {
		if(vertex.get(idVertexIni).getEdge(idVertexFin)!=null)
			vertex.get(idVertexIni).getEdge(idVertexFin).setCostoComparendo(costo);;
	}	
	/** Obtener la información de un arco
	 * @param idVertex
	 * @param infoVertex
	 * @return
	 * @throws Exception 
	 */
	public double getCostArc(K idVertexIni, K idVertexFin){
		if(vertex.get(idVertexIni).getEdge(idVertexFin)!=null)
			return vertex.get(idVertexIni).getEdge(idVertexFin).darCosto();
		return 0;
	}
	public int  ObtenerCostoCom(K idVertexIni,K idVertexFin){
		if(vertex.get(idVertexIni).getEdge(idVertexFin)!=null)
			return vertex.get(idVertexIni).getEdge(idVertexFin).darCostoComparendos();
		return 0;
	}
	
	public void uncheck() {
		for (K key: vertex.keys()) {
			vertex.get(key).setMark(false);
		}
	}
	
	public void dfs(K s) {
		if (!contains(s)) {
			throw new IllegalArgumentException("vertex no pertenece al grafo");

		}
		vertex.get(s).setMark(true);
		vertex.get(s).setIdDelComponenete(count);
        for (K w : this.adj(s)) {
            if (!vertex.get(w).getMark()) {
                dfs(w);
            }
        }

	}
	
	public int cc() {
		count = 0;
		uncheck();
		for (K key: vertex.keys()) {
			if (!vertex.get(key).getMark()) {
				dfs(key);
				count++;
			}
		}
		return count;
	}
	
	public Iterable<K> getCc(K idVertex){
		Queue<K> queue = new Queue<K>();
		int idComp = vertex.get(idVertex).getIdDelComponenete();
		for (K key: vertex.keys()) {
			if (idComp == vertex.get(key).getIdDelComponenete()) {
				queue.enqueue(key);
			}
		}
		return queue;
	}

	public Iterable<K> keys()
	{
		return vertex.keys();
	}

	public boolean contains(K pKey) {
		return vertex.get(pKey) != null ;
	}
}

