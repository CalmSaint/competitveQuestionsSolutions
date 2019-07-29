package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

public class CarName {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int names=Integer.parseInt(br.readLine());
			for (int i=0;i<names;i++) {
				
				String name=br.readLine();
				Map<String,Long> map=new TreeMap<>();
				map=Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
				if(map.keySet().size()==3) {
					Set<Long> aa=new HashSet<>(map.values());
					List<String> ab=new LinkedList<>(map.keySet());
					List<Long> bb=new LinkedList<>(map.values());
					String c1="";
					String c2="";
					String c3="";
					System.out.println(ab);
					for(int j=0;j<bb.get(0);j++) {
						c1+=ab.get(0);
						c2+=ab.get(1);
						c3+=ab.get(2);
						
					}
					
					if(aa.size()==1) {
						if(name.matches(c1+c2+c3)) System.out.println("OK");
						else System.out.println("Not OK");
				}
			}
			
			}}
			
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
