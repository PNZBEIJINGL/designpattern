package com.thread.termination;
/**
 *
 *  Two-Phase Termination 先收拾房间再睡觉
 *
 *  Terminal 角色接收终止请求啊，并实际执行终止处理，它提供了shoudownRequest方法，
 *  示例中CountupThread 扮演了此角色
 *
 *  Thread 的join 方法来等待制定的线程终止，如果返回值是True表示该线程活着，false 表示线程已经终止
 *  可以通过getState 方法获取线程的状态，如果不死检查线程是否已经终止，使用isAlive更好
 *
 *  ExecutorService
 *  isShutdown 方法用于确认shutdown 方法是否已经被调用的方法。如果shutdown已经被调用返回true，即使为true。也并不表示线程已经停止
 *  isTerminated方法用确认线程是否实际停止了，如果线程停止了isTermianated返回true;
 *
 *  CountDownLatch可以帮之我们等待执行次数 示例ContDownLatchTest
 *
 */