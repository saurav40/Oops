package com.practice.graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOfLife extends JPanel implements Runnable {
    private static final int CELL_SIZE = 20; // Size of each cell in pixels
    private boolean[][] board;
    private int rows;
    private int columns;
    private boolean running;
    
    public GameOfLife(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new boolean[rows][columns];
        running = false;
    }
    
    public void setCell() {
       for(int i=0;i<this.rows;i++)
    	   for(int j=0;j<this.columns;j++)
    	   {
    		   Random rand = new Random();
    	        
    	        boolean randomBool = rand.nextBoolean();

    		   board[i][j]=randomBool;
    	   }
    }
    
    public void start() {
        running = true;
        new Thread(this).start();
    }
    
    public void stop() {
        running = false;
    }
    
    @Override
    public void run() {
        while (running) {
            evolve();
            repaint(); // Redraw the panel
            try {
                Thread.sleep(100); // Pause for 100 milliseconds between iterations
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void evolve() {
        boolean[][] newBoard = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int liveNeighbors = countLiveNeighbors(i, j);
                if (board[i][j]) {
                    // Cell is alive
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        // Cell dies
                        newBoard[i][j] = false;
                    } else {
                        // Cell survives
                        newBoard[i][j] = true;
                    }
                } else {
                    // Cell is dead
                    if (liveNeighbors == 3) {
                        // Cell is born
                        newBoard[i][j] = true;
                    } else {
                        newBoard[i][j] = false;
                    }
                }
            }
        }
        board = newBoard;
    }
    
    public int countLiveNeighbors(int row, int column) {
        int count = 0;
        
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < columns && !(i == row && j == column)) {
                    if (board[i][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;
                if (board[i][j]) {
                    g2d.setColor(Color.WHITE);
                } else {
                    g2d.setColor(Color.BLACK);
                }
                g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }
    }
    
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(50, 50);
        // Set initial state of the board
        // ...
        game.setCell();
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
}

