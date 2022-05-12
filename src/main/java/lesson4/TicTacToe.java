
package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    final static int SIZE = 3;

    final static char DOT_EMPTY = '•';
    final static char DOT_HUMAN = 'X';
    final static char DOT_AI = 'O';

    final static char[][] MAP = new char[SIZE][SIZE];
    final static String SPACE_SYMBOL = " ";
    final static String HEADER_SYMBOL = "\\";
    static Scanner in = new Scanner(System.in);
    static Random random = new Random();
    static int lastTurnRow;
    static int lastTurnColumn;

    public static void main(String[] args) {
        initMap();
        printMap();
        turnGame();
    }

    private static void turnGame() {

        playGame();
    }

    private static void initMap() {
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapBody();
    }

    private static void printMapHeader() {
        System.out.print(HEADER_SYMBOL + SPACE_SYMBOL);
        for(int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapBody() {
        for(int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for(int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_SYMBOL);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print((i + 1) + SPACE_SYMBOL);
    }

    private static void playGame() {
        while (true) {

            playerTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static void playerTurn() {
        System.out.println("Ход игрока");

        int rowNumber;
        int columnNumber;

        while (true) {
            rowNumber = in.nextInt() - 1;
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ячейка [%d,%d] уже занята\n", rowNumber + 1, columnNumber + 1);
        }

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        writeLastTurn(rowNumber, columnNumber);
    }


    private static void aiTurn() {
        System.out.println("Ход AI");

        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(SIZE) ;
            columnNumber = random.nextInt(SIZE) ;

        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        writeLastTurn(rowNumber, columnNumber);
    }

    private static void writeLastTurn(int rowNumber, int columnNumber) {
        lastTurnRow = rowNumber;
        lastTurnColumn = columnNumber;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }


    private static boolean checkEnd(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Вы победили");
            } else {
                System.out.println("Выиграл компьютер");
            }

            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    private static boolean checkWin(char symbol) {

        return checkLine(symbol) || checkColumn(symbol) || checkDiagonalUp(symbol) || checkDiagonalDown(symbol);
    }

    private static boolean checkColumn(char symbol) {
        for(int i = 0; i < SIZE; i++) {
            if (MAP[lastTurnRow][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLine(char symbol) {
        for(int i = 0; i < SIZE; i++) {
            if (MAP[i][lastTurnColumn] != symbol) {
                return false;
            }
        }
        return true;
    }

    // check only full-size down diagonal
    private static boolean checkDiagonalDown(char symbol) {
        if (lastTurnColumn != lastTurnColumn) { // we are not on down diagonal
            return false;
        }
        for(int i = 0; i < SIZE; i++) {
            if (MAP[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    // check only full-size up diagonal
    private static boolean checkDiagonalUp(char symbol) {
        if (lastTurnRow + lastTurnColumn != SIZE - 1) { // we are not on down diagonal
            return false;
        }
        for(int i = 0; i < SIZE; i++) {
            if (MAP[SIZE - i - 1][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDraw() {
        for (char[] chars : MAP) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return  true;
    }
}



