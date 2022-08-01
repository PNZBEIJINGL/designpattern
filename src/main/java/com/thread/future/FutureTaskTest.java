package com.thread.future;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
        for (int i = 1; i < 6; i++) {
            FutureTask<Integer> task = new FutureTask<Integer>(new Calculate(i));
            exec.execute(task);
            taskList.add(task);
        }

        Integer sum = 0;
        for (FutureTask<Integer> task : taskList) {
            //阻塞等待
            Integer num = task.get();
            //输出处理结果
            System.out.println("" + new Date() + " " + sum + "+" + num + "=" + (sum + num));
            sum = sum + num;
        }
        exec.shutdown();
    }


}

class Calculate implements Callable {
    private int a;

    public Calculate(Integer a) {
        this.a = a;
    }

    public Integer call() throws Exception {
        System.out.println("" + new Date() + " " + Thread.currentThread().getName() + "deal :" + a);
        Thread.sleep(2000);
        return a * 10;
    }
}
