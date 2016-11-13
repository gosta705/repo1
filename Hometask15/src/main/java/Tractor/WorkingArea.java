package main.java.Tractor;

public class WorkingArea {
    private final Position upperRightBorder;

    public WorkingArea(int xPositionBorder, int yPositionBorder) {
        if (xPositionBorder < 0 || yPositionBorder < 0) {
            throw new IllegalArgumentException("Both position borders should be > 0.");
        }
        upperRightBorder = new Position(xPositionBorder, yPositionBorder);
    }

    public boolean isInArea(Position currentPosition) {
        return currentPosition.getXPosition() > upperRightBorder.getXPosition() ||
                currentPosition.getYPosition() > upperRightBorder.getYPosition();
    }

}
