package cs.lab5;

import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected List<Car> carsList;
    protected Position upperRightCorner;
    protected Position lowerLeftCorner;
    protected MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.carsList = new LinkedList<Car>();
        this.visualizer = new MapVisualizer(this);

        this.upperRightCorner = new Position(0,0);
        this.lowerLeftCorner = new Position(0,0);
    }

    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    public Object objectAt(Position position){
        for(Car car: carsList){
            if(car.getPosition().equals(position))
                return car;
        }
        return null;
    }

    public String toString(){
        return this.visualizer.draw(lowerLeftCorner, upperRightCorner);
    }


}
