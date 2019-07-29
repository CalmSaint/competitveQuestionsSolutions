package breadthFirstSearch;

import java.util.*;
import java.io.*;


class GraphL{
	int vertices;
	LinkedList<NodeL> connNodes[];
	
	GraphL(int vertices){
		this.vertices=vertices;
		connNodes=new LinkedList[vertices+1];
		for (int i = 1; i <= vertices; i++) {
			connNodes[i]=new LinkedList<>();
			
		}
	}
}
class NodeL{
	
	int value;
	int level;
	
	public NodeL(int value) {
		
		this.value = value;
		
	}
	
	
}



public class LevelNodes {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int nodes=Integer.parseInt(br.readLine());
			int temp=nodes;
			GraphL graph=new GraphL(nodes);
			while(nodes-- > 1) {
				String[] in=br.readLine().split("\\s+");
				int a=Integer.parseInt(in[0]);
				int b=Integer.parseInt(in[1]);
				
				graph.connNodes[a].add(new NodeL(b));
				graph.connNodes[b].add(new NodeL(a));
				
			}
			
			nodes=temp;
			int level=Integer.parseInt(br.readLine());
			Queue<NodeL> queue=new LinkedList<>(); 
			 
			
			boolean[] visited=new boolean[nodes+1];
			NodeL n=new NodeL(1);
			n.level=1;
			queue.add(n);
			visited[0]=true;
			visited[n.value]=true;
			
			int count=0;
			
			while(!queue.isEmpty()) {
				NodeL node=queue.remove();
				
				for (int i = 0; i < graph.connNodes[node.value].size(); i++) {
					
					NodeL child=graph.connNodes[node.value].get(i);
					if(visited[child.value]==false) {
						visited[child.value]=true;
						
						child.level=node.level+1;
						
						queue.add(child);
						if(child.level==level) count++;
					}
					
				}
				System.out.println();
				
			}
			
			System.out.println(count);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
