/* This class is the constructor for a True/False question
which extends the Abstract Question Class
Author: Steven Zuelke
 */

package QuestionTypes;

import java.io.Serializable;

public class TrueFalse extends Question implements Serializable {

    //Constructor that calls super and creates the String[]

    public TrueFalse(String title, String correct){

        String[] answers = { "A", "B" };
        super(title, answers, correct);

    }//end constructor

}//end class
