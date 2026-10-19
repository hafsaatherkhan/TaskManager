
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n==== TASK MANAGER ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add("[Pending] " + task);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to complete: ");
                    int number = sc.nextInt();

                    if (number >= 1 && number <= tasks.size()) {
                        String currentTask = tasks.get(number - 1);

                        if (currentTask.startsWith("[Pending] ")) {
                            tasks.set(number - 1,
                                "[Completed] " +
                                currentTask.substring("[Pending] ".length()));
                            System.out.println("Task completed!");
                        } else {
                            System.out.println("Task is already completed.");
                        }
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Task Manager. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
