package tranpham.RallyPuzzle;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testSolvePuzzle(){    	
    	Coordinate grid = new Coordinate(2,2);
    	Coordinate[] blockPoints = new Coordinate[]{};
    	Vector[] jumpingPoints = new Vector[]{};
    	App app = new App();
    	
    	int actual=app.solvePuzzle(grid, blockPoints, jumpingPoints);
    	assertEquals(2, actual);    	
    }
    
    public void testSolvePuzzle2(){    	
    	Coordinate grid = new Coordinate(5,5);
    	Coordinate[] blockPoints = new Coordinate[]{new Coordinate(2,1)};
    	Vector[] jumpingPoints = new Vector[]{};
    	App app = new App();
    	int actual=app.solvePuzzle(grid, blockPoints, jumpingPoints);
    	assertEquals(40, actual);    	
    }
    
    public void testSolvePuzzle3(){    	
    	Coordinate grid = new Coordinate(5,5);
    	Coordinate[] blockPoints = new Coordinate[]{};
    	Vector[] jumpingPoints = new Vector[]{new Vector(2,1,0,3)};
    	App app = new App();
    	int actual=app.solvePuzzle(grid, blockPoints, jumpingPoints);
    	assertEquals(55, actual);    	
    }

}
