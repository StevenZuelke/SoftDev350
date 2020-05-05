/* This is the maze class that will contain all Rooms
and the Gameplay called by Main
Author: Steven Zuelke
 */

import QuestionTypes.Question;

import java.io.Serializable;
import java.util.ArrayList;

public class Maze implements Serializable {

    Room[][] Rooms;

    //Method to try and move the player to a new room
    //Index parameter at 0 is UP and increments Clockwise

    public Boolean ChangeRooms(int index){
        Boolean moved = false;

        return moved;
    }

    //Method to Pick a question from database that isn't already in use
    //NOT DONE WAITING ON DATABASE
    private Question PickQuestion(ArrayList<Question> used){

        Question question = null;

        return question;

    }

    //Method to set up all rooms for beginning of game

    private void SetupRooms(){

        ArrayList<Question> used = new ArrayList<Question>();
        for(int i = 0; i < Rooms.length; i++){

            for(int j = 0; j < Rooms[0].length; j++){

                Question[] questions = new Question[4];
                Boolean occupied = false;
                //for each room fill appropriate question list
                //Top
                if(i != 0){

                    questions[0] = PickQuestion(used);
                    used.add(questions[0]);

                }//end if 0

                else questions[0] = null;
                //Right
                if(j != Rooms[0].length - 1){

                    questions[1] = PickQuestion(used);
                    used.add(questions[1]);

                }//end if 1

                else questions[1] = null;
                //Bottom
                if(i != Rooms.length - 1){

                    questions[2] = PickQuestion(used);
                    used.add(questions[2]);

                }//end if 2

                else questions[2] = null;
                //Left
                if(j != 0){

                    questions[3] = PickQuestion(used);
                    used.add(questions[3]);

                }//end if 3

                else questions[3] = null;

                //Put character in top left
                if(i == 0 && j == 0) occupied = true;
                Rooms[i][j] = new Room(questions, occupied);

            }//end for j

        }//end for i

    }//end SetupRooms

}
