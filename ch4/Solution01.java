package codingbootcamp;

import java.util.*;

class DirectedGraphNode {
	int value;
	List<DirectedGraphNode> neighbors;

	DirectedGraphNode(int val) {
		value = val;
		List<DirectedGraphNode> neighbors = new ArrayList<DirectedGraphNode>();
	}
}

public class codingbootcamp {
	public DirectedGraphNode target; // the target node
	int flag;	// if find target, set flag = 0

	public void dfs(DirectedGraphNode now) {
		if (flag == 1) {
			if (now == target) {
				flag = 0;
				return;
			}
			if (now.neighbors == null)
				return;
			List<DirectedGraphNode> ls = now.neighbors;
			int len = ls.size();
			for (int i = 0; i < len; i++) {
				dfs(ls.get(i));
			}
		}
	}
	// DFS or BFS are all ok, BFS maybe faster in some cases
	public boolean routeBetweenNodes(DirectedGraphNode begin, DirectedGraphNode end) {
		target = end;
		flag = 1;
		dfs(begin);
		if (flag == 1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		DirectedGraphNode root = new DirectedGraphNode(1);
		List<DirectedGraphNode> ls = new ArrayList<DirectedGraphNode>();
		for (int i = 6; i > 1; i--) {
			ls.add(new DirectedGraphNode(i));
		}
		root.neighbors = ls;
		List<DirectedGraphNode> ls2 = new ArrayList<DirectedGraphNode>();
		for (int i = 10; i > 6; i--) {
			ls2.add(new DirectedGraphNode(i));
		}
		root.neighbors.get(3).neighbors = ls2;

		List<DirectedGraphNode> ls3 = new ArrayList<DirectedGraphNode>();
		for (int i = 15; i > 10; i--) {
			ls3.add(new DirectedGraphNode(i));
		}
		root.neighbors.get(3).neighbors.get(0).neighbors = ls3;

		System.out.println(s.routeBetweenNodes(root, root.neighbors.get(2)));
		System.out.println(s.routeBetweenNodes(root,
				root.neighbors.get(3).neighbors.get(0).neighbors.get(3)));
		System.out.println(s.routeBetweenNodes(root.neighbors.get(3), root));
	}
}
