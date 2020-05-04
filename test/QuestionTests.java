//Class to test all the functionality of Questions

import QuestionTypes.MultipleChoice;
import QuestionTypes.Question;
import QuestionTypes.ShortAnswer;
import QuestionTypes.TrueFalse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTests {

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

    }//end ShortAnswer Correct

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

    }//End ShortAnswer Incorrect

    //Methods to Test TrueFalse

    @Test
    public void CheckTFAnswerWithSound_Correct(){

        //Arrange
        Question question = new TrueFalse("This is written in Java", "T");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("T");

        //Assert
        assertEquals(true, correct);
        assertEquals(false, question.GetLocked());

    }//end TF Correct

    @Test
    public void CheckTFAnswerWithSound_Incorrect(){

        //Arrange
        Question question = new TrueFalse("This is written in Java", "T");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("F");

        //Assert
        assertEquals(false, correct);
        assertEquals(true, question.GetLocked());

    }//end TF Incorrect

    @Test
    public void CheckMCAnswerWithSound_Correct(){

        //Arrange
        Question question = new MultipleChoice("Who wrote this test?", "A: Steve", "B: Austin", "C: Cody", "D: Tom", "A");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("A");

        //Assert
        assertEquals(true, correct);
        assertEquals(false, question.GetLocked());

    }//end MC correct

    @Test
    public void CheckMCAnswerWithSound_Incorrect(){

        //Arrange
        Question question = new MultipleChoice("Who wrote this test?", "A: Steve", "B: Austin", "C: Cody", "D: Tom", "A");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("B");

        //Assert
        assertEquals(false, correct);
        assertEquals(true, question.GetLocked());

    }//end MC Incorrect

}