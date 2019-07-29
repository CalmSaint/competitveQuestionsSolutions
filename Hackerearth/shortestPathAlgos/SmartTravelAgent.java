package shortestPathAlgos;

import java.io.*;
import java.util.*;
public class SmartTravelAgent {
	
	class Map{
		int cities;
		int roads;
		HashSet<SmartTravelAgent.City> connectedCities[];
		
		Map(int cities,int roads){
			this.cities=cities;
			this.roads=roads;
			connectedCities=new HashSet[cities+1];
			
			for (int i = 0; i < connectedCities.length; i++) {
				connectedCities[i]=new HashSet<SmartTravelAgent.City>();
			}
		}
	}
	
	class City implements Comparable<SmartTravelAgent.City>{
		int cityNum;
		int capacity;
		
		City(int cityNum,int capacity){
			this.cityNum=cityNum;
			this.capacity=capacity;
		}
		@Override
		public boolean equals(Object obj) {
			SmartTravelAgent.City city=(SmartTravelAgent.City)obj;
			if(city.cityNum==this.cityNum && city.capacity==this.capacity) return true;
			return false;
		}
		
		@Override
		public int hashCode() {
			return this.cityNum*this.capacity;
		}
		
		@Override
		public int compareTo(City o) {
			if(this.capacity>o.capacity) return -1;
			return 1;
		}
	}
	public static void main(String[] args) {
		try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
			
			//first Input Line
			String[] firstInputLine=br.readLine().split("\\s+");
			int numCities=Integer.parseInt(firstInputLine[0]);
			int numRoads=Integer.parseInt(firstInputLine[1]);
			
			SmartTravelAgent agent=new SmartTravelAgent();
			SmartTravelAgent.Map map=agent.new Map(numCities,numRoads);
			
			//Roads
			for (int i = 0; i < numRoads; i++) {
				String[] secondInputLine=br.readLine().split("\\s+");
				int city1=Integer.parseInt(secondInputLine[0]);
				int city2=Integer.parseInt(secondInputLine[1]);
				int capacity=Integer.parseInt(secondInputLine[2]);
				
				//creating the map
				map.connectedCities[city1].add(agent.new City(city2,capacity));
				map.connectedCities[city2].add(agent.new City(city1,capacity));
			}
			
			//last Input Line
			String[] lastInputLine=br.readLine().split("\\s+");
			int srcCity=Integer.parseInt(lastInputLine[0]);
			int destCity=Integer.parseInt(lastInputLine[1]);
			int numTourists=Integer.parseInt(lastInputLine[2]);
			
			// passengers capacity array
			int[] cap=new int[numCities+1];
			Arrays.fill(cap,Integer.MIN_VALUE);
			cap[srcCity]=numTourists;
			
			//priority queue
			PriorityQueue<SmartTravelAgent.City> queue=new PriorityQueue<>();
			queue.add(agent.new City(srcCity,cap[srcCity]));
			
			//array to track visited cities
			boolean[] visited=new boolean[numCities+1];
			Arrays.fill(visited, false);
			
			int[] route=new int[numCities+1];
			while(!queue.isEmpty()) {
				
				SmartTravelAgent.City city=queue.poll();
				int cityNum=city.cityNum;
				int preCap=city.capacity;
				
				if(visited[cityNum]) continue; //check whether city is visited or not
				visited[cityNum]=true;
				
				Iterator<SmartTravelAgent.City> data=map.connectedCities[cityNum].iterator();
				while(data.hasNext()) {
					SmartTravelAgent.City adjCity=data.next();
					int busCap=adjCity.capacity;
					int touristTaken;
					if((preCap+1)>=busCap) touristTaken=busCap-1;
					else touristTaken=preCap;
					
					if(cap[adjCity.cityNum]<touristTaken) {
						cap[adjCity.cityNum]=touristTaken;
						route[adjCity.cityNum]=city.cityNum;
						queue.add(agent.new City(adjCity.cityNum, touristTaken));
					}
				}
			}
			
			int dest1=destCity;
			int kt;
			ArrayList<Integer> nn=new ArrayList<>();
			
			while(true) {
				kt=route[dest1];
				dest1=kt;
				if(kt==srcCity || kt==0) {
					if(kt==srcCity) nn.add(kt);
					break;
				}
				nn.add(kt);
			}
			Collections.reverse(nn);
			nn.forEach(a->System.out.print(a+" "));
			System.out.println(destCity);
			
			System.out.println((int)Math.ceil((double)numTourists/cap[destCity]));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
