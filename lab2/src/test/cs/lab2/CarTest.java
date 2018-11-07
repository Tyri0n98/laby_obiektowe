package cs.lab2;

 import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CarTest
{
    Car testcar=new Car();

    @Test
    public void inittest()
    {
        Position p= new Position(2,2);
        assertEquals(p, testcar.getPosition());
        assertEquals(MapDirection.NORTH, testcar.getOrientation());
    }
    @Test
    public void tostringtest()
    {
        assertEquals("Position: (2,2), Orientation: Północ", testcar.toString());
    }
    @Test
    public void movetest()
    {
        testcar.move(MoveDirection.LEFT);
        testcar.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, testcar.getOrientation());
        testcar.move(MoveDirection.FORWARD);
        assertEquals(new Position(2,1), testcar.getPosition());
        testcar.move(MoveDirection.LEFT);
        testcar.move(MoveDirection.FORWARD);
        testcar.move(MoveDirection.FORWARD);
        testcar.move(MoveDirection.FORWARD);
        assertEquals(new Position(4,1), testcar.getPosition());
        assertEquals(MapDirection.EAST, testcar.getOrientation());
    }

}
