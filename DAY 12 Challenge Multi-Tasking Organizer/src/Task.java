import java.util.concurrent.CompletableFuture;

public class Task implements  Runnable{
public int taskId;
public String taskName;
public int duration;


    public Task(String taskName, int duration) {
        this.taskName = taskName;
        this.duration = duration;
    }

    public void executeSynchronously() {
        System.out.println("Executing task: " + taskName+" (Duration: "+duration+")");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("completed! " + taskName);
    }
    public CompletableFuture<Void> executeAsynchronously() {
        System.out.println("Task: "+taskName+" started asynchronously."  );
        return CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task: " + taskName+" completed asynchronously!"+" (Duration: "+duration+")");
        });}




    @Override
    public void run() {
        System.out.println("Task: "+taskName+" started concurrently."  );
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task: " + taskName+" completed concurrently!"+" (Duration: "+duration+")");
    }
}
