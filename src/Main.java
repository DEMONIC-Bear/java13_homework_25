import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        gameRule();

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

    public static void gameRule() {
        int count = 5;
        int draw = 0;
        int compCount = 0;
        int userCount = 0;
        int compWinRate = compCount / (count - compCount);
        int userWinRate = userCount / (count - userCount);
        int compDefeat = count - compCount;
        int userDefeat = count - userCount;

        while (count != 0) {

            String comp = returnCompChoose().toString();
            String user = returnUserChoose().toString();
            if (comp == "ROCK" || user == "ROCK") {
                draw++;
            } else if (comp == "PAPER" || user == "PAPER") {
                draw++;
            }else if (comp == "SCISSORS" || user == "SCISSORS") {
                draw++;
            }else if (comp == "ROCK" || user == "PAPER") {
                userCount++;
            }else if (comp == "PAPER" || user == "ROCK") {
                compCount++;
            }else if (comp == "SCISSORS" || user == "PAPER") {
                compCount++;
            }else if (comp == "SCISSORS" || user == "ROCK") {
                userCount++;
            }


            if (comp == "ROCK") {
                System.out.println("Computer chose > Rock");
            } else if (comp == "PAPER") {
                System.out.println("Computer chose > Paper");
            } else {
                System.out.println("Computer chose > Scissors");
            }
            count--;

            if (count == 0) {
                if (compCount > userCount) {
                    System.out.println("Win user!");
                    System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", "Victory", "Defeat", "Draw", "Total games", "Win rate");
                    System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", compCount, compDefeat, draw, count, compWinRate);
                } else {
                    System.out.println("Win comp!");
                    System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", "Victory", "Defeat", "Draw", "Total games", "Win rate");
                    System.out.printf("%-8s | %-8s | %-8s | %-12s | %-14s\n", userCount, userDefeat, draw, count, userWinRate);
                }
            }


        }
    }

}
