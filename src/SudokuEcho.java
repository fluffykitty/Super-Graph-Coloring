/*
 *  Rostam Panjshiri
 *  CMSC 501 Dinh
 *  VCU Spring 201
 */

public class SudokuEcho {
    //echos sudoku puzzle as created in sudokugraphrepresentationgenerator
    //and contained in sudoku.txt
    //out to std out
    public static void main(String [] args){
        int n = 81;     // # nodes
        int m = 810;   // # edges

        System.out.println("81 810");

        //creating sudoku graph
        for(int i=1; i<=81; i++){

            //horz mod is a modification necessary for 1...n based cell addressing scheme
            int horz_mod = 9;
            if (i % 9 == 0)
                horz_mod = 0;

            //creating horizontal edges
            int horz_cap = i + horz_mod - (i % 9);
            for (int j = i+1; j <= horz_cap; ++j){
                System.out.println(i + " " + j);
            }

            //creating columnar edges
            for (int k = i+9; k <= 81; k += 9){
                System.out.println(i + " " + k);
            }

            //creating group edges
            //determines position within group from top left (1) to bottom right (9)

            // int loc = ( (i % 3) + 1 ) + (3 * ((int)(i / 9) % 3)); -- works with 0 indexed sudoku cells
            int loc = ( ((i-1) % 3) + 1 ) + (3 * ((int)((i-1) / 9) % 3));
            switch (loc){
                case 1:
                    System.out.println(i + " " + (i+10));
                    System.out.println(i + " " + (i+19));
                    System.out.println(i + " " + (i+11));
                    System.out.println(i + " " + (i+20));
                    break;
                case 2:
                    System.out.println(i + " " + (i+8));
                    System.out.println(i + " " + (i+17));
                    System.out.println(i + " " + (i+10));
                    System.out.println(i + " " + (i+19));
                    break;
                case 3:
                    System.out.println(i + " " + (i+7));
                    System.out.println(i + " " + (i+16));
                    System.out.println(i + " " + (i+8));
                    System.out.println(i + " " + (i+17));
                    break;
                case 4:
                    System.out.println(i + " " + (i+10));
                    System.out.println(i + " " + (i+11));
                    break;
                case 5:
                    System.out.println(i + " " + (i+8));
                    System.out.println(i + " " + (i+10));
                    break;
                case 6:
                    System.out.println(i + " " + (i+7));
                    System.out.println(i + " " + (i+8));
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
            System.out.print(sudoku_example[idx] + " ");
        }
        System.out.print(sudoku_example[sudoku_example.length -1]); //write out the last line

    }
}
