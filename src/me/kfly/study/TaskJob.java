package me.kfly.study;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kfly on 2016/3/23.
 *
 */
public class TaskJob implements Runnable {
    /**
     *定义对队列的处理方法线程
     */
    private Queue<Integer> q = null;
    public TaskJob(Queue q){
        this.q = q;
    }

    @Override
    public void run() {
        while (q.size()>0) {
            System.out.println(Thread.currentThread());
            System.out.println(q.poll());
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
