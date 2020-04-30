/* This class is the constructor for a multiple choice question
which extends the Abstract Question Class
Author: Steven Zuelke
 */

package QuestionTypes;

import java.io.Serializable;

public class MultipleChoice extends Question implements Serializable {

    //Constructor that calls super and creates the String[]

    public MultipleChoice(String title, String answerA, String answerB, String answerC, String answerD, String correct){

        String[] answers = { answerA, answerB, answerC, answerD };
        super(title, answers, correct);

    }//end constructor

}//end class
