import java.util.Random;

public class Computer {
    int gameLevel;

    public Computer(int gameLevel) {
        this.gameLevel = gameLevel;
    }

    public Type getTypeFromComp() {
        if(gameLevel == 1) {
            Type[] types = new Type[3];
            types[0] = Type.ROCK;
            types[1] = Type.PAPER;
            types[2] = Type.SCISSORS;
            Random random = new Random();
            int rnd = random.nextInt(types.length);
            return types[rnd];
        } else {
            Type[] types = Type.values();
            Random random = new Random();
            int rnd = random.nextInt(types.length);
            return types[rnd];
        }
    }
    public void printname(String name) {
        System.out.printf("%-16s - %-12s\n", "Computer chose", name);
        System.out.println("=======================================================");
    }

}
