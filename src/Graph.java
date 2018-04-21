import java.util.stream.IntStream;

public class Graph {

    int V;
    int [][] graph;
    int [] nodes;
    int [] colors;
    int [] degrees;

    Graph(int v){
        V = v;
        graph = new int [v][v];
        nodes = new int [v];
        colors = new int[v];
        degrees = new int[v];
    }

    void addEdge(int a, int b){
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    public void setColors(int [] col){
        colors = col;
    }

    void getDegrees(){
        for (int i=0; i<V; i++){
            degrees[i] = IntStream.of(graph[i]).sum();
        }
    }

    void print(){
        System.out.println("--------------------------------");

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
