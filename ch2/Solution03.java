package codingbootcamp;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
		
		s.deleteNode(head.next.next);
		go = head;
		while (go != null) {
			System.out.println(go.val);
			go = go.next;
		}
	}

}
