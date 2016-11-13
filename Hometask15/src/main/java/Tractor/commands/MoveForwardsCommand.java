package main.java.Tractor.commands;

import main.java.Tractor.Tractor;

public class MoveForwardsCommand implements Command {
    private final Tractor tractor;

    public MoveForwardsCommand(Tractor tractor) {
        this.tractor = tractor;
    }

    @Override
    public void execute() {
        tractor.moveForwards();
    }
}
