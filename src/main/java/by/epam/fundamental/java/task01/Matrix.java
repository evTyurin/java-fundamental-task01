package by.epam.fundamental.java.task01;

import java.util.Scanner;

public class Matrix
{
    public static void main( String[] args )
    {
        int [][] matrix = create();
        view(matrix);
    }

    public static int getDimension () {
        int dimension;
        System.out.println("Please, enter even number");

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            sc.nextLine();
        }

        dimension = sc.nextInt();

        if(dimension % 2 == 1 || dimension < 2) {
            System.out.println("Number is incorrect");
            dimension = getDimension();
        }

        sc.close();
        return dimension;
    }

    public static int[][] create () {
        int dimension = getDimension();
        int [][] matrix = new int[dimension][dimension];
        for (int stringNumber = 0; stringNumber < dimension; stringNumber++) {
            int x = 0;
            int y = dimension;

            for (int columnNumber = 0; columnNumber < dimension; columnNumber++) {
                if (stringNumber % 2 == 0) {
                    matrix[stringNumber][columnNumber] = ++x;
                }
                else {
                    matrix[stringNumber][columnNumber] = y--;
                }
            }
        }
        return matrix;
    }

    public static void view (int[][] matrix) {
        int dimension = matrix.length;

        for (int stringNumber = 0; stringNumber < dimension; stringNumber++) {

            for (int columnNumber = 0; columnNumber < dimension; columnNumber++) {
                System.out.print(matrix[stringNumber][columnNumber] + " ");
            }

            System.out.print(System.lineSeparator());
        }

    }

}