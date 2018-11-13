package agh.cs.lab7;

import java.util.LinkedList;
import java.util.List;

public class Car implements IObject{
    private Position position = new Position(2,2);
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers;

    public Car(IWorldMap map){
        this.map = map;
        this.observers = new LinkedList<IPositionChangeObserver>();
    }

    public Car(IWorldMap map, Position initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.observers = new LinkedList<IPositionChangeObserver>();
    }

    public String toString(){
        return orientation.toString();
    }
    public void move(MoveDirection direction){
        switch (direction) {
            case FORWARD:
            case BACKWARD:{
                 if(map.canMoveTo(this.position.add(getVector(direction))))
                    this.position = this.position.add(getVector(direction));
                break;
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
    public Position getPosition(){
        return this.position;
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }

    public Position getUnitVector(MapDirection direction){
        switch (direction){
            case NORTH: return new Position(0, 1);
            case SOUTH: return new Position(0, -1);
            case EAST: return new Position(1, 0);
            case WEST: return new Position(-1, 0);
            default: return new Position(0,0);
        }
    }

    public Position getVector(MoveDirection direction){
        Position zero = new Position(0,0);
        if(direction.equals(MoveDirection.FORWARD)) return zero.add(getUnitVector(this.orientation));
        if(direction.equals(MoveDirection.BACKWARD)) return zero.subtract(getUnitVector(this.orientation));
        return zero;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }
}
