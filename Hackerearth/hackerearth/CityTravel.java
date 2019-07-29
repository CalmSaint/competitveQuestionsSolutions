package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CityTravel {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] input1=br.readLine().split("\\s+");
			Integer s=Integer.parseInt(input1[0]);
			Integer x=Integer.parseInt(input1[1]);
			Integer n=Integer.parseInt(input1[2]);
					
			if(n!=0) {
				
				int[] aa=new int[n*n*n*n];
				for(int i=0;i<n;i++) {
					String[] in=br.readLine().split("\\s+");
					aa[Integer.parseInt(in[0])]=Integer.parseInt(in[1]);
					
				}
				Integer min=1;
				Integer sum=0;
				while(sum<s) {
					int index=aa[min];
					if(index!=0) {
						sum+=index;
						min++;
					}
					else {
						sum+=x;
						min++;
					}
				}
				System.out.println(min-1);
			}
			else {
				Double xx=Double.parseDouble(input1[1]);
				Double ss=Double.parseDouble(input1[0]);
				System.out.println((long)(Math.ceil(xx/ss)));
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}
	

}
