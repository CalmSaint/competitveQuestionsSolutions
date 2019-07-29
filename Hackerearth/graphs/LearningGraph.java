package graphs;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class GraphLL implements Comparable<GraphLL>{
	public int index;
	public int value;
	@Override
	public int compareTo(GraphLL g) {
		if(this.value<g.value) {
			return -1;
		}
		else if(this.value>g.value) {
			return 1;
		}
		else if(this.value==g.value) {
			if(this.index<g.index) {
				return -1;
			}
			else return 1;
		}
		else {
			return 0;
		}
	}
	
	
}
public class LearningGraph {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in1=br.readLine().split("\\s+");
			int n=Integer.parseInt(in1[0]);
			int m=Integer.parseInt(in1[1]);
			int k=Integer.parseInt(in1[2])-1;
			
			//Adjacency List
			
			
			
			
			//Values List to fetch
			String[] valList=br.readLine().split("\\s+");
			
			List<GraphLL> valueList=new ArrayList<>();
			
			for (int i = 0; i <n; i++) {
				int value = Integer.parseInt(valList[i]);
				
				
				valueList.add(new GraphLL());
				valueList.get(i).index=i;
				valueList.get(i).value=value;
			}
			
			List<Integer> graph[]=new ArrayList[n];
			
			for (int i = 0; i < m; i++) {
				
				String[] edge=br.readLine().split("\\s+");
				
				int x=Integer.parseInt(edge[0])-1;
				int y=Integer.parseInt(edge[1])-1;
				
				if(graph[x]==null) {
					graph[x]=new ArrayList<>();
					graph[x].add(y);
				}
				else {
					graph[x].add(y);
				}
				
				if(graph[y]==null) {
					graph[y]=new ArrayList<>();
					graph[y].add(x);
				}
				else {
					graph[y].add(x);
				}
			}
			
			
			for (int i = 0; i < n; i++) {
				List<Integer> connNodes=graph[i];
				
				
				if(connNodes!=null) {
					List<GraphLL> temp=new ArrayList<>();
					
					for(int j=0;j<connNodes.size();j++) {
						temp.add(valueList.get(connNodes.get(j)));
					}
					
					
					Collections.sort(temp,Collections.reverseOrder());
					
					int node=temp.get(k).index;
					System.out.println(node+1);
				}
				else {
					System.out.println("-1");
				}
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
