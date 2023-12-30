import java.util.HashMap;

public class Rentcar {

    HashMap<String, Boolean> map = new HashMap<>();
    String[][] customer = new String[10][5];
    String[][] carinfo = new String[10][3];
    int i = 0, total_rented = 0, total_cars = 0;
    HashMap<String, String> history = new HashMap<>();
    int j = 0; // car,name

    public void Addcar(String c, String model, String year) {
        map.put(c, true);

        // add more info
        carinfo[j][0] = c;
        carinfo[j][1] = model;
        carinfo[j][2] = year;
        j++;
        total_cars++;

        System.out.println("Car added succesfully!!");

    }

    // called by customer
    public void Rent(String c, String name, String mobile, String rental_date, String return_date, String duration) {
        if (map.containsKey(c) && map.get(c) == true) {
            map.put(c, false);
            // adding customer to list
            customer[i][0] = name;
            customer[i][1] = mobile;
            customer[i][2] = rental_date;
            customer[i][3] = return_date;
            customer[i][4] = duration;
            history.put(c, name);
            i++;
            total_rented++;

            System.out.println("car rented successfully!!");
        } else {
            System.out.println("car is not available for rent.");
        }
    }

    // free up rented car
    public void freeup(String c) {

        if (map.containsKey(c)) {
            map.put(c, true);

            String name = history.get(c);

            history.remove(c);

            // delete customer
            for (int j = 0; j < total_rented; j++) {
                if (customer[j][0] == name) {

                    for (int k = j + 1; k < total_rented; k++) {
                        customer[k - 1][0] = customer[k][0];
                        customer[k - 1][1] = customer[k][1];
                        customer[k - 1][2] = customer[k][2];
                        customer[k - 1][3] = customer[k][3];
                        customer[k - 1][4] = customer[k][4];

                    }

                    break;
                }

                total_rented--;
            }
        } else {
            System.out.println("car is not assigned to any customer.");
        }

    }

    // delete car
    public void deletecar(String c) {
        if (map.containsKey(c)) {
            map.remove(c);

            if (history.containsKey(c)) {
                String name = history.get(c);
                // System.out.println(name);

                history.remove(c);

                // delete customer
                for (int j = 0; j < total_rented; j++) {
                    if (customer[j][0] == name) {

                        for (int k = j + 1; k < 10; k++) {
                            customer[k - 1][0] = customer[k][0];
                            customer[k - 1][1] = customer[k][1];
                            customer[k - 1][2] = customer[k][2];
                            customer[k - 1][3] = customer[k][3];
                            customer[k - 1][4] = customer[k][4];
                        }

                        break;
                    }

                    total_rented--;
                }

            }

            // delete car
            for (int j = 0; j < 10; j++) {
                if (carinfo[j][0] == c) {
                    for (int k = j + 1; k < 10; k++) {
                        carinfo[k - 1][0] = carinfo[k][0];
                        carinfo[k - 1][1] = carinfo[k][1];
                        carinfo[k - 1][2] = carinfo[k][2];

                    }

                    total_cars--;
                    break;

                }
            }

        } else {
            System.out.println("invalid car data.");
        }
    }

    public void displaycustomer() {
        System.out.println("******************************************************");
        for (int j = 0; j < total_rented; j++) {

            System.out.println("name: " + customer[j][0] + " mobile: " + customer[j][1] + " rental date: "
                    + customer[j][2] + " return date: " + customer[j][3] + " duration: " + customer[j][4]);

        }
        System.out.println("******************************************************");
    }

    public void displaycar() {
        System.out.println("******************************************************");
        for (int j = 0; j < total_cars; j++) {
            System.out.println("number: " + carinfo[j][0] + " model: " + carinfo[j][1] + " year: " + carinfo[j][2]);
        }
        System.out.println("******************************************************");
    }

    public void display() {
        System.out.println("******************************************************");

        System.out.println(map);
        System.out.println("******************************************************");

        // for(Map.Entry<String,Integer> m : map.entrySet())
        // {
        // String key = m.getKey();
        // Boolean value = m.getValue();

        // if(value == true)
        // System.out.println(key);

        // }

    }

    public void updatecustomer(String name, String mobile, String carnumber, String return_date, String duration) {
        String old = history.get(carnumber);

        for (int j = 0; j < 10; j++) {

            if (customer[j][0] == old) {
                // update info
                customer[j][0] = name;
                customer[j][1] = mobile;
                customer[j][3] = return_date;
                customer[j][4] = duration;

                history.put(carnumber, name);

                System.out.println("updated successfully");

                break;
            }

        }

    }

    public void updatecar(String carnumber, String model, String year) {
        for (int j = 0; j < 10; j++) {
            if (carinfo[j][0] == carnumber) {
                carinfo[j][1] = model;
                carinfo[j][2] = year;

                System.out.println("updated successfully");

                break;
            }
        }

    }

}
