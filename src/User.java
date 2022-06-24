import java.util.Scanner;

public class User {
    int gameLevel;

    public User(int num) {
        this.gameLevel = num;
    }

    int userChooseNum = 0;

    public Type getTypeFromUser() {
        boolean check = true;
        if (gameLevel == 1) {
            while (check) {
                try {
                    System.out.print("Enter the number of the selected option:\n" +
                            "[1] - ROCK | [2] - PAPER | [3] - SCISSORS --> ");
                    userChooseNum = new Scanner(System.in).nextInt();
                    if (userChooseNum < 1 || userChooseNum > 3) {
                        throw new RuntimeException();
                    } else {
                        if (userChooseNum == 1) {
                            check = false;
                            return Type.ROCK;
                        } else if (userChooseNum == 2) {
                            check = false;
                            return Type.PAPER;
                        } else {
                            check = false;
                            return Type.SCISSORS;
                        }

                    }
                } catch (Exception e) {
                    System.out.println("No such option exists! Please repeat.");
                    check = true;
                }
            }
        } else {
            while (check) {
                try {
                    System.out.print("Enter the number of the selected option:\n" +
                            "[1] - ROCK | [2] - PAPER | [3] - SCISSORS | [4] - LIZARD | [5] - SPOCK --> ");
                    userChooseNum = new Scanner(System.in).nextInt();
                    if (userChooseNum < 1 || userChooseNum > 5) {
                        throw new RuntimeException();
                    } else {
                        if (userChooseNum == 1) {
                            check = false;
                            return Type.ROCK;
                        } else if (userChooseNum == 2) {
                            check = false;
                            return Type.PAPER;
                        } else if (userChooseNum == 3) {
                            check = false;
                            return Type.SCISSORS;
                        } else if (userChooseNum == 4) {
                            check = false;
                            return Type.LIZARD;
                        } else {
                            check = false;
                            return Type.SPOCK;
                        }

                    }
                } catch (Exception e) {
                    System.out.println("No such option exists! Please repeat.");
                    check = true;
                }
            }

        }
        return getTypeFromUser();
    }

    public void printName(String name) {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-16s - %-12s\n", "You chose", name);

    }
}
