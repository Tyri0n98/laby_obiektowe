package agh.cs.lab7;


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
}
