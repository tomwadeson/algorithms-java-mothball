package datastructures.graphs;

import java.util.*;
import java.util.Map.Entry;

public class Graph<T> {

	private final Map<T, Set<T>> adjacencyList;
	
	public Graph() {
		adjacencyList = new HashMap<>();
	}
	
	public Graph(List<T> edges) {
		this();
		addEdges(edges);
	}

	private void addEdges(List<T> edges) {
		if (edges.size() % 2 == 1)
			throw new IllegalArgumentException("To create edges, vertices should be supplied in pairs");
		
		for (int i = 0; i < edges.size(); i += 2)
			addEdge(edges.get(i), edges.get(i+1));
	}
	
	public void addEdge(T v1, T v2) {
		initialiseVertex(v1);
		initialiseVertex(v2);
		
		adjacencyList.get(v1).add(v2);
	}

	private void initialiseVertex(T vertex) {
		if (!adjacencyList.containsKey(vertex))
			adjacencyList.put(vertex, new LinkedHashSet<T>());
	}

	public Set<T> getVertices() {
		return adjacencyList.keySet();
	}
	
	public Set<Edge<T>> getEdges() {
		Set<Edge<T>> edges = new LinkedHashSet<>();
		
		for (Entry<T, Set<T>> e : adjacencyList.entrySet()) {
			for (T w : e.getValue()) {
				edges.add(new Edge<T>(e.getKey(), w));
			}
		}
		
		return edges;
	}
	
	public Set<T> getAdjacentVertices(T vertex) {
		return adjacencyList.getOrDefault(vertex, Collections.emptySet());
	}
	
	public Set<T> depthFirstSearch(T vertex) {
		Set<T> visited = new LinkedHashSet<>();
		
		Stack<T> stack = new Stack<>();
		stack.push(vertex);
		
		while(!stack.isEmpty()) {
			T v = stack.pop();
			
			if (!visited.contains(v)) {
				visited.add(v);
				
				// Reversing the order of adjacent vertices to 
				// effect a pre-order traversal of the graph
				for (T w : reverse(getAdjacentVertices(v)))
					stack.push(w);
			}
		}
		
		return visited;
	}
	
	private List<T> reverse(Set<T> vertices) {
		List<T> l = new ArrayList<>(vertices);
		Collections.reverse(l);
		return l;
	}
	
	public Set<T> breadthFirstSearch(T vertex) {
		Set<T> visited = new LinkedHashSet<>();
		
		Queue<T> queue = new LinkedList<>();
		queue.add(vertex);
		
		while (!queue.isEmpty()) {
			T v = queue.remove();
			
			if (!visited.contains(v)) {
				visited.add(v);
				
				for(T w : getAdjacentVertices(v))
					queue.add(w);
			}
		}
		
		return visited;
	}
}