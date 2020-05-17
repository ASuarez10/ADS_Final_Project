package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class GraphAlgorithmsAMTest {
	
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
	void setUpScenary1(){
		graph = new AdjacencyMatrix<Integer>(true);
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(1, 3);
		graph.addEdge(2, 1);
		graph.addEdge(3, 2);
		graph.addEdge(2, 5);
		graph.addEdge(4, 2);
		graph.addEdge(3, 4);
	
	}
	
	@Test
	void setUpScenary2() {
		graph = new AdjacencyMatrix<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 12);
		graph.addEdge(3, 2, 7);
		graph.addEdge(3, 4, 3);
		graph.addEdge(2, 4, 15);
		graph.addEdge(2, 5, 4);
		graph.addEdge(4, 5, 6);
		
		
	}
	
	@Test
	void setUpScenary3() {
		graph = new AdjacencyMatrix<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(1, 2, 2);
		graph.addEdge(1, 3, 3);
		graph.addEdge(2, 3, 7);
		graph.addEdge(2, 4, 10);
		graph.addEdge(2, 5, 3);
		graph.addEdge(3, 4, 3);	
		graph.addEdge(4, 5, 7);
		
		
	}
	
	@Test
	void setUpScenary4() {
		graph = new AdjacencyMatrix<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(4, 5);
		
		
	}
	
	@Test
	void setUpScenary5() {
		graph = new AdjacencyMatrix<Integer>(true);
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		graph.addEdge(2, 5);
		graph.addEdge(5, 4);
		
		
	}
	
	@Test
	void setUpScenary6() {
		graph = new AdjacencyMatrix<Integer>();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(1, 2, 17);
		graph.addEdge(1, 3, 13);
		graph.addEdge(2, 3, 14);
		graph.addEdge(2, 4, 16);
		graph.addEdge(2, 5, 3);
		graph.addEdge(3, 4, 5);
		graph.addEdge(4, 5, 4);
		
		
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
	void bfsTest2() {
		setUpScenary5();
		
		assertTrue(1 == GraphAlgorithms.bfs(graph, 1).get(0));
		assertTrue(2 == GraphAlgorithms.bfs(graph, 1).get(1));
		assertTrue(3 == GraphAlgorithms.bfs(graph, 1).get(2));
		assertTrue(4 == GraphAlgorithms.bfs(graph, 1).get(3));
		assertTrue(5 == GraphAlgorithms.bfs(graph, 1).get(4));
		
		
	}
	
	@Test
	void dfsTest() {
		setUpScenary1();
		
		//Hace el bfs correcto, pero mantiene la secuencia en orden ascendente sin importar que se haya saltado uno menor a el
		assertTrue(1==GraphAlgorithms.dfs(graph, 1).get(0));
		assertTrue(3==GraphAlgorithms.dfs(graph, 1).get(1));
		assertTrue(4==GraphAlgorithms.dfs(graph, 1).get(2));
		assertTrue(2==GraphAlgorithms.dfs(graph, 1).get(3));
		assertTrue(5==GraphAlgorithms.dfs(graph, 1).get(4));
		
		
	}
	
//	@Test
//	void dfsTest2() {
//		setUpScenary4();
//		
//		assertTrue(1==GraphAlgorithms.dfs(graph, 1).get(0));
//		assertTrue(3==GraphAlgorithms.dfs(graph, 1).get(1));
//		assertTrue(2==GraphAlgorithms.dfs(graph, 1).get(2));
//		assertTrue(5==GraphAlgorithms.dfs(graph, 1).get(3));
//		assertTrue(4==GraphAlgorithms.dfs(graph, 1).get(4));
//		
//		
//	}
	
	@Test
	void primTest() {
		setUpScenary2();
		
		assertTrue(15 == GraphAlgorithms.prim(1, graph));
		
		
	}
	
	@Test
	void primTest2() {
		setUpScenary3();
		
		assertTrue(11 == GraphAlgorithms.prim(1, graph));
		
		
	}
	
	@Test
	void kruskalTest() {
		//Toma las aristas de menor a mayor peso con sus vertices de origen menor a llegada mayor.
		setUpScenary2();
		assertEquals(15, GraphAlgorithms.prim(1, graph));
		List<Edge<Integer>> edges1 = GraphAlgorithms.kruskal(graph);
		
		int totalW = 0;
		Edge<Integer> e1 = edges1.get(0);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(1)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(2)));
		assertEquals(e1.getWeight(), 2);
		totalW+= e1.getWeight();
		
		e1 = edges1.get(1);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(3)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(4)));
		assertEquals(e1.getWeight(), 3);
		totalW+= e1.getWeight();
		
		e1 = edges1.get(2);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(2)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(5)));
		assertEquals(e1.getWeight(), 4);
		totalW+= e1.getWeight();
		
		e1 = edges1.get(3);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(4)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(5)));
		assertEquals(e1.getWeight(), 6);
		totalW+= e1.getWeight();
		
		assertTrue(totalW == GraphAlgorithms.prim(1, graph));
		
	}
	
	@Test
	void kruskalTest2() {
		
		setUpScenary3();
		assertEquals(11, GraphAlgorithms.prim(1, graph));
		List<Edge<Integer>> edges1 = GraphAlgorithms.kruskal(graph);
		
		int totalW = 0;
		Edge<Integer> e1 = edges1.get(0);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(1)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(2)));
		assertEquals(e1.getWeight(), 2);
		totalW+= e1.getWeight();
		
		e1 = edges1.get(1);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(1)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(3)));
		assertEquals(e1.getWeight(), 3);
		totalW+= e1.getWeight();
		
		e1 = edges1.get(2);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(2)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(5)));
		assertEquals(e1.getWeight(), 3);
		totalW+= e1.getWeight();
		
		e1 = edges1.get(3);
		assertEquals(e1.getSource(), graph.search(graph.getIndex(3)));
		assertEquals(e1.getDestination(), graph.search(graph.getIndex(4)));
		assertEquals(e1.getWeight(), 3);
		totalW+= e1.getWeight();
		
		assertTrue(totalW == GraphAlgorithms.prim(1, graph));
		
	}
	
	@Test
	
	void dijkstraTest() {
		setUpScenary6();
		GraphAlgorithms.dijkstra(1, graph, 0);
		assertTrue(68.0 == (GraphAlgorithms.getCost()[0] + GraphAlgorithms.getCost()[1] + GraphAlgorithms.getCost()[2] 
				+ GraphAlgorithms.getCost()[3] + GraphAlgorithms.getCost()[4]));
		
		System.out.println("1." + GraphAlgorithms.getCost()[0] + "\n2." + GraphAlgorithms.getCost()[1] + "\n3." +GraphAlgorithms.getCost()[2] +
				"\n4." + GraphAlgorithms.getCost()[3] + "\n5." +GraphAlgorithms.getCost()[4]);
	}
}
