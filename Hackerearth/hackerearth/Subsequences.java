package hackerearth;

import java.math.*;
import java.util.*;
public class Subsequences {

	public static void main(String[] args) {
		int[] arr=new int[] {0,1,2,3};
		int size=4;
		
		//number of subsequences is 2^n-1
		
		int opSize=(int)Math.pow(2,size);
		List<String> list=new ArrayList<>();
		//run from counter 000..1 to 111..1
		
		for(int i=1;i<opSize;i++) {
			String s="";
			for(int j=0;j<size;j++) {
				if(BigInteger.valueOf(i).testBit(j)) s+=arr[j];
			}
			list.add(s);
		}
System.out.println(list);
System.out.println(list.size());
	}

}
