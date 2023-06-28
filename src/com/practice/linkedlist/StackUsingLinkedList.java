package com.practice.linkedlist;

public class StackUsingLinkedList {
	private Node head;
	private int size;

	public StackUsingLinkedList() {
		this.head = null;
		this.size = 0;
	}

	private void push(int x) {
		Node newNode = new Node(x);
		if (head == null) {
			newNode.next = head;
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	private int pop() {
		if (isEmpty()) {
			System.out.println("Stack Is empty...");
			return 0;
		}
		Node x = head;
		head = head.next;
		size--;
		return x.data;
	}

	private int peek() {
		if (isEmpty()) {
			System.out.println("Stack Is empty...");
			return 0;
		}
		int x = head.data;
		return x;
	}

	boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
	int getSize()
	{
		return size;
	}
	public static void main(String[] args) {
      StackUsingLinkedList stack = new StackUsingLinkedList();
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(5);
      System.out.println(stack.peek());
      System.out.println("Poped Element "+stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      stack.push(6);
      System.out.println("Size of Stack "+stack.getSize());
	}
}
