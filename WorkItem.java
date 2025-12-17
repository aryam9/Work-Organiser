import java.time.LocalDate;

public class WorkItem {

    private String title;
    private String category;
    private LocalDate dueDate;
    private Priority priority;
    private boolean completed;

    public WorkItem(String title, String category, LocalDate dueDate, Priority priority) {
        this.title = title;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public void markCompleted() {
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return (completed ? "[✓] " : "[ ] ")
                + title + " | "
                + category + " | "
                + priority + " | Due: " + dueDate;
    }
}
