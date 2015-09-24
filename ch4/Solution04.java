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
	final int max_depth = 3;
	
	boolean flag;
    public int dfs(TreeNode root) {
    	if (root == null) return 0;
        if (flag == false) return 0;
        if (root.left == null && root.right == null) return 1;
        int left_h = dfs(root.left);
        int right_h = dfs(root.right);
        if (left_h < right_h - 1 || left_h > right_h + 1) flag = false;
        //get the height by recursion
        return Integer.max(left_h, right_h) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        flag = true;
        dfs(root);
        return flag;
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
		
		root.left.left.left = new TreeNode(100);
//		root.left.left.left.left = new TreeNode(100);
//		root.left.left.left.left.left = new TreeNode(100);
		System.out.println(s.isBalanced(root));
		
	}
}
