package hackerearth;

import java.util.*;
import java.io.*;

public class Jiva {

	public static void main(String[] args){
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int testCase=Integer.parseInt(br.readLine());
			
			for (int j = 0; j < testCase; j++) {
				String[] in=br.readLine().split("\\s+");
				int n=Integer.parseInt(in[0]);
				int m=Integer.parseInt(in[1]);
				String mm="";
				
				boolean[][] pass=new boolean[n][100];
				for (int i = 0; i < n; i++) {
					String[] in1=br.readLine().split("\\s+");
					int pickUp=Integer.parseInt(in1[0]);
					int drop=Integer.parseInt(in1[1])-1;
					Arrays.fill(pass[i], pickUp, drop+1, true);
				}
				double revenue=0;
				for (int i = 0; i < 100; i++) {
					int count=0;
					for (int k = 0; k < n; k++) {
						if(pass[k][i]==true) {
							count++;
							if(count<=m) revenue+=10;
						}
					}
					
					if(count==m || count>m) mm="Cab was full";
					if(count==2) {
						revenue-=count*(0.5);
					}
					if(count>=3) {
						if(count==3) revenue-=(3*(0.7));
						if(count>m) revenue-=(m*(0.7));
					}
					
				}
				System.out.println(mm.isEmpty() ? Math.round(revenue):Math.round(revenue)+" "+mm);			
			}
			
		}
		
		catch(Exception ee) {
			ee.printStackTrace();
		}
		
	}

}
