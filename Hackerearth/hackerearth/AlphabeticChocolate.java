package hackerearth;

import java.util.Scanner;
import java.util.*;

public class AlphabeticChocolate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int testCase=Integer.parseInt(sc.nextLine());
		String[] arr=new String[testCase];
		for(int i=0;i<testCase;i++){
			arr[i]=sc.nextLine();
			
		}
		for(int i=0;i<testCase;i++){
			String word=arr[i];
			int a=0;
			for(int j=0;j<word.length();j++){
				for(int k=j+1;k<=word.length();k++){
					String ww=word.substring(j, k);
					a+=ww.toLowerCase().replaceAll("[^[bcdfghjklmnpqrstvwxyz]]","").length();
				}
			}
			
			
		System.out.println(a);
		
		}
	}

}


