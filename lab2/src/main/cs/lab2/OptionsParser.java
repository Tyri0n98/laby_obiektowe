package cs.lab2;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] directions = new MoveDirection[args.length];
        int i = 0;
        for(String arg: args){
            if(arg.equals("f") || arg.equals("forward")){
                directions[i] = MoveDirection.FORWARD;
                i++;
            }
            if(arg.equals("b") || arg.equals("backward")){
                directions[i] = MoveDirection.BACKWARD;
                i++;
            }
            if(arg.equals("r") || arg.equals("right")){
                directions[i] = MoveDirection.RIGHT;
                i++;
            }
            if(arg.equals("l") || arg.equals("left")){
                directions[i] = MoveDirection.LEFT;
                i++;
            }
        }
        MoveDirection[] directions1 = new MoveDirection[i];
        for(int j=0; j<i; j++) directions1[j] = directions[j];
        return directions1;
    }
}
