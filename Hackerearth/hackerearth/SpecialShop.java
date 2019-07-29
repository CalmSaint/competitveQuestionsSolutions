package hackerearth;



import java.io.*;

public class SpecialShop {

	public static void main(String[] args) {
		
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in));){
			int testCase=Integer.parseInt(br.readLine());
			SpecialShop s=new SpecialShop();
			for(int i=0;i<testCase;i++){
				String[] input=br.readLine().split("\\s+");
				
				Long n=Long.parseLong(input[0]);
				
				Double a=Double.parseDouble(input[1]);
				Double b=Double.parseDouble(input[2]);
				long xx=s.findMin(n,a,b);
				System.out.println(xx);
			
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public long findMin(long n,double a,double b){
		long xx=Math.round((b*n)/(a+b));
		return (long)(a*(Math.pow(xx, 2.0))+b*(Math.pow(n-xx,2.0)));
		
	}

}
