package cs.lab5;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest {
    @Test
    public void initTest(){
        List<HayStack> hayStacks = new LinkedList<HayStack>();
        hayStacks.add(new HayStack(new Position(-1,1)));
        hayStacks.add(new HayStack(new Position(5,3)));
        IWorldMap map = new UnboundedMap(hayStacks);
        assertEquals(new Position(5,3), ((UnboundedMap) map).getUpperRightCorner());
        assertEquals(new Position(-1,0), ((UnboundedMap) map).getLowerLeftCorner());
    }
    @Test
    public void occupiedTest(){
        List<HayStack> hayStacks = new LinkedList<HayStack>();
        hayStacks.add(new HayStack(new Position(-1,1)));
        hayStacks.add(new HayStack(new Position(5,3)));
        IWorldMap map = new UnboundedMap(hayStacks);
        Car car = new Car(map, new Position(2,2));
        map.place(car);
        assertTrue(map.isOccupied(car.getPosition()));
        assertTrue(map.isOccupied(new Position(-1,1)));
        assertFalse(map.isOccupied(new Position(4,3)));
        assertTrue(map.isOccupied(new Position(5,3)));
    }
    @Test
    public void runTest(){
        List<HayStack> hayStacks = new LinkedList<HayStack>();
        hayStacks.add(new HayStack(new Position(-1,1)));
        hayStacks.add(new HayStack(new Position(5,3)));
        IWorldMap map = new UnboundedMap(hayStacks);
        Car car = new Car(map, new Position(2,2));
        map.place(car);
        String[] directionsString = {"f","f","f"};
        MoveDirection[] directions = OptionsParser.parse(directionsString);
        map.run(directions);
        assertEquals(new Position(5,5), ((UnboundedMap) map).getUpperRightCorner());
    }
}
