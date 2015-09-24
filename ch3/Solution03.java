package codingbootcamp;

import java.util.*;

class SetOfStacks {
	final static int stack_threshold = 5;
	private List <Stack <Integer>> st = new ArrayList<Stack <Integer>> ();
	
	public void push(int value) {
		System.out.println(st.size());
		if (st.isEmpty() || st.get(st.size() - 1).size() >= stack_threshold) {
			st.add(new Stack <Integer> ());
		}
		st.get(st.size() - 1).add(value);
	}
	
	public void pop() {
		Stack <Integer> one;
		int i = 1;
		// need to find the 1st nonempty stack
		//	because pop operation can make some stacks empty
		do {
			one = st.get(st.size() - i ++);
		} while (one.size() == 0);
		one.pop();
	}
	
	public int peek() {
		Stack <Integer> one;
		int i = 1;
		do {
			one = st.get(st.size() - i ++);
		} while (one.size() == 0);
		return one.peek();
	}
}

public class codingbootcamp {
	public static void main(String[] args) {
		SetOfStacks stack = new SetOfStacks();
		for (int i=0; i<11; i++) {
			stack.push(i);
		}
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		for (int i=0; i<8; i++) stack.pop();
		System.out.println(stack.peek());
	}
}
