package codingbootcamp;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
	//time O(n) space O(1)
	public int getlen(ListNode head){
        int len = 0;
        ListNode go = head;
        while (go != null){
            len++; 
            go = go.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getlen(headA);
        int lenB = getlen(headB);
        ListNode goa = headA;
        ListNode gob = headB;
        if (lenA > lenB){
            int m = lenA - lenB;
            while (m > 0){
                m--;
                goa = goa.next;
            }
        }
        else if (lenA < lenB){
            int m = lenB - lenA;
            while (m > 0){
                m --;
                gob = gob.next;
            }
        }
        while (goa != null){
            if (goa == gob) return goa;
            goa = goa.next;
            gob = gob.next;
        }
        return null;
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
		ListNode head2 = new ListNode(9);
		head2.next = head.next.next.next;
		// run function and output
		codingbootcamp s = new codingbootcamp();
		System.out.println(s.getIntersectionNode(head, head2).val);
		
	}

}
