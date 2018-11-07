package cs.lab2;

/**
 * Created by Student40 on 2018-10-09.
 */
public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;
    public String toString(){
        switch (this){
            case NORTH: return "Północ";
            case SOUTH: return "Południe";
            case EAST: return "Wschód";
            case WEST: return "Zachód";
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
