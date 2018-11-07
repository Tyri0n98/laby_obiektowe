package cs.lab2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OptionsParserTest
{
    Car testcar=new Car();
    @Test
    public void parsertest()
    {
        String[] move={"f","f","r","b","  ","rjkalsd","l"};
        MoveDirection[] moveparsed=OptionsParser.parse(move);
        for(MoveDirection mov: moveparsed)
        {
            testcar.move(mov);
        }
        assertEquals(new Position(1,4), testcar.getPosition());
        assertEquals(MapDirection.NORTH, testcar.getOrientation());
    }
}
