/*This class holds the list of all questions accessed from the database
as well as the connection and reading it
Author: Steven Zuelke
*/

import QuestionTypes.Question;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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
        Connection c = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:trivia.db");

            Statement statement = c.createStatement();
            String sql = "";
            statement.executeUpdate(sql);
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Success");
    }

    private void ReadShortAnswer(){

    }

    private void ReadTrueFalse(){

    }

}
