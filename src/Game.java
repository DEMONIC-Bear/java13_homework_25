import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int count = 5;
    private static int totalGame = 0;
    private static int draw = 0;
    private static int compCount = 0;
    private static int compDefeat = 0;
    private static int userCount = 0;
    private static int userDefeat = 0;

    public void gameRule() {

        while (count != 0) {
            String comp = returnCompChoose().toString();
            String user = returnUserChoose().toString();

            if (Objects.equals(comp, "ROCK")) {
                System.out.printf("%-16s - %-12s\n", "Computer chose", "ROCK");
                System.out.println("=======================================================");
            } else if (Objects.equals(comp, "PAPER")) {
                System.out.printf("%-16s - %-12s\n", "Computer chose", "PAPER");
                System.out.println("=======================================================");
            } else if (Objects.equals(comp,"SCISSORS")){
                System.out.printf("%-16s - %-12s\n", "Computer chose", "SCISSORS");
                System.out.println("=======================================================");
            } else if(Objects.equals(comp,"LIZARD")) {
                System.out.printf("%-16s - %-12s\n", "Computer chose", "LIZARD");
                System.out.println("=======================================================");
            }else if(Objects.equals(comp,"SPOCK")) {
                System.out.printf("%-16s - %-12s\n", "Computer chose", "SPOCK");
                System.out.println("=======================================================");
            }

            checkingOptions(user, comp);


            totalGame++;
            count--;
        }
        printInfo();

    }

    public static Type returnCompChoose() {
        Type[] types = Type.values();
        Random random = new Random();
        int rnd = random.nextInt(types.length);
        return types[rnd];
    }

    public static Type returnUserChoose() {
        System.out.print("Enter the number of the selected option:\n" +
                "[1] - ROCK | [2] - PAPER | [3] - SCISSORS | [4] - LIZARD | [5] - SPOCK --> ");
        int userChooseNum = new Scanner(System.in).nextInt();
        if (userChooseNum == 1) {
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-16s - %-12s\n", "You chose", "ROCK");
            return Type.ROCK;
        } else if (userChooseNum == 2) {
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-16s - %-12s\n", "You chose", "PAPER");
            return Type.PAPER;
        } else if (userChooseNum == 3){
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-16s - %-12s\n", "You chose", "SCISSORS");
            return Type.SCISSORS;
        }else if (userChooseNum == 4){
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-16s - %-12s\n", "You chose", "LIZARD");
            return Type.LIZARD;
        }else {
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-16s - %-12s\n", "You chose", "SPOCK");
            return Type.SPOCK;
        }
    }

    public static void checkingOptions(String user, String comp) {

        if (Objects.equals(user, comp)) {
            draw++;
        } else if (Objects.equals(user, "ROCK") || Objects.equals(comp, "LIZARD") &&
                Objects.equals(user, "ROCK") || Objects.equals(comp, "SCISSORS")) {
            userCount++;
            compDefeat++;
        } else if (Objects.equals(user, "PAPER") || Objects.equals(comp, "ROCK") &&
        Objects.equals(user,"PAPER") || Objects.equals(comp,"SPOCK")) {
            userCount++;
            compDefeat++;
        } else if (Objects.equals(user, "SCISSORS") || Objects.equals(comp, "PAPER") &&
        Objects.equals(user,"SCISSORS") || Objects.equals(comp,"LIZARD")) {
            userCount++;
            compDefeat++;
        } else if (Objects.equals(user, "LIZARD") || Objects.equals(comp, "SPOCK") &&
        Objects.equals(user,"LIZARD") || Objects.equals(comp,"PAPER")) {
            userCount++;
            compDefeat++;
        } else if (Objects.equals(user, "SPOCK") || Objects.equals(comp, "SCISSORS") &&
        Objects.equals(user,"SPOCK") || Objects.equals(comp,"ROCK")) {
            userCount++;
            compDefeat++;
        } else if (Objects.equals(comp, "ROCK") || Objects.equals(user, "LIZARD") &&
        Objects.equals(comp,"ROCK") || Objects.equals(user,"SCISSORS")) {
            compCount++;
            userDefeat++;
        }else if (Objects.equals(comp, "PAPER") || Objects.equals(user, "ROCK") &&
        Objects.equals(comp,"PAPER") || Objects.equals(user,"SPOCK")) {
            compCount++;
            userDefeat++;
        }else if (Objects.equals(comp, "SCISSORS") || Objects.equals(user, "PAPER") &&
        Objects.equals(comp,"SCISSORS") || Objects.equals(user,"LIZARD")) {
            compCount++;
            userDefeat++;
        }else if (Objects.equals(comp, "LIZARD") || Objects.equals(user, "SPOCK") &&
        Objects.equals(comp,"LIZARD") || Objects.equals(user,"PAPER")) {
            compCount++;
            userDefeat++;
        }else if (Objects.equals(comp, "SPOCK") || Objects.equals(user, "SCISSORS") &&
        Objects.equals(comp,"SPOCK") || Objects.equals(user,"ROCK")) {
            compCount++;
            userDefeat++;
        }
    }

    public static void printInfo() {
        double compCountDefinition = compCount;
        double totalGameDefinition = totalGame;
        double compWinRate = (compCountDefinition / totalGameDefinition) * 100;
        double userCountDefinition = userCount;
        double userWinRate = (userCountDefinition / totalGameDefinition) * 100;

        if (userCount > compCount) {
            System.out.println("YOU WIN! CONGRATULATIONS");
            System.out.println("+------------------------------------------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s | %-10s |\n", "Victory", "Defeat", "Draw", "Total games", "Win rate");
            System.out.println("|----------+----------+------------+-------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s | %-10s |\n", userCount, userDefeat, draw, totalGame, userWinRate + "%");
            System.out.println("+------------------------------------------------------------+");
        } else if (compCount > userCount) {
            System.out.println("Computer WIN! YOU LOSE");
            System.out.println("+------------------------------------------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s | %-10s |\n", "Victory", "Defeat", "Draw", "Total games", "Win rate");
            System.out.println("|----------+----------+------------+-------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s | %-10s |\n", compCount, compDefeat, draw, totalGame, compWinRate + "%");
            System.out.println("+------------------------------------------------------------+");
        } else {
            System.out.println("This game is a DRAW!");
            System.out.println("+-----------------------------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s |\n", "User Win", "Comp WIn", "Draw", "Total games");
            System.out.println("|----------+----------+----------+--------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s |\n", userCount, compCount, draw, totalGame);
            System.out.println("+-----------------------------------------------+");
        }
    }

}
