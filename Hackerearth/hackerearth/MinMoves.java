package hackerearth;

import java.util.Scanner;

public class MinMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String[] In1=(sc.nextLine().split("\\s+"));
		
		int n=Integer.parseInt(In1[0]);
		int k=Integer.parseInt(In1[1]);
		
		String[] in2=(sc.nextLine().split("\\s+"));
		String[] in3=(sc.nextLine().split("\\s+"));
		
		int moves=0;
		for(int i=0;i<k;i++){
			int x1=Integer.parseInt(in2[i]);
			int y1=Integer.parseInt(in3[i]);
			
			if(x1>(n/2)){
				moves+=(n-x1);
			}
			else {
				moves+=(x1-1);
			}
			if(y1>=(n/2)){
				moves+=(n-y1);
			}
			else {
				moves+=(y1-1);
			}
			
		}
		System.out.println(moves);
		

	}

}
