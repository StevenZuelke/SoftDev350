/* This class will be the abstract Question
This will hold Title, possible and correct answers
The sound files, And whether the question is completed
 */

import javafx.scene.media.AudioClip;

import java.io.Serializable;

public abstract class Question implements Serializable {

    private String Title;
    private String[] Answers;
    private String Correct;
    private AudioClip GoodSound;
    private AudioClip BadSound;
    private Boolean Locked;

    //Constructor with Question and answer strings

    public Question(String title, String[]Answers, String Correct){

    }

    //Method to check if the answer is correct,
    //mark as locked if wrong, play the sound if correct/incorrect

    public Boolean CheckCorrect(String answer){

        Boolean correct = false;

        if(answer == Correct){

            correct = true;
            GoodSound.play();

        }else{

            Locked = true;
            BadSound.play();

        }

        return correct;

    }

    //Following Methods are Getters for the private members

    public String[] GetAnswers(){ return Answers; }

    public Boolean GetLocked(){ return Locked; }

    public String GetTitle(){ return Title; }



}
