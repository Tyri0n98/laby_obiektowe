package agh.cs.lab6;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Student40 on 2018-10-09.
 */
public class CarSystem {
    public static void main(String[] args){
        try {
            String[] argss = {"f", "r", "f", "f"};
            MoveDirection[] directions = OptionsParser.parse(argss);
            List<HayStack> hayStacks = new LinkedList<HayStack>();
            hayStacks.add(new HayStack(new Position(3, 2)));
            hayStacks.add(new HayStack(new Position(0, 0)));
            hayStacks.add(new HayStack(new Position(8, 6)));
            IWorldMap map = new UnboundedMap(hayStacks);
            //IWorldMap map = new RectangularMap(5,5);
            map.place(new Car(map));
            map.place(new Car(map, new Position(2,2)));
            map.run(directions);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}