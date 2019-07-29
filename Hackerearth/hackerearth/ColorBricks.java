package hackerearth;
import java.io.*;
import java.util.*;
public class ColorBricks {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			Integer testCases=Integer.parseInt(br.readLine().split("\\s+")[0]);
			for (int i = 0; i < testCases; i++) {
				
				Integer bricks=Integer.parseInt(br.readLine().split("\\s+")[0]);
				
				
				Double modulo=Math.pow(10, 9)+7;
				System.out.println((int)(3*(Math.pow(2, bricks-1)%modulo)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
