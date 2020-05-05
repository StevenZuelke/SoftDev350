/*This class holds the list of all questions accessed from the database
as well as the connection and reading it
Author: Steven Zuelke
*/

import QuestionTypes.MultipleChoice;
import QuestionTypes.Question;
import QuestionTypes.TrueFalse;

import java.sql.*;
import java.util.ArrayList;

public class DataAccess {

    private ArrayList<Question> Questions = new ArrayList<Question>();

    //Constructor

    public DataAccess(){

        ReadQuestions();

    }//end Constructor

    //Add questions to db

    public void AddMC(String title, String a, String b, String c, String d, String correct){

        Connection connection = null;
        try{

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:trivia.db");
            Statement statement = connection.createStatement();
            String sql = "Insert into MultipleChoice (Title, A, B, C, D, Correct)" +
                         "Values ('"+title+"', '"+a+"', '"+b+"', '"+c+"', '"+d+"', '"+correct+"');";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            ReadQuestions();

        } catch (Exception e) {

            e.printStackTrace();

        }//end catch

    }//end AddMC

    //Getter for the Questions

    public ArrayList<Question> GetQuestions(){

        return Questions;

    }//end GetQuestions

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
                String a =  resultSet.getString("A");
                String b =  resultSet.getString("B");
                String c =  resultSet.getString("C");
                String d =  resultSet.getString("D");
                String correct = resultSet.getString("Correct");
                Questions.add(new MultipleChoice(title, a, b, c, d, correct));

            }//end MC while

            //True False
            sql = "SELECT * FROM TrueFalse;";
            resultSet = statement.executeQuery(sql);
            //Add each question in resultSet
            while(resultSet.next()){

                String title = resultSet.getString("Title");
                String correct = resultSet.getString("Correct");
                Questions.add(new TrueFalse(title, correct));

            }//end TF while

            //Short Answer
            sql = "SELECT * FROM ShortAnswer;";
            resultSet = statement.executeQuery(sql);
            //Add each question in resultSet
            while(resultSet.next()){

                String title = resultSet.getString("Title");
                String correct = resultSet.getString("Correct");
                Questions.add(new TrueFalse(title, correct));

            }//end SA while

            statement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }//end catch

    }//end ReadQuestions

    //Method to remove the question from database

    public void RemoveQuestion(String title){

        Connection connection = null;
        try{

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:trivia.db");
            //Try deleting from every table no analysis on which type it is
            String sql = "Delete from MultipleChoice " +
                    "Where Title = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.executeUpdate();
            sql = "Delete from ShortAnswer " +
                    "Where Title = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.executeUpdate();
            sql = "Delete from TrueFalse " +
                    "Where Title = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, title);
            ps.executeUpdate();
            ps.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }//end catch

        ReadQuestions();

    }//end RemoveQuestion

}//end Class
