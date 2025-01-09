package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Tabla {
private List<City> graph;
Scanner scanner = new Scanner(System.in);

public Tabla() {
	super();
	this.graph = new LinkedList<City>();
}

public List<City> getGraph() {
	return graph;
}

public void setGraph(List<City> graph) {
	this.graph = graph;
}

public void addCity(City city) {
		if(graph.contains(city)) {
			System.out.println("ERROR: 'Element' already exist!");
			return;
		}
	graph.add(city);
}

public void deleteCity(City city) {
	if(!graph.contains(city)) {
		System.out.println("Error element wasn't detected!");
		return;
	}
	for(City c: graph) {
		for(int i=0; i<c.getAdjacents().size();i++) {
			if(c.getAdjacents().get(i).getValue().equals(city)) {
				c.getAdjacents().remove(c.getAdjacents().get(i));
			}
		}
	}
	graph.remove(graph.indexOf(city));
}
public void deleteConnection(City city1,City city2) {
	if(city1==null||city2==null) {
		System.out.println("Error: city is null");
		return;
	}
	for(City c: graph) {
		if(c.equals(city1)) {
			for(int i=0;i<c.getAdjacents().size();i++) {
				if(c.getAdjacents().get(i).getValue().equals(city2)) {
				c.getAdjacents().remove(c.getAdjacents().get(i));
				}
			}
		}
		if(c.equals(city2)) {
			for(int i=0;i<c.getAdjacents().size();i++) {
				if(c.getAdjacents().get(i).getValue().equals(city1)) {
				c.getAdjacents().remove(c.getAdjacents().get(i));
				}
			}
		}
	}
}
public void addConnection(City city1,City city2) {
	if(city1.getAdjacents().contains(city2)) {
		System.out.println("ERROR: 'Connection' already exist!");
		return;
	}
	if(city1==null||city2==null) {
		System.out.println("Error: city is null");
		return;
	}
	System.out.println("Connection between "+city1+" and "+city2);
	System.out.println("Enter your distance:");
	int dis=scanner.nextInt();
	if(city1.getCountry().equalsIgnoreCase(city2.getCountry())) {
		city1.addConnection(dis, 0.10, city2);
		city2.addConnection(dis, 0.10, city1);
		
	}else {
		Connection c1= city1.addConnection(dis, 0.15, city2);
		Connection c2= city2.addConnection(dis, 0.15, city1);
	
	}
}
public void showCity() {
	int p=1;
	for (int i = 0; i < graph.size(); i++) {
		System.out.print(p+") "+graph.get(i).toString()+" \n");
		p++;
	}
}
public void showTableRounded() {
	String line="";
	for(City city: graph) {
		line+=city.getName()+"("+city.getCountry()+")";
		for(Connection con: city.getAdjacents()) {
			line+="-"+Math.round(con.getDistance())+"-"+con.getValue();
		}
		line+="\n";
	}
	System.out.println(line);
}
public void showTable() {
	String line="";
	for(City city: graph) {
		line+=city.getName()+"("+city.getCountry()+")";
		for(Connection con: city.getAdjacents()) {
			line+="-"+con.getDistance()+"-"+con.getValue();
		}
		line+="\n";
	}
	System.out.println(line);
}
public void showTablePrice() {
	String line="";
	for(City city: graph) {
		line+=city.getName()+"("+city.getCountry()+")";
		for(Connection con: city.getAdjacents()) {
			line+="-"+(con.getDistance()*con.getPrice())+"-"+con.getValue();
		}
		line+="\n";
	}
	System.out.println(line);
}
public void foreignTourCheapest(City current, double money) {
	String line="";
	Connection min=null;
	for(City city: graph) {
		for(Connection con:city.getAdjacents()) {
			if(!current.getCountry().equalsIgnoreCase(con.getValue().getCountry())
					&&money>=(con.getPrice()*con.getDistance())&&!con.getValue().equals(current)) {
				if(min==null) {
					min=con;
					line=current.getName()+"-"+con.getValue().getName()
							+"\n"+"Price: "+(con.getPrice()*con.getDistance())+"\n"+"distance:"+con.getDistance()+"\n";
					continue;
				}
				if(min.getPrice()>con.getPrice()) {
					line=current.getName()+"-"+con.getValue().getName()
					+"\n"+"Price: "+(con.getPrice()*con.getDistance())+"\n"+"distance:"+con.getDistance()+"\n";
					continue;
				}
			}
		}
	}
	System.out.println("\nCheapest tour\n"+line+"--------------------");
}
public boolean updateCity(City city, String name, String country) {
	for(City c:graph) {
		if(c.equals(city)) {
			c.setName(name);
			c.setCountry(country);
			System.out.println("Element moded!");
			return true;
		}
	}
	System.out.println("Element not exist!");
	return false;
}
//можно не указывать дистанцию или конечный город, аргументы затычки distance: -1, newEndCity: null
public void updateConnection(City currentCity, City endCity, int distance, City newEndCity) {
	 if(currentCity==null||endCity==null) {
		 System.out.println("Error: element is null (city)!");
		 return;
	 }
	 if(newEndCity==null&&distance==-1) {
		 System.out.println("Attention! You tried to change nothing!(≧▽≦)");
		 return;
	 }
	 for(City city: graph) {
		 if(city.equals(currentCity)) {
			 for(Connection conn: city.getAdjacents()) {
				 if(conn.getValue().equals(endCity)) {
					 if(distance!=-1) {
						 conn.setDistance(distance);
					 }
					 if(newEndCity!=null) {
						 conn.setValue(newEndCity);
						 for(City city2: graph) {
							 if(city2.equals(endCity)) {
								 for(Connection conn2: city2.getAdjacents()) {
									 if(conn2.getValue().equals(currentCity)) {
										 city2.getAdjacents().remove(city2.getAdjacents().indexOf(conn2)); 
									 }
								 }
							 }
						 }
					 }
					 System.out.println("Updated successfully!");
					 
				 }
			 }
		 }
	 }
}
public void foreignTourSheetForCountry(double money) {
	String line="";
	for(City city: graph) {
		line+=city.getName()+"("+city.getCountry()+")";
		for(Connection con: city.getAdjacents()) {
			if(!city.getCountry().equalsIgnoreCase(con.getValue().getCountry())) {
			line+="-"+(con.getDistance()*con.getPrice())+"-"+con.getValue();
			}
		}
		line+="\n";
	}
	System.out.println(line);
}
}





















