package test;

public class Test {
public void test() {
	Tabla t = new Tabla();
	City c1 = new City("A1", "c1");
	City c2 = new City("A2", "c2");
	City c3 = new City("A3", "c3");
	City c4 = new City("A4", "c4");
	City c5 = new City("A5", "c5");
	City c6 = new City("A6", "c6");
	City c7 = new City("A7", "c7");
	t.addCity(c1);
	t.addCity(c2);
	t.addCity(c3);
	t.addCity(c4);
	t.addCity(c5);
	t.addCity(c6);
	t.addCity(c7);
	t.showCity();
	
	t.addConnection(c6, c7);
	t.addConnection(c1, c7);
	t.addConnection(c2, c4);
	t.addConnection(c3, c5);
	t.addConnection(c4, c6);
	t.addConnection(c1, c5);
//	t.foreignTourCheapest(c7, 100);
//	t.foreignTourSheetForCountry(1000);
	t.deleteConnection(c6, c7);
	t.updateConnection(c2, c4, 66, c6);
	t.showTable();
}
}
