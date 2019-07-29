package hackerearth;

import java.util.Scanner;

public class FooStress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int testCase=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<testCase;i++){
			String[] in=sc.nextLine().split("\\s+");
			long a=Long.parseLong(in[0]);
			long b=Long.parseLong(in[1]);
			long c=Long.parseLong(in[2]);
			long d=Long.parseLong(in[3]);
			long k=Long.parseLong(in[4]);
			
			int t=1;
			long tt=(a*((long)Math.pow((double)t,3)))+(b*((long)Math.pow((double)t,2)))+(c*t)+d;
			
			
				while(tt<k){
					t+=1;
					tt=(a*(t*t*t))+(b*(t*t))+(c*t)+d;
				}	
			
			
			System.out.println(t-1);
		}

	}

}
