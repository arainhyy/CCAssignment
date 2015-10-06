package cc150;

import java.util.*;

class SetOfStacks {
	final static int stack_threshold = 5;
	private List<Stack<Integer>> st = new ArrayList<Stack<Integer>>();

	public void push(int value) {
		if (st.isEmpty() || st.get(st.size() - 1).size() >= stack_threshold) {
			st.add(new Stack<Integer>());
		}
		st.get(st.size() - 1).add(value);
	}

	public int pop() {
		Stack<Integer> one;
		one = st.get(st.size() - 1); // get the last stack
		if (one.size() == 1)
			st.remove(one);
		return one.pop();
	}

	public int peek() {
		Stack<Integer> one;
		one = st.get(st.size() - 1);
		return one.peek();
	}

	// move those stack after inx, need to move the first element to its latter
	// stack
	public int popAt(int inx) {
		Stack<Integer> one;
		int now = st.size() - 1;
		int tmp;
		int post_firstone = 0; // first element of the latter stack
		while (now != inx) {
			one = st.get(now);
			tmp = one.remove(0); // remove the first element of this stack
			if (one.isEmpty()) st.remove(one);
			if (now != st.size() - 1)
				one.push(post_firstone); // push the first element of latter stack
			post_firstone = tmp;
			now--;
		}
		one = st.get(inx);
		
		tmp = one.pop();
		if (one.isEmpty()) st.remove(one);
		
		one.push(post_firstone);
		return tmp;
	}
}

public class cc150 {
	public static void main(String[] args) {
		SetOfStacks stack = new SetOfStacks();
		for (int i = 0; i < 11; i++) {
			stack.push(i);
		}
		System.out.println(stack.peek());
		stack.popAt(2);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
