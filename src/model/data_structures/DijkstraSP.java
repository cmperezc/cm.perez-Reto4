package model.data_structures;

import java.util.Iterator;

public class DijkstraSP
{
	private Edge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;
	public DijkstraSP(DirectedGraph G, int s)
	{
		edgeTo = new Edge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());
		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s] = 0.0;
		pq.insert(s, 0.0);
		while (!pq.isEmpty())
			relax(G, pq.delMin());
	}
	private void relax(DirectedGraph G, int v)
	{
		
		Stack s=(Stack) G.adj1(v);
		while(s.isEmpty()==false){
			Edge e=(Edge) s.pop();
			
			int w = (int) e.darVerticeDestino().getKey();
			if (distTo[w] > distTo[v] + e.darCosto())
			{
				distTo[w] = distTo[v] + e.darCosto();
				edgeTo[w] = e;
				if (pq.contains(w)) pq.changeKey(w, distTo[w]);
				else pq.insert(w, distTo[w]);
			}
		}
	}	
	public boolean hasPathTo(int v) {

		return distTo[v] < Double.POSITIVE_INFINITY;
	}
	public double distTo(int v)
	{ return distTo[v]; }
	
	public Iterable<Edge> pathTo(int v)
	{
		if (!hasPathTo(v)) return null;
		Stack<Edge> path = new Stack<Edge>();
		for (Edge e = edgeTo[v]; e != null; e = edgeTo[(int) e.darVerticeOrigen().getKey()]){
			
			path.push(e);}
		return path;
	}
}