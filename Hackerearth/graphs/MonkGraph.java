package graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkGraph {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int n=Integer.parseInt(br.readLine());
			String[] a=br.readLine().split("\\s+");
			int sum=Arrays.stream(a).map(b->Integer.parseInt(b)).reduce(0,(x,y)->x+y);
			System.out.println(sum);
			if(sum==2*(n-1)) System.out.println("Yes");
			else System.out.println("No");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}

}
