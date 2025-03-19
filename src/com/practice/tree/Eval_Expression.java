package com.practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class Eval_Expression {
	private static boolean isOperand(String data) {
		Set<String> operatots = new HashSet<>(Arrays.asList("+","-","*","%","/"));
		return operatots.contains(data);	
	}
	private static int compute(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left ==null && root.left == null) {
			return Integer.parseInt(root.data);
		}
		 
		int l_val = compute(root.left);
		
		int r_val = compute(root.right);
		if(root.data.equals("+"))
			return l_val + r_val;
	    
		if(root.data.equals("-"))
			return l_val - r_val;
		
		if(root.data.equals("*"))
			return l_val * r_val;
		
		if(root.data.equals("%")) {
			return l_val % r_val;
		}
		
		return l_val/r_val;
		
	}
	public static void main(String[] args) {
       TreeNode root = new TreeNode("+");
       root.left = new TreeNode("*");
       root.left.left = new TreeNode("5");
       root.left.right = new TreeNode("4");
       
       root.right = new TreeNode("-");
       root.right.left = new TreeNode("100");
       root.right.right = new TreeNode("20");
       
       int ans = compute(root);
       System.out.println(ans);
       
       
       TreeNode root1 = new TreeNode("+");
       root1.left = new TreeNode("*");
       root1.left.left = new TreeNode("5");
       root1.left.right = new TreeNode("4");
       
       root1.right = new TreeNode("-");
       root1.right.left = new TreeNode("100");
       root1.right.right = new TreeNode("/");
       root1.right.right.left = new TreeNode("20");
       root1.right.right.right = new TreeNode("2");
       
       System.out.println(compute(root1));
       
       String number = "";
       for(int i=1;i<=3;i++){
           number += (char)('0'+i);
       }
       
       List<String> result = new ArrayList<>();
       boolean visited[] = new boolean[number.length()];
       sequence(number,result, new ArrayList<>(),visited);
       for(String s:result)
    	   System.out.println(s);
       
	}
	
	private static void sequence(String number, List<String> ans, List<Character> curr, boolean visited[]) {
		if(curr.size() == number.length()) {
			String s = "";
			for(char ch : curr)s+=ch;
			ans.add(s);
			return;
		}
		
		for(int i=0;i<number.length();i++) {
			if(!visited[i]) {
				visited[i] = true;
				curr.add(number.charAt(i));
				sequence(number, ans, curr, visited);
				visited[i]=false;
				curr.remove(curr.size()-1);
			}
		}
		
	}
	
}
