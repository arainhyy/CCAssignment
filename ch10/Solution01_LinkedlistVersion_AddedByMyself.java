package codingbootcamp;

class ListNode {
	int data;
	ListNode next;
	ListNode (int val) {
		data = val;
		next = null;
	}
}

public class codingbootcamp {
	
	public static ListNode mergeSorted (ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.data < l2.data) {
			l1.next = mergeSorted(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeSorted(l1, l2.next);
			return l2;
		}
	}
	
	
	public static void main(String[] args) {
       ListNode l1 = new ListNode(1);
       ListNode l2 = new ListNode(2);
       l1.next = new ListNode(9);
       l2.next = new ListNode(7);
       ListNode ans = mergeSorted(l1, l2);
       
       while (ans != null) {
    	   System.out.println(ans.data);
    	   ans = ans.next;
       }
    }
}