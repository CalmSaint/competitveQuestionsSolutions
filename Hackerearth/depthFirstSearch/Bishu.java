package depthFirstSearch;

import java.io.*;
import java.util.*;
public class Bishu {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			int country=Integer.parseInt(br.readLine());
			LinkedList<Integer> connRoads[]=new LinkedList[country+1];
			for (int i = 0; i < connRoads.length; i++) {
				connRoads[i]=new LinkedList<>();
			}
			for (int i = 0; i < country-1; i++) {
				String[] in=br.readLine().split("\\s+");
				
				int u=Integer.parseInt(in[0]);
				int v=Integer.parseInt(in[1]);
				
				connRoads[u].add(v);
				connRoads[v].add(u);
			}
			
			Stack<Integer> stack=new Stack<>();
	 	    boolean[] visited=new boolean[country+1];
	 	    Arrays.fill(visited, false);
	 	    visited[1]=true;
	 	    
	 	    stack.push(1);
	 	    int[] dist=new int[country+1];
	 	    dist[1]=0;
	 	    while(!stack.isEmpty()) {
	 	    	int source=stack.pop();
	 	    	Iterator<Integer> data=connRoads[source].iterator();
	 	    	while(data.hasNext()) {
	 	    		int child=data.next();
	 	    		if(visited[child]==false) {
	 	    			dist[child]=dist[source]+1;
	 	    			visited[child]=true;
	 	    			stack.push(child);
	 	    		}
	 	    		
	 	    	}
	 	    }
	 	    int q=Integer.parseInt(br.readLine());
	 	    int[] out=new int[q];
	 	    for (int i = 0; i < out.length; i++) {
				out[i]=Integer.parseInt(br.readLine());
			}
	 	    Arrays.sort(out);
	 	    int min=dist[out[0]];
	 	    int outt=out[0]
;	 	    for (int i = 1; i < out.length; i++) {
				if(dist[out[i]]<min) {
					min=dist[out[i]];
					outt=out[i];
				}
			}
			System.out.println(outt);
	 	    
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}

