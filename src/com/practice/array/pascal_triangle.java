package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class pascal_triangle {
	static private List<Integer>  generateRow(int row)
    {
        int result = 1;
        List<Integer> ansRow = new ArrayList<>();
        int num = row-1;
        ansRow.add(result);
        for(int i=1;i<=row-1;++i)
        {
       
         result = (result * num)/i;
         System.out.println(i +" " + num+" "+result);
         ansRow.add(result);
         num--;
        }
        System.out.println(ansRow);
        return ansRow;
    }
	public static void main(String[] args) {
		generateRow(5);
	}
}
