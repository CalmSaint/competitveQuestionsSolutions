package shortestPathAlgos;

import java.util.*;
import java.io.*;


//to add in prioirity queue
class Sett  implements Comparable<Sett>{
	int vertex;
	int distance;
	Sett(int vertex,int distance){
		this.vertex=vertex;
		this.distance=distance;
	}
	
	@Override
	public int compareTo(Sett o) {
		if(this.distance>o.distance) {
			return 1;
		}
		else {
			return -1;
		}
	}
}

// to add a node
class NodeD{
	int node;
	int weight;
	
	NodeD(int node,int weight){
		this.node=node;
		this.weight=weight;
	}
	
	
}

//for the graph
class GraphD{
	int v;
	int e;
	LinkedList<NodeD> connNodes[];
	
	GraphD(int v,int e){
		this.v=v;
		this.e=e;
		connNodes=new LinkedList[v+1];
		for (int i = 0; i < connNodes.length; i++) {
			connNodes[i]=new LinkedList<>();
		}
	}
}



public class ShortestPathDjikstra {
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] firstLine=br.readLine().split("\\s+");
			int v=Integer.parseInt(firstLine[0]);
			int e=Integer.parseInt(firstLine[1]);
			
			//instantiating the graph
			GraphD graph=new GraphD(v,e);
			
			for(int i=0;i<e;i++) {
				String[] in=br.readLine().split("\\s+");
				
				//adding in linkedList
				graph.connNodes[Integer.parseInt(in[0])].add(new NodeD(Integer.parseInt(in[1]),Integer.parseInt(in[2])));
			}
			
		int[] paths=new int[e]; //array to store all of the shortest paths
		
		int dist[]=new int[v+1]; //to update the distances
		
		Arrays.fill(dist, 1000000000);
		dist[1]=0;
		
		//arrays to track visited nodes
		boolean[] visited=new boolean[v+1];
		Arrays.fill(visited,false);
		
		PriorityQueue<Sett> queue=new PriorityQueue<>();
		
		queue.add(new Sett(1,0));
		
		
		while(!queue.isEmpty()) {
			Sett currentNode=queue.remove();
			
			int node=currentNode.vertex;
			int weight=currentNode.distance;
			
			//check if the vertex is visited before
			if(visited[node]) continue;
			
			visited[node]=true;
			
			for (int i = 0; i < graph.connNodes[node].size(); i++) {
				NodeD next=graph.connNodes[node].get(i);
				weight=next.weight;
				if(visited[next.node]==false && ((dist[node]+weight) < dist[next.node])) {
					dist[next.node]=(dist[node]+weight);
					queue.add(new Sett(next.node,dist[next.node]));
				}
				
			}
			
			
			
			
			
		}
		
		for (int i = 2; i < dist.length; i++) {
			System.out.print(dist[i]);
			if(i==dist.length-1) break;
			System.out.print(" ");
		}
		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
