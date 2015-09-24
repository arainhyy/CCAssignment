package codingbootcamp;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int value) {
		val = value;
	}
}

public class codingbootcamp {
	List <ArrayList <TreeNode>> ls;
	final int max_depth = 5;
	
	public void dfs(TreeNode now, int depth) {
		if (ls.size() < depth) {
			ArrayList <TreeNode> list = new ArrayList <TreeNode> ();
			ls.add(list);
		}
		ls.get(depth - 1).add(now);
		if (now.left != null) dfs(now.left, depth+1);
		if (now.right != null) dfs(now.right, depth+1);
	}
	
	public List <ArrayList <TreeNode>> listOfDepths(TreeNode root) {
		if (root == null) return null;
		ls = new ArrayList <ArrayList <TreeNode>> ();
		dfs(root, 1);
		return ls;
	}
	
	public void createTree(TreeNode root, int d, int now) {
		if (d >= max_depth) return;
		TreeNode left = new TreeNode(now);
		TreeNode right = new TreeNode(now + 1);
		root.left = left;
		root.right = right;
		createTree(left, d+1, now + 2);
		createTree(right, d+1, now + 2);
	}
	
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		
		TreeNode root = new TreeNode(0);
		s.createTree(root, 1, 1);
		
		List <ArrayList <TreeNode>> list = s.listOfDepths(root);
		List <TreeNode> l;
		for (int i=0; i<list.size(); i++) {
			l = list.get(i);
			for (int j=0; j<l.size(); j++) {
				System.out.print(l.get(j).val + " ");
			}
			System.out.println("\n");
		}
		
	}
}
