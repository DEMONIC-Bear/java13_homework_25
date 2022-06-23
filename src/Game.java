import java.util.Arrays;
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
                System.out.println("Computer chose > Rock");
            } else if (Objects.equals(comp, "PAPER")) {
                System.out.println("Computer chose > Paper");
            } else {
                System.out.println("Computer chose > Scissors");
            }


            if (Objects.equals(user, "ROCK") || Objects.equals(comp, "ROCK") &&
                    Objects.equals(user, "PAPER") && Objects.equals(comp, "PAPER") &&
                    Objects.equals(user, "SCISSORS") || Objects.equals(comp, "SCISSORS")) {
                draw++;
            } else if (Objects.equals(user, "ROCK") || Objects.equals(comp, "PAPER")) {
                compCount++;
                userDefeat++;
            } else if (Objects.equals(user, "ROCK") || Objects.equals(comp, "SCISSORS")) {
                userCount++;
                compDefeat++;
            } else if (Objects.equals(user, "PAPER") || Objects.equals(comp, "ROCK")) {
                userCount++;
                compDefeat++;
            } else if (Objects.equals(user, "PAPER") || Objects.equals(comp, "SCISSORS")) {
                compCount++;
                userDefeat++;
            } else if (Objects.equals(user, "SCISSORS") || Objects.equals(comp, "ROCK")) {
                compCount++;
                userDefeat++;
            } else if (Objects.equals(user, "SCISSORS") || Objects.equals(comp, "PAPER")) {
                userCount++;
                compDefeat++;
            }
            count--;
            totalGame++;
        }
        double compCountDefinition = compCount;
        double totalGameDefinition = totalGame;
        double compWinRate = (compCountDefinition / totalGameDefinition) * 100;
        double userCountDefinition = userCount;
        double userWinRate = (userCountDefinition / totalGameDefinition) * 100;

        if (userCount > compCount) {
            System.out.println("YOU WIN!");
            System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", "Victory", "Defeat", "Draw", "Total games", "Win rate");
            System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", userCount, userDefeat, draw, totalGame, userWinRate + "%");
        } else if (compCount > userCount) {
            System.out.println("Computer WIN!");
            System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", "Victory", "Defeat", "Draw", "Total games", "Win rate");
            System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", compCount, compDefeat, draw, totalGame, compWinRate + "%");
        } else {
            System.out.println("DRAW!");
            System.out.printf("%-8s | %-8s | %-8s | %-12s \n", "User Win", "Comp WIn", "Draw", "Total games");
            System.out.printf("%-8s | %-8s | %-8s | %-12s \n", userCount, compCount, draw, totalGame);
        }
    }

    public static Type returnCompChoose() {
        int rnd = new Random().nextInt(3) + 1;
        if (rnd == 1) {
            return Type.ROCK;
        } else if (rnd == 2) {
            return Type.PAPER;
        } else {
            return Type.SCISSORS;
        }
    }

    public static Type returnUserChoose() {
        System.out.println("""
                Enter the number of the selected option:
                 1 - Rock
                 2 - Paper
                 3 - Scissors""");
        System.out.println("=======================================================");
        int userChooseNum = new Scanner(System.in).nextInt();
        if (userChooseNum == 1) {
            System.out.println("You chose > Rock");
            return Type.ROCK;
        } else if (userChooseNum == 2) {
            System.out.println("You chose > Paper");
            return Type.PAPER;
        } else {
            System.out.println("You chose > Scissors");
            return Type.SCISSORS;
        }
    }
}
