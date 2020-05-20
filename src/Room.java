/* This is the Room class that contains the
different questions for the room, and occupied status
Author: Steven Zuelke
 */

import QuestionTypes.Question;

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

    public void SetOccupied(Boolean bool){ Occupied = bool; }

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

}//end class
