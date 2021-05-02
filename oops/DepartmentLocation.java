package oops;

import java.util.Scanner;

public class DepartmentLocation {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, m, i, k, j = 0;

        System.out.println("\nEnter count of department instances: ");
        n = Integer.parseInt(input.nextLine());

        Department departments[] = new Department[n];

        for (i = 0; i < n; i++) {
            System.out.print("Enter department name: ");
            String name = input.nextLine();
            departments[i] = new Department(name);
        }

        System.out.print("\nEnter # of locations across all departments: ");
        m = Integer.parseInt(input.nextLine());
        Department.Location locations[] = new Department.Location[m];

        for (i = 0; i < n; i++) {

            System.out.print("\nEnter # of locations for department " + (i + 1) + ": ");
            k = Integer.parseInt(input.nextLine());

            while (k-- > 0) {
                System.out.println("\nEnter location id, name, latitude, longitude:");
                String id = input.nextLine();
                String lName = input.nextLine();
                double lat = Double.parseDouble(input.nextLine());
                double longitude = Double.parseDouble(input.nextLine());

                locations[j++] = departments[i].new Location(id, lName, longitude, lat);
            }
        }

        System.out.print("\nEnter department name to be searched: ");
        String deptName = input.nextLine();
        boolean found = false;

        for (int t = 0; t < m; t++) {
            if (locations[t].getDeptName().equals(deptName)) {
                found = true;
                locations[t].displayLocationDetails();
            }
        }

        if (!found) {
            System.out.println("No such department name found");
        }

        input.close();
    }
}

class Department {
    public String Dname;

    public Department(String name) {
        Dname = name;
    }

    public class Location {
        String id;
        String locationName;
        double longitude;
        double latitude;

        public Location(String id, String name, double longitude, double lat) {
            this.id = id;
            this.locationName = name;
            this.longitude = longitude;
            this.latitude = lat;
        }

        public void displayLocationDetails() {
            System.out.println("----------------------");
            System.out.println(id + " " + locationName + " " + longitude + " " + latitude);
        }

        public String getDeptName() {
            return Dname;
        }
    }
}