package com.thread.worker;
/*
 * Worker Thread :工作没来就等待，工作来了就干活
 * 将工作交给其他线程，自己就可以做下一项工作。通过轮流和反复的使用线程来提高吞吐量
 *
 * client :创建表示工作请求的Request角色并将其传递给Channel角色
 * channel:角色接收来自Client角色的Request，并将传递 Worker 角色。
 * Worker：从Channel角色中获取Request，并进行工作。当一项工作完成后他会去获取另外的Request角色
 * Request：保存了工作信息。
 *
 * 工作流程
 * channel创建后并同时创建几个处理channel中请求的工人，由于channel中没有请求因此工人出于闲置等地状态
 * client将请求发送给channel，channel 将其放入处理队列并唤醒工人对象， 工人对象从队列中获取请求并处理
 *
 *
 * 最开始只有几个工人角色，当工作增加的时候就增加。如果增加太多会导致内存耗尽，因此到达极限后就不增加，反之工作减少工人也应加少
 * ThreadPoolExecutor类是用于实际执行上述容量控制的类
 *
 */