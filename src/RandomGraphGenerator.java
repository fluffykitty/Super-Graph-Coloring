import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class RandomGraphGenerator {
    //creates a random graph with size of nodes (n) read from STDIN
    //to solve the graph coloring problem
    //no nodes are initially colored

    public static void main (String [] args){

        try{
            Scanner scanner = new Scanner(System.in);
            PrintWriter writer = new PrintWriter("text.txt", "UTF-8");
            int n = 0;

            System.out.print("Number of nodes: ");
            n = scanner.nextInt();

            int m = (n*(n-1))/10;
            Graph g = new Graph(n);

            writer.println(n + " " + m);

            Random rand = new Random();
            while(m > 0){
                rand = new Random();
                int u = rand.nextInt(n)+1; //n is our max and 1 is our min
                int v = rand.nextInt(n)+1;
                if (u !=v && g.graph[u-1][v-1] == 0){
                    g.addEdge(u-1, v-1);
                    m--;
                    writer.println(u + " " + v);
                }
            }//while

            for(int i=0; i<n-1; i++){
                writer.print("0 ");
            }
            writer.print("0");
            writer.close();

        } catch(IOException e){
            System.out.println("Your input is wonky or the text file isn't written");
        }

    }

}
