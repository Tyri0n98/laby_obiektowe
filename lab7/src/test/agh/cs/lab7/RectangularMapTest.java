package agh.cs.lab7;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {
    @Test
    public void integrationTest(){
        RectangularMap map = new RectangularMap(5,5);
        assertFalse(map.isOccupied(new Position(2,2)));
        Car car = new Car(map);
        map.place(car);
        assertTrue(map.isOccupied(car.getPosition()));

        assertTrue(map.canMoveTo(new Position(4,4)));
        assertTrue(map.canMoveTo(new Position(1,0)));
        assertFalse(map.canMoveTo(new Position(-1,0)));
        assertFalse(map.canMoveTo(new Position(5,0)));
        assertFalse(map.canMoveTo(new Position(1,5)));
    }
    @Test
    public void runTest(){
        RectangularMap map = new RectangularMap(5,5);
        IPositionChangeObserver observer = map;
        Car car1 = new Car(map);
        Car car2 = new Car(map, new Position(3,3));
        car1.addObserver(observer);
        car2.addObserver(observer);
        map.place(car1);
        map.place(car2);
        String[] directionsString = {"f","l","r","f","b","b","b","b","b","b","b","b","b"};
        MoveDirection[] directions = OptionsParser.parse(directionsString);
        map.run(directions);
        assertEquals(new Position(0,3), car1.getPosition());
        assertEquals(MapDirection.EAST, car1.getOrientation());
        assertEquals(new Position(4,3), car2.getPosition());
        assertEquals(MapDirection.WEST, car2.getOrientation());
    }
}
