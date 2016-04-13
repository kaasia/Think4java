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
     * ��ʱ�鿴���������Ƿ�ǿգ��ǿ���ŵ��̳߳��д���
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
     * �̳߳أ����ô������Զ��н��д���
     * */
    private void multiThread(Queue q){
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++) {
            exec.execute(new TaskJob(q));
        }
        exec.shutdown();
    }
}
