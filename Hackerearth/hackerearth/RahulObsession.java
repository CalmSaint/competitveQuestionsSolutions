package hackerearth;

import java.util.*;
import java.io.*;
public class RahulObsession {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))) {
			int testCases=Integer.parseInt(br.readLine());
			for (int i = 0; i < testCases; i++) {
				long n=Long.parseLong(br.readLine());
				long j=(n/2)-n;
				
				long count=0;
				for(long k=j;k*k<=n;k++) {
					
					for (long k2 = j; k2*k2<=n ; k2++) {
						
						for (long l = j; l*l<=n; l++) {
							
							for (long l2 = j; l2*l2<=n; l2++) {
								
								if((k*k)+((k2)*(k2))+(l*l)+((l2)*(l2))==n) count++;
							}
						}
					}
				}
				
				System.out.println(count);
				
				
				
			}
		}
		catch(Exception e) {
			
		}
		

	}

}
