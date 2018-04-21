import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Graph {

    int V;
    int [][] graph;
    int [] nodes;
    int [] nodeColors;
    int [] degrees;

    int numberOfColorsUsed = 0;

    Set<Integer> uniqueColors = new HashSet<Integer>();
    Set<Integer> temporary = new HashSet<Integer>();

    Graph(int v){
        V = v;
        graph = new int [v][v];
        nodes = new int [v];
        nodeColors = new int[v];
        degrees = new int[v];
    }

    void addEdge(int a, int b){
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    public void setColors(int [] col){
        nodeColors = col;
        //add all unique colors to our set
        for (int el : nodeColors)
            if (el != 0)
                uniqueColors.add(el);

        numberOfColorsUsed = uniqueColors.size();
    }

    void getDegrees(){
        for (int i=0; i<V; i++)
            degrees[i] = IntStream.of(graph[i]).sum();
    }

    int getSaturationDegree(int node){
        temporary.clear();

        for (int i=0; i<V; i++)
            if(graph[node][i] == 1)
                temporary.add(nodeColors[i]);

        return temporary.size();
    }

    Set<Integer> getSaturatedColors(int node){
        //get all adjacent nodes that are differently colored
        temporary.clear();

        for (int i=0; i<V; i++)
            if(graph[node][i] == 1)
                temporary.add(nodeColors[i]);

        return temporary;
    }

    int selectNodeToColor(){
        //gets saturation degrees of all nodes yet colored
        //tracks index of highest saturated node
        //returns index of node to be colored

        int max = -1;
        int index = -1; //will not result in outofboundsexception
        for(int i=0; i<V; i++){
            if(nodeColors[i] == 0){
                int curr = getSaturationDegree(i);
                if( curr > max) {
                    max = curr;
                    index = i;
                }
                //perhaps add check for if max == curr and base off node degree
            }
        }//for

        return index;

    }

    void print(){
        System.out.println("--------------------------------\n" +
                "-------- Printing Graph --------\n" +
                "--------------------------------");

        for(int i=0; i<V; i++){
            System.out.print("[  ");
            for(int j=0; j<V; j++){
                System.out.print(graph[i][j] + "  ");
            }
            System.out.print("]\n");
        }

        System.out.println("--------------------------------\n");
    }
}
