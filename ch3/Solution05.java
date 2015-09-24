package codingbootcamp;

import java.util.*;

public class codingbootcamp {
	
	public void sortStack(Stack <Integer> s) {
		Stack <Integer> tmp = new Stack <Integer> ();
		int num_tmp = 0;
		int one;
		Integer x;
		while (!s.isEmpty()) tmp.push(s.pop());
		
		while (!tmp.isEmpty()) {
			one = tmp.pop();
			while (!s.isEmpty()) {
				x = s.peek();
				if (x > one) {
					tmp.push(s.pop());
					num_tmp ++;
				} else break;
			}
			s.push(one);
			while (num_tmp > 0) {
				s.push(tmp.pop()); num_tmp --;
			}
		}
	}
	
	public static void main(String[] args) {
		Stack <Integer> stack = new Stack <Integer> ();
		stack.push(4); stack.push(2); stack.push(9); stack.push(0);
		new codingbootcamp().sortStack(stack);
		for (Integer x : stack) System.out.println(x);
	}
}
