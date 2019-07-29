package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DivideNumber {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int testCase=Integer.parseInt(br.readLine());
			for(int i=0;i<testCase;i++) {
				long n=Long.parseLong(br.readLine());
				int j=1;
				
				List<Long> list=new ArrayList<>();
				
				while(j<=n/2) {
					if(n%j==0) {
						list.add((long)j);
						
				}
					j++;
			}
				
			}
			System.out.println(2);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
