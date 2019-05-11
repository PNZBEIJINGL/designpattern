package com.thread.balking;
/**
 *  Balking  阻塞模式
 *  GUARDOBJECT 被守护的对象， 当线程执行到守护方法时候，
 *  若守护条件成立，则执行实际的处理，当守护条件不成立时。则不执行实际处理
 *  示例中：守护条件为changed=true
 *
 *  守护对象GuardedObject
 *  state 状态
 *  guardedMethod 守护方法
 *  stateChangeingMethod 状态发生变化
 *
 */