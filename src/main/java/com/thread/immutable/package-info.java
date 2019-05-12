package com.thread.immutable;
/**
 * Immutalbe 无法破坏 不变的不发生改变的意思
 *
 * 创建实例后不发生改变是必要条件。所以可以声明字段为final 且没有setter 方法
 *
 * 类库中String BigInteger 都是 immutable类
 *
 * final
 * 如果类的声明中增加了final 则表示该类无法扩展。也就是说无法创建final 的子类。所以也不会被子类重写
 * 如果在实例方法中声明final 则表示该方法不会被子类方法重写。如果在静态方法中声明final表示该方法不会被子类的方法隐藏，即重写或者隐藏都会编译报错
 *
 */