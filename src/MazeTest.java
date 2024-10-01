

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


/**
 * The test class MazeTest.
 *
 */
public class MazeTest
{
    /**
     * Default constructor for test class MazeTest
     */
    public MazeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testLoadMaze()
    {
        // test that a valid maze is loaded successfully
        Maze maze = new Maze();
        assertTrue(maze.loadMaze( "src/maze-2"));
    
        // test that attempting to load an invalid maze returns false
        maze = new Maze();
        assertFalse(maze.loadMaze("src/maze-invalid"));

        // test that attempt to load a maze that doesn't exist returns false
        maze = new Maze();
        assertFalse(maze.loadMaze("src/maze-does-not-exist"));
    }
    
    @Test
    public void testGetNeighbors()
    {
        Maze maze = new Maze();
        maze.loadMaze( "src/maze-2");

        // test upper-left corner
        ArrayList<Square> expectedNeighbors = new ArrayList<Square>();
        expectedNeighbors.add(new Square(0, 1, 0));
        expectedNeighbors.add(new Square(1, 0, 1));
        ArrayList<Square> neighbors = maze.getNeighbors( new Square( 0, 0, 0 ));
        assertEquals( expectedNeighbors, neighbors);

        // test upper-right corner
        expectedNeighbors = new ArrayList<Square>();
        expectedNeighbors.add(new Square(1, 12, 0));
        expectedNeighbors.add(new Square(0, 11, 0));
        neighbors = maze.getNeighbors( new Square( 0, 12, 0 ));
        assertEquals( expectedNeighbors, neighbors);

        // test lower-left corner
        expectedNeighbors = new ArrayList<Square>();
        expectedNeighbors.add(new Square(5, 0, 0));
        expectedNeighbors.add(new Square(6, 1, 0));
        neighbors = maze.getNeighbors( new Square( 6, 0, 0 ));
        assertEquals( expectedNeighbors, neighbors);

        // test lower-right corner
        expectedNeighbors = new ArrayList<Square>();
        expectedNeighbors.add(new Square(5, 12, 0));
        expectedNeighbors.add(new Square(6, 11, 3));
        neighbors = maze.getNeighbors( new Square( 6, 12, 0 ));
        assertEquals( expectedNeighbors, neighbors);

        // test an edge
        expectedNeighbors = new ArrayList<Square>();
        expectedNeighbors.add(new Square(0, 6, 1));
        expectedNeighbors.add(new Square(1, 5, 1));
        expectedNeighbors.add(new Square(0, 4, 0));
        neighbors = maze.getNeighbors( new Square( 0, 5, 0 ));
        assertEquals( expectedNeighbors, neighbors);

        // test an interior square
        // test an edge
        expectedNeighbors = new ArrayList<Square>();
        expectedNeighbors.add(new Square(2, 4, 0));
        expectedNeighbors.add(new Square(3, 3, 1));
        expectedNeighbors.add(new Square(3, 5, 0));
        expectedNeighbors.add(new Square(4, 4, 0));
        neighbors = maze.getNeighbors( new Square( 3, 4, 0 ));
        assertEquals( expectedNeighbors, neighbors);
    }
    
    @Test
    public void testGetStart()
    {
        Maze maze = new Maze();
        maze.loadMaze( "src/maze-2");
        assertEquals(6, maze.getStart().getRow());
        assertEquals( 4, maze.getStart().getCol());
        assertEquals( 2, maze.getStart().getType());
    }
    
    @Test
    public void testGetFinish()
    {
        Maze maze = new Maze();
        maze.loadMaze( "src/maze-2");
        assertEquals(6, maze.getFinish().getRow());
        assertEquals(11, maze.getFinish().getCol());
        assertEquals(3, maze.getFinish().getType());
    }

    @Test
    public void testReset()
    {
        // this test method cannot be implemented yet
        //  as it requires functionality in the Square class that doesn't yet exist
    }
    
    @Test
    public void testToString()
    {
        Maze maze = new Maze();
        maze.loadMaze( "src/maze-3");
        String expectedStr = "_ _ # _ _ \nS _ # _ E \n_ _ # _ _ \n";
        assertEquals(expectedStr, maze.toString());
    }
}
