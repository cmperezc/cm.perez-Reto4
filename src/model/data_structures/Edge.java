package model.data_structures;



/**
 * Representa un arco del grafo
 * @param <K> Tipo del identificador de un vértice
 * @param <V> Tipo de datos del elemento del vértice
 * @param <A> Tipo de datos del elemento del arco
 */
public class Edge<K, V >
{
	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Vértice desde el cual sale el arco
	 */
	private Vertex<K, V> origen;

	/**
	 * Vértice hacia el cual va el arco
	 */
	private Vertex<K, V> destino;

	/**
	 * Elemento en el arco
	 */
	private double costoHaversiana;
	
	private int costoComparendos;
	
	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del arco
	 * @param pOrigen Vértice desde el cual sale el arco
	 * @param pDestino Vértice hacia donde se dirige el arco
	 * @param pInfoArco Elemento en el arco
	 */
	public Edge( Vertex<K, V> pOrigen, Vertex<K, V> pDestino, double pCosto )
	{
		origen = pOrigen;
		destino = pDestino;
		costoHaversiana = pCosto;;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve el elemento del arco
	 * @return Elemento en el arco
	 */
	public double darCosto( )
	{
		return costoHaversiana;
	}
	public int darCostoComparendos(){
		return costoComparendos;
	}

	/**
	 * Devuelve el vértice de destino del arco
	 * @return vértice de destino del arco
	 */
	public Vertex<K, V> darVerticeDestino( )
	{
		return destino;
	}

	/**
	 * Devuelve el vértice de origen del arco
	 * @return vértice de origen del arco
	 */
	public Vertex<K, V> darVerticeOrigen( )
	{
		return origen;
	}

	
	/**
	 * 
	 * @param info
	 */
	public void setCosto(double Pcosto)
	{
		costoHaversiana = Pcosto;
	}
	public void setCostoComparendo(int pComparendo){
		costoComparendos=pComparendo;
	}
}
