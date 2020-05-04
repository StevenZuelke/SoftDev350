/* This class is the constructor for a True/False question
which extends the Abstract QuestionTypes.Question Class
Author: Steven Zuelke
 */

package QuestionTypes;

import java.io.Serializable;

public class TrueFalse extends Question implements Serializable {

    //Constructor that calls super and creates the String[]

    public TrueFalse(String title, String correct){

        Title = title;
        Correct = correct;
        String[] answers = { "A", "B" };
        Answers = answers;

    }//end constructor

}//end class
