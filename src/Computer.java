import java.util.Random;

public class Computer {
    public Type getTypeFromComp() {
        Type[] types = Type.values();
        Random random = new Random();
        int rnd = random.nextInt(types.length);
        return types[rnd];
    }
    public void printname(String name) {
        System.out.printf("%-16s - %-12s\n", "Computer chose", name);
        System.out.println("=======================================================");
    }

}
