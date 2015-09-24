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
	final int max_depth = 3;
	
	// show tree to check
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
	public void showTree(TreeNode root) {
		List <ArrayList <TreeNode>> list = listOfDepths(root);
		List <TreeNode> l;
		for (int i=0; i<list.size(); i++) {
			l = list.get(i);
			for (int j=0; j<l.size(); j++) {
				System.out.print(l.get(j).val + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// these two functions are the solution
	public boolean checkThisSubtree(TreeNode a, TreeNode b) {
		Queue <TreeNode> qa = new LinkedList <TreeNode> ();
		qa.add(a);
		Queue <TreeNode> qb = new LinkedList <TreeNode> ();
		qb.add(b);
		TreeNode nowa,nowb;
		while (!qa.isEmpty()) {
			nowa = qa.poll();
			nowb = qb.poll();
			if (nowa.val != nowb.val) return false;
			if (nowa.left != null) {
				if (nowb.left == null) return false;
				qa.add(nowa.left);
				qb.add(nowb.left);
			} else if (nowb.left != null) return false;
			if (nowa.right != null) {
				if (nowb.right == null) return false;
				qa.add(nowa.right);
				qb.add(nowb.right);
			} else if (nowb.right != null) return false;
		}
		return true;
	}
	public boolean checkSubtree(TreeNode root, TreeNode sub_root) {
		Queue <TreeNode> q = new LinkedList <TreeNode> ();
		q.add(root);
		TreeNode now;
		while (!q.isEmpty()) {
			now = q.poll();
			if (now.val == sub_root.val) {
				if (checkThisSubtree(now, sub_root)) return true;
			}
			if (now.left != null) q.add(now.left);
			if (now.right != null) q.add(now.right);
		}
		return false;
	}
	
    // create a tree
	public void createTree(TreeNode root, int d, int now) {
		if (d >= max_depth) return;
		TreeNode left = new TreeNode(now);
		TreeNode right = new TreeNode(now + 1);
		root.left = left;
		root.right = right;
		createTree(left, d+1, now + 2);
		createTree(right, d+1, now + 4);
	}
	
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		
		TreeNode root = new TreeNode(0);
		s.createTree(root, 1, 1);
		TreeNode root2 = new TreeNode(2);
		s.createTree(root2, 2, 5);
		TreeNode root3 = new TreeNode(2);
		s.createTree(root3, 2, 3);
		s.showTree(root);
		s.showTree(root2);
		s.showTree(root3);
		
		System.out.println(s.checkSubtree(root, root.left));
		System.out.println(s.checkSubtree(root, root2));
		System.out.println(s.checkSubtree(root, root3));
	}
}
