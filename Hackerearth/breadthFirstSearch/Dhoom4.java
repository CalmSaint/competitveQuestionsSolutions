package breadthFirstSearch;

import java.util.*;

import java.util.stream.Collectors;
import java.io.*;
public class Dhoom4 {

	public static void main(String[] args) {
	try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
		
		String[] input=br.readLine().split("\\s+");
		long sKey=Integer.parseInt(input[0]);
		int lock=Integer.parseInt(input[1]);
		
		int keys=Integer.parseInt(br.readLine());
		List<Integer> vals=Arrays.stream(br.readLine().split("\\s+")).map(a->(new Integer(a))).collect(Collectors.toList());
		
		long[] visited=new long[100005];
		Arrays.fill(visited,-1L);
		
		visited[(int) sKey]=0L;
		Queue<Long> queue=new LinkedList<>();
		queue.add(sKey);
		
		while(!queue.isEmpty()) {
			long oKey=queue.poll();
			if(oKey==lock) break;
			for (int i = 0; i < keys; i++) {
				long toMerge=vals.get(i);
				toMerge=(toMerge*oKey)%100000;
				
				if(visited[(int) toMerge]==-1) {
					visited[(int) toMerge]=visited[(int) oKey]+1;
					queue.add(toMerge);
				}
			}
		}
		System.out.println(visited[lock]);
		
		
		
		
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}

	}

}
