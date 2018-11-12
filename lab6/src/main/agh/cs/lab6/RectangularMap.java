package agh.cs.lab6;

import java.util.LinkedList;

/**
 * Created by student14 on 2018-10-23.
 */
public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        super();
        this.upperRightCorner = new Position(width -1,height-1);
    }

    @Override
    public boolean canMoveTo(Position position) {
        if(position.larger(this.upperRightCorner) || position.smaller(this.lowerLeftCorner) || isOccupied(position))
            return false;
        return true;
    }

    @Override
    public boolean place(IObject car) {
        return super.place(car);
    }

    @Override
    public void run(MoveDirection[] directions) {
        super.run(directions);
    }
}
