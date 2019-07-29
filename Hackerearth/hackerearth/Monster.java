package hackerearth;

import java.io.*;
public class Monster {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int testCase=Integer.parseInt(br.readLine());
			for(int l=0;l<testCase;l++) {
				String[] in=br.readLine().split("\\s+");
				
				String input=in[0];
				
				int k=Integer.parseInt(in[1]);
				
				char[] charArray=input.toCharArray();
				int count=0;
				for(int i=0;i<=charArray.length-k;i++) {
					if(charArray[i]=='0') {
						for(int j=i;j<k+i;j++) {
							if(charArray[j]=='0') {
								charArray[j]='1';
							}
							else {
								charArray[j]='0';
							}
						}
						count++;
					}
				}
				String fin=String.valueOf(charArray);
				
				if(fin.contains("0")) {
					System.out.println("-1");
				}
				else {
					System.out.println(count);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
