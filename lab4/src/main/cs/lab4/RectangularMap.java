package cs.lab4;

import java.util.LinkedList;

/**
 * Created by student14 on 2018-10-23.
 */
public class RectangularMap implements IWorldMap{
    private int width;
    private int height;
    private LinkedList <Car> carsList;


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        carsList = new LinkedList<Car>();
    }

    @Override
    public boolean canMoveTo(Position position) {
        if(position.x >= width || position.x < 0 || position.y >= height || position.y < 0 || isOccupied(position))
            return false;
        return true;
    }

    @Override
    public boolean isOccupied(Position position) {
        for(Car car: carsList){
            if(car.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())){
            carsList.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++ ){
            carsList.get(i % carsList.size()).move(directions[i]);
            System.out.print(this.toString());
        }
    }

    @Override
    public Object objectAt(Position position){
        for(Car car: carsList){
            if(car.getPosition().equals(position))
                return car;
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Position(0, 0), new Position(this.width -1, this.height -1));
    }

}
