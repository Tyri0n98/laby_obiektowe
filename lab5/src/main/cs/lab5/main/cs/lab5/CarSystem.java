package cs.lab5;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Student40 on 2018-10-09.
 */
public class CarSystem {
    public static void main(String[] args){

        String[] argss = {"r","f","f"};
        MoveDirection[] directions = OptionsParser.parse(argss);
        List<HayStack> hayStacks = new LinkedList<HayStack>();
        hayStacks.add(new HayStack(new Position(3,2)));
        hayStacks.add(new HayStack(new Position(0,0)));
        hayStacks.add(new HayStack(new Position(1,6)));
        //IWorldMap map = new UnboundedMap(hayStacks);
        IWorldMap map = new RectangularMap(5,5);
        map.place(new Car(map));
        //map.place(new Car(map, new Position(3,4)));
        map.run(directions);
    }
}