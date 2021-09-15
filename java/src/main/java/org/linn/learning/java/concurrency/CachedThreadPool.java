package org.linn.learning.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        // 创建一个线程池，该线程池根据需要创建新线程，但将在以前构造的线程可用时重用它们。
        // 这些池通常会提高执行许多短期异步任务的程序的性能。
        // 要执行的调用将重用之前构造的线程，如果它们可用。
        // 如果没有可用的现有线程，则将创建一个新线程并将其添加到池中。
        // 60秒内未使用的线程将被终止并从缓存中删除。
        // 因此，空闲时间足够长的池不会消耗任何资源。
        // 注意，具有类似属性但细节不同(例如，超时参数)的池可以使用ThreadPoolExecutor构造函数创建。
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        // 启动一个有序的关闭，先前提交的任务将继续被执行，但不接受新的任务。
        // 如果已经关闭，则调用没有额外的效果。
        // 此方法不等待先前提交的任务完成执行，使用awaitterminate来做这件事。
        exec.shutdown();
    }
}