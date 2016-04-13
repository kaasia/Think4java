package me.kfly.test;

import me.kfly.study.TaskCheck;
import me.kfly.study.TaskJob;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kfly on 2016/3/24.
 */
public class ThreadTest {
    public static void main(String[] args){
        ThreadTest threadTest = new ThreadTest();
        Queue<Integer> queue = threadTest.getQueue(1,10);
        threadTest.doTaskQueue(queue);
    }

    //构造队列
    public Queue getQueue(int seed,int queueSize){
        Queue<Integer> q = new LinkedList<Integer>();
        Random rand = new Random(seed);
        for(int i=0;i<queueSize;i++){
            q.add(rand.nextInt(100));
        }
        return q;
    }
    //用自己实现的定时线程
    public void doTaskQueue(Queue q){
        System.out.println("Queue is:"+q);
        TaskCheck taskCheck = new TaskCheck(q);
        taskCheck.run();
    }
    //用TimerTask类来实现(未完成)
    class TimerTask2 {
        private  Queue<Integer> queue2 = null;
        public void doTaskQueue2(Queue q) {
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    while(queue2.size()>0){
                        multiThread(queue2);
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        }
        private void multiThread(Queue q){
            ExecutorService exec = Executors.newFixedThreadPool(5);
            for(int i=0;i<5;i++) {
                exec.execute(new TaskJob(q));
            }
            exec.shutdown();
        }
    }
}
