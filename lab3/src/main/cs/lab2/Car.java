package cs.lab2;

/**
 * Created by student40 on 2018-10-16.
 */
public class Car {
    private Position position = new Position(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    public String toString(){
        return "Position: " + position.toString() + ", Orientation: " + orientation.toString();
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD: {
                switch (orientation) {
                    case NORTH: {
                        if(position.y < 4) position = new Position(position.x, position.y + 1);
                        return;
                    }
                    case SOUTH: {
                        if(position.y > 0) position = new Position(position.x, position.y - 1);
                        return;
                    }
                    case EAST: {
                        if(position.x < 4) position = new Position(position.x +1, position.y);
                        return;
                    }
                    case WEST: {
                        if(position.x > 0) position = new Position(position.x - 1, position.y);
                        return;
                    }
                    default: return;
                }
            }
            case BACKWARD: {
                switch (orientation) {
                    case NORTH: {
                        if(position.y > 0) position = new Position(position.x, position.y - 1);
                        return;
                    }
                    case SOUTH: {
                        if(position.y < 4) position = new Position(position.x, position.y + 1);
                        return;
                    }
                    case EAST: {
                        if(position.x > 0) position = new Position(position.x - 1, position.y);
                        return;
                    }
                    case WEST: {
                        if(position.x < 4) position = new Position(position.x + 1, position.y);
                        return;
                    }
                    default: return;
                }
            }
            case RIGHT: {
                orientation = orientation.next();
                break;
            }
            case LEFT: {
                orientation = orientation.previous();
                break;
            }
        }
    }

}
