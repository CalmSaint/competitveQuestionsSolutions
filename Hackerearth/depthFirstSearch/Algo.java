package depthFirstSearch;

import java.io.*;
import java.util.*;

public class Algo {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in=br.readLine().split("\\s+");
			int n=Integer.parseInt(in[0]);
			int m=Integer.parseInt(in[1]);
			
			List<Integer> graph[]=new LinkedList[n+1];
			for (int i = 0; i < graph.length; i++) {
				graph[i]=new LinkedList<>();
			}
			for (int i = 0; i < m; i++) {
				String[] inp=br.readLine().split("\\s+");
				int x=Integer.parseInt(inp[0]);
				int y=Integer.parseInt(inp[1]);
				
				graph[x].add(y);
				graph[y].add(x);
			}
			
			Stack<Integer> stack=new Stack<>();
			stack.push(1);
			boolean[] visited=new boolean[n+1];
			visited[1]=true;
			
			while(!stack.isEmpty()) {
				int source=stack.pop();
				System.out.print(source+" ");
				Iterator<Integer> data=graph[source].iterator();
				while(data.hasNext()) {
					int child=data.next();
					if(visited[child]==false) {
						
						
						visited[child]=true;
						stack.push(child);
					}
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
