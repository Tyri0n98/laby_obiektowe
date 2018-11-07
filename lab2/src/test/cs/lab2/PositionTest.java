package cs.lab2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by Student40 on 2018-10-09.
 */
public class PositionTest {
    @Test
    public void testGetX(){ assertEquals(2, new Position(2, 1).getX());}
    @Test
    public void testToString() {assertEquals("(1,2)", new Position(1,2).toString());}
    @Test
    public void testEquals() {assertEquals(Boolean.TRUE, new Position(1,1).equals(new Position(1,1)));}
    @Test
    public void testSmaller() {assertEquals(Boolean.TRUE, new Position(1,1).smaller(new Position(2,2)));}
    @Test
    public void testLarger() {assertEquals(Boolean.TRUE, new Position(4,5).larger(new Position(3,1)));}
    @Test
    public void testUpperRight() {
        assertEquals(1, new Position(1,0).upperRight(new Position(0,1)).x);
        assertEquals(1, new Position(1,0).upperRight(new Position(0,1)).y);
    }
    @Test
    public void testLowerLeft() {
        assertEquals(1, new Position(1,0).lowerLeft(new Position(1,2)).x);
        assertEquals(1, new Position(1,0).upperRight(new Position(2,1)).y);
    }
    @Test
    public void testAdd() {
        assertEquals(5, new Position(2,3).add(new Position(3,2)).x);
        assertEquals(5, new Position(2,3).add(new Position(3,2)).y);
    }
}
