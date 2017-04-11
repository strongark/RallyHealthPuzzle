package tranpham.RallyPuzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class App 
{
	static int nResult=0;
    public static void main( String[] args )
    {
    	Coordinate grid = new Coordinate(5,5);
    	Coordinate[] blockPoints = new Coordinate[]{};
    	Vector[] jumpingPoints = new Vector[]{new Vector(2,1,0,3)};
    	
    	int totalStep = solvePuzzle(grid, blockPoints, jumpingPoints);
    	System.out.print("Total solutions: "+totalStep);
    }
    
    public static int solvePuzzle(Coordinate gridSize,Coordinate[] blockPoints
    						, Vector[] jumpingPoints){
    	nResult=0;
    	//Initialize the route, departure at (0,0)
    	Coordinate root = new Coordinate(0, 0);
    	LinkedList<Coordinate> route = new LinkedList<Coordinate>();
    	route.add(root);
    	//Using backtrack to find all possible route to destination (gridSize._row-1, gridSize._column-1)
    	backTrack(gridSize, blockPoints, jumpingPoints, route);
    	return nResult;
    }    
    
    /*Backtrack algorithm
     * @param gridSize: _row & _column define the size of the matrix
     * @param blockedPoints: list of blocked point
     * @param jumpingPoints: list of jumping point
     * @param route: the current route
     * */
    public static void backTrack(Coordinate gridSize,Coordinate[] blockedPoints
			,Vector[] jumpingPoints, LinkedList<Coordinate> route){
    	if(accept(gridSize, blockedPoints, jumpingPoints, route)){
    		output(route);
    		return;
    	}

    	Queue<Coordinate> stepQueue = findNextStep(gridSize, blockedPoints, jumpingPoints, route);
    	if(stepQueue.size()<1) 
    		return;

    	while(stepQueue.peek()!=null){
    		LinkedList<Coordinate> advance=(LinkedList<Coordinate>)route.clone();
    		Coordinate nextStep=stepQueue.poll();
    		advance.add(nextStep);
    		//check for jump point
    		int idx=findJumpingPoint(jumpingPoints, nextStep);
    		if(idx>=0){
    			advance.add(jumpingPoints[idx]._end);
    		}
    			
    		backTrack(gridSize,blockedPoints,jumpingPoints, advance);
    	}
    }
    
    /* print the result route
     * sum up the total solution
     * */
    private static void output(LinkedList<Coordinate> route) {
		// TODO Auto-generated method stub
    	Coordinate step=null;
    	while(route.peek()!=null){
    		step = route.poll();
    		System.out.print(String.format("(%s,%s)",step._row,step._column));
    		if(route.peek()!=null)
    			System.out.print("=>");    		
    		else
    			System.out.println();
    	}
    	nResult++;
	}

    /* Find all the next possible step from the end of the current route
     * @param blockedPoints: list of blocked point
     * @param jumpingPoints: list of jumping point
     * @param route: the current route
     * 
     * RETURN: queue of all possible step
     * */
	public static Queue<Coordinate> findNextStep(Coordinate gridSize, Coordinate[] blockedPoints
    					,Vector[] jumpingPoints, LinkedList<Coordinate> route){
    	Queue<Coordinate> queue = new LinkedList<Coordinate>();
    	
    	//move in 2 directions
    	Coordinate lastStep = route.peekLast();
    	/*
	   	 * check if the direction is applicable:
	   	 *  - in the boundary of the matrix
	   	 *  - not exists in the route
	   	 *  - not a block point
	   	 * */
    	Coordinate _right = new Coordinate(lastStep._row, lastStep._column+1);
    	if(_right._column<gridSize._column
    		&&Arrays.binarySearch(blockedPoints, _right)<0){//row is already in matrix boundary
    		if(route.indexOf(_right)==-1){//not exists in the current route
    			queue.add(_right);
    		}
    	}

    	Coordinate _down = new Coordinate(lastStep._row+1, lastStep._column);
    	if(_down._row<gridSize._row
        		&&Arrays.binarySearch(blockedPoints, _down)<0){//row is already in matrix boundary
    		if(route.indexOf(_down)==-1){//not exists in the current route
    			queue.add(_down);
    		}
    	}

    	return queue;
    }
    
    /*
     * Determine if the route is acceptable answer
     * @param blockedPoints: list of blocked point
     * @param jumpingPoints: list of jumping point
     * @param route: the current route
     * 
     * Return: 
     *  - true: if the route is a correct solution
     *  - false: if the route is not a correct solution
     * */
    public static boolean accept(Coordinate gridSize, Coordinate[] blockedPoints
			,Vector[] jumpingPoints,LinkedList<Coordinate> route){
    	Coordinate root = new Coordinate(0, 0);
    	Coordinate destination = new Coordinate(gridSize._row-1, gridSize._column-1);
    	if(route.peekFirst().equals(root)
    			&&route.peekLast().equals(destination)){//departure and destination is correct    		
    		return true;
    	};
    	return false;
    }
    
    /*Find and return the index the in the jumping point list that match the point param
     * */
    public static int findJumpingPoint(Vector[] jumpingPoints, Coordinate point){
    	for(int i=0;i<jumpingPoints.length;i++){
    		if(jumpingPoints[i]._start.equals(point))
    			return i;
    	}
    	return -1;
    }
    
}


