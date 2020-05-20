
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
class SaveLoadTests {

    static Maze testMaze;

    //This method will create a new maze that will act as the default game session to be saved
    public static void InitializeTestMaze() {
        testMaze = new Maze();
        //Change the current room to something other than the default
        testMaze.Rooms[0][0].SetOccupied(false);
        testMaze.Rooms[1][1].SetOccupied(true);
    }

    //Creates a saved state of the game to be used in other methods based on default game session
    public void CreateSaveFile() {
        InitializeTestMaze();
        SaveData data = new SaveData();
        data.maze = testMaze;

        try {
            ResourceManager.Save(data, "TestSaveFile.triv");
        } catch (Exception e) {
        }
    }

    @Test
    public void SaveMethodCreatesSavedFile() {
        CreateSaveFile();
        File file = new File("TestSaveFile.triv");
        assertTrue(file.exists());
        //Delete the file to ensure there are no possible previously saved games that will affect test results
        file.delete();
    }

    @Test
    public void LoadMethodCreatesGameFromSavedState() {
        CreateSaveFile();
        Maze loadedMaze;
        File file = new File("TestSaveFile.triv");
        try {
            SaveData data = (SaveData) ResourceManager.Load("TestFile.triv");
            loadedMaze = data.maze;
            //Tests whether the current room is that of the default (will fail test) or that of the loaded game
            assertEquals(loadedMaze.GetRoom().getX(), 1);
            assertEquals(loadedMaze.GetRoom().getY(), 1);
        } catch (Exception e) {
        }
        //Delete the file to ensure there are no possible previously saved games that will affect test results
        file.delete();
    }
}
