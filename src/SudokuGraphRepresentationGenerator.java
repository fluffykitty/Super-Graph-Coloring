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
            int m = 1458;   // # edges

            writer.println("81 1458");

            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

}

