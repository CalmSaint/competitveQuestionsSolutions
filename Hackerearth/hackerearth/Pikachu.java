package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pikachu {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int n=Integer.parseInt(br.readLine());
			char[] s=br.readLine().toCharArray();
			char[] t=br.readLine().toCharArray();
			int days=0;
			for(int i=0;i<n;i++) {
				if(s[i]!=t[i]) {
					int b=t[i]-s[i];
					if(b<0) {
						int bb=('Z'-s[i])+(t[i]-'A')+1;
						days+=((bb/13)+(bb%13));
					}
					else days+=((b/13)+(b%13));
					
					
					
				}
			}
			System.out.println(days);
		}
		catch(Exception e) {
			
		}

	}

}
