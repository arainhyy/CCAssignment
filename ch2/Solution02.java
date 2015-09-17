package codingbootcamp;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int inx = 0;
        ListNode go = head;
        ListNode befn = null;
        while (go != null){
            if (inx == n){
                befn = head;
            }
            else if (befn != null) befn = befn.next;
            go = go.next;
            inx ++;
        }
        if (befn == null) {
        	if (inx == n) return head.next;
        	else return head;	//if irrational input, do nothing
        }
        befn.next = befn.next.next;
        return head;
    }
	public static void main(String[] args) {
		// build linked list
		int [] a = {1,4,3,2,5,2};
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
		
		go = s.removeNthFromEnd(head, 7);
		while (go != null) {
			System.out.println(go.val);
			go = go.next;
		}
	}

}
