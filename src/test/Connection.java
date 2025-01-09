package test;

import java.util.Objects;

public class Connection {
private double distance;
private double price;

private City value;
public Connection(double distance, double price, City value) {
	super();
	this.distance = distance;
	this.price = price;
	this.value = value;
}

public double getDistance() {
	return distance;
}
public void setDistance(double distance) {
	this.distance = distance;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public City getValue() {
	return value;
}
public void setValue(City value) {
	this.value = value;
}
@Override
public boolean equals(Object obj) {
	if (obj instanceof Connection) {
		Connection o = (Connection)obj;
		if(o.getDistance()==distance&&value.equals(o.getValue())) {
			return true;
		}
	}
	return false;
}

}
