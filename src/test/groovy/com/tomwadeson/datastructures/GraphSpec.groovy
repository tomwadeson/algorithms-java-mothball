package com.tomwadeson.datastructures

import spock.lang.*

class GraphSpec extends Specification {
	
	void "graphs should be instantiated without existing vertices or edges"() {
		given:
		def graph = new Graph()
		
		expect:
		graph.getVertices().isEmpty()
		graph.getEdges().isEmpty()
	}
	
	void "graphs can be instantiated with lists whose pairs represent edges"() {
		given:
		def edges = [1, 2, 1, 3]
		
		when:
		def graph = new Graph(edges)
		
		then:
		graph.getVertices() as List == [1, 2, 3]
		graph.getEdges().collect { edge -> edge.toList() }.flatten() == [1, 2, 1, 3]
	}
	
	void "graphs instantiated with odd edges will throw an exception"() {
		given:
		def edges = [1, 2, 3]
		
		when:
		def graph = new Graph(edges)
		
		then:
		thrown(IllegalArgumentException)
	}
	
	void "vertices should be implicitly created when creating new edges"() {
		given:
		def graph = new Graph()
		
		when:
		graph.addEdge(1, 2)
		graph.addEdge(1, 3)
		
		then:
		graph.getVertices() as List == [1, 2, 3]
		graph.getEdges().size() == 2
	}
	
	void "graphs should be able to be queried for their set of edges"() {
		given:
		def graph = new Graph()
		
		when:
		graph.addEdge(1, 2)
		graph.addEdge(1, 3)
		
		then:
		graph.getEdges().collect { edge -> edge.toList() }.flatten() == [1, 2, 1, 3]
	}
	
	void "should return a vertex's adjacent vertices"() {
		given:
		def edges = [1, 2, 1, 3]
		def graph = new Graph(edges)
		
		when:
		def adjacentVertices = graph.getAdjacentVertices(from)
		
		then:
		adjacentVertices as List == expected
		
		where:
		from || expected
		1    || [2, 3]
		2    || []
		3    || []
		500  || []
	}
	
	void "should return a set as a list with its elements reversed based on insertion order"() {
		given:
		def graph = new Graph()
		
		expect:
		graph.reverse([1, 2, 3, 4, 5] as Set) == [5, 4, 3, 2, 1]
	}
	
	void "DFS should traverse graphs in the correct order"() {
		given:
		def edges = [1, 2, 1, 7, 1, 8, 2, 3, 2, 6, 3, 4, 3, 5, 8, 9, 8, 12, 9, 10, 9, 11]

		when:
		def graph = new Graph(edges)

		then:
		graph.depthFirstSearch(1) as List == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
	}
	
	void "BFS should traverse graphs in the correct order"() {
		given:
		def edges = [1, 2, 1, 3, 1, 4, 2, 5, 2, 6, 5, 9, 5, 10, 4, 7, 4, 8, 7, 11, 7, 12]

		when:
		def graph = new Graph(edges)

		then:
		graph.breadthFirstSearch(1) as List == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
	}
}