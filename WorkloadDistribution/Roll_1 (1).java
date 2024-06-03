
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Roll_1 {
    static Scanner scanner = new Scanner(System.in);
    static Map<Task, Boolean> taskComp = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        int k = scanner.nextInt(); 
        Server[] servers = new Server[k];
        for (int i = 0; i < k; i++) {
            String serverName = scanner.next();
            int time = scanner.nextInt();
            servers[i] = new Server(serverName, time);
           // System.out.println(serverName);
             // System.out.println("\nhere "+ time);

        }

        int x = scanner.nextInt(); 
        Task[] tasks = new Task[x];
        for (int i = 0; i < x; i++) {
            int id = scanner.nextInt();
            int mtime = scanner.nextInt();
            tasks[i] = new Task(id, mtime);
            taskComp.put(tasks[i], false);
        }

       
        for (Task task : tasks) {
            for (Server server : servers) {
                if (server.getTime() >= task.getTime()) {
                    server.pushTask(task);
                }
            }
        }

        for (Server server : servers) {
            server.start();
        }

        for (Server server : servers) {
            server.join();
        }
    }
}

class Server extends Thread {
    private String name;
    private int time;
    private ArrayList<Task> assignedTasks = new ArrayList<>();

    Server(String name, int time) {
        super(name); 
        this.name = name;
        this.time = time;
        // System.out.println("here"+ task.getId()+ );
    }

    public void pushTask(Task task) {
        assignedTasks.add(task);
    }

    public String getNaame() {
        return name;
    }

    public int getTime() {
        return time;
    }

    @Override
    public void run() {
        for (Task task : assignedTasks) {
            synchronized (task) {
                if (!Roll_1.taskComp.get(task)) {
                    try {
                       System.out.println("Server " + getName() + " started working on Task " + task.getId());
                       // System.out.println("here "+ task.getId()+ );
                        task.process();
                        Roll_1.taskComp.put(task, true);
                        System.out.println("Server " + getName() + " completed Task " + task.getId());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

class Task {
    private int id;
    private int time;
    private boolean isDone = false;

    public Task(int id, int time) {
        this.id = id;
        this.time = time;
    }

    /*int working(int id, int time) {
        this.id = id;
        this.time = time;
        int k= id+1;
        return i;
    }*/


    public synchronized void process() throws InterruptedException {
        if (!isDone) {
            Thread.sleep(time);
            isDone = true;
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public int getTime() {
        return time;
    }

    public String getId() {
        return Integer.toString(id);
    }
}
