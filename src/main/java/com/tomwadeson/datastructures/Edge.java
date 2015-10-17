package com.tomwadeson.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Edge<T> {
	
	public final T from;
	public final T to;
	
	public Edge(T from, T to) {
		this.from = from;
		this.to = to;
	}
	
	public List<T> toList() {
		List<T> list = new ArrayList<>();
		list.add(from);
		list.add(to);
		return list;
	}
}