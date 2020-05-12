/* This class is the constructor for a short answer question
which extends the Abstract QuestionTypes.Question Class
Author: Steven Zuelke
 */

package QuestionTypes;

import java.io.Serializable;

public class ShortAnswer extends Question implements Serializable {

    //Constructor that calls super and creates the String[]

    public ShortAnswer(String title, String correct){

        super(title, new String[]{}, correct);

    }//end constructor

}//end class
