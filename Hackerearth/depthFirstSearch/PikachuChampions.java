package depthFirstSearch;

import java.io.*;
import java.util.*;

public class PikachuChampions {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in=br.readLine().split("\\s+");
			int nodes=Integer.parseInt(in[0]);
			int q=Integer.parseInt(in[1]);
			
			List<Integer> connNodes[]=new LinkedList[nodes+1];
			for (int i = 0; i < connNodes.length; i++) {
				connNodes[i]=new LinkedList<>();
			}
			
			for (int i = 0; i < nodes-1; i++) {
				String[] inn=br.readLine().split("\\s+");
				int u=Integer.parseInt(inn[0]);
				int v=Integer.parseInt(inn[1]);
				connNodes[u].add(v);
				connNodes[v].add(u);
			}
			
			
			
			while(q-- > 0) {
				String[] input=br.readLine().split("\\s+");
				int k=Integer.parseInt(input[0]);
				int[] set=new int[k];
				for (int i = 1; i < input.length; i++) {
					set[i-1]=Integer.parseInt(input[i]);
					
				}
				
				int max=0;
				
				int[] dist=new int[nodes+1];
				for (int i = 0; i < set.length; i++) {
					for (int j = i+1; j < set.length; j++) {
						
						dist[set[i]]=0;
						boolean[] visited=new boolean[nodes+1];
						DFS(set[i],set[j],visited,connNodes,dist);
						
						int a=dist[set[j]];
						
						if(a>max) max=a;
					}
				}
			System.out.println(max);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	static void DFS(int v,int f,boolean[] visited,List<Integer> graph[],int[] dist) {
		visited[v]=true;
		Iterator<Integer> data=graph[v].iterator();
		while(data.hasNext()) {
			int child=data.next();
			
			if(visited[child]==false) {
				dist[child]=dist[v]+1;
				if(child==f) break;
				DFS(child,f,visited,graph,dist);
			}
		}
	}
	
	
}
