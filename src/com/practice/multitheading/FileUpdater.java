package com.practice.multitheading;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUpdater {

    private static final String FILE_PATH = "data.txt";
    private static List<String> fileContent = new ArrayList<>();

    public static void main(String[] args) {
        // Create and start the three threads
        Thread thread1 = new Thread(new WriterThread("Thread 1"));
        Thread thread2 = new Thread(new WriterThread("Thread 2"));
        Thread thread3 = new Thread(new ReaderThread("Thread 3"));
        Thread thread4 = new Thread(new ReaderThread("Thread 4"));
        Thread thread5 = new Thread(new ReaderThread("Thread 5"));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    // Thread to write data to the file
    static class WriterThread implements Runnable {
        private String name;

        public WriterThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (fileContent) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                    // Write data to the file
                    writer.write(name + ": New data\n");
                    writer.flush();
                    System.out.println(name + " has written data to the file.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Thread to read data from the file
    static class ReaderThread implements Runnable {
        private String name;

        public ReaderThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (fileContent) {
                try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileContent.add(line);
                    }
                    System.out.println(name + " has read data from the file.");
                    // Display the read data
                    for (String data : fileContent) {
                        System.out.println(data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
