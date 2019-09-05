package com.programing.locks.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现线程执行的业务进行顺序规划
 */
public class ConditionSortProcess {

    volatile public static int PRINT_NO = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final private static Condition conditionA = lock.newCondition();
    final private static Condition conditionB = lock.newCondition();
    final private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (PRINT_NO != 1) {
                        conditionA.await();
                    }

                    System.out.println("Thread A ");
                    PRINT_NO = 2;
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadB = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (PRINT_NO != 2) {
                        conditionA.await();
                    }

                    System.out.println("Thread B ");
                    PRINT_NO = 3;
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread threadC = new Thread() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (PRINT_NO != 3) {
                        conditionA.await();
                    }

                    System.out.println("Thread C ");
                    PRINT_NO = 1;
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread[] array1 = new Thread[5];
        Thread[] array2 = new Thread[5];
        Thread[] array3 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            array1[i] = new Thread(thread);
            array2[i] = new Thread(threadB);
            array3[i] = new Thread(threadC);

            array1[i].start();
            array2[i].start();
            array3[i].start();
        }
    }


}
