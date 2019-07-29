package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Doublets {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String in=sc.nextLine();
		
		String[] arr=in.split("\\s+");
		ArrayList<String> out=new ArrayList<>();
		
		for (int i=0;i<arr.length;i++) {
			List<String> data=Arrays.asList(arr[i].split(""));
			ArrayList<String> a =new ArrayList<>(data);
			
			for(int j=i+1;j<arr.length;j++){
				List<String> data1=Arrays.asList(arr[j].split(""));
				ArrayList<String> b =new ArrayList<>(data1);
				if(a.size()==b.size()){
					System.out.println(a);
					System.out.println(b);
					a.removeAll(b);
					System.out.println(a);
					if(b.size()==1){
						out.add(arr[i]+":"+arr[j]);
					}	
				}
				
				
			}
		}
		Iterator<String> dataa=out.iterator();
		String outt="";
		while(dataa.hasNext()){
			outt+=dataa.next();
			if(dataa.hasNext()){
				outt+=",";
			}
		}
		if(outt.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(outt);	
		}
		
		sc.close();
		
		
		

	}

}
