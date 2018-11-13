package agh.cs.lab7;


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
