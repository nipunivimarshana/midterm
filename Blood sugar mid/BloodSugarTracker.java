import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BloodSugarTracker {

    private Map<String, UserData> userDatabase;

    public BloodSugarTracker() {
        this.userDatabase = new HashMap<>();
    }

    public static void main(String[] args) {
        BloodSugarTracker tracker = new BloodSugarTracker();
        tracker.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    createRecord(scanner);
                    break;
                case "2":
                    showAllUserData();
                    break;
                case "3":
                    showUserData(scanner);
                    break;
                case "4":
                    deleteAllRecords();
                    break;
                case "5":
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create a record");
        System.out.println("2. Show blood sugar data for all users");
        System.out.println("3. Show blood sugar data for a selected user");
        System.out.println("4. Delete all records");
        System.out.println("5. Exit application");
    }

    private void createRecord(Scanner scanner) {
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter year of birth: ");
        int yearOfBirth = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter blood sugar level: ");
        double bloodSugarLevel = Double.parseDouble(scanner.nextLine());

        UserData userData = new UserData(name, yearOfBirth, bloodSugarLevel);
        userDatabase.put(userId, userData);

        System.out.println("Record created successfully.");
    }

    private void showAllUserData() {
        System.out.println("\nBlood Sugar Data for All Users:");
        for (Map.Entry<String, UserData> entry : userDatabase.entrySet()) {
            entry.getValue().display();
        }
    }

    private void showUserData(Scanner scanner) {
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        if (userDatabase.containsKey(userId)) {
            userDatabase.get(userId).display();
        } else {
            System.out.println("User ID not found.");
        }
    }

    private void deleteAllRecords() {
        userDatabase.clear();
        System.out.println("All records deleted successfully.");
    }

    private void exit() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    private static class UserData {
        private String name;
        private int yearOfBirth;
        private double bloodSugarLevel;

        public UserData(String name, int yearOfBirth, double bloodSugarLevel) {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
            this.bloodSugarLevel = bloodSugarLevel;
        }

        public void display() {
            System.out.println(
                    "Name: " + name + ", Year of Birth: " + yearOfBirth + ", Blood Sugar Level: " + bloodSugarLevel);
        }
    }

    // Additional Methods

    private void index() {
        System.out.println("\nBlood Sugar Data for All Users:");
        for (UserData userData : userDatabase.values()) {
            userData.display();
        }
    }

    private void view(Scanner scanner) {
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        if (userDatabase.containsKey(userId)) {
            userDatabase.get(userId).display();
        } else {
            System.out.println("User ID not found.");
        }
    }

    private void delete() {
        userDatabase.clear();
        System.out.println("All records deleted successfully.");
    }
}
