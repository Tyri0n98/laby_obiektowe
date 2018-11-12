package agh.cs.lab6;

/**
 * Created by student14 on 2018-10-30.
 */
public class HayStack implements IObject{
    private Position position;

    public HayStack(Position pos){
        this.position = pos;
    }

    public Position getPosition(){
        return this.position;
    }

    public String toString(){
        return "s";
    }

    public void move(MoveDirection direciton){};
}
