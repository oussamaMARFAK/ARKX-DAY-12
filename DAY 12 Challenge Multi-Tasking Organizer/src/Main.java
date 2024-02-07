import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("A", 2000));
        tasks.add(new Task("B", 1500));
        tasks.add(new Task("C", 3000));

       executeTasksSynchronously(tasks);
        executeTasksAsynchronously(tasks);
        Thread.sleep(5000);

    }


    public static void executeTasksSynchronously(List<Task> tasks) {
        System.out.println("Executing tasks synchronously:");
        for (Task task : tasks) {
            task.executeSynchronously();
        }
    }
    private static void executeTasksAsynchronously(List<Task> tasks) {
        System.out.println("Executing tasks Asynchronously:");

        for (Task task:tasks) {
            task.executeAsynchronously();
        }
        List<Task> tosks = new ArrayList<>();
        tosks.add(new Task("GAMA", 2000));
        tosks.add(new Task("BETA", 1500));
        tosks.add(new Task("ALPHA", 3000));

        Thread[] threads=new Thread[3];
        System.out.println("Concurrent Task Execution:");
        int i=0;
        for (Task tosk:tosks){
            threads[i]=new Thread(tosk);
            threads[i].start();
        }

    }
}
