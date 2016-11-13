package main.java.Tractor;

public enum Orientation {
    NORTH {
        public Position moveForward(Position oldPosition) {
            return oldPosition.changeYPosition(1);
        }

        public Orientation turnClockwise() {
            return EAST;
        }
    },
    WEST {
        public Position moveForward(Position oldPosition) {
            return oldPosition.changeXPosition(-1);
        }

        public Orientation turnClockwise() {
            return NORTH;
        }
    },
    SOUTH {
        public Position moveForward(Position oldPosition) {
            return oldPosition.changeYPosition(-1);
        }

        public Orientation turnClockwise() {
            return WEST;
        }
    },
    EAST {
        public Position moveForward(Position oldPosition) {
            return oldPosition.changeXPosition(1);
        }

        public Orientation turnClockwise() {
            return SOUTH;
        }
    };

    public abstract Position moveForward(Position oldPosition);

    public abstract Orientation turnClockwise();
}
