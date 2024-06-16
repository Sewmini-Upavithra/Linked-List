package LinkedList;

class Stack {
	    private class StackNode {
	        int data;
	        StackNode next;
	        StackNode(int d) {
	            data = d;
	            next = null;
	        }
	    }
	    StackNode top;
	    int size;
	    Stack() {
	        this.top = null;
	        this.size = 0;
	    }
	    public void push(int x) {
	        StackNode element = new StackNode(x);
	        element.next = top;
	        top = element;
	        System.out.println("Element pushed");
	        size++;
	    }
	    public int pop() {
	        if (top == null) return -1;
	        int topData = top.data;
	        StackNode temp = top;
	        top = top.next;
	        size--;
	        return topData;
	    }
	    public int size() {
	        return size;
	    }
	    public boolean isEmpty() {
	        return top == null;
	    }
	    public void printStack() {
	        StackNode current = top;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	}

	public class LinkedListStack {
	    public static void main(String[] args) {
	        Stack s = new Stack();
	        s.push(30);
	        s.push(40);
	        s.push(50);
	        s.printStack();
	        System.out.println("Element popped: " + s.pop());
	        s.printStack();
	        System.out.println("Stack size: " + s.size());
	        System.out.println("Stack is empty or not: " + s.isEmpty());
	        s.push(60);
	        s.push(70);
	        s.printStack();
	        System.out.println("Element popped: " + s.pop());
	        s.printStack();
	    }
	}
