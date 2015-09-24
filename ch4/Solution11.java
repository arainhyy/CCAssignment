package codingbootcamp;

import java.util.*;

class TreeNode {
    public int val;
    public int size;
    public TreeNode left, right;
    
    TreeNode(int val) { this.val = val; size = 1;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.size = 1;
    }
    
    public TreeNode getRandomNode() {
    	Random random = new Random();
    	int inx = random.nextInt(size);
    	int left_size = (left == null) ? 0 : left.size;
    	if (inx < left_size) return left.getRandomNode();
    	else if (inx == left_size) return this; 
    	else return right.getRandomNode();
    }
    
    public TreeNode find(int d) {
    	if (d == val) return this;
    	if (d < val) {
    		return left == null ? null : left.find(d);
    	} 
    	else {
    		return right == null ? null : right.find(d);
    	}
    }
    
    public void insert(int x) {
        size ++;
        if (x < val) {
            if (left != null) left.insert(x);
            else left = new TreeNode(x);
        } else {
            if (right != null) right.insert(x);
            else right = new TreeNode(x);
        }
    }

    public String toString() {
        String l = (left == null) ? "null" : left.toString();
        String r = (right == null) ? "null" : right.toString();
        return val + " -> ( " + l + " , " + r + " )";
    }
}

public class codingbootcamp {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.insert(2);
        root.insert(1);
        root.insert(3);
        root.insert(6);
        root.insert(5);
        root.insert(7);
        
        String treeString = root.toString();
        System.out.println(root.toString());
        
        System.out.println(root.getRandomNode().val);
        System.out.println(root.getRandomNode().val);
        System.out.println(root.getRandomNode().val);
        
    }
}
