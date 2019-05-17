package com.headfirst.command;

/**
 * 方法接口，所以命令实现这个方法接口
 */
public interface ICommand {

    /**
     * 执行
     */
    public void execute();

    /**
     * 撤销
     */
    public void undo();

}
