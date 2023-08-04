package com.practice.string;

public class StringBasics {
	public static void main(String[] args) {
		String comments[] ={"Your videos good good","Your videos are bad","good"};
		String check = "good";
		String bad ="bad";
		int cg = 0;
		int cb = 0;
		for(String comment : comments)
		{
			String [] parts = comment.split(" ");
			int cg1=0,cb1=0;
			for(String word:parts)
			{
				if(check.equals(word.toLowerCase()) && cg1==0)
				{
					cg++;
					cg1++;

				}
				if(bad.equals(word.toLowerCase()) && cb1==0)
				{
					cb++;
				    cb1++;
				}
			}
		}
		System.out.println("Good : "+cg+" bad : "+cb);
		//stringFunctions();
		//printAllSymbols();
		//printUpperCase();
		//printLowerCase();
		//printAlphabets();
	    //printSymbolWithAlphabets();
	    /*
	     *  WAP to remove duplicate from a String
	     *  S = "geeks__for_geeks11458ACCDB;
	     *  ans = geks_for1458ACDB
	     * 
	     */
//	    System.out.println(removeDuplicate("geeks__for_geeks11458ACCDB"));
//	    System.out.println(removeDuplicate("------####&&&```~~~cccghhjkACCD%%++--)))(((("));
        
	}
	/*
	 *  String Functions in java
	 */
	static void stringFunctions()
	{
		String str1 = "Hello";  // Initializing a string using string literal
		String str2 = new String("World");  // Initializing a string using the 'new' keyword
        System.out.println(str1+" "+str2);
        
        String str = "Hello";
        int length = str.length();  // Returns the length of the string (number of characters)
        System.out.println(length);
        
        String result = str1 + " " + str2;  // Concatenates two strings
        System.out.println(result);
        
        //String Comparsion
        boolean isEqual = str1.equals(str2);  // Checks if two strings are equal
        System.out.println(isEqual);
        boolean isIgnoreCaseEqual = str1.equalsIgnoreCase(str2);  // Ignores case while comparing strings
        System.out.println(isEqual);
        int comparison = str1.compareTo(str2);  // Compares two strings lexicographically
        System.out.println(comparison);
        
        
        //Susbstring
        String str3 = "Hello World";
        String substring = str3.substring(6);  // Retrieves the substring starting from index 6 till the end
        String substringWithLength = str3.substring(0, 5);  // Retrieves the substring from index 0 to 4
        System.out.println(substring);
        System.out.println(substringWithLength);
        
        
        //Spilting a string
        String str4 = "Hey,Guys";
        String[] parts = str4.split(",");  // Splits the string into an array of substrings using the delimiter
        for(String x:parts)
        	System.out.println(x);
        
        //Conversion to char Array
        String str5 = "GeeksForGeeks";
        char[] charArray = str5.toCharArray();  // Converts the string to a character array
        for(char ch:charArray)
        	System.out.print(ch+" ");
        System.out.println();

        
        //Finding a character or substring:
        String str6 = "Hello World";
        int index = str6.indexOf('W');  // Finds the index of the first occurrence of 'W'
        int lastIndex = str6.lastIndexOf('o');  // Finds the index of the last occurrence of 'o'
        boolean contains = str6.contains("World");  // Checks if the string contains a specific substring
        
        //Changing case
        String lowerCase = str6.toLowerCase();
        String upperCase = str6.toUpperCase();
        String capitalize = str6.substring(0,1).toUpperCase()+str6.substring(1).toLowerCase();
        System.out.println(lowerCase + "\n"+upperCase+"\n"+capitalize);
        
        //Removing leading/trailing whitespaces:
        String x = " geeks for geeks";
        String y = x.trim();
        String z = "geeks for geeks";
        System.out.println((x.equals(y))+" "+y.equals(z));
        
        //Replacing characters/substrings:
        String a = "My journey was simple";
        String replaced = a.replace("simple", "tough");
        System.out.println(replaced);
        
        //String formatting:
        String name = "Saurabh";
        double salary = 934.508;
        int age = 26;
        String formatInfo = String.format("[ Name = %s , age = %d, salary = %1.3f ]", name,age,salary);
        System.out.println(formatInfo);
        
        //String to integer/float conversion:
        
        String num = "1245";
        int number = Integer.parseInt(num);
        double dnumber = Double.parseDouble("3.67");
        float fnumber = Float.parseFloat("3.1455");
        System.out.println(number+"\n"+dnumber+"\n"+fnumber);
        

	}
	//ASCII Code to symbols
	static void printAllSymbols()
	{
		for (int i = 32; i <= 126; i++) {
            System.out.println("ASCII value: " + i + ", Symbol: " + (char) i);
        }
	}
	// UpperCase ASCII to sysbole ->65 to 90[A-Z]
	static void printUpperCase()
	{
		for(int i=65;i<=90;i++)
			System.out.println("ASCII value: " + i + ", Symbol: " + (char) i);
			
	}

	// LowerCase ASCII to sysbole ->65 to 90[A-Z]
	static void printLowerCase() {
		for (int i = 97; i <= 122; i++)
			System.out.println("ASCII value: " + i + ", Symbol: " + (char) i);

	}
	//print all alphabets Capital Letter & Small Letter
	static void printAlphabets()
	{
		for(int i=0;i<26;i++)
		{
			int lowerCase = i+(int)'a';
			int upperCase = i+(int)'A';
			System.out.println((char)lowerCase+" "+(char)upperCase);
		}
	}
	static void printSymbolWithAlphabets() {
		for(int i=0;i<=94;i++)
		{
			int symbol = i +(int)' ';
			System.out.println((char)symbol);
		}
	}
    static String removeDuplicate(String s)
    {
    	int[] hash = new int[127];
    	for(int i=0;i<s.length();i++)
    	{
    		   int idx = (int)s.charAt(i);
    		   hash[idx]++;
    	}
    	String ans = "";
    	for(int i=0;i<s.length();i++)
    	{
    		int idx = (int)s.charAt(i);
    		if(hash[idx]>=1) {
    			ans +=s.charAt(i);
    			hash[idx]=0;
    		}
    	}
    	return ans;
    }
	
}
