package hackerearth;
import java.util.*;
import java.util.Scanner;

public class MFirstName {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int testCase=Integer.parseInt(sc.nextLine());
		Map<String,Integer> fMap=new HashMap<>();
		for(int i=0;i<testCase;i++){
			
			String in=sc.nextLine();
			
			fMap.put("SUVO", 0);
			fMap.put("SUVOJIT", 0);
			
			while(in.contains("SUVOJIT")){
				Integer c=fMap.get("SUVOJIT");
			    fMap.put("SUVOJIT",c+1);
			    in=in.replaceFirst("SUVOJIT","");
			}
			
			while(in.contains("SUVO")){
				Integer c=fMap.get("SUVO");
			    fMap.put("SUVO",c+1);
			    in=in.replaceFirst("SUVO","");
			}
			System.out.println("SUVO = "+fMap.get("SUVO")+", SUVOJIT = "+fMap.get("SUVOJIT"));
		}
		

	}

}
