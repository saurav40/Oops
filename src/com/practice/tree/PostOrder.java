package com.practice.tree;

import java.util.Stack;

public class PostOrder {
  public static void main(String[] args) {
	     Node root = new Node(1);
	     root.left = new Node(2);
	     root.right = new Node(3);
	     root.left.left = new Node(4);
	     root.left.right = new Node(5);
	     root.left.right.left = new Node(8);
	     root.right.left = new Node(6);
	     root.right.right = new Node(7);
	     root.right.right.left = new Node(9);
	     root.right.right.right = new Node(10);
	     postOrder(root);
	     System.out.println();
	     postOrderIterative(root);
}
  //Recursive
  private static void postOrder(Node root)
  {
	  if(root==null)
		  return;
	  postOrder(root.left);
	  postOrder(root.right);
	  System.out.print(root.Data+" ");
  }
  //Using Two Stacks
  private static void postOrderIterative(Node root)
  {
	  if(root == null)
	    return;
	  
	  Stack<Node> st1 = new Stack();
	  Stack<Node> st2 = new Stack();
	  
	  st1.add(root);
	  while(!st1.isEmpty())
	  {
		  Node tmp = st1.pop();
		  st2.add(tmp);
		  if(tmp.left!=null)
		  {
			  st1.add(tmp.left);
		  }
		  if(tmp.right!=null)
		  {
			  st1.add(tmp.right);
		  }
	  }
	  
	  while(!st2.isEmpty())
	  {
		  System.out.print(st2.pop().Data+" ");
	  }
  }
  
}
