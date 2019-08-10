
一些学习随手敲的代码
------------------------------------------------------
一些是书中的demo
一些是看到的不错的设计方法
一些是自己用过的
------------------------------------------------------
《Head Fist 设计模式》
《Java 多线程设计模式图解》
《Java 多线程编程核心技术》

20190810：基础很重要，还是要补基础知识
synchronized:
1）拥有锁重入的狗功能，当一个线程得到一个对象锁后，再次请求此对象时可以再次得到该对象的锁
2）出现异常锁自动释放
3）同步不能被继承，父类方法加锁后，子类方法重写也需要加锁 ！ 跳坑！！
4）用关键字synchronized声明方法在某些情况下是有弊端的，比如A线程调用同步方法执行一个长时间的任务，那么
   B线程则必须等待比较长时间，这种情况下可以使用synchronized(this)同步语句块来解决的。synchronized方法是对当前
   对象加锁，而synchronized代码块是对某一个对象加锁
5）使用同步代码块synchronized(this)时，当访问一个对象的synchroized(this)同步代码块时，其他线程访问同一个Object
   中所有其他synchronized(this)同步代码块的访问将会被阻塞，说明synchronized(this)使用的对象监听器是同一个
   synchronized同步方法
   （1）对其他synchronized同步方法或者synchronized（this）同步代码块调用呈现阻塞状态
   （2）同一个时间只有1个线程可以访问执行synchronized同步方法里的代码
   synchronized（this）
   （1）对其他synchronized同步方法或者synchronized（this）同步代码块调用呈现阻塞状态
   （2）同一个时间只有1个线程可以访问执行synchronized（this）代码块中的代码
   synchronized（非this）
   （1）在多个线程持有对象监听器为同一个对象的前提下，同一个时间只有一个线程可以执行synchronized(非this对象)同步代码块的代码
   （2）当持有对象监视器为同一个对象的前提下，同一时间只有一个线程可以执行