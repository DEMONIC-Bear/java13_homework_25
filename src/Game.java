import java.util.Objects;
import java.util.Scanner;

public class Game {
    private static int gameLevel = 0;
    private Computer computer = new Computer(gameLevel);
    private User userData = new User(gameLevel);
    private static int count = 4;
    private static int totalGame = 0;
    private static int draw = 0;
    private static int compCount = 0;
    private static int compDefeat = 0;
    private static int userCount = 0;
    private static int userDefeat = 0;

    public void gameRule() {
        System.out.println("------------ Start game -------------");
        count = getGameCount();
        getGameLevel();
        computer = new Computer(gameLevel);
        userData = new User(gameLevel);

        while (count != 0) {
            String user = userData.getTypeFromUser().name();
            userData.printName(user);
            String comp = computer.getTypeFromComp().name();
            computer.printname(comp);
            checkingOptions(user, comp);
            totalGame++;
            count--;
        }


        printInfo();
    }

    public static int getGameCount() {
        boolean check = true;
        int gameCountLocale = 0;
        while (check) {
            try {
                System.out.print("How many times do you want to play...? ");
                gameCountLocale = new Scanner(System.in).nextInt();
                if(gameCountLocale < 1 || gameCountLocale > 100) {
                    throw new RuntimeException();
                } else {
                    check = false;
                    return gameCountLocale;
                }
            } catch (Exception e) {
                System.out.println("You entered an invalid value");
                check = true;
            }
        }
        return getGameCount();
    }

    public static int getGameLevel() {
        boolean check = true;
        while (check) {
            try {
                System.out.println("Select game mode:\n" +
                        "[1] - Easy | [2] - Hard");
                gameLevel = new Scanner(System.in).nextInt();
                if (gameLevel < 1 || gameLevel > 2) {
                    throw new RuntimeException();
                } else {
                    check = false;
                    return gameLevel;
                }
            } catch (Exception e) {
                System.out.println("There are only two modes");
                check = true;
            }
        }
        return getGameLevel();
    }

    public static void checkingOptions(String user, String comp) {
        if (totalGame == 1) {
            if (Objects.equals(user, comp)) {
                draw++;
            } else if ((Objects.equals(user, Type.ROCK.name()) && Objects.equals(comp, Type.SCISSORS.name()))) {
                userCount++;
                compDefeat++;
            } else {
                compCount++;
                userDefeat++;
            }
        } else {
            if (Objects.equals(user, comp)) {
                draw++;
            } else if (
                    (Objects.equals(user, Type.ROCK.name()) && (Objects.equals(comp, Type.SCISSORS.name()) || Objects.equals(comp, Type.LIZARD.name()))) ||
                            (Objects.equals(user, Type.PAPER.name()) && (Objects.equals(comp, Type.ROCK.name()) || Objects.equals(comp, Type.SPOCK.name()))) ||
                            (Objects.equals(user, Type.SCISSORS.name()) && (Objects.equals(comp, Type.PAPER.name()) || Objects.equals(comp, Type.LIZARD.name()))) ||
                            (Objects.equals(user, Type.LIZARD.name()) && (Objects.equals(comp, Type.PAPER.name()) || Objects.equals(comp, Type.SPOCK.name()))) ||
                            (Objects.equals(user, Type.SPOCK.name()) && (Objects.equals(comp, Type.ROCK.name()) || Objects.equals(comp, Type.SCISSORS.name())))
            ) {
                userCount++;
                compDefeat++;
            } else {
                compCount++;
                userDefeat++;
            }
        }

    }

    public static void printInfo() {
        double compCountDefinition = compCount;
        double userCountDefinition = userCount;
        double totalGameDefinition = totalGame;
        double drawDefinition = draw;
        double compWinRate = (((drawDefinition / 2) + compCountDefinition) / totalGameDefinition) * 100;
        double userWinRate = (((drawDefinition / 2) + userCountDefinition) / totalGameDefinition) * 100;

        if (userCount > compCount) {
            System.out.println("YOU WIN! CONGRATULATIONS");
            System.out.println("+------------------------------------------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s | %-10s |\n", "Victories", "Defeats", "Draw", "Total games", "Win rate");
            System.out.println("|----------+----------+----------+---------------------------+");
            System.out.printf("| %-9s | %-8s | %-8s | %-12s | %-6s |\n", userCount, userDefeat, draw, totalGame, userWinRate + "%     ");
            System.out.println("+------------------------------------------------------------+");
        } else if (compCount > userCount) {
            System.out.println("COMPUTER WIN! YOU LOSE");
            System.out.println("+------------------------------------------------------------+");
            System.out.printf("| %-8s | %-8s | %-8s | %-12s | %-10s |\n", "Victories", "Defeats", "Draw", "Total games", "Win rate");
            System.out.println("|-----------+----------+----------+--------------------------+");
            System.out.printf("| %-9s | %-8s | %-8s | %-12s | %-6s |\n", compCount, compDefeat, draw, totalGame, compWinRate + "%     ");
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
