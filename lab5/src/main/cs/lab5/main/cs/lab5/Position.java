package cs.lab5;

/**
 * Created by Student40 on 2018-10-09.
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        return this.x == that.x && this.y == that.y;
    }
    public boolean smaller(Position pos){
        return (this.x < pos.x || this.y < pos.y);
    }
    public boolean larger(Position pos){
        return (this.x > pos.x || this.y > pos.y);
    }
    public Position upperRight(Position pos){
        int x, y;
        if(pos.x > this.x) x=pos.x;
        else x=this.x;
        if(pos.y > this.y) y=pos.y;
        else y=this.y;
        return new Position(x, y);
    }
    public Position lowerLeft(Position pos){
        int x, y;
        if(pos.x < this.x) x=pos.x;
        else x=this.x;
        if(pos.y < this.y) y=pos.y;
        else y=this.y;
        return new Position(x, y);
    }
    public Position add(Position pos){
        return new Position(this.x + pos.x, this.y + pos.y);
    }
    public Position subtract(Position pos){
        return new Position(this.x - pos.x, this.y - pos.y);
    }
    public int getX(){ return this.x;}
}
