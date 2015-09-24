package codingbootcamp;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int value) {
		val = value;
	}
	
	public String toString() {
        String l = (left == null) ? "null" : left.toString();
        String r = (right == null) ? "null" : right.toString();
        return val + " -> ( " + l + " , " + r + " )";
    }
}

public class codingbootcamp {
	List <ArrayList <TreeNode>> ls;
	final int max_depth = 3;
	
	Map <Integer, Integer> mp = new HashMap <Integer, Integer> ();
	int ans, sum;
	public void dfs(TreeNode now, int pre_sum) {
		if (now == null) return;
		int now_sum = pre_sum + now.val;
		if (mp.containsKey(now_sum - sum)) 
			ans += mp.get(now_sum - sum);
		
		if (mp.containsKey(now_sum)) mp.put(now_sum, mp.get(now_sum) + 1);
		else mp.put(now_sum, 1);
		if (now.left != null) dfs(now.left, now_sum);
		if (now.right != null) dfs(now.right, now_sum);
		mp.put(now_sum, mp.get(now_sum) - 1);
	}
	public int pathsWithSum(TreeNode root, int sum) {
		ans = 0;
		this.sum = sum;
		mp.put(0, 1);
		dfs(root, 0);
		return ans;
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
		System.out.println(root.toString());
		
		System.out.println(new codingbootcamp().pathsWithSum(root, 4));
	}
}
