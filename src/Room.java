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
    private boolean topLocked = false;
    private boolean bottomLocked = false;
    private boolean leftLocked = false;
    private boolean rightLocked = false;

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
        if(topLocked) {
            System.out.println("Sorry, this door is locked");
        }
        return topLocked;
    }

    public boolean getBottomLocked() {
        if(bottomLocked) {
            System.out.println("Sorry, this door is locked");
        }
        return bottomLocked;
    }

    public boolean getLeftLocked() {
        if(leftLocked) {
            System.out.println("Sorry, this door is locked");
        }
        return leftLocked;
    }

    public boolean getRightLocked() {
        if(rightLocked) {
            System.out.println("Sorry, this door is locked");
        }
        return rightLocked;
    }

    public void setBottomLocked(boolean isLocked) {
        bottomLocked = isLocked;
    }

    public void setTopLocked(boolean isLocked) {
        topLocked = isLocked;
    }

    public void setLeftLocked(boolean isLocked) {
        leftLocked = isLocked;
    }

    public void setRightLocked(boolean isLocked) {
        rightLocked = isLocked;
    }

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
        } else if(topLocked) {
            finalRoomString += lockedRoomAbove;
        } else {
            finalRoomString += openRoomAbove;
        }

        if(Maze.GetRoom().getX() == 0 && rightLocked) {
            finalRoomString += wallLeftAndLockedRight;
        } else if (Maze.GetRoom().getX() == 0 && !rightLocked) {
                finalRoomString += wallLeftAndUnlockedRight;
        } else if (Maze.GetRoom().getX() == Maze.GetAllRooms().length - 1 && !leftLocked) {
                finalRoomString += unlockedLeftAndWallRight;
        } else if (Maze.GetRoom().getX() == Maze.GetAllRooms().length - 1 && leftLocked) {
            finalRoomString += lockedLeftAndWallRight;
        } else if (!leftLocked && !rightLocked) {
            finalRoomString += unlockedLeftAndRight;
        } else if (leftLocked && rightLocked) {
            finalRoomString += lockedLeftAndRight;
        } else if (leftLocked && !rightLocked) {
            finalRoomString += lockedLeftAndUnlockedRight;
        } else if (!leftLocked && rightLocked) {
            finalRoomString += unlockedLeftAndLockedRight;
        }

        if(Maze.GetRoom().getY() == Maze.GetAllRooms().length - 1) {
            finalRoomString += wallBelow;
        } else if(bottomLocked) {
            finalRoomString += lockedRoomBelow;
        } else {
            finalRoomString += openRoomBelow;
        }

        System.out.println(finalRoomString);
    }

}//end class
