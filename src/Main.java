/* This class is main, will start, load, save, and cheat/instuctions here
Author: Steven Zuelke
 */

import QuestionTypes.Question;
import QuestionTypes.ShortAnswer;
import java.sql.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

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

    }//end main method

}//end class
