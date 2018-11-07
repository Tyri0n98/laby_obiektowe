package cs.lab5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student14 on 2018-10-30.
 */
public class UnboundedMap extends AbstractWorldMap {
    private List<HayStack> hayList;

    public UnboundedMap(List<HayStack> hayStacks){
        super();

        this.hayList = hayStacks;
        for(HayStack hay: hayStacks){
            this.upperRightCorner = hay.getPosition().upperRight(this.upperRightCorner);
            this.lowerLeftCorner = hay.getPosition().lowerLeft(this.lowerLeftCorner);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())){
            carsList.add(car);
            if(car.getPosition().larger(upperRightCorner))this.upperRightCorner = car.getPosition().upperRight(this.upperRightCorner);
            if(car.getPosition().smaller(lowerLeftCorner))this.lowerLeftCorner = car.getPosition().lowerLeft(this.lowerLeftCorner);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++ ){
            carsList.get(i % carsList.size()).move(directions[i]);
            if(carsList.get(i % carsList.size()).getPosition().larger(this.upperRightCorner)) this.upperRightCorner = carsList.get(i % carsList.size()).getPosition().upperRight(this.upperRightCorner);
            if(carsList.get(i % carsList.size()).getPosition().smaller(this.lowerLeftCorner)) this.lowerLeftCorner = carsList.get(i % carsList.size()).getPosition().lowerLeft(this.lowerLeftCorner);
            System.out.print(this.toString());
        }
    }

    @Override
    public Object objectAt(Position position) {
        for(HayStack hay: hayList){
            if(hay.getPosition().equals(position))
                return hay;
        }
        return super.objectAt(position);
    }
    public Position getUpperRightCorner(){ return this.upperRightCorner;}
    public Position getLowerLeftCorner(){return this.lowerLeftCorner;}

}
