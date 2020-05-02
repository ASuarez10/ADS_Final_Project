package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphAlgorithmsTest {
	
	private IGraph<Integer> graph;
	
	@Test 
	void setUpScenary(){
		graph = new AdjacencyMatrix<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		graph.addVertex(9);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 5);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(5, 4);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(4, 7);
		graph.addEdge(4, 8);
		graph.addEdge(6, 7);
		graph.addEdge(6, 9);
		graph.addEdge(7, 8);
		graph.addEdge(7, 9);
		graph.addEdge(8, 9);
	}
	
	@Test
	void bfsTest() {
		setUpScenary();
		assertTrue(1 == GraphAlgorithms.bfs(graph, 1).get(0));
		assertTrue(2 == GraphAlgorithms.bfs(graph, 1).get(1));
		assertTrue(3 == GraphAlgorithms.bfs(graph, 1).get(2));
		assertTrue(5 == GraphAlgorithms.bfs(graph, 1).get(3));
		assertTrue(4 == GraphAlgorithms.bfs(graph, 1).get(4));
		assertTrue(6 == GraphAlgorithms.bfs(graph, 1).get(5));
		assertTrue(7 == GraphAlgorithms.bfs(graph, 1).get(6));
		assertTrue(8 == GraphAlgorithms.bfs(graph, 1).get(7));
		assertTrue(9 == GraphAlgorithms.bfs(graph, 1).get(8));
		
		
	}
	
	@Test
	void dfsTest() {
		
	}
	
	
}
