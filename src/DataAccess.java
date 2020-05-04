/*This class holds the list of all questions accessed from the database
as well as the connection and reading it
Author: Steven Zuelke
*/

import QuestionTypes.Question;

import java.util.ArrayList;

public class DataAccess {

    private ArrayList<Question> Questions = new ArrayList<Question>();

    //Constructor

    public DataAccess(){

        ReadQuestions();

    }

    //Getter for the Questions

    public ArrayList<Question> GetQuestions(){

        return Questions;

    }

    //Method to call the Reads from different tables

    private void ReadQuestions(){

        ReadMultipleChoice();
        ReadShortAnswer();
        ReadTrueFalse();

    }

    private void ReadMultipleChoice(){

    }

    private void ReadShortAnswer(){

    }

    private void ReadTrueFalse(){

    }

}
