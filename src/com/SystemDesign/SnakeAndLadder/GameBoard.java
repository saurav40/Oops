package com.SystemDesign.SnakeAndLadder;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


class GameBoard {
    private Dice dice;
    private Queue<Player> nextTurn;
    private List<Jumper> snakes;
    private  List<Jumper> ladders;
    private  Map<String,Integer> playersCurrentPosition;
    int boardSize;

    GameBoard(Dice dice, Queue<Player> nextTurn, List<Jumper> snakes, List<Jumper> ladders,Map<String,Integer> playersCurrentPosition,int boardSize) {
        this.dice = dice;
        this.nextTurn = nextTurn;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersCurrentPosition = playersCurrentPosition;
        this.boardSize = boardSize;
    }

     void startGame(){
    	Scanner in = new Scanner(System.in);
        while(nextTurn.size()>1) {
        	
            Player player = nextTurn.poll();
        
            int currentPosition = playersCurrentPosition.get(player.getPlayerName());
            //System.out.print(player.getPlayerName()+" Press enter to roll the dice.");
           // in.nextLine();
            int diceValue = dice.rollDice();
            //System.out.println("No came on dice: "+diceValue);
            
            int nextCell = currentPosition + diceValue;
            
            if (nextCell > boardSize) nextTurn.offer(player);
            else if (nextCell == boardSize) {
                System.out.println( player.getPlayerName() + " won the game");
            }else{
            	
               int[] nextPosition= new int[1];
               
               boolean[] b =new boolean[1];
               
               nextPosition[0]= nextCell;
               // check if snake bite
               snakes.forEach(v-> {
                   if(v.startPoint==nextCell) {
                       nextPosition[0] = v.endPoint;
                   } } );
               // If bitten by snake then 
               if(nextPosition[0] != nextCell) 
            	   System.out.println(player.getPlayerName() + " Bitten by Snake present at: "+ nextCell);
               // check if next cell has a ladder
                int ladderAt[] = new int[1];
                ladders.forEach(v-> {
                    if(v.startPoint==nextPosition[0]) {
                    	ladderAt[0] = nextPosition[0];
                        nextPosition[0] = v.endPoint;
                        b[0]=true;
                    } } );
                if(nextPosition[0] != nextCell && b[0]) System.out.println(player.getPlayerName() + " Got ladder present at: "+ ladderAt[0]);
                if(nextPosition[0] == boardSize){
                    System.out.println(player.getPlayerName() + " won the game");
                }else{
                    playersCurrentPosition.put(player.getPlayerName(),nextPosition[0]);
                    System.out.println(player.getPlayerName() + " is at position "+ nextPosition[0]);
                    nextTurn.offer(player);
                }
            }
        }
    }
}