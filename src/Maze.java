/* This is the maze class that will contain all Rooms
and the Gameplay called by Main
Author: Steven Zuelke
 */

import java.io.Serializable;

public class Maze implements Serializable {

    Room[][] Rooms;



    //Method to try and move the player to a new room
    //Index parameter at 0 is UP and increments Clockwise

    public Boolean ChangeRooms(int index){
        Boolean moved = false;

        return moved;
    }

    //Method to set up all rooms for beginning of game

    public void SetupRooms(){

    }//end SetupRooms

}
