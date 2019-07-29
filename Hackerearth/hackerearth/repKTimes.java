package hackerearth;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
public class repKTimes {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=Integer.parseInt(sc.nextLine());
		
		Map<String,Long> nMap=Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		int k=Integer.parseInt(sc.nextLine());
		List<Integer>aData=new ArrayList<>();
		
		Iterator<Entry<String,Long>> data=nMap.entrySet().iterator();
		while(data.hasNext()){
			Entry<String,Long> aa=data.next();
			if(aa.getValue()==k){
				aData.add(Integer.parseInt(aa.getKey()));
			}
		}
		Collections.sort(aData);
		System.out.println(aData.get(0));
		sc.close();
		
		
		
		
		

	}

}
