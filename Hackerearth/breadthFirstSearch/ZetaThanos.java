package breadthFirstSearch;

import java.io.*;
import java.util.*;
public class ZetaThanos {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			String[] in1=br.readLine().split("\\s+");
			int n=Integer.parseInt(in1[0]);
			int m=Integer.parseInt(in1[1]);
			
			List<String> wakanda[]=new LinkedList[n];
			for (int i = 0; i < wakanda.length; i++) {
				wakanda[i]=new LinkedList<>();
			}
			
			for (int i = 0; i < n; i++) {
				String[] in=br.readLine().split("\\s+");
				for (int j = 0; j < m; j++) {
					wakanda[i].add(in[0]);
				}
			}
			
			String[] in2=br.readLine().split("\\s+");
			int a=Integer.parseInt(in2[0])-1;
			int b=Integer.parseInt(in2[1])-1;
			
			int q=Integer.parseInt(br.readLine());
			while(q-- > 0) {
				String[] in3=br.readLine().split("\\s+");
				int x=Integer.parseInt(in3[0])-1;
				int y=Integer.parseInt(in3[1])-1;
				
				if(wakanda[x].get(y).equals("*")) {
					System.out.println("-1 -1");
					break;
				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
