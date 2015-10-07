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
	final int max_depth = 5;
	boolean flag;

	public void dfs(TreeNode now, long min, long max) {
		if (flag == true) {
			if (now.val <= min || now.val >= max) {
				flag = false;
				return;
			}
			if (now.left != null)
				dfs(now.left, min, now.val);
			if (now.right != null)
				dfs(now.right, now.val, max);
		}
	}

	// Problem 4.5
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		flag = true;
		// need to take care of the corner input, use dfs to check if the value
		// 	of every node is legal
		dfs(root, (long) Integer.MIN_VALUE - 1, (long) Integer.MAX_VALUE + 1);
		return flag;
	}

	public void createTree(TreeNode root, int d, int now) {
		if (d >= max_depth)
			return;
		TreeNode left = new TreeNode(now);
		TreeNode right = new TreeNode(now + 1);
		root.left = left;
		root.right = right;
		createTree(left, d + 1, now + 2);
		createTree(right, d + 1, now + 2);
	}

	// Problem 4.2
	public TreeNode createBSTminimumHight(TreeNode root, int[] array,
			boolean isLeft, int left, int right) {
		if (right < left)
			return null;

		int inx = (right + left) / 2;

		TreeNode one = new TreeNode(array[inx]);
		if (root != null) {
			if (isLeft == true)
				root.left = one;
			else
				root.right = one;
		}

		createBSTminimumHight(one, array, true, left, inx - 1);
		createBSTminimumHight(one, array, false, inx + 1, right);
		return one;
	}

	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();

		TreeNode root = new TreeNode(0);
		s.createTree(root, 1, 1);

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode BSTroot = s.createBSTminimumHight(null, a, true, 0,
				a.length - 1);

		System.out.println(s.isValidBST(BSTroot));
		System.out.println(s.isValidBST(root));
	}
}
