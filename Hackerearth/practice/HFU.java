package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HFU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		sc.nextLine();
		String arrEl=sc.nextLine();
		String[] bArr=arrEl.split("\\s");
		
		ArrayList<Integer> eList=new ArrayList<>();
		double av=0;
		for(int i=0;i<n;i++){
			int element=Integer.parseInt(bArr[i]);
			eList.add(element);
			av+=(double)element/(double)n;
		}
		int avg=(int)Math.floor(av);
		
		int dist=-1;
		if(Collections.frequency(eList,avg)>1){
			dist=eList.lastIndexOf(avg)-eList.indexOf(avg);
		}
		System.out.println(dist);
		sc.close();
		
		

	}

}
