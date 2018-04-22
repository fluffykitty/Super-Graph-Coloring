import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        try{
            //File f = new File("sample.txt");
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

            g.getDegrees();
            g.findMinimalColoring();

            //g.printMinimalColoring();

            //1st line of std out
            int additional_colors_needed = g.uniqueColors.size() - initial_size_colors;
            System.out.println(additional_colors_needed);
            //2nd line of std out
            for(int z=0; z<g.nodeColors.length-1; z++)
                System.out.print(g.nodeColors[z] + " ");
            System.out.print(g.nodeColors[g.nodeColors.length-1] + "\n");

        }
        catch (Exception e){
            System.out.println("Check your standard input!");
        }
    }

}
