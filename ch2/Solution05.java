package codingbootcamp;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
	// not recursive
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        int flag = 0;
        ListNode pre = null;
        ListNode ans = null;
        ListNode tmp;
        while (one != null && two != null){
            if (one.val + two.val + flag >= 10){
                tmp = new ListNode(one.val + two.val + flag - 10);
                flag = 1;
            }
            else{
                tmp = new ListNode(one.val + two.val + flag);
                flag = 0;
            }
            if (pre != null) pre.next = tmp;
            else ans = tmp;
            pre = tmp;
            one = one.next;
            two = two.next;
        }
        while (one != null){
        	if (one.val + flag >= 10){
                tmp = new ListNode(one.val + flag - 10);
                flag = 1;
            }
            else{
                tmp = new ListNode(one.val + flag);
                flag = 0;
            }
        	if (pre != null) pre.next = tmp;
            else ans = pre;
            pre = tmp;
            one = one.next;
        }
        while (two != null){
        	if (two.val + flag >= 10){
                tmp = new ListNode(two.val + flag - 10);
                flag = 1;
            }
            else{
                tmp = new ListNode(two.val + flag);
                flag = 0;
            }
        	if (pre != null) pre.next = tmp;
            else ans = pre;
            pre = tmp;
            two = two.next;
        }
        if (flag != 0){
        	tmp = new ListNode(flag);
        	pre.next = tmp;
        }
        return ans;
    }
	
	//recursive
    public ListNode add(ListNode a, ListNode b, int carry) {
        if (a == null && b == null && carry == 0) return null;
        int a_val = (a == null) ? 0 : a.val;
        int b_val = (b == null) ? 0 : b.val;
        ListNode one = new ListNode((a_val + b_val + carry) % 10);
        one.next = add((a!=null)?a.next:null, (b!=null)?b.next:null,
                   (a_val + b_val + carry)/10);
        return one;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
	
	public static void main(String[] args) {
		// build linked list
		int [] a = {1,4,4,3,2,5,2};
		int [] b = {2,2,2,2,4,4};
		ListNode head1 = null, head2 = null;
		ListNode go1 = head1, go2 = head2;
		
		for (int i=0; i<a.length; i++) {
			ListNode one = new ListNode(a[i]);
			
			if (head1 == null) {
				head1 = one; go1 = head1;
			}
			else {
				go1.next = one;
				go1 = one;
			}
		}
		for (int i=0; i<b.length; i++) {
			ListNode two = new ListNode(b[i]);

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
		
		ListNode head3 = s.addTwoNumbers1(head1, head2);
		head1 = s.addTwoNumbers2(head3, head2);
		go1 = head1;
		while (go1 != null) {
			System.out.println(go1.val);
			go1 = go1.next;
		}
	}

}
