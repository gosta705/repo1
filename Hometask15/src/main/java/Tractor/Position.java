package main.java.Tractor;

public class Position {
    private final int xPosition;
    private final int yPosition;

    public Position(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public Position changeXPosition(int changeXPosition){
        return new Position(xPosition + changeXPosition, yPosition);
    }

    public Position changeYPosition(int changeYPosition){
        return new Position(xPosition, yPosition + changeYPosition);
    }
}
