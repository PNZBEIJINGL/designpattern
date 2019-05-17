package com.headfirst.command;

/**
 * 宏命令，1个命令执行多个行为
 * 将多个元算打包
 */
public class MacroCommand implements ICommand {
    private ICommand[] commands;

    public MacroCommand(ICommand[] commands) {
        this.commands = commands;
    }

    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
            ;
        }
    }

    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
            ;
        }
    }
}
