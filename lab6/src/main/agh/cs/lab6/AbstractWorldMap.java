package agh.cs.lab6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap{
    protected Position upperRightCorner;
    protected Position lowerLeftCorner;
    protected MapVisualizer visualizer;
    protected LinkedHashMap<Position, IObject> objects = new LinkedHashMap<>();
    protected LinkedList<Car> carsList = new LinkedList<>();

    public AbstractWorldMap(){
        this.visualizer = new MapVisualizer(this);

        this.upperRightCorner = new Position(0,0);
        this.lowerLeftCorner = new Position(0,0);
    }

    public boolean canMoveTo(Position position){
        return !isOccupied(position);
    }

    public boolean place(IObject object){
        if(!isOccupied(object.getPosition())){
            this.objects.put(object.getPosition(), object);
            if(object instanceof Car){
                carsList.add((Car) object);
            }
            return true;
        }
        throw new IllegalArgumentException("Pole: " + object.getPosition() + " jest zajete");
    }

    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    public void run(MoveDirection[] directions){
        for(int i = 0; i < directions.length; i++){
            Car car = carsList.get(i % carsList.size());
            Position beforeMove = car.getPosition();
            car.move(directions[i]);
            objects.remove(beforeMove);
            objects.put(car.getPosition(), car);
            setSize(car.getPosition());
            System.out.println(this.toString());
        }
    }

    public Object objectAt(Position position){
        return objects.get(position);
    }

    public String toString(){
        return this.visualizer.draw(lowerLeftCorner, upperRightCorner);
    }

    public void setSize(Position position){};
}
