package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ShinoFactors {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] input=br.readLine().split("\\s+");
			
			long a=Long.parseLong(input[0]);
			long b=Long.parseLong(input[1]);
			
			long min=Math.min(a, b);
			long flag=1;
			long count=0;
			
			while(flag<=min/2) {
				if(a%flag==0 && b%flag==0 ) count++;
				flag++;
			}
			System.out.println(count);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}

}
