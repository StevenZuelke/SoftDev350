//This class is to test all functionality of the methods in Maze

import javafx.geometry.Point2D;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MazeTests {

    @Test
    public void CheckWinWorksWin(){

        //Arrange
        Maze maze = new Maze();
        maze.Rooms[0][0].SetOccupied(false);
        maze.Rooms[2][2].SetOccupied(true);

        //Act
        Boolean won = maze.CheckWin();

        //Assert
        assertEquals(true, won);

    }//end CheckWinWin

    @Test
    public void CheckWinWorksLost(){

        //Arrange
        Maze maze = new Maze();

        //Act
        Boolean won = maze.CheckWin();

        //Assert
        assertEquals(false, won);

    }//end CheckWinLost

    @Test
    public void CheckLossWorksLost(){

        //Arrange
        Maze maze = new Maze();
        maze.Rooms[1][2].GetQuestion(1).CheckCorrect("");
        maze.Rooms[2][1].GetQuestion(2).CheckCorrect("");

        //Act
        Boolean lost = maze.CheckLoss(0,0, new ArrayList<Point2D>());

        //Assert
        assertEquals(true, lost);

    }//end CheckLostlost

    @Test
    public void CheckLossWorksWin(){

        //Arrange
        Maze maze = new Maze();
        maze.Rooms[2][1].GetQuestion(2).CheckCorrect("");

        //Act
        Boolean lost = maze.CheckLoss(0,0, new ArrayList<Point2D>());

        //Assert
        assertEquals(false, lost);

    }//end CheckLostwin

}//end MazeTests