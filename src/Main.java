/* This class is main, will start, load, save, and cheat/instuctions here
Author: Steven Zuelke
 */

import QuestionTypes.Question;
import QuestionTypes.ShortAnswer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //Arrange
        Question question = new ShortAnswer("What is 2 + 2", "4");
        Boolean correct;

        //Act
        correct = question.CheckCorrect("4");
        System.in.read();
    }//end main method

}//end class
