package codingbootcamp;

import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
	// time O(n) space O(n)
	public void removeDups1(ListNode h) {
		Set <Integer> s = new HashSet <Integer> ();
		ListNode inx = h;
		ListNode pre = null;
		while (inx != null) {
			if (s.contains(inx.val)) {
				pre.next = inx.next;
			}
			else {
				s.add(inx.val);
				pre = inx;
			}
			inx = inx.next;
		}
	}
	//time O(1) space O(n)
	public void removeDups2(ListNode h) {
		ListNode inx = h;
		ListNode pre = null;
		ListNode go;
		while (inx != null) {
			go = inx;
			while (go.next != null) {
				if (go.next.val == inx.val)
					go.next = go.next.next;
				//if delete, pointer go need not to change
				else go = go.next;
			}
			inx = inx.next;
		}
	}
	
	public static void main(String[] args) {
		// build linked list
		int [] a = {1,4,4,3,2,5,2};
		int [] b = {2,2,2,2,4,4,5};
		ListNode head1 = null, head2 = null;
		ListNode go1 = head1, go2 = head2;
		
		for (int i=0; i<a.length; i++) {
			ListNode one = new ListNode(a[i]);
			ListNode two = new ListNode(b[i]);
			
			if (head1 == null) {
				head1 = one; go1 = head1;
			}
			else {
				go1.next = one;
				go1 = one;
			}
			
			if (head2 == null) {
				head2 = two; go2 = head2;
			}
			else {
				go2.next = two;
				go2 = two;
			}
		}
		
		// run function and output
		codingbootcamp s = new codingbootcamp();
		
		s.removeDups2(head1);
		go1 = head1;
		while (go1 != null) {
			System.out.println(go1.val);
			go1 = go1.next;
		}
		System.out.println();
		
		s.removeDups2(head2);
		go2 = head2;
		while (go2 != null) {
			System.out.println(go2.val);
			go2 = go2.next;
		}
	}

}
