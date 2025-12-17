import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WorkManager manager = new WorkManager();

        while (true) {
            System.out.println("\n--- WORK ORGANIZER ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Pending (By Priority & Due Date)");
            System.out.println("4. Complete Task");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Due date (YYYY-MM-DD): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    System.out.print("Priority (HIGH / MEDIUM / LOW): ");
                    Priority priority =
                            Priority.valueOf(scanner.nextLine().toUpperCase());

                    manager.add(new WorkItem(title, category, date, priority));
                }
                case 2 -> manager.listAll();
                case 3 -> manager.listPendingByUrgency();
                case 4 -> {
                    System.out.print("Task number: ");
                    manager.complete(scanner.nextInt() - 1);
                }
                case 5 -> {
                    System.out.println("Stay productive!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
