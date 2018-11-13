package agh.cs.lab7;

import java.util.LinkedList;
import java.util.List;


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
            IPositionChangeObserver observer = (UnboundedMap) map;
            Car car1 = new Car(map);
            Car car2 = new Car(map, new Position(5,2));
            car1.addObserver(observer);
            car2.addObserver(observer);
            map.place(car1);
            map.place(car2);
            map.run(directions);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}