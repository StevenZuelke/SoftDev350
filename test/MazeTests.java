//This class is to test all functionality of the methods in Maze

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeTests {

    @Test
    public void CheckWinWorks(){

        //Arrange
        Maze maze = new Maze();
        maze.Rooms[0][0].SetOccupied(false);
        maze.Rooms[2][2].SetOccupied(true);

        //Act
        Boolean won = maze.CheckWin();

        //Assert
        //waiting on questions in the database
        //assertEquals(true, won);

    }//end CheckWin

}//end MazeTests