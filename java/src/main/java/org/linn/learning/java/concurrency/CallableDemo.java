package org.linn.learning.java.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results) {
            try {
                // Waits if necessary for the computation to complete, and then retrieves its result.
                String result = fs.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                // if the current thread was interrupted while waiting.
                e.printStackTrace();
                return;// 随后执行finally，然后退出方法执行
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "Result of TaskWithResult " + id;
    }
}
