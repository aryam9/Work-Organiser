import java.io.*;
import java.util.ArrayList;

public class FileStorage {

    private static final String FILE = "tasks.txt";

    public static void save(ArrayList<WorkItem> items) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE))) {
            for (WorkItem item : items) {
                writer.println(
                        item.isCompleted() + "," +
                        item.getDueDate() + "," +
                        item.toString()
                );
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    public static ArrayList<WorkItem> load() {
        return new ArrayList<>(); 
    }
}
