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
}