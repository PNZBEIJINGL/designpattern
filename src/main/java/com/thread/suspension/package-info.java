package com.thread.suspension;
/**
 * Guarded Suspension
 * 该模式通过线程等待来保证实例的安全性
 * <p>
 * ClientThread 不定时向队列中发送元素
 * ServerThread 不定时向队列中获取元素
 * ServerThread 获取元素时，如果队列RequestQueue中没有元素会被其阻塞并等插入元素时候继续获取
 */