// Car Rental System
// Design a Java program to manage a car rental system using a HashMap<String, Boolean>, where the key is the car registration number, and the value is a boolean indicating whether the car is available or not.
// Implement methods to add a new car, rent a car, return a car, and display the list of available cars.

public class Car {

    public static void main(String[] args) {

        Rentcar car = new Rentcar();

        // add car
        car.Addcar("abcd", "2X", "2020");
        car.Addcar("egfg", "2Y", "2022");
        car.Addcar("helloyes", "2AB", "2019");

        // rent car
        car.Rent("abcd", "prarthana", "9313935733", "14 dec 2024", "20 dec 2024", "6 days");

        // display availabel cars
        car.display();

        // display customers
        car.displaycustomer();

        // update customers
        car.updatecustomer("Prarthana Galani", "9313935733", "abcd", "25 dec 2024", "11 days");

        car.displaycustomer();

        // update car
        car.updatecar("egfg", "2YX", "2023");

        // display car
        car.displaycar();

        // get rented car back
        car.freeup("abcd");

        // delete car
        // car.deletecar("abcd");

        car.display();

        car.displaycustomer();

    }

}
