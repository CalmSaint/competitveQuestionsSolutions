package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BeautifulArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int l=sc.nextInt();
		boolean out=false;
		
		sc.nextLine();
		String arrEl=sc.nextLine();
		
		String[] bArr=arrEl.split("\\s");
		
		ArrayList<Integer> eList=new ArrayList<>();
		
		int flag=0;
		for(int i=0;i<l;i++){
			int element=Integer.parseInt(bArr[i]);
			
			eList.add(element);
			//checking between 1 and N
			
			if(!(element>=1 && element<=n)){
				flag=1;
			}
		}
		
		//checking the uniqueness
		Iterator<Integer> data=eList.iterator();
		while(data.hasNext()){
			Integer a=data.next();
			if(Collections.frequency(eList,a)>1){
				flag=1;
			}
		}
		
		
		
		System.out.println(eList);
		ArrayList<Integer> oList=new ArrayList<>(eList);
		
		oList.sort((a,b)->(a-b));
		if(eList.equals(oList)){
			flag=1;
		}
		oList.sort((a,b)->(b-a));
		if(eList.equals(oList)){
			flag=1;
		}
		if(flag==1){
			out=false;
		}
		else{
			out=true;
		}
		System.out.println(out);
		
		
		
		
		
		

	}

}
