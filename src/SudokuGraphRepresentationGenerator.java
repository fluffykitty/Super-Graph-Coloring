import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SudokuGraphRepresentationGenerator {

    public static void main(String [] args){
        try{
            File f = new File("sudoku.txt");
            PrintWriter writer = new PrintWriter(f);

            int n = 81;     // # nodes
            int m = 810;   // # edges

            writer.println("81 810");

            //creating sudoku graph
            for(int i=0; i<81; i++){

                //creating horizontal edges
                int horz_cap = i + 9 - (i % 9);
                for (int j = i+1; j < horz_cap; ++j){
                    writer.println(i + " " + j);
                }

                //creating columnar edges
                for (int k = i+9; k < 81; k += 9){
                    writer.println(i + " " + k);
                }

                //creating group edges
                //determines position within group from top left (1) to bottom right (9)
                int loc = ( (i % 3) + 1 ) + (3 * ((int)(i / 9) % 3));
                switch (loc){
                    case 1:
                        writer.println(i + " " + (i+10));
                        writer.println(i + " " + (i+19));
                        writer.println(i + " " + (i+11));
                        writer.println(i + " " + (i+20));
                        break;
                    case 2:
                        writer.println(i + " " + (i+8));
                        writer.println(i + " " + (i+17));
                        writer.println(i + " " + (i+10));
                        writer.println(i + " " + (i+19));
                        break;
                    case 3:
                        writer.println(i + " " + (i+7));
                        writer.println(i + " " + (i+16));
                        writer.println(i + " " + (i+8));
                        writer.println(i + " " + (i+17));
                        break;
                    case 4:
                        writer.println(i + " " + (i+10));
                        writer.println(i + " " + (i+11));
                        break;
                    case 5:

                        writer.println(i + " " + (i+8));
                        writer.println(i + " " + (i+10));
                        break;
                    case 6:
                        writer.println(i + " " + (i+7));
                        writer.println(i + " " + (i+8));
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                }
            }//end graph generation

            //inserting node colors as Sudoku Puzzle example given in Assignment PDF
            //done reading in row-major order
            int [] sudoku_example =    {0,0,1,0,0,0,0,0,4,
                                        0,2,3,1,0,0,9,0,0,
                                        0,8,6,0,5,0,3,0,0,
                                        0,6,0,0,4,0,0,0,0,
                                        3,0,0,9,0,1,0,0,5,
                                        0,0,0,0,7,0,0,3,0,
                                        0,0,4,0,3,0,6,1,0,
                                        0,0,2,0,0,5,8,4,0,
                                        7,0,0,0,0,0,5,0,0};

            for (int idx = 0; idx < sudoku_example.length - 1; idx++){
                writer.print(sudoku_example[idx] + " ");
            }
            writer.print(sudoku_example[sudoku_example.length -1]); //write out the last line

            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

}

