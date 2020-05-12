/* This class will be the abstract QuestionTypes.Question
This will hold Title, possible and correct answers
The sound files, And whether the question is completed
Acts more as a door than just the question
Author: Steven Zuelke
 */

package QuestionTypes;

import javax.sound.sampled.*;
import java.io.File;
import java.io.Serializable;

public abstract class Question implements Serializable {

    private String Title;
    private String[] Answers;
    private String Correct;
    private File GoodSoundFile = new File("resources/Correct.wav");
    private File BadSoundFile = new File("resources/Incorrect.wav");
    private Boolean Locked;

    //Constructor with QuestionTypes.Question and answer strings

    public Question(String title, String[] answers, String correct){

        Title = title;
        Answers = answers;
        Correct = correct.toUpperCase();
        Locked = false;

    }//end constructor

    //Method to check if the answer is correct,
    //mark as locked if wrong, play the sound if correct/incorrect

    public Boolean CheckCorrect(String answer){

        Boolean correct = false;
        File soundFile;
        answer = answer.toUpperCase();

        if(answer == Correct){

            correct = true;
            soundFile = GoodSoundFile;

        }else{ //end correct if

            Locked = true;
            soundFile = BadSoundFile;

        }// end incorrect if

        //Try to open audiostream and play sound
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile)) {

            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
            Thread.sleep(1500);
            audioClip.close();

        //end try
        }catch(Exception e) { e.printStackTrace(); }

        return correct;

    }//end CheckCorrect

    //Following Methods are Getters for the private members

    public String[] GetAnswers(){ return Answers; }

    public String GetCorrect(){ return Correct; }

    public Boolean GetLocked(){ return Locked; }

    public String GetTitle(){ return Title; }



}
