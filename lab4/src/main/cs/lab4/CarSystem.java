package cs.lab4;

/**
 * Created by Student40 on 2018-10-09.
 */
public class CarSystem {
    public static void main(String[] args){
        /*Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        Car car = new Car();
        String[] tab = {"r","f","b","r","d","r"};
        MoveDirection[] directions = OptionsParser.parse(tab);
        for(MoveDirection arg: directions){
            car.move(arg);
        }
        System.out.println(car);*/
        String[] argss = {"f","b","r","l","f"};
        MoveDirection[] directions = OptionsParser.parse(argss);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map, new Position(3,4)));
        map.run(directions);
    }
}