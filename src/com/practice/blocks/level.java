package com.practice.blocks;

/*
 *  A Enum is a specail class that represnts a group of constants
 *   --> A enum can't extend any other class or enum
 *   --> We can't instantiate a enum
 *   --> We can declare variable and methods and constructor in Enum to initialize and get ValueOf a constant 
 */
enum weekDays
{
	SUNDAY("Sun"),
	MONDAY("Mon"),
	TUESDAY("TUE"),
	WEDNESDAY("Wed"),
	THURSDAY("Thu"),
	FRIDAY("Fri"),
	SATUARDAY("Sat");
	String day;
	private weekDays(String day) {
		this.day = day;
	}
	String getDay()
	{
		return day;
	}
	
}
public enum level {
   LOW(10),
   MEDIUM(20),
   HIGH(30);
   int value ;
   level(int x)//This can be private or default
   {
	this.value = x;
   }
   int getX()
   {
	   return value;
   }
  public static void main(String[] args) {
	 System.out.println(level.HIGH.value);
	 System.out.println(level.HIGH.getX());
	 
	 //WeekDays
	 System.out.println(weekDays.SUNDAY.day);
	 System.out.println(weekDays.FRIDAY.getDay());
  }
}
