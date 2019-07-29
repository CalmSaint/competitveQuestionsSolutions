package depthFirstSearch;

import java.util.*;
import java.io.*;
public class HappyVertices {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			String[] in=br.readLine().split("\\s+");
			int nodes=Integer.parseInt(in[0]);
			int edges=Integer.parseInt(in[1]);
			
			LinkedList<Integer> connNodes[]=new LinkedList[nodes+1];
			int root=nodes;
			for (int i = 0; i < connNodes.length; i++) {
				connNodes[i]=new LinkedList<>();
			}
			for (int i = 0; i < edges; i++) {
				String[] inn=br.readLine().split("\\s+");
				int x=Integer.parseInt(inn[0]);
				int y=Integer.parseInt(inn[1]);
				
				connNodes[x].add(y);
				connNodes[y].add(x);
				if(x<root) root=x;
				if(y<root) root=y;
			}
			
			int[] childs=new int[nodes+1];
			boolean[] visited=new boolean[nodes+1];
			Stack<Integer> stack=new Stack<>();
			stack.push(root);
			childs[root]=connNodes[root].size();
			visited[root]=true;
			
			int count=2;
			while(!stack.isEmpty()) {
				int source=stack.pop();
				Iterator<Integer> data=connNodes[source].iterator();
				while(data.hasNext()) {
					int child=data.next();
					if(visited[child]==false) {
						visited[child]=true;
						childs[child]=connNodes[child].size();
						stack.push(child);
						if(childs[child] > childs[source]) count++;
					}
				}
			}
			System.out.println(count);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

}

}