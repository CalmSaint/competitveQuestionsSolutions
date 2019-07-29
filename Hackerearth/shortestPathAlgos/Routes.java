package shortestPathAlgos;

import java.io.*;
import java.util.*;
public class Routes {
	
	class Graph{
		int vertices;
		int edges;
		HashSet<Routes.Node> connNodes[];
		Graph(int vertices,int edges){
			this.vertices=vertices;
			this.edges=edges;
			connNodes=new HashSet[vertices+1];
			for(int i=0;i<vertices+1;i++) connNodes[i]=new HashSet<>();
		}
		
	}
	
	class Node{
		
		int node;
		int time;
		int cost;
		Node(int node,int time,int cost){
			
			this.node=node;
			this.time=time;
			this.cost=cost;
		}
		
		@Override
		public boolean equals(Object obj) {
			Routes.Node node=(Routes.Node)obj;
			if(node.node==this.node && node.time==this.time && node.cost==this.cost) return true;
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.node*this.cost*this.time;
		}
	}
	
	//for priority queue
	class Sett implements Comparable<Sett>{
		int node;
		int distance;
		
		Sett(int node,int distance){
			this.node=node;
			this.distance=distance;
		}
		
		@Override
		public int compareTo(Sett o) {
			if(this.distance>o.distance) return 1;
			else return -1;
		}
		
	}

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int amt=Integer.parseInt(br.readLine().split("\\s+")[0]);
			int v=Integer.parseInt(br.readLine().split("\\s+")[0]);
			int e=Integer.parseInt(br.readLine().split("\\s+")[0]);
			if(e>((v*(v-1)))/2) {
				System.out.println("Error");
				return;
			}
			
			Routes r=new Routes();
			Routes.Graph graph=r.new Graph(v,e);
			
			for(int i=0;i<e;i++) {
				String[] inx=br.readLine().split("\\s+");
				int dest=Integer.parseInt(inx[1]);
				int time=Integer.parseInt(inx[2]);
				int cost=Integer.parseInt(inx[3]);
				
				graph.connNodes[Integer.parseInt(inx[0])].add(r.new Node(dest,time,cost));
				graph.connNodes[Integer.parseInt(inx[1])].add(r.new Node(Integer.parseInt(inx[0]),time,cost));
				
			}
			
			int src=Integer.parseInt(br.readLine().split("\\s+")[0]);
			int dest=Integer.parseInt(br.readLine().split("\\s+")[0]);
			
			//to track visited nodes
			boolean[] visited=new boolean[v+1];
			Arrays.fill(visited, false);
			
			//to track cost
			int[] dist=new int[v+1];
			Arrays.fill(dist,Integer.MAX_VALUE); 
			dist[src]=0;
			
			//priority queue to apply dijkstra
			PriorityQueue<Routes.Sett> queue=new PriorityQueue<>();
			queue.add(r.new Sett(src,dist[src]));
			int[] cities=new int[v+1];
			
			while(!queue.isEmpty()) {
				Routes.Sett s=queue.poll();
				int node=s.node;
				
				if(visited[node]==true) continue;
				visited[node]=true;
				
				Iterator<Routes.Node> data=graph.connNodes[node].iterator();
				while(data.hasNext()) {
					Routes.Node next=data.next();
					next.time+=(next.node==dest)?0:1;
					
					int distance=next.cost+amt*next.time;
					
					if(dist[next.node]>(dist[node]+distance)) {
						dist[next.node]=dist[node]+distance;
						cities[next.node]=node;
						queue.add(r.new Sett(next.node,dist[next.node]));
					}
				}
			}
			
			if(dist[dest]==Integer.MAX_VALUE) {
				System.out.println("Error");
			}
			else {
				int dest1=dest;
				int kt;
				LinkedList<Integer> nn=new LinkedList<>();
				
				while(true) {
					kt=cities[dest1];
					dest1=kt;
					if(kt==src || kt==0) {
						if(kt==src) nn.add(kt);
						break;
					}
					nn.add(kt);
					
				}
				Collections.reverse(nn);
				for (int i = 0; i < nn.size(); i++) {
					System.out.print(nn.get(i));
					if(i==nn.size()-1) break;
					System.out.print("->");
				}
				System.out.print("->"+dest+" "+(nn.size()+1));
				System.out.println(" "+dist[dest]);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
