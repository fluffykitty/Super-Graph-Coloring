import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        try{
            File f = new File("sudoku.txt");
            Scanner scanner = new Scanner(f);

            int n, m;

            n = scanner.nextInt();
            m = scanner.nextInt();

            Graph g = new Graph(n);

            for(int i=0; i<m; i++){
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                //nodes are numbered 1-->n as opposed to 0-->n-1 so we adjust for our arrays
                //g.addEdge(a-1,b-1);
                /** IMPORTANT */
                /** sudoku graph (currently) starts with nodes numbered at 0 not 1 */
                g.addEdge(a,b);
            }

            //setting nodeColors of each node
            for (int j=0; j<n; j++)
                g.nodeColors[j] = scanner.nextInt();

            for (int el : g.uniqueColors)
                System.out.println("el # " + el);

            g.print();
            g.getDegrees();

            g.findMinimalColoring();
            g.printMinimalColoring();

        }
        catch (FileNotFoundException e){
            System.out.println("file not found");
        }
    }

}
