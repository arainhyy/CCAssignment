package codingbootcamp;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		val = value;
	}
}

public class codingbootcamp {
	List<ArrayList<TreeNode>> ls;
	final int max_depth = 3;

	// show tree to check
	public void dfs(TreeNode now, int depth) {
		if (ls.size() < depth) {
			ArrayList<TreeNode> list = new ArrayList<TreeNode>();
			ls.add(list);
		}
		ls.get(depth - 1).add(now);
		if (now.left != null)
			dfs(now.left, depth + 1);
		if (now.right != null)
			dfs(now.right, depth + 1);
	}

	public List<ArrayList<TreeNode>> listOfDepths(TreeNode root) {
		if (root == null)
			return null;
		ls = new ArrayList<ArrayList<TreeNode>>();
		dfs(root, 1);
		return ls;
	}

	// find LCA ---solution to this problem
	TreeNode x, y;

	TreeNode find(TreeNode root) {
		if (root == null)
			return null;
		if (root == x || root == y)
			return root; // find at least one node, return it
		TreeNode left = find(root.left);
		TreeNode right = find(root.right);
		// find two nodes respectively on left and right subtree, then root is the LCA
		if (left != null && right != null)
			return root;
		// only find node in one subtree, means already found LCA, just return it
		return left == null ? right : left; 
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		x = p;
		y = q;
		return find(root);
	}

	// create a tree
	public void createTree(TreeNode root, int d, int now) {
		if (d >= max_depth)
			return;
		TreeNode left = new TreeNode(now);
		TreeNode right = new TreeNode(now + 1);
		root.left = left;
		root.right = right;
		createTree(left, d + 1, now + 2);
		createTree(right, d + 1, now + 4);
	}

	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();

		TreeNode root = new TreeNode(0);
		s.createTree(root, 1, 1);
		List<ArrayList<TreeNode>> list = s.listOfDepths(root);
		List<TreeNode> l;
		for (int i = 0; i < list.size(); i++) {
			l = list.get(i);
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j).val + " ");
			}
			System.out.println("\n");
		}

		System.out
				.println(s.lowestCommonAncestor(root, root, root.left.left).val);
		System.out.println(s.lowestCommonAncestor(root, root.left.right,
				root.left.left).val);
		System.out.println(s.lowestCommonAncestor(root, root.left.right,
				root.left.right).val);
		System.out.println(s.lowestCommonAncestor(root, root.left.right,
				root.right.left).val);
	}
}
