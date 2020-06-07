/* This class tests functionality for the Room class
Author: Steven Zuelke
 */

import static org.junit.jupiter.api.Assertions.*;
import QuestionTypes.*;
import org.junit.jupiter.api.Test;

class RoomTests {

    //Method for basic construction and the getters work

    @Test
    public void GettersWork_OccupyQuestions(){

        //Arrange
        Question[] questions = new Question[4];
        for(int i = 0; i < 4; i++){

            questions[i] = new ShortAnswer("A", "A");

        }//end for i


        //Act
        Room room = new Room(questions, true);

        //Assert
        assertEquals(true, room.GetOccupied());
        for(int i = 0; i < 4; i++){

            assertEquals(questions[i], room.GetQuestion(i));

        }

    }//end GettersWork

    //Method to test an empty doorway returns null

    @Test
    public void GetQuestion_ReturnsNull(){
        //Arrange
        Question[] questions = new Question[4];
        for(int i = 0; i < 3; i++){

            questions[i] = new ShortAnswer("A", "A");

        }//end for i

        questions[3] = null;

        //Act
        Room room = new Room(questions, true);

        //Assert
        assertEquals(null, room.GetQuestion(3));

    }//end GetQuestion_ReturnsNull

}