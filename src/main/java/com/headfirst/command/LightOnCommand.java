package com.headfirst.command;

/**
 * 开灯的命令
 */
public class LightOnCommand implements ICommand {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    /**
     * 封装了执行命令，调用Light.on
     */
    public void execute() {
        light.on();
    }
}
