package level1;
import java.util.Scanner;
public class Caeser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String inputString=sc.nextLine();
		int n=sc.nextInt();
		System.out.println(n);
		
		StringBuffer out=new StringBuffer(inputString.length());
		
		for(int i=0;i<inputString.length();i++){
			
			if((inputString.charAt(i)>='a' && inputString.charAt(i)<='z') || (inputString.charAt(i)>='A' && inputString.charAt(i)<='Z')){
			 if(n>0){
				if (Character.isUpperCase(inputString.charAt(i)))
	            {
	                char ch = (char)(((int)inputString.charAt(i) +
	                                  n - 65) % 26 + 65);
	                out.append(ch);
	            }
	            else
	            {
	                char ch = (char)(((int)inputString.charAt(i) +
	                                  n - 97) % 26 + 97);
	                out.append(ch);
	            }}
			 else{
				 n=26+n;
				 if (Character.isUpperCase(inputString.charAt(i)))
		            {
		                char ch = (char)(((int)inputString.charAt(i) +
		                                  n - 65) % 26 + 65);
		                out.append(ch);
		            }
		            else
		            {
		                char ch = (char)(((int)inputString.charAt(i) +
		                                  n - 97) % 26 + 97);
		                out.append(ch);
		            }
			 }
	        }
			else{
				out.append(inputString.charAt(i));
				}
			}
			System.out.println(out);
			sc.close();
		}

	}

	
