package com.practice.collections;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 */
public class ConcurrentMap {
	public static void main(String[] args) {
       ConcurrentHashMap<String, Integer> mp = new ConcurrentHashMap<>();
       mp.put("OPTION", 873);
       
       Thread thread1 = new Thread(()->{
    	   for(int i=0;i<10;i++)
    	   {
    		   mp.put("Key_"+i, i+1);
    		   // Write Thread
    		   try{
    			   Thread.sleep(100);
    		   }
    		   catch(InterruptedException e){
    			   System.out.println(e.getMessage());
    		   }
    	   }
       });
       
       // Reader
       Thread thread2 = new Thread(()->{
    	  while(true)
    	  {
    		  mp.forEach((K,V)->{
    			  System.out.println(K +" "+ V);
    		  });
    		  
    		  try {
    			  Thread.sleep(150);
    		  }
    		  catch(InterruptedException e) {
    			  System.out.println(e.getMessage());
    		  }
    		  if(mp.size() > 10)
    			  break;
    	  }
       });
       
       // Start both threads
       thread1.start();
       thread2.start();
       
    // Wait for both threads to finish
     try {
    	 thread1.join();
    	 thread2.join();
     }
     catch(InterruptedException e)
     {
    	 e.printStackTrace();
     }
       
       
	}
}
