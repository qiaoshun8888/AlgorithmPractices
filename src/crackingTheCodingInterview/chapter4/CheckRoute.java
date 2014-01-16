package crackingTheCodingInterview.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import crackingTheCodingInterview.chapter4.CheckRoute.State;

public class CheckRoute {
	
	public enum State {
		Unvisited, Visited, Visiting;
	}
	
	public static boolean dfs(Graph g, Node start, Node end) {
		Stack<Node> s = new Stack<Node>();
		
		if (start == end) return true;
		
		s.push(start);
		
		while(!s.isEmpty()) {
			Node n = s.pop();
			if (n != null) {
				n.state = State.Visited;
				for (Node v : n.getAdjacent()) {
					if (end == v) return true;
					if (v.state == State.Unvisited) s.push(v);
				}
			}
		}
		return false;
	}
	
	public static boolean dfs_R(Node start, Node end) {
		start.state = State.Visited;
		if (start == end) return true;
		for (Node n : start.getAdjacent()) {
			if (n.state == State.Unvisited) {
				return dfs_R(n, end);
			}
		}
		return false;
	}
	
	public static boolean bfs(MGraph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		
		for (Node u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		Node n;
		
		while(!q.isEmpty()) {
			n = q.removeFirst(); // dequeue()
			if (n != null) {
				for (Node v : n.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end) {
							return true;
						}
						v.state = State.Visiting;
						q.add(v);
					}
				}
				n.state = State.Visited;
			}
		}
		
		return false;
	}
	
	public static void main(String [] args) {
		
	}
}

class MGraph extends Graph {
	
	public MGraph(Graph G) {
		super(G);
	}

	public ArrayList<Node> getNodes() {
		return null;
	}
}

class Node {
	State state;

	public ArrayList<Node> getAdjacent() {
		return null;
	}
}