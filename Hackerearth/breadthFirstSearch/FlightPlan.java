package breadthFirstSearch;

import java.util.*;
import java.io.*;

public class FlightPlan {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in=br.readLine().split("\\s+");
			int cities=Integer.parseInt(in[0]);
			int routes=Integer.parseInt(in[1]);
			int t=Integer.parseInt(in[2]);
			int timeTaken=Integer.parseInt(in[3]);
			
			LinkedList<Integer> connCities[]=new LinkedList[cities+1];
			for (int i = 1; i <=cities; i++) {
				connCities[i]=new LinkedList<>();
			}
			
			for (int i = 0; i < routes; i++) {
				String[] input=br.readLine().split("\\s+");
				int u=Integer.parseInt(input[0]);
				int v=Integer.parseInt(input[1]);
				
				connCities[u].add(v);
				connCities[v].add(u);
			}
			
			String[] destCities=br.readLine().split("\\s+");
			int x=Integer.parseInt(destCities[0]);
			int y=Integer.parseInt(destCities[1]);
			
			
				boolean[] visited=new boolean[cities+1];
				
				Set<String> poss=new TreeSet<>();
				Queue<Integer> queue=new LinkedList<>();
				queue.add(x);
				visited[x]=true;
				String s=x+"";
				while(!queue.isEmpty()) {
					int city=queue.poll();
					
					Iterator<Integer> data=connCities[city].iterator();
					boolean flag=false;
					while(data.hasNext()) {
						int child=data.next();
						if(visited[child]==false) {
							visited[child]=true;
							queue.add(child);
							if(child==y) {
								s+=city;
								s+=child;
								flag=true;
								break;
							}
							if(flag) break;
							
						}
					}
					if(s.contains(String.valueOf(y))) poss.add(s);
					
					
				}
			List<String> d=new LinkedList<>(poss);
			System.out.println(d.get(0).length());
			
			System.out.println(String.join(" ",d.get(0).split("")));
			
			
			
			
			
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
