package shortestPathAlgos;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class BoozeFirst {

	class Graph{
		int nodes;
		int edges;
		HashSet<BoozeFirst.Node> connNodes[];
		Graph(int nodes,int edges){
			this.nodes=nodes;
			this.edges=edges;
			connNodes=new HashSet[nodes+1];
			for (int i = 0; i < connNodes.length; i++) {
				connNodes[i]=new HashSet<>();
			}
			
		}
	}
	
	class Node implements Comparable<BoozeFirst.Node>{
		int node;
		int length;
		
		
		Node(int node,int length){
			this.node=node;
			this.length=length;
			
		}
		
		@Override
		public boolean equals(Object obj) {
			BoozeFirst.Node nod=(BoozeFirst.Node)obj;
			if(this.node==nod.node && this.length==nod.length) return true;
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.node*this.length;
		}

		@Override
		public int compareTo(Node o) {
			if(this.length>o.length) return 1;
			return -1;
		}
	}
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] firstLine=br.readLine().split("\\s+");
			int points=Integer.parseInt(firstLine[0]);
			int edges=Integer.parseInt(firstLine[1]);
			
			BoozeFirst booze=new BoozeFirst();
			BoozeFirst.Graph graph=booze.new Graph(points, edges);
			
			for (int i = 0; i < edges; i++) {
				String[] nextLines=br.readLine().split("\\s+");
				int u=Integer.parseInt(nextLines[0]);
				int v=Integer.parseInt(nextLines[1]);
				int w=Integer.parseInt(nextLines[2]);
				graph.connNodes[u].add(booze.new Node(v, w));
				graph.connNodes[v].add(booze.new Node(u, w));
			}
			
			int totalShops=Integer.parseInt(br.readLine().split("\\s+")[0]);
			
			String[] lastLine=br.readLine().split("\\s+");
			boolean[] shops=new boolean[points+1];
			Arrays.fill(shops, false);
			
			for (int i = 0; i <lastLine.length; i++) {
				shops[Integer.parseInt(lastLine[i])]=true;
			}
			int[] dist=new int[points+1];
			
			
			boolean[] visited=new boolean[points+1];
			
			
			for (int i = 1; i < points+1; i++) {
				Arrays.fill(dist,Integer.MAX_VALUE);
				Arrays.fill(visited, false);
				dist[i]=0;
				
				PriorityQueue<BoozeFirst.Node> queue=new PriorityQueue<>();
				queue.add(booze.new Node(i,dist[i]));
				
				while(!queue.isEmpty()) {
					BoozeFirst.Node nod=queue.poll();
					int node=nod.node;
					
					if(visited[node]) continue;
					visited[node]=true;
					
					Iterator<BoozeFirst.Node> data=graph.connNodes[node].iterator();
					while(data.hasNext()) {
						BoozeFirst.Node next=data.next();
						int newNode=next.node;
						int distance=next.length;
						if(dist[newNode]>(dist[node]+distance)) {
							dist[newNode]=dist[node]+distance;
							queue.add(booze.new Node(newNode, dist[newNode]));
						}
					}
					
				}
				ArrayList<Integer> output=new ArrayList<>();
				for (int j = 0; j < dist.length; j++) {
					if(shops[j]==true) output.add(dist[j]);
				}
				System.out.println(Collections.min(output));
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
