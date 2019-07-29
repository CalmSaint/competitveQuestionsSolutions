package depthFirstSearch;

import java.io.*;
import java.util.*;

public class RhezoCriticalLinks {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in=br.readLine().split("\\s+");
			int nodes=Integer.parseInt(in[0]);
			int edges=Integer.parseInt(in[1]);
			int p=Integer.parseInt(in[2]);
			
			List<Integer> connNodes[]=new LinkedList[nodes+1];
			for (int i = 0; i < connNodes.length; i++) {
				connNodes[i]=new LinkedList<>();
			}
			
			String[] links=new String[edges];
			for (int i = 0; i < edges; i++) {
				String[] input=br.readLine().split("\\s+");
				
				links[i]=input[0]+" "+input[1];
				int x=Integer.parseInt(input[0]);
				int y=Integer.parseInt(input[1]);
				
				connNodes[x].add(y);
				connNodes[y].add(x);
			}
			int[] visited=new int[nodes+1];
			Arrays.fill(visited, 0);
			visited[0]=1;
			int cc=(int)Arrays.stream(visited).filter(a->a==0).count();
			
			DFS(1,visited,connNodes);
			int initConComp=(int)Arrays.stream(visited).filter(a->a==0).count();
			
			int count=0;
			for (int i = 0; i < edges; i++) {
				Arrays.fill(visited,0);
				visited[0]=1;
				int u=Integer.parseInt(links[i].split("\\s+")[0]);
				int v=Integer.parseInt(links[i].split("\\s+")[0]);
				
				connNodes[u].remove(v);
				connNodes[v].remove(u);
				
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	static void DFS(int v,int[] visited,List<Integer> graph[]) {
		visited[v]=1;
		
		Iterator<Integer> data=graph[v].iterator();
		while(data.hasNext()) {
			
			int child=data.next();
			if(visited[child]==0) {
				DFS(child,visited,graph);
			}
		}
		
	}
//	static int connCompp(int[] visited) {
//		
//	}
//	
	
	

}
