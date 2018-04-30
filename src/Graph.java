/*
 *  Rostam Panjshiri
 *  CMSC 501 Dinh
 *  VCU Spring 201
 */

import java.util.*;
import java.util.stream.IntStream;

public class Graph {
    //graph representation
    //using adjacency matrix
    //and containing methods necessary to find minimal coloring

    int V;
    int [][] graph;
    int [] nodes;
    int [] nodeColors;
    int [] degrees;

    int numberOfColorsUsed = 0;
    int numberOfNodesColored = 0;

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

    public void setColors() {
        // add all unique colors to our set
        int temp = 0;
        for (int el : nodeColors){
            if (el != 0) {
                uniqueColors.add(el);
                temp++;
            }
        }
        numberOfNodesColored = temp;
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
        // get all adjacent nodes that are differently colored
        temporary.clear();

        for (int i=0; i<V; i++)
            if(graph[node][i] == 1)
                temporary.add(nodeColors[i]);

        return temporary;
    }

    int selectNodeToColor(){
        // gets saturation degrees of all nodes yet colored
        // tracks index of highest saturated node
        // returns index of node to be colored

        int max = -1;
        int index = -1; //will not result in outofboundsexception
        for(int i=0; i<V; i++){
            if(nodeColors[i] == 0){
                int curr = getSaturationDegree(i);
                if( curr > max) {
                    max = curr;
                    index = i;
                }
                // perhaps add check for if max == curr and base off node degree
            }
        }//for
        return index;
    }

    void assignColor(){
        //assigns a singular color

        // determines whether node qualifies to use a pre-existing color
        // or whether it should be assigned a new color
        setColors();
        int node = selectNodeToColor();

        Set<Integer> colorsAvailable = new HashSet<>(uniqueColors);
        colorsAvailable.removeAll(getSaturatedColors(node));

        // if there is a pre-existing color that is not adjacent to this node
        // meaning the set of colorsAvailable is not empty,
        // then we assign that node to that color
        int kolor;

        if (!colorsAvailable.isEmpty()) {
            Iterator<Integer> it = colorsAvailable.iterator();
            kolor = it.next();
        } else if (uniqueColors.isEmpty()){
            kolor = 1;
        }
        else {
            kolor = Collections.max(uniqueColors) + 1;
        }
        nodeColors[node] = kolor;
        setColors(); //updates unique colors and counts colored nodes
    }

    void findMinimalColoring(){
        while (numberOfNodesColored < V){
            assignColor();
        }
    }

    void printGraph(){
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

    void printMinimalColoring(){
        System.out.println("The minimum number of colors needed is: " + uniqueColors.size());
        System.out.println("Minimal coloring is: " + Arrays.toString(nodeColors));
    }

    void printMinimalSudoku(){

        System.out.println("--------------------------------\n" +
                "------- Printing Sudoku --------\n" +
                "--------------------------------");

        for(int i=0; i<9; i++){
            System.out.print("[  ");
            for(int j=0; j<9; j++){
                System.out.print(nodeColors[i*9 + j] + "  ");
            }
            System.out.print("]\n");
        }

    }
}
