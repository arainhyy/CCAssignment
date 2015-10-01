package codingbootcamp;

class TreeNode {
	int val;
	int num;
	TreeNode left, right;
	TreeNode(int value) {
		val = value; num = 1;
	}
}

class Tree {
	TreeNode head;
	
	public void insertNode(TreeNode pre, TreeNode now, int val) {
		if (now == null) {
			now = new TreeNode(val);
			if (pre == null) {
				head = now;
				return;
			}
			if (val < pre.val) pre.left = now;
			if (val > pre.val) pre.right = now;
		}
		else if (now.val > val) insertNode(now, now.left, val);
		else if (now.val < val) insertNode(now, now.right, val);
		else {
			now.num++;
		}
	}
	
	public int getRank(TreeNode now, int value, int num_sum){
		if (now == null) return 0;
		if (value < now.val) return getRank(now.left, value, num_sum);
		else if (value == now.val) return now.num - 1 + getRank(now.left, value, num_sum);
		else
			return getRank(now.left, value, num_sum) + now.num + getRank(now.right, value, num_sum);
	}
}

public class codingbootcamp {
	public static Tree tree;
	
	public static void track(int val) {
		tree.insertNode(null, tree.head, val);
	}
	
	public static int getRankOfNumber(int val) {
		return tree.getRank(tree.head, val, 0);
	}
	
	public static void main(String[] args) {
       tree = new Tree();
       track(5);
       System.out.println(getRankOfNumber(5));
       track(1);track(4);track(4);
       System.out.println(getRankOfNumber(4));
       track(5);track(9);track(7);
       System.out.println(getRankOfNumber(5));
       track(13);track(3);
       System.out.println(getRankOfNumber(1));
       System.out.println(getRankOfNumber(3));
       System.out.println(getRankOfNumber(4));
       System.out.println(getRankOfNumber(13));
    }
}