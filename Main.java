import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] array = new String[3][3];

        // print empty grid

        System.out.println("---------");

        for (int i = 0; i < array.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = " ";
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        //create loop

        int first = 0;
        int second = 0;
        boolean firstIsNum;
        boolean secondIsNum;
        int counter = 0;
        boolean emptySpace = true;
        boolean win = false;


        while (true) {
            counter++;
           // System.out.println(counter);
            try {
                first = Integer.parseInt(scanner.next());
                firstIsNum = true;
            } catch (NumberFormatException e) {
                firstIsNum = false;
            }

            try {
                second = Integer.parseInt(scanner.next());
                secondIsNum = true;
            } catch (NumberFormatException e) {
                secondIsNum = false;
            }

            if (firstIsNum == false || secondIsNum == false) {
                System.out.println("You should enter numbers!");
                counter--;
            } else {
                if (!(first > 0 && first < 4) || !(second > 0 && second < 4)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    counter--;
                } else if ((first > 0 && first < 4) && (second > 0 && second < 4)) {
                    if ((array[first - 1][second - 1].equalsIgnoreCase("X")) || (array[first - 1][second - 1].equalsIgnoreCase("O"))) {
                        System.out.println("This cell is occupied! Choose another one!");
                        counter--;
                    } else {
                        if (counter % 2 == 1) {
                            array[first - 1][second - 1] = "X";
                            //print new grid after "X"
                            System.out.println("---------");

                            for (int i = 0; i < array.length; i++) {
                                System.out.print("| ");
                                for (int j = 0; j < array[i].length; j++) {

                                    System.out.print(array[i][j] + " ");
                                }
                                System.out.println("|");
                            }
                            System.out.println("---------");

                            //check if you won or draw
                            emptySpace = false;

                            if (array[0][0].equals(array[0][1]) && array[0][0].equals(array[0][2]) && array[0][0].equals("X") ||
                                    array[1][0].equals(array[1][1]) && array[1][0].equals(array[1][2]) && array[1][0].equals("X") ||
                                    array[2][0].equals(array[2][1]) && array[2][0].equals(array[2][2]) && array[2][0].equals("X") ||
                                    array[0][0].equals(array[1][0]) && array[0][0].equals(array[2][0]) && array[0][0].equals("X") ||
                                    array[0][1].equals(array[1][1]) && array[0][1].equals(array[2][1]) && array[0][1].equals("X") ||
                                    array[0][2].equals(array[1][2]) && array[0][2].equals(array[2][2]) && array[0][2].equals("X") ||
                                    array[0][0].equals(array[1][1]) && array[0][0].equals(array[2][2]) && array[0][0].equals("X") ||
                                    array[2][0].equals(array[1][1]) && array[2][0].equals(array[0][2]) && array[2][0].equals("X")) {
                                System.out.println("X wins");
                                win = true;
                                break;
                            } else {
                                for (int i = 0; i < array.length; i++) {
                                    for (int j = 0; j < array[i].length; j++) {
                                        if (array[i][j].equalsIgnoreCase(" ")) {
                                            emptySpace = true;
                                        }
                                    }

                                }
                                if (!emptySpace) {

                                    System.out.println("Draw");
                                    break;
                                }

                            }

                        } else if (counter % 2 == 0) {
                            array[first - 1][second - 1] = "O";

                            //print new grid after "O"
                            System.out.println("---------");

                            for (int i = 0; i < array.length; i++) {
                                System.out.print("| ");
                                for (int j = 0; j < array[i].length; j++) {

                                    System.out.print(array[i][j] + " ");
                                }
                                System.out.println("|");
                            }
                            System.out.println("---------");

                            emptySpace = false;

                            if (array[0][0].equals(array[0][1]) && array[0][0].equals(array[0][2]) && array[0][0].equals("O") ||
                                    array[1][0].equals(array[1][1]) && array[1][0].equals(array[1][2]) && array[1][0].equals("O") ||
                                    array[2][0].equals(array[2][1]) && array[2][0].equals(array[2][2]) && array[2][0].equals("O") ||
                                    array[0][0].equals(array[1][0]) && array[0][0].equals(array[2][0]) && array[0][0].equals("O") ||
                                    array[0][1].equals(array[1][1]) && array[0][1].equals(array[2][1]) && array[0][1].equals("O") ||
                                    array[0][2].equals(array[1][2]) && array[0][2].equals(array[2][2]) && array[0][2].equals("O") ||
                                    array[0][0].equals(array[1][1]) && array[0][0].equals(array[2][2]) && array[0][0].equals("O") ||
                                    array[2][0].equals(array[1][1]) && array[2][0].equals(array[0][2]) && array[2][0].equals("O")) {
                                System.out.println("O wins");
                                win = true;
                                break;
                            } else {

                                for (int i = 0; i < array.length; i++) {
                                    for (int j = 0; j < array[i].length; j++) {
                                        if (array[i][j].equalsIgnoreCase(" ")) {
                                            emptySpace = true;
                                        }
                                    }
                                }
                                if (!emptySpace) {

                                    System.out.println("Draw");
                                    break;
                                }
                            }
                        }
                        if (win == true || emptySpace == false) {
                            break;
                        }

                    }
                    if (win == true || emptySpace == false) {
                        break;
                    }

                }
                if (win == true || emptySpace == false) {
                    break;
                }

            }
            if (win == true || emptySpace == false) {
                break;
            }

        }

        }

    }



