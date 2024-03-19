package kthdsa.L3;

import java.util.Scanner;

public class PuzzleMain {
    public static void main(String[] args) {

        Puzzle puzzle = new Puzzle();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange rad för den grå rutan (1 till 5): ");
        int row = scanner.nextInt();
        System.out.print("Ange kolumn för den grå rutan (1 till 5): ");
        int col = scanner.nextInt();

        puzzle.play(row, col);
        System.out.println("row: " + row + " col: " + col + " -> " + puzzle.getSolutions());

//        for(int r = 1; r < 6; r++){
//            for(int c = 1; c < 6; c++){
//                puzzle.play(r, c);
//                System.out.println("row: " + r + " col: " + c + " -> " + puzzle.getSolutions());
//            }
//        }
    }
}
