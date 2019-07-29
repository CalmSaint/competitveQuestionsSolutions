package hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CandyMonk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int testCase=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<testCase;i++){
			int k=Integer.parseInt(sc.nextLine().split("\\s+")[1]);
			
			String in3=sc.nextLine();
			
			List<Long> cList=Arrays.stream(in3.split("\\s+")).map(a->Long.parseLong(a)).collect(Collectors.toList());
			
			Long c=0L;
			for(int j=0;j<k;j++){
				long a=Collections.max(cList);
				int index=cList.indexOf(a);
				c+=a;
				cList.remove(index);
				cList.add(index,(long)Math.floor(a/2));
			}
			System.out.println(c);
		}
		sc.close();

	}

}
