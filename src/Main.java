/*
 *  Rostam Panjshiri
 *  CMSC 501 Dinh
 *  VCU Spring 201
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        try{
            Scanner scanner = new Scanner(System.in);

            int n, m;

            n = scanner.nextInt();
            m = scanner.nextInt();

            Graph g = new Graph(n);

            for(int i=0; i<m; i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                //nodes are numbered 1-->n as opposed to 0-->n-1 so we adjust for our arrays
                g.addEdge(a-1,b-1);
            }

            //setting nodeColors of each node
            for (int j=0; j<n; j++)
                g.nodeColors[j] = scanner.nextInt();

            g.setColors();
            int initial_size_colors = g.uniqueColors.size();

            /** FOR TIMING */
//            final long startTime = System.currentTimeMillis();

            g.getDegrees();
            g.findMinimalColoring();

            g.getDegrees();
//            int maxDegree = Arrays.stream(g.degrees).max().getAsInt();
//            final long endTime = System.currentTimeMillis();

            System.out.println(" ");
//            g.printMinimalColoring();

//            System.out.println("\nMax degree: " + maxDegree);
//            System.out.println("Total execution time: " + (endTime - startTime) + " milliseconds");

            /** Printing to specified format */
            //1st line of std out
            int additional_colors_needed = g.uniqueColors.size() - initial_size_colors;
            System.out.println(additional_colors_needed);
            //2nd line of std out
            for(int z=0; z<g.nodeColors.length-1; z++)
                System.out.print(g.nodeColors[z] + " ");
            System.out.print(g.nodeColors[g.nodeColors.length-1] + "\n");

            //uncomment to print a beautiful sudoku puzzle
            //as long as input is in sudoku format
//            g.printMinimalSudoku();

        }
        catch (ArithmeticException e){
            System.out.println("Check your standard input!");
        }
    }

}
