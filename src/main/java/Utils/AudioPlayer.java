package Utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

/*
 * @author nrileyfletcher
 * @brief Plays sound effects for chess game
 * @current {Wrong move, move occurs, player wins}
 */
public class AudioPlayer {
    private static Clip clip;


    public AudioPlayer() {
    }

    public void playMoveErrorSound() {
        String soundFilePath = "audio/bad_move.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(0.2f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clip.setFramePosition(0);
        clip.start();
    }

    public void playPieceMoveSound() {
        String soundFilePath = "audio/valid_move.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clip.setFramePosition(0);
        clip.start();
    }

    public void playVictorySound() {
        String soundFilePath = "audio/victory.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clip.setFramePosition(0);
        clip.start();
    }
}