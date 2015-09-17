package codingbootcamp;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
	// slow: L+x  fast: L+x+nc  L=nc-x 
	// need to move pointer back x
	public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast.next == null || fast.next.next == null) return null;
            else fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    
	public static void main(String[] args) {
		// build linked list
		int [] a = {1,4,3,7,4,1};
		ListNode head = null;
		ListNode go = head;
		for (int i=0; i<a.length; i++) {
			ListNode one = new ListNode(a[i]);
			if (head == null) {
				head = one; go = head;
			}
			else {
				go.next = one;
				go = one;
			}
		}
		go.next = head.next.next.next;
		// run function and output
		codingbootcamp s = new codingbootcamp();
		System.out.println(s.detectCycle(head).val);
	}

}
