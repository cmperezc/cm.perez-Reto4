package model.data_structures;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad  de  los Andes   (Bogotá - Colombia)
 * Departamento de  Ingeniería  de  Sistemas    y   Computación
 * Licenciado   bajo    el  esquema Academic Free License versión 2.1
 *      
 * Taller 8 201810 Estructura de datos sección 2 y 3
 * Autoras: Maria Ocampo y Leidy Romero 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

public interface IDirectedGraph < K, V  > {

	/** Retorna el número de vértices del grafo
	 * @return Número de vértices
	 */
	public int V();
	/** Retorna el número de arcos del grafo
	 * @return Número de arcos
	 */
	public int E();
	/**Adiciona un vértice con un Id único. El vértice tiene la información InfoVertex
	 * @param idVertex id del vértice.
	 * @param infoVertex información del vértice.
	 */
	public void addVertex(K idVertex, V infoVertex);
	/**Adiciona el arco del vertice IdVertexIni al vértice IdVertexFin. El arco tiene la información infoArc
	 * @param idVertexIni id del vértice de origen del arco.
	 * @param idVertexFin ide del vértice destino del arco.
	 * @param infoArc Información del arco
	 */
	public void addEdge(K idVertexIni, K idVertexFin, double costo);
	/** Obtener la información de un vértice
	 * @param idVertex id del vértice a buscar.
	 * @return Información del vértice encontrado.
	 */
	public V getInfoVertex(K idVertex);
	/**  Modificar la información del vértice idVertex
	 * @param idVertex
	 * @param infoVertex
	 */
	public void setInfoVertex(K idVertex, V infoVertex);
	/** Modificar la información del arco entre los vértices idVertexIni e idVertexFin
	 * @param idVertexIni
	 * @param idVertexFin
	 * @param infoArc
	 */
	public void setCostArc(K idVertexIni, K idVertexFin, double costo);
	/** Obtener la información de un arco
	 * @param idVertex
	 * @param infoVertex
	 * @return
	 */
	public double getCostArc(K idVertexIni, K idVertexFin);
	/** Retorna los identificadores de los vértices adyacentes a idVertex
	 * @param idVertex
	 * @return
	 */
	public Iterable<K> adj (K idVertex);
}
