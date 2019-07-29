package hackerearth;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class PicuBank {

	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			int testCase=Integer.parseInt(br.readLine());
			
			for(int i=0;i<testCase;i++){
				List<Long> inList=Arrays.stream(br.readLine().split("\\s+")).map(a->Long.parseLong(a)).collect(Collectors.toList());
				
				Long sum=inList.get(0);
				long count=0L;
				Boolean flag=true;
				while(flag){
					for(int j=0;j<inList.get(2);j++){
						sum+=inList.get(1);
						count+=1L;
						if(sum>=inList.get(4)){
							flag=false;
							break;
						}
					}
					if(flag){
						sum+=inList.get(3);
						count+=1;
						if(sum>=inList.get(4)){
							flag=false;
						}
					}
					
				}
				System.out.println(count);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
