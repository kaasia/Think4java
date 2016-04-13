package me.kfly.study;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kfly on 2016/3/24.
 */
public class TaskCheck implements Runnable{

    /**
     * 定时查看队列里面是否非空，非空则放到线程池中处理
     */
    private Queue<Integer> queue = null;

    public TaskCheck(Queue q){
        this.queue = q;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("task check,there is "+queue.size()+" jobs");
            if (queue.size()> 0) {
                multiThread(queue);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 线程池，调用处理方法对队列进行处理
     * */
    private void multiThread(Queue q){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++) {
            exec.execute(new TaskJob(q));
        }
        exec.shutdown();
    }
}
