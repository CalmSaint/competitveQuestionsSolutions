package depthFirstSearch;

import java.io.*;
import java.util.*;
public class UnReachableNodes {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in=br.readLine().split("\\s+");
			int nodes=Integer.parseInt(in[0]);
			int edges=Integer.parseInt(in[1]);
			
			List<Integer> connNodes[]=new LinkedList[nodes+1];
			for (int i = 0; i < connNodes.length; i++) {
				connNodes[i]=new LinkedList<>();
			}
			for (int i = 0; i < edges; i++) {
				String[] inp=br.readLine().split("\\s+");
				int x=Integer.parseInt(inp[0]);
				int y=Integer.parseInt(inp[1]);
				
				connNodes[x].add(y);
				connNodes[y].add(x);
			}
			
			int count=0;
			Stack<Integer> stack=new Stack<>();
			boolean[] visited=new boolean[nodes+1];
			
			int head=Integer.parseInt(br.readLine());
			visited[head]=true;
			stack.push(head);
			
			while(!stack.isEmpty()) {
				int source=stack.pop();
				count++;
				Iterator<Integer> data=connNodes[source].iterator();
				while(data.hasNext()) {
					int child=data.next();
					
					if(visited[child]==false) {
						visited[child]=true;
						stack.push(child);
					}
				}
			}
			System.out.println(nodes-count);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
