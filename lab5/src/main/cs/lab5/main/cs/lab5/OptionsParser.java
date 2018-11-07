package cs.lab5;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        MoveDirection[] directions = new MoveDirection[args.length];
        int i = 0;
        for(String arg: args){
            if(arg.equals("f") || arg.equals("forward")){
                directions[i] = MoveDirection.FORWARD;
                i++;
            }
            else if(arg.equals("b") || arg.equals("backward")){
                directions[i] = MoveDirection.BACKWARD;
                i++;
            }
            else if(arg.equals("r") || arg.equals("right")){
                directions[i] = MoveDirection.RIGHT;
                i++;
            }
            else if(arg.equals("l") || arg.equals("left")){
                directions[i] = MoveDirection.LEFT;
                i++;
            }
            else {
                throw new IllegalArgumentException(arg + " is invalid");
            }
        }
        MoveDirection[] directions1 = new MoveDirection[i];
        for(int j=0; j<i; j++) directions1[j] = directions[j];
        return directions1;
    }
}
