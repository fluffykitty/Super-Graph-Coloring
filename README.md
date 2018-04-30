# Super-Graph-Coloring

Finds the minimal coloring for all nodes in a graph s.t. no two neighbors or adjacent nodes share the same color.

Input can be specified and solved as a Sudoku puzzle. 

#### Usage

To compile and run the sudoku sample _(on linux systems)_:
- travel to src folder
- `javac Main.java`
- `java Main < ../sudoku.txt` to pipe sudoku sample text into stdin of the program
- `java Main < ../sample.txt` to pipe sample text into stdin of the program
- or alternatively you can feed input according to STDIN rules

Or to run the sample texts:
- `cat ../sample.txt | java Main`

To compile and run _(on windows systems)_:
- travel to src folder
  - ensure java is declared in PATH variable as seen here https://www.java.com/en/download/help/path.xml
  - or from CMD prompt, inside src folder, type `set path=%path%;C:\Program Files\Java\jdk1.5.0_09\bin`
- `javac Main.java`
- `java Main < ../sudoku.txt` to run example texts akin to Linux systems

This pipes the sample sudoku puzzle contained in SudokuEcho into the STDIN of the main class.
The program accepts any STDIN input following the specifications.
The source code can be altered to accept files instead.

#### Specifications
`Input: STDIN` : 
- 1 < **n** < 1000 : number of nodes.
- 1 < **m** < 100000 : number of edges.
- next *m* lines contain two numbers: *node u* and *node v* representing each bidirectional edge.
- last *n* integers represent the coloring of the corresponding node, 0 represents an uncolored node.

`Output: STDOUT` : 
- First line contains additional colors necessary to achieve a minimal coloring of the graph.
- Second line contains the nodes of the graph with a number corresponding to its color.

Output is specified in accordance to project specifications. Source code can be altered to printGraph(), printMinimalSudoku(), and printMinimalColoring() for better output formatting. 

#### Citations:
The strategy behind solving this NP-complete problem employs a greedy algorithm using degrees of saturation (# of adjacent colored nodes) as described by Dr. Hussein Al-Omari and Khair Eddin Sabri as published in the Journal of Mathematics and Statistics. 

`Hussein Al-Omari, Dr & Sabri, Khair Eddin. (2006). New Graph Coloring Algorithms. Journal of Mathematics and Statistics. 2. 10.3844/jmssp.2006.439.441`

Also impossible without the learnings from lecture. Thanks Dr.Dinh. 

#### Credit
> Written for Dr.Thang Dinh's Advanced Algorithm Course (CMSC 501) at Virginia Commonwealth University in Spring 2018.
> Written By me, Rostam Panjshiri.
