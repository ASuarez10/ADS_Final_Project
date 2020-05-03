package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphAlgorithms<T> {
	
	//Attributtes
	
	//Constructor Method
	
	public GraphAlgorithms(){
		
	}
	
	/**
	 * Performs a breadth-first search to traverse a graph
	 * @param <T> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param node Vertex where it's going to start the BFS
	 * @return A list with a resultant order due to a BFS
	 */
	
	public static <T> List<T> bfs(IGraph<T> g, T node){
		return traversal(g, node, new Queue<T>());
	}
	
	/**
	 * Performs a depth-first search to traverse a graph
	 * @param <T> Abstract data type that represent a vertex within the graph
	 * @param g Graph which is going to be traversed
	 * @param v Vertex where it's going to start the DFS
	 * @return A list with a resultant order due to a DFS
	 */
	
	public static <T> List<T> dfs (IGraph<T> g, T node){
		return traversal(g, node, new Stack<T>());
	}
	
	/**
	 * This method will traverse the graph given a data structure. This will perform  BFS or DFS, given the case.
	 * @param g The graph to be traversed.
	 * @param node The vertex from which the traversal will begin.
	 * @param ds The data structure to be used in this traversal. Either a Stack for a DFS or a Queue for BFS.<br>
	 * <pre> ds Must be empty.
	 * @return A List with the resulting traversal performed on the given graph from the given vertex.
	 */
	
	private static <T> List<T> traversal(IGraph<T> g, T node, ICollection<T> ds){
		List<T> trav = new ArrayList<>();
		//Invariant: Each algorithm adds the given element first. 
		T vertex = node;
		ds.add(vertex);
		boolean[] visited = new boolean[g.getVertexSize()];
		//Invariant: While the traversal occurs, the given DS to be used will have, at least, one element.
		while(!ds.isEmpty()) {
			 //Invariant: Element added is always retired from the DS
			vertex = ds.poll();
			int indexV = g.getIndex(vertex);
			if(!visited[indexV]) {
				trav.add(vertex);
				visited[indexV] = true;
				List<T> adjacents = g.vertexAdjacent(vertex);
				ds.addAll(adjacents);
			}
		}
		return trav;
	}
	
	public static <T> int prim(T node, IGraph<T> graph){
		double[][] weights = graph.weightMatrix();
		int n = graph.getVertexSize();
		int index = graph.getIndex(node);
		int minLength = 0;
		int z;
		double min;
		double[] cost = new double[n];
		int[] closer = new int[n];
		boolean[] W = new boolean[n];
		for (int i = 0; i < n; i++) {
			W[i] = false;
		}
		W[index] = true;
		for (int i = 0; i < n; i++) {
			if (i != index) {
				cost[i] = weights[index][i];
				closer[i] = 0;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i != index) {
				min = cost[1];
				z = 1;
				for (int j = 0; j < n; j++) {
					if (j != index) {
						if (cost[j] < min) {
							min = cost[j];
							z = j;
						}
					}
				}
				minLength += min;
				W[z] = true;
				cost[z] = Integer.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if (j != index) {
						if (weights[z][j] < cost[j] && !W[j]) {
							cost[j] = weights[z][j];
							closer[j] = z;
						}
					}
				}
			}
		}
		return minLength;
	}
	
	public static <T> ArrayList<Edge<T>> kruskal(IGraph<T> g){
		List<Edge<T>> result = new ArrayList<Edge<T>>(); // This will store the resultant MST
		int e = 0; // An index variable, used for result[]
		int i = 0; // An index variable, used for sorted edges

		List<Edge<T>> edges = (ArrayList<Edge<T>>) g.getEdges();

		// Step 1: Sort all the edges in non-decreasing order of their
		// weight. If we are not allowed to change the given graph, we
		// can create a copy of array of edges
		Collections.sort(edges);

		UnionFind uf = new UnionFind(g.getVertexSize());

		i = 0; // Index used to pick next edge

		// Number of edges to be taken is equal to V-1
		while (e < g.getVertexSize() - 1 && i < edges.size()) {
			// Step 2: Pick the smallest edge. And increment
			// the index for next iteration
			Edge<T> edge = edges.get(i);
			i++;

			int x = uf.find(g.getIndex(edge.getSource()));
			int y = uf.find(g.getIndex(edge.getDestination()));

			// If including this edge does't cause cycle,
			// include it in result and increment the index
			// of result for next edge
			if (x != y) {
				result.add(edge);
				e++;
				uf.union(x, y);
			}
			// Else discard the edge
		}
		return (ArrayList<Edge<T>>) result;
	}

}
