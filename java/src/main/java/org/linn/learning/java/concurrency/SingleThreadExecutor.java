package org.linn.learning.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        // 创建一个Executor，该Executor使用一个工作线程操作一个无界队列。
        // 但是请注意，如果这个线程在关闭之前的执行过程中由于失败而终止，如果还需要执行后续任务，将会有一个新的线程代替它。
        // 任务保证按顺序执行，并且在任何给定的时间都不会有超过一个任务处于活动状态。
        // 与等价的newFixedThreadPool(1)不同，返回的执行器保证不会被重新配置以使用其他线程。
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
