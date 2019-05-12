package com.thread.producer;
/**
 * Producer - Consumer 生产者消费者
 *
 * Table.tail表示下次放蛋糕的位置
 * Table.head表示下次取蛋糕的位置
 * 通过计算顺序向数组中存蛋糕数据
 *
 * notify/notifyall 唤醒的是该实例的等待队列中的线程，而不是直接指定的线程，唤醒后会执行下一条语句
 * notify/notifyall 执行时必须获取该实例的锁
 *
 * Table 类等同于java.utils.concurrent.ArrayBlockingQueue，所以可以替换
 */