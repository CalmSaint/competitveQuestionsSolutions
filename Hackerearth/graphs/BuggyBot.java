package graphs;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class GraphBot {
	public int vertices;
	
	LinkedList<Integer> connNodes[];
	public GraphBot(int vertices) {
		this.vertices=vertices;
		connNodes=new LinkedList[vertices+1];
		
		for (int i = 1; i <= vertices; i++) {
			connNodes[i]=new LinkedList<>();
			
		}
		
	}
	
}

class Instruction{
	int src;
	int dest;
	
	Instruction(int src,int dest) {
		this.src=src;
		this.dest=dest;
	}
}
public class BuggyBot {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in1=br.readLine().split("\\s+");
			int n=Integer.parseInt(in1[0]);
			int m=Integer.parseInt(in1[1]);
			int k=Integer.parseInt(in1[2]);
			
			GraphBot graph=new GraphBot(n);
			for (int i = 0; i < m; i++) {
				String[] edge=br.readLine().split("\\s+");
				int a=Integer.parseInt(edge[0]);
				int b=Integer.parseInt(edge[1]);
				graph.connNodes[a].add(b);
			}
			
			int currentNode=1;
			
			
			//possible currentnodes
			
			
			//instructions List
			List<Instruction> instructions=new ArrayList<>();
			
			List<Integer> pNodes=new ArrayList<>();
			
			for (int i = 0; i < k; i++) {
				String[] in=br.readLine().split("\\s+");
				int x=Integer.parseInt(in[0]);
				int y=Integer.parseInt(in[1]);
				instructions.add(new Instruction(x,y));
			}
			List<Integer> finalNodes=new ArrayList<>();
			
				for (int i = 0; i < k; i++) {
					if(currentNode==instructions.get(i).src && graph.connNodes[instructions.get(i).src].contains(instructions.get(i).dest)) {
						currentNode=instructions.get(i).dest;
						
					}
					else if(currentNode!=instructions.get(i).src) {
						if(currentNode+1==instructions.get(i).src && graph.connNodes[currentNode+1].contains(instructions.get(i).dest)) {
							if(!pNodes.contains(instructions.get(i).src))
							pNodes.add(instructions.get(i).src);
						}
					}
				}
				finalNodes.add(currentNode);
				
				pNodes.sort((a,b)->a-b);
				
				int flag=0;
				while(!pNodes.isEmpty()) {
					int pNode=pNodes.get(flag);
					currentNode=pNode;
					pNodes.remove(flag);
					for (int i = 0; i < k; i++) {
						if(currentNode==instructions.get(i).src && graph.connNodes[instructions.get(i).src].contains(instructions.get(i).dest)) {
							currentNode=instructions.get(i).dest;
							
						}
						else if(currentNode!=instructions.get(i).src) {
							if(currentNode+1==instructions.get(i).src && graph.connNodes[currentNode+1].contains(instructions.get(i).dest)) {
								pNodes.add(instructions.get(i).src);
								
							}
						}
					}
					if(!finalNodes.contains(currentNode)) finalNodes.add(currentNode);
					
				}
				
			
			System.out.println(finalNodes.size());
			Collections.sort(finalNodes);
			
			System.out.println(finalNodes.stream().map(a->String.valueOf(a)).collect(Collectors.joining(" ")));; 
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
