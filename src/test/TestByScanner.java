package test;

import java.util.Scanner;

public class TestByScanner {
    private static Scanner scan = new Scanner(System.in);

    public void test() {
        Tabla tabla = new Tabla();
        System.out.println("=== Railway System ===");

        while (true) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add city");
            System.out.println("2. Show list of cities");
            System.out.println("3. Add connection between cities");
            System.out.println("4. Display list of routes(distance)");
            System.out.println("5. Display list of routes(price)");
            System.out.println("6. Find the cheapest international");
            System.out.println("7. Delete city");
            System.out.println("8. Delete connection");
            System.out.println("9. ForeignTourSheetForCountry");
            System.out.println("10. Update city");
            System.out.println("11. Update connection");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            
            int choice = scan.nextInt();
            scan.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String name = scan.next();
                    System.out.println();
                    System.out.print("Enter country name: ");
                    String country = scan.next();
                    City city = new City(name, country);
                    tabla.addCity(city);
                    break;
                case 2:
                    tabla.showCity();
                    break;
                case 3:
                    System.out.print("Enter place of departure (name): ");
                    String nameDeparture = scan.next();
                    System.out.println();
                    System.out.print("Enter place of departure (country): ");
                    String countryDeparture = scan.next();
                    System.out.print("Enter place of arrival (name): ");
                    String nameArrival = scan.next();
                    System.out.println();
                    System.out.print("Enter place of arrival (country): ");
                    String countryArrival = scan.next();
                    City c1 = new City(nameDeparture, countryDeparture);
                    City c2 = new City(nameArrival, countryArrival);
                    tabla.addConnection(c1, c2);
                    break;
                case 4:
                    tabla.showTable();
                    break;
                case 5:
                    tabla.showTablePrice();
                    break;
                case 6:
                    tabla.showCity();
                    System.out.print("Enter city index: ");
                    int citys = scan.nextInt();
                    System.out.println();
                    System.out.print("Enter price: ");
                    double money = scan.nextDouble();
                    tabla.foreignTourCheapest(tabla.getGraph().get(citys - 1), money);
                    break;
                case 7:
                    System.out.print("Enter the name of the city to delete: ");
                    String cityNameToDelete = scan.nextLine();
                    System.out.print("Enter the country: ");
                    String cityCountryToDelete = scan.nextLine();
                    tabla.deleteCity(new City(cityNameToDelete, cityCountryToDelete));
                    break;
                case 8:
                    System.out.print("Enter departure city (name): ");
                    String departureCity = scan.nextLine();
                    System.out.print("Enter departure city (country): ");
                    String departureCountry = scan.nextLine();
                    System.out.print("Enter arrival city (name): ");
                    String arrivalCity = scan.nextLine();
                    System.out.print("Enter arrival city (country): ");
                    String arrivalCountry = scan.nextLine();
                    City depCity = new City(departureCity, departureCountry);
                    City arrCity = new City(arrivalCity, arrivalCountry);
                    tabla.deleteConnection(depCity, arrCity);
                    break;
                case 9:
                    System.out.print("Enter price: ");
                    double moneyf = scan.nextDouble();
                    tabla.foreignTourSheetForCountry( moneyf);
                    break;
                case 10:
                	 tabla.showCity();
                	 System.out.print("Enter current city: ");
                     int currentCity = scan.nextInt();
                     tabla.showCity();
                     System.out.print("Enter destination city: ");
                     int destinationCity = scan.nextInt();
                     System.out.print("Enter new distance (to ignore, enter: -1): ");
                     int distance = scan.nextInt();
                     System.out.print("Enter new destination city (to ignore, enter: null): ");
                     int newDestinationCity=scan.nextInt();
                     tabla.updateConnection(tabla.getGraph().get(currentCity-1), tabla.getGraph().get(destinationCity-1), 
                    		 distance, tabla.getGraph().get(newDestinationCity-1));
                    return;
                case 11:
                	tabla.showCity();
                	System.out.println("Enter the city: ");
                	int updateCity=scan.nextInt();
                	System.out.println("Enter new name of city: ");
                	String updateNameCity=scan.next();
                	System.out.println("Enter new country of city: ");
                	String updateCountryCity=scan.next();
                	tabla.updateCity(tabla.getGraph().get(updateCity-1), updateNameCity, updateCountryCity);
                    return;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Error: Invalid choice!");
            }
        }
    }
}

