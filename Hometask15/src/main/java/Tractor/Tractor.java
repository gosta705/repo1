package main.java.Tractor;

import main.java.Tractor.commands.Command;

public class Tractor {
    private Position position = new Position(0, 0);
    private final WorkingArea workingArea = new WorkingArea(5, 5);
    private Orientation orientation;

    public Tractor(Orientation orientation) {
        this.orientation = orientation;
    }

    public void move(Command command) {
        command.execute();
    }

    public void moveForwards() {
        position = orientation.moveForward(position);
        if (workingArea.isInArea(position)) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        orientation = orientation.turnClockwise();
    }

    public int getPositionX() {
        return position.getXPosition();
    }

    public int getPositionY() {
        return position.getYPosition();
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
