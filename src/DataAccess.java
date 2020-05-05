/*This class holds the list of all questions accessed from the database
as well as the connection and reading it
Author: Steven Zuelke
*/

import QuestionTypes.MultipleChoice;
import QuestionTypes.Question;
import QuestionTypes.TrueFalse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

        Connection connection = null;
        try{

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:trivia.db");
            Statement statement = connection.createStatement();
            //Multiple Choice
            String sql = "SELECT * FROM MultipleChoice;";
            ResultSet resultSet = statement.executeQuery(sql);
            //Add each question in resultSet
            while(resultSet.next()){

                String title = resultSet.getString("Title");
                String a = "A: " + resultSet.getString("A");
                String b = "B: " + resultSet.getString("B");
                String c = "C: " + resultSet.getString("C");
                String d = "D: " + resultSet.getString("D");
                String correct = resultSet.getString("Correct");
                Questions.add(new MultipleChoice(title, a, b, c, d, correct));

            }

            //True False
            sql = "SELECT * FROM TrueFalse;";
            resultSet = statement.executeQuery(sql);
            //Add each question in resultSet
            while(resultSet.next()){

                String title = resultSet.getString("Title");
                String correct = resultSet.getString("Correct");
                Questions.add(new TrueFalse(title, correct));

            }

            //Short Answer
            sql = "SELECT * FROM ShortAnswer;";
            resultSet = statement.executeQuery(sql);
            //Add each question in resultSet
            while(resultSet.next()){

                String title = resultSet.getString("Title");
                String correct = resultSet.getString("Correct");
                Questions.add(new TrueFalse(title, correct));

            }

            statement.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
