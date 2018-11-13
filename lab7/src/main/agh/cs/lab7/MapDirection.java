package agh.cs.lab7;


public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;
    public String toString(){
        switch (this){
            case NORTH: return "^";
            case SOUTH: return "v";
            case EAST: return ">";
            case WEST: return "<";
        }
        return null;
    }
    public MapDirection next(){
        switch (this) {
            case NORTH: return EAST;
            case SOUTH: return WEST;
            case EAST: return SOUTH;
            case WEST: return NORTH;
        }
        return null;
    }
    public MapDirection previous(){
        switch (this) {
            case NORTH: return WEST;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            case WEST: return SOUTH;
        }
        return null;
    }
}
