package hackerearth;

import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class CountingSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String S = br.readLine();
         int Q = Integer.parseInt(br.readLine().trim());
         String[] arr = new String[Q];
         for(int i_arr=0; i_arr<Q; i_arr++)
         {
         	arr[i_arr] = br.readLine();
         }

         int[] out_ = helpPrivateRyan(S, arr);
         System.out.print(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] helpPrivateRyan(String S, String[] arr){
        
    	//total number of subsequences 2^n-1 (_n = length of String)
		int totalSubSeq=(int)(Math.pow(2,S.length()))%(1000000007);
		
		//List to store subsequences
		List<String> allSubSeq=new ArrayList<>();
		
		for (int i = 1; i < totalSubSeq; i++) {
			String temp="";
			for (int j = 0; j < S.length(); j++) {
				if(BigInteger.valueOf(i).testBit(j)) {
					temp+=S.charAt(j);
				}
			}
			allSubSeq.add(temp);
		}
		
		//array to store all outputs
		int[] output=new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			String character=arr[i];
			output[i]=(int)(allSubSeq.stream().filter(a->a.endsWith(character)).count()%(1000000007));
		}
		return output;
        
        
    
    }
}