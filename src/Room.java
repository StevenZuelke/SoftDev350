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

}//end class
