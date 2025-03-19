package com.SystemDesign.SnakeAndLadder;

import java.util.*;

public class PlaySnakeAndLadder {
    public static void main(String[] args) {
        Dice dice = new Dice(2);
        
        Player p1 = new Player("Alberts",1);
        Player p2 = new Player("Pintoss",2);
        Player p3 = new Player("Saurabh",3);
        Player p4 = new Player("Vikash",4);
        
        Queue<Player> allPlayers = new LinkedList<>();
        allPlayers.offer(p1);
        allPlayers.offer(p2);
        allPlayers.offer(p3);
        allPlayers.offer(p4);
        
        Jumper snake1 = new Jumper(10,2);
        Jumper snake2 = new Jumper(99,12);
        Jumper snake3 = new Jumper(77, 1);
        Jumper snake4 = new Jumper(88, 22);
        
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);
        
        Jumper ladder1 = new Jumper(5,25);
        Jumper ladder2 = new Jumper(40,89);
        Jumper ladder3 = new Jumper(15, 97);
        Jumper ladder4 = new Jumper(27, 76);
        Jumper ladder5 = new Jumper(12, 44);
     
        
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);
        ladders.add(ladder4);
        ladders.add(ladder5);
        
        Map<String,Integer> playersCurrentPosition = new HashMap<>();
        playersCurrentPosition.put("Alberts",0);
        playersCurrentPosition.put("Pintoss",0);
        playersCurrentPosition.put(p3.getPlayerName(), 0);
        playersCurrentPosition.put(p4.getPlayerName(), 0);
        
        GameBoard gb=new GameBoard(dice,allPlayers,snakes,ladders,playersCurrentPosition,100);
        gb.startGame();
    }
}
