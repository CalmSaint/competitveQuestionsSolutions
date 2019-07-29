package hackerearth;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class FredoAndArrayUpdate {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int length=Integer.parseInt(br.readLine());
			String[] input=br.readLine().split("\\s+");
			int sum=Arrays.stream(input).map(a->Integer.parseInt(a)).reduce(0,(b,c)->(b+c));
			
			List<Integer> array=Arrays.stream(input).map(a->Integer.parseInt(a)).collect(Collectors.toList());
			Collections.sort(array);
			int mid=sum/length;
			boolean flag=true;
			mid=mid-1;
			while(flag) {
				if(mid*length>sum) {
					flag=false;
				}
				else {
					mid++;
				}
			}
			System.out.println(mid);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
