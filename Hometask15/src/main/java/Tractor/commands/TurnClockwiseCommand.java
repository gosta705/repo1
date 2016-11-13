package main.java.Tractor.commands;

import main.java.Tractor.Tractor;

public class TurnClockwiseCommand implements Command {
    private final Tractor tractor;

    public TurnClockwiseCommand(Tractor tractor) {
        this.tractor = tractor;
    }

    @Override
    public void execute() {
        tractor.turnClockwise();
    }
}
