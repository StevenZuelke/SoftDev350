/* This class is main, will start, load, save, and cheat/instuctions here
Author: Steven Zuelke
 */

import QuestionTypes.Question;
import QuestionTypes.ShortAnswer;
import javafx.geometry.Point2D;

import javax.xml.crypto.Data;
import java.io.File;
import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner Scan;
    private static ArrayList<String> ValidInput = new ArrayList<String>();
    private static Maze Maze;
    private static boolean NeedsSaved = false;
    private static String SavedFile = null;

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
        File savedGameDirectory = new File("resources/savedGames");

        if(savedGameDirectory.list().length == 0) {
            System.out.println("There are no saved games available");
            MainGameMenu();
        } else {
            //Creates a list of possible saved games to choose from
            String[] saveGameList = savedGameDirectory.list();
            System.out.println("Please enter the saved game you'd like to load from the options:");
            ValidInput.clear();

            for(int i = 0; i < saveGameList.length; i++) {
                //The value of i is changed to accommodate index selection without beginning options list at 0
                System.out.println(i + 1 + ": " + saveGameList[i]);
                ValidInput.add(String.valueOf(i + 1));
            } //end for loop

            String input = ReadInput();

            try {
                //Will save the game with the chosen file name
                SaveData data = (SaveData) ResourceManager.Load("resources/savedGames/" + saveGameList[Integer.parseInt(input) - 1]);
                Maze = data.maze;
                loaded = true;
            } catch (Exception e) {
                System.out.println("Couldn't load saved data: " + e.getMessage());
            }
        } //end else
        return loaded;
    }//end LoadGame

    //Method to handle a player winning the game

    private static void WonGame(){

        System.out.println("Congratulations, you've won!\n");
        System.out.println("Incorrect Answers: " + Maze.getLockedRoomsCount());
        System.out.println("Correct Answers: " + Maze.getCorrectAnswersCount());

        MainGameMenu();

    }//end wongame

    //Method to handle a lost game

    private static void LostGame(){

        System.out.println("Game Over.");
        System.out.println("Incorrect Answers: " + Maze.getLockedRoomsCount());
        System.out.println("Correct Answers: " + Maze.getCorrectAnswersCount());

        MainGameMenu();

    }//end LostGame

    //Main Menu for the Database (List, Add, Remove)

    private static void MainDataMenu(){

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

    private static void MainGameMenu(){

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
                if(LoadGame()) {

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

    private static void MainMenu(){

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
        boolean won = false;
        boolean lost = false;

        System.out.println("Welcome to the Trivia Game!");
        System.out.println("Enter 1 to Start!\n" +
                            "Enter 2 for Game Instructions");
        ValidInput.clear();
        ValidInput.add("1");
        ValidInput.add("2");
        String input = ReadInput();
        if(input.equals("2")) ViewInstructions();
        while(!gameOver){

            TakeTurn();
            won = Maze.CheckWin();
            if(won){

                WonGame();

            }//end if games over

        }//end while game not over

    }//end PlayGame

    //Method to check if player wants to save before quitting

    private static void QuitGame(){

        String input;

        if(NeedsSaved){

            System.out.println("Before quitting, would you like to save the game?\n" +
                    "Enter 1 to save the game\n" +
                    "Enter 2 to return to the main menu without saving");

            ValidInput.clear();
            ValidInput.add("1");
            ValidInput.add("2");
            input = ReadInput();
            switch(input){

                case "1":
                    SaveGame();
                    break;

            }//end switch



        }//end if

        MainGameMenu();

    }//method to QuitGame

    //Method to read valid input with possible answers

    private static String ReadInput(){

        Boolean invalid = true;
        String input = "";

        while(invalid){

            System.out.print("(Answers: ");
            for(String string : ValidInput){

                System.out.print(string + ", ");

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
        boolean needsName = true;

        if(SavedFile != null){

            System.out.println("Enter 1 to use current file,");
            System.out.println("Enter 2 to create a new file");
            ValidInput.clear();
            ValidInput.add("1");
            ValidInput.add("2");
            String input = ReadInput();
            if(input.equals("1")) needsName = false;

        }//end if not null

        if(needsName){

            System.out.println("Please enter a name for your saved game: ");
            SavedFile = Scan.nextLine();

        }//end if needsname

        File file = new File("resources/savedGames/" + SavedFile + ".triv");
        if(file.isFile() && needsName) {
            System.out.println(file.getName() + " already exists, would you like to overwrite it?\n" +
                    "Enter 1 to overwrite file\n" +
                    "Enter 2 to choose new file name");
            ValidInput.clear();
            ValidInput.add("1");
            ValidInput.add("2");
            String input = ReadInput();
            switch(input){

                case "1":
                    break;
                case "2":
                    SaveGame();
                    return;
            }
        }

        try {

            ResourceManager.Save(data, "resources/savedGames/" + SavedFile + ".triv");
            NeedsSaved = false;

        } catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }//end try

    }//end SaveGame

    //Method to take a single turn by the player

    private static void TakeTurn(){

        String input = "";
        boolean valid = false;

        while(!valid){

            System.out.println("You are in room: " + (int) Maze.GetRoom().getX() + ", " + (int) Maze.GetRoom().getY());
            Maze.DisplayRoom();
            System.out.println("Which direction do you want to go?");
            System.out.println("Enter S to save game");
            System.out.println("Enter Q to quit game");
            ValidInput.clear();
            ValidInput.add("0");
            ValidInput.add("1");
            ValidInput.add("2");
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
                    if(!valid && Maze.CheckLoss(0,0, new ArrayList<Point2D>()))
                        LostGame();
                    NeedsSaved = true;
                    break;

            }//end switch input

        }//end while not valid

    }//end Take Turn

    //Method to print specific instructions and game description to console

    private static void ViewInstructions() {

        String instructions = "How to Play...\n" +
                "You're locked in a maze containing a series of rooms.\n" +
                "To open the door to a room, you must first answer its trivia question.\n" +
                "Do so correctly, and the door will open; fail, and that door is locked forever.\n\n" +
                "The questions will take one of three forms:\n" +
                "For true/false questions, simply enter a \"t\" for true and a \"f\" for false.\n" +
                "For multiple choice questions, enter an \"a\",\"b\",\"c\", or \"d\" that's associated with your chosen answer.\n" +
                "For short answer questions, we're looking for a single word answer, and spelling counts (sorry).\n\n" +
                "And that's it. Navigate your way through the maze without locking yourself in, and you win!\n\n";

        System.out.println(instructions);

    }//end ViewInstructions

}//end class
