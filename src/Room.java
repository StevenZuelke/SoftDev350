/* This is the Room class that contains the
different questions for the room, and occupied status
Author: Steven Zuelke
 */

import QuestionTypes.Question;
import javafx.geometry.Point2D;

import java.io.Serializable;

public class Room implements Serializable {

    //QuestionTypes.Question[0] is up and increments Clockwise
    private Question[] Questions;
    private Boolean Occupied;

    //Constructor

    public Room(Question[] questions, Boolean occupied){

        Questions = questions;
        Occupied = occupied;

    }//end Constructor

    //Getters for specific question and Occupied status

    public Boolean GetOccupied(){ return Occupied; }

    public void SetOccupied(Boolean bool){Occupied = bool;}

    //Returns null if No question at that index

    public Question GetQuestion(int index){

        Question q;
        if((q = Questions[index]) != null){

            return q;

        }//end if q
        return null;

    }//end GetQuestion

    public boolean getTopLocked() {

        boolean topLocked = Questions[0].GetLocked();
        if(topLocked) {

            System.out.println("Sorry, this door is locked");

        }//end if

        return topLocked;

    }//end getTopLocked

    public boolean getBottomLocked() {

        boolean bottomLocked = Questions[2].GetLocked();
        if(bottomLocked) {

            System.out.println("Sorry, this door is locked");

        }//end if

        return bottomLocked;

    }//end getBottomLocked

    public boolean getLeftLocked() {

        boolean leftLocked = Questions[3].GetLocked();
        if(leftLocked) {

            System.out.println("Sorry, this door is locked");

        }//end if

        return leftLocked;

    }//end getLeftLocked

    public boolean getRightLocked() {

        boolean rightLocked = Questions[1].GetLocked();
        if(rightLocked) {

            System.out.println("Sorry, this door is locked");

        }//end if

        return rightLocked;

    }//end getRightLocked()

    public void DisplayRoom() {
        String wallBelow = "- - - - - - - - - -\n";
        String wallAbove = "- - - - - - - - - -\n";
        String openRoomAbove = "- - - O P E N - - -\n";
        String lockedRoomAbove = "- - L O C K E D - -\n";
        String openRoomBelow = "- - - O P E N - - -\n";
        String lockedRoomBelow = "- - L O C K E D - -\n";
        String lockedLeftAndRight = "|                  |\n" + "|                  |\n"
                +"L                  L\n" +"O                  O\n" +"C                  C\n"
                +"K                  K\n" +"E                  E\n" +"D                  D\n"
                +"|                  |\n" +"|                  |\n";

        String unlockedLeftAndRight = "|                  |\n" + "|                  |\n"
                +"|                  |\n" +"O                  O\n" +"P                  P\n"
                +"E                  E\n" +"N                  N\n" +"|                  |\n"
                +"|                  |\n" +"|                  |\n";
        String unlockedLeftAndLockedRight = "|                  |\n" + "|                  |\n"
                +"|                  L\n" +"O                  O\n" +"P                  C\n"
                +"E                  K\n" +"N                  E\n" +"|                  D\n"
                +"|                  |\n" +"|                  |\n";
        String lockedLeftAndUnlockedRight = "|                  |\n" + "|                  |\n"
                +"L                  |\n" +"O                  O\n" +"C                  P\n"
                +"K                  E\n" +"E                  N\n" +"D                  |\n"
                +"|                  |\n" +"|                  |\n";
        String wallLeftAndUnlockedRight = "|                  |\n" + "|                  |\n"
                +"|                  |\n" +"|                  O\n" +"|                  P\n"
                +"|                  E\n" +"|                  N\n" +"|                  |\n"
                +"|                  |\n" +"|                  |\n";
        String wallLeftAndLockedRight = "|                  |\n" + "|                  |\n"
                +"|                  L\n" +"|                  O\n" +"|                  C\n"
                +"|                  K\n" +"|                  E\n" +"|                  D\n"
                +"|                  |\n" +"|                  |\n";
        String unlockedLeftAndWallRight = "|                  |\n" + "|                  |\n"
                +"|                  |\n" +"O                  |\n" +"P                  |\n"
                +"E                  |\n" +"N                  |\n" +"|                  |\n"
                +"|                  |\n" +"|                  |\n";
        String lockedLeftAndWallRight = "|                  |\n" + "|                  |\n"
                +"L                  |\n" +"O                  |\n" +"C                  |\n"
                +"K                  |\n" +"E                  |\n" +"D                  |\n"
                +"|                  |\n" +"|                  |\n";
        String finalRoomString = "";

        if(Maze.GetRoom().getY() == 0) {
            finalRoomString += wallAbove;
        } else if(getTopLocked()) {
            finalRoomString += lockedRoomAbove;
        } else {
            finalRoomString += openRoomAbove;
        }

        if(Maze.GetRoom().getX() == 0 && getRightLocked()) {
            finalRoomString += wallLeftAndLockedRight;
        } else if (Maze.GetRoom().getX() == 0 && !getRightLocked()) {
                finalRoomString += wallLeftAndUnlockedRight;
        } else if (Maze.GetRoom().getX() == Maze.GetAllRooms().length - 1 && !getLeftLocked()) {
                finalRoomString += unlockedLeftAndWallRight;
        } else if (Maze.GetRoom().getX() == Maze.GetAllRooms().length - 1 && getLeftLocked()) {
            finalRoomString += lockedLeftAndWallRight;
        } else if (!getLeftLocked() && !getRightLocked()) {
            finalRoomString += unlockedLeftAndRight;
        } else if (getLeftLocked() && getRightLocked()) {
            finalRoomString += lockedLeftAndRight;
        } else if (getLeftLocked() && !getRightLocked()) {
            finalRoomString += lockedLeftAndUnlockedRight;
        } else if (!getLeftLocked() && getRightLocked()) {
            finalRoomString += unlockedLeftAndLockedRight;
        }

        if(Maze.GetRoom().getY() == Maze.GetAllRooms().length - 1) {
            finalRoomString += wallBelow;
        } else if(getBottomLocked()) {
            finalRoomString += lockedRoomBelow;
        } else {
            finalRoomString += openRoomBelow;
        }

        System.out.println(finalRoomString);

    }

}//end class
