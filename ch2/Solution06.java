package codingbootcamp;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
	//time O(n) space O(1)
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode go = head;
        ListNode mid = head;
        while (go.next != null && go.next.next != null) {
            go = go.next.next;
            mid = mid.next;
        }
        mid = mid.next; //get the [round(l/2) + 1]th node
        
        //reverse the half back linked list
        ListNode pre = null; 
        ListNode now = mid;
        go = now.next;
        mid.next = null; //don't forget cut operation
        while (go != null) {
            pre = now;
            now = go;
            go = go.next;
            now.next = pre;
        }
        
        //compare two parts
        go = head;
        while (now != null) {
            if (now.val != go.val) return false;
            go = go.next;
            now = now.next;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// build linked list
		int [] a = {1,4,3,3,4,1};
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
		
		// run function and output
		codingbootcamp s = new codingbootcamp();
		
		System.out.println(s.isPalindrome(head));
		System.out.println(s.isPalindrome(head.next));
	}

}
