package practice;

import java.util.Scanner;

public class Prefix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String inputString = s.nextLine();
		int i=1;
      int flag=0;
      
      while(i<=inputString.length()/2){
    	  
        if(inputString.startsWith(inputString.substring(0, i)) && inputString.endsWith(inputString.substring(0,i))){
          flag=inputString.substring(0,i).length();
          
        }
        i++;
      }
      System.out.println(flag);
      s.close();
	}

	}


