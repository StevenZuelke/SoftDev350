/* This class is main, will start, load, save, and cheat/instuctions here
Author: Steven Zuelke
 */

import QuestionTypes.Question;
import QuestionTypes.ShortAnswer;
import javafx.geometry.Point2D;

import javax.xml.crypto.Data;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner Scan;
    private static ArrayList<String> ValidInput = new ArrayList<String>();
    private static Maze Maze;
    private static boolean NeedsSaved = true;

    public static void main(String[] args) {

        Scan = new Scanner(System.in);
        Maze = new Maze(); //So we have Access to Data
        MainMenu();
        Scan.close();

    }//end main method

    //Method to add questions to database within data program

    private static void AddQuestions(){

        String type, input;
        String title, correct;
        String[] answers = new String[4];
        int numAns = 1; //will identify type of question by number of answers

        System.out.println("To add Multiple Choice Enter 1\n" +
                "To add True/False Enter 2\n" +
                "To add Short Answer Enter 3" +
                "To return to Database Menu Enter 4");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        ValidInput.add("3");
        ValidInput.add("4");
        type = ReadInput();
        switch(type){

            case "1":
                numAns = 4;
                break;
            case "2":
            case "3":
                numAns = 0;
                break;
            case "4":
                MainDataMenu();
                return;

        }//end switch type

        //Get Question info
        System.out.println("Enter Title:");
        title = Scan.nextLine();
        for(int i = 0; i < numAns; i++){

            System.out.println("Enter Possible Answer:");
            answers[i] = Scan.nextLine();

        }//end for i

        System.out.println("Enter Correct Answer:");
        if(type == "2") {

            ValidInput.clear();
            ValidInput.add("T");
            ValidInput.add("F");
            correct = ReadInput();

        }//end if type == 2

        else correct = Scan.nextLine();
        //Confirm question before committing
        System.out.println("Confirm your question:");
        System.out.println(title);
        for(int i = 0; i < numAns; i++){

            System.out.println(answers[i]);

        }//end for i

        System.out.println("Correct: " + correct);
        System.out.println("To confirm Enter 1\n" +
                           "To retry Enter 2");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        input = ReadInput();
        if(input == "2"){

            AddQuestions();
            return;

        }//end if input ==2

        switch(type){

            case "1":
                Maze.DataAccess.AddMC(title, answers[0], answers[1], answers[2], answers[3], correct);
                break;
            case "2":
                Maze.DataAccess.AddTF(title, correct);
                break;
            case "3":
                Maze.DataAccess.AddSA(title, correct);
                break;

        }//end switch type

        AddQuestions();//continue adding questions

    }//end AddQuestions

    //Method to display the room to console

    private static void DisplayRoom(){



    }//end DisplayRoom

    //Method to list all questions within data program

    private static void ListQuestions(){

        String input;
        int numAns = 1; //will identify type of question by number of answers
        ArrayList<Question> questions = Maze.DataAccess.GetQuestions();

        System.out.println("To see Multiple Choice Enter 1\n" +
                "To see True/False Enter 2\n" +
                "To see Short Answer Enter 3\n" +
                "To return to Database Menu Enter 4");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        ValidInput.add("3");
        ValidInput.add("4");
        input = ReadInput();
        switch(input){

            case "1":
                numAns = 4;
                break;
            case "2":
                numAns = 2;
                break;
            case "3":
                numAns = 0;
                break;
            case "4":
                MainDataMenu();
                return;

        }//end switch input

        for(Question question : questions){

            if(question.GetAnswers().length == numAns){

                System.out.println(question.GetTitle());
                for(int j = 0; j < numAns; j++){

                    System.out.println(question.GetAnswers()[j]);

                }//end for j

                System.out.println("Correct Answer: " + question.GetCorrect());

            }//end if  = numAns

        }//end foreach

    }//end ListQuestions

    //Method to Load a new game from a file, returns true if successful otherwise false

    private static boolean LoadGame(){

        boolean loaded = false;
        try {
            SaveData data = (SaveData) ResourceManager.Load("savedGame.triv");
            Maze = data.maze;
            loaded = true;
        } catch(Exception e) {
            System.out.println("Couldn't load saved data: " + e.getMessage());
        }

        return loaded;

    }//end LoadGame

    //Main Menu for the Database (List, Add, Remove)

    public static void MainDataMenu(){

        String input;

        System.out.println("DATABASE");
        System.out.println("To see existing questions Enter 1\n" +
                           "To add new questions Enter 2\n" +
                           "To remove questions Enter 3\n" +
                           "To return to Main Menu Enter 4");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        ValidInput.add("3");
        ValidInput.add("4");
        input = ReadInput();
        switch(input){

            case "1":
                ListQuestions();
                break;
            case "2":
                AddQuestions();
                break;
            case "3":
                RemoveQuestions();
                break;
            case "4":
                MainMenu();
                break;

        }//end switch input

    }//end MainDataMenu

    //Main Menu for the Trivia Maze (New/Load, Instructions etc)

    public static void MainGameMenu(){

        String input;

        System.out.println("TRIVIA GAME");
        System.out.println("To start a new game Enter 1\n" +
                "To load an existing game file Enter 2\n" +
                "To return to Main Menu Enter 3");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        ValidInput.add("3");
        input = ReadInput();
        switch(input){

            case "1":
                NewGame();
                break;
            case "2":
                if(!LoadGame()) {

                    System.out.println("Load failed!");

                }else{//end if Load fail

                    PlayGame();

                }//end else

                break;
            case "3":
                MainMenu();
                break;

        }//end switch input

    }//end MainGameMenu

    //Method to present main menu and
    //Goto either Database, or to the Game

    public static void MainMenu(){

        String input;

        System.out.println("Welcome!\n" +
                           "Enter 1 to play Trivia Maze\n" +
                           "Enter 2 to access the Database");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        input = ReadInput();
        switch(input){

            case "1":
                MainGameMenu();
                break;
            case "2":
                MainDataMenu();
                break;

        }//end switch input

    }//end MainMenu

    //Method to start a new game and start the game

    private static void NewGame(){

        Maze = new Maze();
        System.out.println("You started a new game!");
        PlayGame();

    }//end newGame

    //Method to play the entire game from an enstanciated maze

    private static void PlayGame(){

        boolean gameOver = false;

        System.out.println("Welcome to the Trivia Game!");
        while(!gameOver){

            TakeTurn();
            if(Maze.CheckLoss(0,0, new ArrayList<Point2D>()) ||
                Maze.CheckWin()){

                gameOver = true;

            }//end if games over

        }//end while game not over

    }//end PlayGame

    //Method to check if player wants to save before quitting

    private static void QuitGame(){



    }//method to QuitGame

    //Method to read valid input with possible answers

    private static String ReadInput(){

        Boolean invalid = true;
        String input = "";

        while(invalid){

            System.out.print("(Answers: ");
            for(String string : ValidInput){

                System.out.print(string + " ");

            }//end foreach

            System.out.print(")\n");
            input = Scan.nextLine().toUpperCase();
            for(int i = 0; i < ValidInput.size(); i++){

                String compare = ValidInput.get(i).toUpperCase();
                if(input.equals(compare)){
                    return input;

                }//end if

            }//end for i

        }//end while invalid

        return input;

    }//end ReadInput

    //Method to remove Question within Database Program

    private static void RemoveQuestions(){

        String input;
        String title, correct;

        System.out.println("To Remove a question: Enter the title\n" +
                "To return to Database Menu Enter 1\n");
        title = Scan.nextLine();
        if(title.equals("1")){

            MainDataMenu();
            return;

        }//end if 1

        //Confirm question before committing
        System.out.println("Confirm your question:");
        System.out.println(title);
        System.out.println("To confirm Enter 1\n" +
                "To retry Enter 2");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        input = ReadInput();
        if(input == "2"){

            RemoveQuestions();
            return;

        }//end if input ==2

        Maze.DataAccess.RemoveQuestion(title);
        RemoveQuestions();//continue removing questions

    }//end RemoveQuestions

    //Method to save the game

    private static void SaveGame(){

        SaveData data = new SaveData();
        data.maze = Maze;

        try {
            ResourceManager.Save(data, "savedGame.triv");
            NeedsSaved = false;
        } catch (Exception e){
            System.out.println("Couldn't save: " + e.getMessage());
        }



    }//end SaveGame

    //Method to take a single turn by the player

    private static void TakeTurn(){

        String input = "";
        boolean valid = false;

        while(!valid){

            System.out.println("You are in room: " + Maze.GetRoom().getX() + ", " + Maze.GetRoom().getY());
            DisplayRoom();
            System.out.println("Which direction do you want to go?");
            System.out.println("Enter S to save game");
            System.out.println("Enter Q to quit game");
            ValidInput.clear();
            ValidInput.add("1");
            ValidInput.add("2");
            ValidInput.add("0");
            ValidInput.add("3");
            ValidInput.add("Q");
            ValidInput.add("S");
            input = ReadInput();
            switch(input){

                case "S":
                    SaveGame();
                    break;
                case "Q":
                    QuitGame();
                    return;
                default:
                    valid = Maze.ChangeRooms(Integer.parseInt(input));
                    break;

            }//end switch input

        }//end while not valid

    }//end Take Turn

}//end class
