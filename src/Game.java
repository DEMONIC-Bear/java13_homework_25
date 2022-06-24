import java.util.Objects;

public class Game {
    private Computer computer = new Computer();
    private User userData = new User();
    private static int count = 5;
    private static int totalGame = 0;
    private static int draw = 0;
    private static int compCount = 0;
    private static int compDefeat = 0;
    private static int userCount = 0;
    private static int userDefeat = 0;

    public void gameRule() {

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

    public static void checkingOptions(String user, String comp) {

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
