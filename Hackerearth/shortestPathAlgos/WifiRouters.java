package shortestPathAlgos;

import java.io.*;
import java.util.*;
public class WifiRouters {

	class Coordinate{
		int x;
		int y;
		
		
		Coordinate(int x,int y) {
			this.x=x;
			this.y=y;
			
		}
		double distance(Coordinate c) {
			return Math.sqrt((this.x-c.x)+(this.y-c.y));
		}
	}
	
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			int testCase=Integer.parseInt(br.readLine().split("\\s+")[0]);
			while(testCase-->0) {
				
				int numRouters=Integer.parseInt(br.readLine().split("\\s+")[0]);
				int numUsers=Integer.parseInt(br.readLine().split("\\s+")[1]);
				
				WifiRouters parent=new WifiRouters(); //instantiating the parent class
				ArrayList<WifiRouters.Coordinate> routers=new ArrayList<>(); //list for routers
				for (int i = 0; i < numRouters; i++) {
					String[] line=br.readLine().split("\\s+");
					routers.add(parent.new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
				}
				
				ArrayList<WifiRouters.Coordinate> users=new ArrayList<>(); //list for users
				for (int i = 0; i < numUsers; i++) {
					String[] line=br.readLine().split("\\s+");
					users.add(parent.new Coordinate(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
				}
				
				double maxRouter;
				double maxUser;
				
				//to find max distance between any user and his nearest router
				double minUser=Double.MAX_VALUE;
				Iterator<WifiRouters.Coordinate> data=users.iterator();
				while(data.hasNext()) {
					WifiRouters.Coordinate next=data.next();
					
					Iterator<WifiRouters.Coordinate> data1=routers.iterator();
					while(data1.hasNext()) {
						WifiRouters.Coordinate router=data1.next();
						double distance=next.distance(router);
						if(distance<minUser) minUser=distance;
					}
				}
				
				
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
