package hackerearth;
import java.util.*;


public class Spell {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int testCase=Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<testCase;i++){
			String word=sc.nextLine();
			word=word.replaceAll("[^[bcdfghjklmnpqrstvwxyz]]","");
			
			if(word.isEmpty()){
				System.out.println("Good");
				continue;
			}
			
			word=word.replaceAll("(.)(?=.*\\1)","");
			System.out.println(word);
			int flag=order(word);
			if(flag==1){
				System.out.println("Good");
			}else if(flag==2){
				System.out.println("Worst");
			}
			else{
				System.out.println("Bad");
			}
			
			
		}
		sc.close();

	}
	static int order(String word){
		String vowels="aeiou";
		List<Integer> a=new ArrayList<>();
		for(int i=0;i<word.length();i++){
			a.add(vowels.indexOf(word.charAt(i)));
		}
		
		List<Integer> b=new ArrayList<>(a);
		Collections.sort(b);
		if(a.equals(b)){
			return 1;
		}
		Collections.reverse(b);
		if(a.equals(b)){
			return 2;
		}else{
			return 0;
		}
	}

}
