# Path Finding in Maze
Write a program that takes as input the dimensions of the grid, 
a list of states that you can’t get to (designated by a list grid coordinates), 
and a list of states that will jump you to a different place altogether (designated by pairs of grid coordinates). 
Your program should output the total number of different ways to arrive at your goal. 
Each unit of work can  either  get you one test written (a “jump” between jumpable coordinates)  
or  one step closer to feature complete.
Example 1 In:
22   ()
()
Example 1 Out:
2
Example 2 In:
55 ((2 1)) ()
Example 2 Out:
40
Example 3 In:
55
() (((2,1),(0,3)))
Example 3 Out:
55
//  (a 2x2 grid)
// (no “blocked” points) // (no “jumping” points)
// (there are two ways to get from (0,0) to (1,1)
// (a 5x5 grid)
// (one “blocked” point, the coordinate (2,1) ) // (no “jumping” points)
// (a 5x5 grid)
// (no “blocked” points)
// the coordinate (2, 1) jumps you to the coordinate (0,3)
