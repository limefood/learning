package org.linn.learning.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        // 创建一个线程池，该线程池重用固定数量的线程操作一个共享的无界队列。
        // 在任何时候，至多nThreads个线程处于活动状态处理任务。
        // 如果在所有线程都处于活动状态时提交了额外的任务，它们将在队列中等待，直到有线程可用。
        // 如果某线程在关闭之前的执行过程中由于失败而终止，如果还需要执行后续任务，将会有一个新的线程代替它。
        // 池中的线程将一直存在，直到它被显式关闭。
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
