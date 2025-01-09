package test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class City {
	private String name;
	private String country;
	private List<Connection> adjacents;
	public City(String name, String country) {
		super();
		this.name = name;
		this.country = country;
		this.adjacents = new LinkedList<Connection>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Connection> getAdjacents() {
		return adjacents;
	}
	public void setAdjacents(List<Connection> adjacents) {
		this.adjacents = adjacents;
	}
	public Connection addConnection(double distance, double price, City value) {
		for(Connection i:adjacents) {
			if( i.getValue().getName().equalsIgnoreCase(name)&&i.getValue().getCountry().equalsIgnoreCase(country)) {
				System.out.println("----------------------------------");
				System.out.println("ERROR: 'Connection' already exist!");
				System.out.println("----------------------------------");
				return null;
			}
		}
		Connection connection = new Connection(distance, price, value);
		adjacents.add(connection);
		return connection;
	}
	@Override
	public String toString() {
		String adjacentToString="";
		for(int i=0; i<adjacents.size();i++) {
			adjacentToString+=adjacents.get(i).getValue().getName()+" ";
		}
		return name + "(" + country +")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof City) {
			City city = (City)obj;
			if(city.getName().equalsIgnoreCase(name)&&city.getCountry().equalsIgnoreCase(country)) {
				return true;
			}
		}
		return false;
	}
	
}
