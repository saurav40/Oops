package com.practice.graph;

import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
         char [][]board = {{'_','_','_'},{'_','_','_'},{'_','_','_'}
         };
         //char turn = '*';
         boolean turnA=true;
         boolean turnB=false;
         
         int cnt=0;
         System.out.println("*********[ TIC TAC TOE ]*********");
         Scanner in = new Scanner(System.in);
         while(true)
         {
        	 for(int i=0;i<3;i++) {
        		 System.out.print("   "+i);
        	 }
        	 System.out.println();
        	 for(int i=0;i<3;i++) {
        		 System.out.print(i+" ");
        		 for(int j=0;j<3;j++)
        		 {
        			 System.out.print(" "+board[i][j]+" ");
        		 }
        		 System.out.println();
        	 }
        	System.out.println();
        	System.out.println("Enter row and column for your Turn");
        	int row = in.nextInt();
        	int col = in.nextInt();
        	if(row<0 && row >2 && col <0 && col >2) {
        		System.out.println("Please Enter valid row and column..");
        		//continue;
        	}
        	else if(board[row][col]=='_')
        	{
        		if(turnA) {
        		 board[row][col] = '*';
        		 turnA=false;
        		 turnB=true;
        		}
        		else if(turnB)
        		{
        		 board[row][col] = 'o';
           		 turnA=true;
           		 turnB =false;	
        		}
        		
        	    cnt++;
        		//check winner
        		if(checkWinner(board[row][col],board))
        		{
        			System.out.println("The player choosen "+ board[row][col] +",won");
        			break;
        		}
        		//Draw
        		if(cnt==9)
        		{
        			System.out.println("Draw");
        			break;
        		}
        		
        	}
        	else
        		System.out.println("Enter valid row & column");
        	
         }
	}
   private static boolean checkWinner(char player,char[][] board)
   {
	   for (int i = 0; i < 3; i++) {
           if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
               return true;
           }
       }

       // Check columns
       for (int j = 0; j < 3; j++) {
           if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
               return true;
           }
       }

       // Check diagonals
       if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
           return true;
       }

       return false;
   }
}
