package agh.cs.lab7;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {

    public UnboundedMap(List<HayStack> hayStacks){
        super();
        for(IObject hay: hayStacks){
            place(hay);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public boolean place(IObject object) throws IllegalArgumentException{
        if(super.place(object)){
            setSize(object.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public void setSize(Position position){
        this.lowerLeftCorner = position.lowerLeft(this.lowerLeftCorner);
        this.upperRightCorner = position.upperRight(this.upperRightCorner);
    }

    public Position getUpperRightCorner(){ return this.upperRightCorner;}
    public Position getLowerLeftCorner(){return this.lowerLeftCorner;}

}
