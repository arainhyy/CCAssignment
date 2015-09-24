package codingbootcamp;

import java.util.*;

class QueueViaStacks {
	// when one need to push an element, store in "in" stack
	// when one need to remove or peek an element, find it in "out" stack
	// transfer between two stacks help to implement FIFO queue
	Stack <Integer> in = new Stack <Integer> ();
	Stack <Integer> out = new Stack <Integer> ();
	
	public boolean isEmpty() {
		if (in.isEmpty() && out.isEmpty()) return true;
		else return false;
	}
	
	public void add(int value) {
		in.add(value);
	}
	
	public int remove() {
		if (out.isEmpty() && in.isEmpty()) throw new RuntimeException();
		if (out.isEmpty() && !in.isEmpty()) {
			while (!in.isEmpty()) {
				out.add(in.pop());
			}
		}
		return out.pop();
	}
	
	public int peek() {
		if (out.isEmpty() && in.isEmpty()) throw new RuntimeException();
		if (out.isEmpty() && !in.isEmpty()) {
			while (!in.isEmpty()) {
				out.add(in.pop());
			}
		}
		return out.peek();
	}
}

public class codingbootcamp {
	public static void main(String[] args) {
		QueueViaStacks q = new QueueViaStacks();
		for (int i=0; i<11; i++) {
			q.add(i);
		}
		System.out.println(q.peek());
		q.remove();
		q.add(100);
		System.out.println(q.peek());
		for (int i=0; i<9; i++) q.remove();
		System.out.println(q.peek());
		
		q.remove();
		System.out.println(q.peek());
		q.remove();
		
	}
}
