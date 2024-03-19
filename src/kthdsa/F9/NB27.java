package kthdsa.F9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Car implements Comparable<Car> {
    private String brand;
    private int year;
    private int mileage;

    public Car(String brand, int year, int mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public int compareTo(Car other) {
        return this.brand.compareTo(other.brand);
    }
}

class CompareCar implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getYear(), car2.getYear());
    }
}

public class NB27 {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        // Läs in bilar från textfil till array
        try (Scanner scanner = new Scanner(new File("bilar.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String brand = parts[0];
                int year = Integer.parseInt(parts[1]);
                int mileage = Integer.parseInt(parts[2]);
                cars.add(new Car(brand, year, mileage));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta filen.");
            e.printStackTrace();
        }

        // Sortera bilar efter bilmärke och skriv till ny textfil
        Collections.sort(cars);
        writeToFile(cars, "bilar_sorted_by_brand.txt");

        // Sortera bilar efter årsmodell och skriv till annan textfil
        Collections.sort(cars, new CompareCar());
        writeToFile(cars, "bilar_sorted_by_year.txt");
    }

    private static void writeToFile(ArrayList<Car> cars, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Car car : cars) {
                writer.println(car.getBrand() + "," + car.getYear() + "," + car.getMileage());
            }
        } catch (IOException e) {
            System.out.println("Ett fel uppstod vid skrivning till filen " + filename);
            e.printStackTrace();
        }
    }
}
