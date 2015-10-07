package codingbootcamp;

import java.util.*;

class TreeNode {
	public int val;
	public boolean isVisit;
	public TreeNode left, right;

	TreeNode() {
		val = 0;
		isVisit = false;
		left = right = null;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
		isVisit = false;
	}

	public void add(int x) {
		if (x < val) {
			if (left != null)
				left.add(x);
			else
				left = new TreeNode(x, null, null);
		} else {
			if (right != null)
				right.add(x);
			else
				right = new TreeNode(x, null, null);
		}
	}

	public String toString() {
		String l = (left == null) ? "null" : left.toString();
		String r = (right == null) ? "null" : right.toString();
		return val + " -> ( " + l + " , " + r + " )";
	}
}

class Solution {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	List<TreeNode> treeNodes = new ArrayList<TreeNode>();

	public List<List<Integer>> findBSTsequences(TreeNode tree) {
		if (tree == null)
			return ans;
		getTreeNodeList(tree);
		tree.isVisit = true;
		List<Integer> tmp = new ArrayList<Integer>();
		find(tmp);
		return ans;
	}

	// build a list contains all tree nodes
	public void getTreeNodeList(TreeNode tree) {
		if (tree == null)
			return;
		treeNodes.add(tree);
		getTreeNodeList(tree.left);
		getTreeNodeList(tree.right);
	}

	public void find(List<Integer> res) {
		if (res.size() == treeNodes.size()) {
			ans.add(new ArrayList<Integer>(res));
			return;
		}
		// backtracking
		TreeNode node;
		for (int i = 0; i < treeNodes.size(); i++) {
			node = treeNodes.get(i);
			if (node.isVisit) {
				node.isVisit = false;
				if (node.left != null)
					node.left.isVisit = true;
				if (node.right != null)
					node.right.isVisit = true;
				res.add(node.val);
				find(res);
				res.remove(res.size() - 1);
				if (node.right != null)
					node.right.isVisit = false;
				if (node.left != null)
					node.left.isVisit = false;
				node.isVisit = true;
			}
		}
	}
}

public class codingbootcamp {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, null, null);
		root.add(2);
		root.add(1);
		root.add(3);
		root.add(6);
		root.add(5);
		root.add(7);
		String treeString = root.toString();
		System.out.println(root.toString());

		List<List<Integer>> ans = new Solution().findBSTsequences(root);
		System.out.println(ans.size());

		// check every possible array
		List<Integer> list;
		for (int i = 0; i < ans.size(); i++) {
			list = ans.get(i);
			TreeNode t = new TreeNode(list.get(0), null, null);
			boolean isFirst = true;
			Integer x;
			for (int j = 0; j < list.size(); j++) {
				x = list.get(j);
				System.out.print(x);
				System.out.print(" ");
				if (isFirst) {
					isFirst = false;
					continue;
				}
				t.add(x);
			}
			if (t.toString().compareTo(treeString) != 0) {
				System.out.println("Wrong");
			} else {
				System.out.println("Right");
			}
		}
	}
}
