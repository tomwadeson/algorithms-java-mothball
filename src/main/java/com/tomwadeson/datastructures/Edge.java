package com.tomwadeson.datastructures;

import java.util.Arrays;
import java.util.List;

public class Edge<T> {
	
	public final T from;
	public final T to;
	
	public Edge(T from, T to) {
		this.from = from;
		this.to = to;
	}
	
	public List<T> toList() {
		return Arrays.asList(from, to);
	}
}