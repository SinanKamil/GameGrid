import java.security.SecureRandom;
import java.util.Scanner;
public class GameGrid {
int counter = 0;
    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n      Welcome to the Game Grid\n");
        System.out.println("Instructions: This is a very simple game to play. ");
        System.out.println("You will need to not cross the number (1) and escape ");
        System.out.println("from any side to Win.\n");
        int[][] game = new int[10][10];
        SecureRandom ran = new SecureRandom();
        int iwallChance = 30;

        LinkedList w = new LinkedList();
        int iUserRow = 0;
        int iUserCol = 0;

        boolean exits = false;
        //rows
        for (int x = 0; x < 10; x++) {
            // Cols
            for (int y = 0; y < 10; y++) {
                if (ran.nextInt(100) < iwallChance) {
                    game[x][y] = 1;
                } else {
                    game[x][y] = 0;
                }
            }
        }
        game[0][0] = 0;


        for (int i = 0; i < game.length; i++) {
            for (int v = 0; v < game[i].length; v++) {
                if (i == iUserRow && v == iUserCol) {
                    System.out.print("$ ");
                } else {
                    System.out.print(game[i][v] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("\nChoose from the following");
        System.out.println("1) TO MOVE RIGHT ");
        System.out.println("2) TO MOVE DOWN ");

        while (!exits) {
            System.out.println("Enter your choice Here: ");
            int choice = 0;
            choice = input.nextInt();

            w.addHeadNode(iUserCol, iUserRow);

            if (choice == 1) {
                iUserCol++;
            } else if (choice == 2) {
                iUserRow++;
            } else {
                System.out.printf("Wrong input, try again. ");
                System.out.println("Enter your choice Here: ");
            }

            if (game[iUserRow][iUserCol] == 1) {
                System.out.printf("You Failed, Game over" + "\n");
               // System.out.println("Total moves taken: " + counter + "\n");
                exits = true;
            } else if (iUserCol == 9 || iUserRow == 9) {
                System.out.printf("You Won!!! \n");
                exits = true;
            }
            for (int i = 0; i < game.length; i++) {
                for (int v = 0; v < game[i].length; v++) {
                    if (i == iUserRow && v == iUserCol) {
                        System.out.print("$ ");
                    } else {
                        System.out.print(game[i][v] + " ");
                    }
                }
                System.out.println();
            }

        }

        Node t = w.removeHeadNode();
        while (t != null) {
            game[t.yPosition][t.xPosition] = 9;
            t = w.removeHeadNode();
            counter++;
        }
        System.out.println();
       for (int i = 0; i < game.length; i++) {
            for (int v = 0; v < game[i].length; v++) {
                if (i == iUserRow && v == iUserCol) {
                    System.out.print("$ ");
                } else {
                    System.out.print(game[i][v] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("Total moves taken: " + counter + "\n");
    }
}


