//Class to test all the functionality of Questions

import QuestionTypes.Question;
import QuestionTypes.ShortAnswer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTests {

    //Method tests ShortAnswer

    @Test
    public void CheckShortAnswerWithSound_Correct(){

        //Arrange
        Question question = new ShortAnswer("What is 2 + 2", "4");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("4");

        //Assert
        assertEquals(true, correct);
        assertEquals(false, question.GetLocked());

    }

    @Test
    public void CheckShortAnswerWithSound_Incorrect(){

        //Arrange
        Question question = new ShortAnswer("What is 2 + 2", "4");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("3");

        //Assert
        assertEquals(false, correct);
        assertEquals(true, question.GetLocked());

    }

}