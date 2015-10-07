package codingbootcamp;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;

	TreeNode(int value, TreeNode par) {
		val = value;
		parent = par;
	}

	public String toString() {
		String l = (left == null) ? "null" : left.toString();
		String r = (right == null) ? "null" : right.toString();
		return val + " -> ( " + l + " , " + r + " )";
	}
}

public class codingbootcamp {
	List<ArrayList<TreeNode>> ls;
	final int max_depth = 3;

	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	int ans, sum;

	public TreeNode inorderSuccessor(TreeNode now) {
		if (now == null)
			return null;
		if (now.right != null) { // find the leftmost node of right subtree
			TreeNode go = now.right;
			while (go.left != null)
				go = go.left;
			return go;
		} else { // find the not visited parent 
			TreeNode go = now;
			TreeNode par = go.parent;
			while (par != null && par.left != go) {
				go = par;
				par = par.parent;
			}
			return par;
		}
	}

	// create a tree
	public void createTree(TreeNode root, int d, int now) {
		if (d >= max_depth)
			return;
		TreeNode left = new TreeNode(now, root);
		TreeNode right = new TreeNode(now + 1, root);
		root.left = left;
		root.right = right;
		createTree(left, d + 1, now + 2);
		createTree(right, d + 1, now + 4);
	}

	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();

		TreeNode root = new TreeNode(0, null);
		s.createTree(root, 1, 1);
		System.out.println(root.toString());

		System.out.println(s.inorderSuccessor(root));
		System.out.println(s.inorderSuccessor(root.left.left));
		System.out.println(s.inorderSuccessor(root.right));
		System.out.println(s.inorderSuccessor(root.right.right));
		System.out.println(s.inorderSuccessor(root.left.right));
	}
}