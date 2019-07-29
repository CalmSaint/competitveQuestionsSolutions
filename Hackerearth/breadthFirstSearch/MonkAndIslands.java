package breadthFirstSearch;

import java.util.*;
import java.io.*;


public class MonkAndIslands {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			int testCases=Integer.parseInt(br.readLine());
			while(testCases-- > 0) {
				String[] input=br.readLine().split("\\s+");
				int islands=Integer.parseInt(input[0]);
				int bridges=Integer.parseInt(input[1]);
				
				List<Integer> connIslands[]=new LinkedList[islands+1];
				for (int i = 0; i < connIslands.length; i++) {
					connIslands[i]=new LinkedList<>();
				}
				
				while(bridges-- > 0) {
					String[] in=br.readLine().split("\\s+");
					int x=Integer.parseInt(in[0]);
					int y=Integer.parseInt(in[1]);
					
					connIslands[x].add(y);
					connIslands[y].add(x);
				}
				Queue<Integer> queue=new LinkedList<>();
				queue.add(1);
				boolean[] visited=new boolean[islands+1];
				Arrays.fill(visited, false);
				visited[1]=true;
				
				int count=0;
				
				int[] dist=new int[islands+1];
				Arrays.fill(dist,0);
				dist[1]=0;
				while(!queue.isEmpty()) {
					int source=queue.poll();
					
					Iterator<Integer> data=connIslands[source].iterator();
					while(data.hasNext()) {
						int child=data.next();
						if(visited[child]==false) {
							visited[child]=true;
							dist[child]=dist[source]+1;
							if(child==islands) break;
							queue.add(child);
						}
					}
					
					
				}
				System.out.println(dist[islands]);
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
