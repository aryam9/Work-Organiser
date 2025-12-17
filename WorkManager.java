import java.util.ArrayList;
import java.util.Comparator;

public class WorkManager {

    private ArrayList<WorkItem> items = new ArrayList<>();

    public void add(WorkItem item) {
        items.add(item);
    }

    public void listAll() {
        if (items.isEmpty()) {
            System.out.println("No tasks added yet.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }
    }

    public void listPendingByUrgency() {
        items.stream()
                .filter(item -> !item.isCompleted())
                .sorted(
                        Comparator
                                .comparing(WorkItem::getPriority)
                                .thenComparing(WorkItem::getDueDate)
                )
                .forEach(System.out::println);
    }

    public void complete(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).markCompleted();
            System.out.println("Task completed.");
        } else {
            System.out.println("Invalid number.");
        }
    }
}
