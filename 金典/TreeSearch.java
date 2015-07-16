package JinDian;

import java.util.LinkedList;

import Package17.Node;

/**
 * 数的广度邮箱遍历
 * @author wangpeng
 *
 */


public class TreeSearch {
	
	public enum State{
		Unvisited,Visited,Visiting;
	}
	
	public static boolean search(Graph g, Node start,Node end){
		LinkedList<Node> q = new LinkedList<Node>();
		
		for(Node u : g.getNodes()){
			u.state = State.Unvisited;
		}
		
		q.add(start);
		while(!q.isEmpty()){
			Node u = q.removeFirst();
			for(Node v :  u.getAdjacent()){
				if(v.state == State.Unvisited){
					if(v == end)
						return true;
					else{
						v.state = State.Visiting;
						q.add(v);
					}
				}
			}
			
			u.state = State.Visited;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
