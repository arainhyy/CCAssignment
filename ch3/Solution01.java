package codingbootcamp;

import java.util.*;

class Three_stack {
	final static int SIZE = 100;
	private int [] top = {-3, -2, -1};
	private int [] array = new int [SIZE];
	
	public boolean isFull(int stack_inx) {
		if (top[stack_inx] + 3 >= SIZE) return true;
		else return false;
	}
	
	public boolean isEmpty(int stack_inx) {
		if (top[stack_inx] < 0) return true;
		else return false;
	}
	public void push(int stack_inx, int value) {
		if (isFull(stack_inx)) throw new RuntimeException();
		else {
			top[stack_inx] += 3;
			array[top[stack_inx]] = value;
		}
	}
	
	public int peek(int stack_inx) {
		if (isEmpty(stack_inx)) {
			throw new EmptyStackException();
		}
		return array[top[stack_inx]];
	}
	
	public void pop(int stack_inx) {
		if (isEmpty(stack_inx)) throw new EmptyStackException();
		else top[stack_inx] -= 3;
	}
}

public class codingbootcamp {
	
    
	public static void main(String[] args) {
		codingbootcamp s = new codingbootcamp();
		Three_stack stack = new Three_stack();
		for (int i=0; i<10; i++) {
			stack.push(0, i);
			stack.push(1, 3);
		}
		System.out.println(stack.peek(0));
		stack.pop(0);
		System.out.println(stack.peek(0));
		System.out.println(stack.peek(2)); //test empty stack exception
	}
}
