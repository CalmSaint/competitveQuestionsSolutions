package breadthFirstSearch;

import java.util.*;
import java.io.*;
public class SocialNetworkingGraph {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			String[] in=br.readLine().split("\\s+");
			int nodes=Integer.parseInt(in[0]);
			int edges=Integer.parseInt(in[1]);
			
			LinkedList<Integer> connCities[]=new LinkedList[nodes+1];
			for (int i = 0; i < connCities.length; i++) {
				connCities[i]=new LinkedList<>();
			}
			
			for (int i = 0; i < edges; i++) {
				String[] in1=br.readLine().split("\\s+");
				int u=Integer.parseInt(in1[0]);
				int v=Integer.parseInt(in1[1]);
				
				connCities[u].add(v);
				connCities[v].add(u);
			}
			
			int m=Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				int count=0;
				String[] test=br.readLine().split("\\s+");
				
				int x=Integer.parseInt(test[0]);
				int dist=Integer.parseInt(test[1]);
				
				boolean[] visited=new boolean[nodes+1];
				visited[x]=true;
				Queue<Integer> queue=new LinkedList<>();
				queue.add(x);
				
				
				int[] level=new int[nodes+1];
				Arrays.fill(level,-1);
				level[x]=0;
				
				while(!queue.isEmpty()) {
					int source=queue.poll();
					
					Iterator<Integer> data=connCities[source].iterator();
					while(data.hasNext()) {
						int key=data.next();
						if(level[key]==-1) level[key]=level[source]+1;
						
						if(visited[key]==false) {
							visited[key]=true;
							queue.add(key);
							if(level[key]==dist) count++;
						}
					}
				}
				System.out.println(count);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
