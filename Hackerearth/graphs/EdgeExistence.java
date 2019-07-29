package graphs;
import java.io.*;
public class EdgeExistence {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in1=br.readLine().split("\\s+");
			int n=Integer.parseInt(in1[0]);
			int m=Integer.parseInt(in1[1]);
			boolean[][] graph=new boolean[n][n];
			for(int i=0;i<m;i++) {
				String[] in2=br.readLine().split("\\s+");
				int a=Integer.parseInt(in2[0]);
				int b=Integer.parseInt(in2[1]);
				graph[a][b]=true;
			}
			int q=Integer.parseInt(br.readLine());
			for(int i=0;i<q;i++) {
				String[] in3=br.readLine().split("\\s+");
				int a=Integer.parseInt(in3[0]);
				int b=Integer.parseInt(in3[1]);
				if(graph[a][b]) System.out.println("YES");
				else System.out.println("NO");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
