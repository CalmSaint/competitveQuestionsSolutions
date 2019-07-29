//Code for Bellman Ford's Algorithm


package shortestPathAlgos;

import java.io.*;
import java.util.*;

//taking all variables as a default variable

//class for a particular edge
class EdgeB{
	int src;
	int dest;
	int weight;
	EdgeB(){
		this.src=0;
		this.dest=0;
		this.weight=0;
		
	}
}
// graph will store all of the edges with weights
class GraphB{
	int vertices;
	int ed;
	EdgeB[] edges;
	
	GraphB(int v,int e){
		this.vertices=v;
		this.ed=e;
		edges=new EdgeB[e];
		for(int i=0;i<e;i++) {
			edges[i]=new EdgeB();
		}
	}
}

public class ShortestPathBellmanFord {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] firstLine=br.readLine().split("\\s+");
			int v=Integer.parseInt(firstLine[0]);
			int e=Integer.parseInt(firstLine[1]);
			
			//instantiating the graph
			GraphB graph=new GraphB(v,e);
			
			for(int i=0;i<e;i++) {
				String[] in=br.readLine().split("\\s+");
				graph.edges[i].src=Integer.parseInt(in[0]);
				graph.edges[i].dest=Integer.parseInt(in[1]);
				graph.edges[i].weight=Integer.parseInt(in[2]);
			}
			
		int[] paths=new int[e]; //array to store all of the shortest paths
		
		int dist[]=new int[v+1]; //to update the distances
		
		//Step1 initializing dist from src to all other vertices infinite
		//in our case src is 1
		for(int i=1;i<v+1;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		dist[1]=0;
		
		for(int i=0;i<v;i++) {
			for(int j=0;j<graph.edges.length;j++) {
				
				int src=graph.edges[j].src;
				int dest=graph.edges[j].dest;
				int weight=graph.edges[j].weight;
				
				if(dist[src]!=Integer.MAX_VALUE && (dist[dest]>dist[src]+weight)) {
					dist[dest]=dist[src]+weight;
				}
			}
		}
		
		for (int i = 0; i < dist.length; i++) {
			if(dist[i]!=0) System.out.print(dist[i]);
			if(i==dist.length-1) break;
			if(dist[i]==0) continue;
			System.out.print(" ");
		}
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
