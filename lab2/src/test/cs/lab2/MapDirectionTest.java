package cs.lab2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Student40 on 2018-10-09.
 */
public class MapDirectionTest {
    @Test
    public void testNext(){
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
    }
    public void testPrevious(){
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
    }
}
