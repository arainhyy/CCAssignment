package codingbootcamp;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class codingbootcamp {
    public ListNode partition(ListNode head, int x) {
        ListNode morego = null;
        ListNode more = null; //list of nodes of val >= x
        ListNode go = head;
        ListNode pre = null;
        ListNode ans = head;
        while (go != null){
            if (go.val >= x){
                if (pre != null) pre.next = go.next;
                //change
                else {
                    ans = ans.next;
                }
                //
                if (more == null){
                    more = new ListNode(go.val);
                    morego = more;
                }
                else {
                    morego.next = new ListNode(go.val);
                    morego = morego.next;
                }
            }
            else pre = go;
            go = go.next;
        }
        if (pre != null) pre.next = more;
        else ans = more;
        return ans;
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
		
		// run function
		codingbootcamp s = new codingbootcamp();
		s.partition(head, 3);
		
		// output
		go = head;
		while (go != null) {
			System.out.println(go.val);
			go = go.next;
		}
	}

}
