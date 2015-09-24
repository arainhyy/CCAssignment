package codingbootcamp;

import java.util.*;

// Solution 1:  space O(2n)
//		store min values in nodes of stack
// Solution 2:  space O(n) - O(2n)
// Use another data structure ArrayList to implement a stack 
//    to store min values of the main stack.
class Stack_include_min {
	final static int SIZE = 100;
	private int top = -1;
	private int top_min = -1;
	List <Integer> min = new ArrayList <Integer> ();
	private int [] array = new int [SIZE];
	
	public boolean isFull() {
		if (top + 1 >= SIZE) return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if (top < 0) return true;
		else return false;
	}
	
	public int min_element() {
		if (min.size() == 0) throw new EmptyStackException();
		return min.get(top_min);
	}
	
	public void push(int value) {
		if (isFull()) throw new RuntimeException();
		else {
			top ++;
			array[top] = value;
			if (min.isEmpty() || value <= min_element()) {
				min.add(value);
				top_min ++;
			}
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return array[top];
	}
	
	public void pop() {
		if (isEmpty()) throw new EmptyStackException();
		if (peek() == min_element()) {
			min.remove(top); top_min --;
		}
		top --;
	}
}

public class codingbootcamp {
	public static void main(String[] args) {
		Stack_include_min stack = new Stack_include_min();
		for (int i=0; i<10; i++) {
			stack.push(10 - i);
		}
		System.out.println(stack.peek());
		System.out.println(stack.min_element());
		stack.pop();
		System.out.println(stack.peek());
		System.out.println(stack.min_element());
		for (int i=0; i<8; i++) stack.pop();
		System.out.println(stack.min_element());
		
		stack.pop();
		stack.min_element(); //check empty stack exception
	}
}
