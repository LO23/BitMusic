/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.connection.ConnectionController;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.player.BitMusicPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarController extends AbstractController<PlayBarModel, PlayBarView> {

    private boolean resume;
    private boolean pause;
    private boolean stop;
    private boolean play;

    public PlayBarController(final PlayBarModel model, final PlayBarView view) {
        super(model, view);

        resume = false;
        pause = false;
        stop = false;
        play = false;

    }

    public class PlayListener implements ActionListener  {
        final private Path p = Paths.get("ilikeit.mp3");
        final private String filename = "/bitmusic/hmi/modules/playbar/songitems/ilikeit.mp3";

        // Ici il faut mettre le chamin absolu avec deux back slash sinon il va renvoyer une FileNotFoundException
        final private String fileNameTochange = "C:\\Users\\khadre\\Documents\\NetBeansProjects\\BitMusic\\BitMusic\\bitmusic\\hmi\\modules\\playbar\\songitems\\ilikeit.mp3";
        private Player player;
        @Override
        public void actionPerformed(ActionEvent e) {
           // try {
                System.out.println("---- Clic sur le bouton Play");

                BitMusicPlayer bitMusic = BitMusicPlayer.getInstance();
                WindowComponent win = WindowComponent.getInstance();
                // Plays a song
                if (resume == false && pause == false && stop == false && play == false) {
                     System.out.println("-----Playing the song for the first time");
                     win.getPlayBarComponent().getView().setPlayIcon(win.getPlayBarComponent().getView().getPauseIcon());
                     JSlider playBar = win.getPlayBarComponent().getView().getPlayBar();

                     win.getApiMusic().playSongFromStart(fileNameTochange);
                     while(win.getApiMusic().getCurrentFrame() != win.getApiMusic().getNumberOfFrame() ) {
                         playBar.setValue(win.getApiMusic().getCurrentFrame());
                     }
                     play = true;

                }

                else if(play == true) {
                    win.getPlayBarComponent().getView().setPlayIcon(win.getPlayBarComponent().getView().getPlayIcon());
                    win.getApiMusic().resumeSong();
                    pause = true ;
                    play = false;
                }
                else if (pause==true) {
                    //System.out.println("------Resuming the song previously paused");
                    win.getPlayBarComponent().getView().setPlayIcon(win.getPlayBarComponent().getView().getPauseIcon());
                    win.getApiMusic().resumeSong();
                    pause = false;
                    resume = true;
                }

                else { //if(stop == true) {
                    win.getApiMusic().playSongFromStart(fileNameTochange);
                    stop=false;
                }


                //Path p = Paths.get(this.getClass().getResource(filename).toString());
                /*String res = this.getClass().getResource(filename).toString();
                //res = res.replace ("/", "\\");
                //System.out.println("---- PATH : " + this.getClass().getResource(filename).toString());
                //Path folder = p.getParent();

                /// the following code's purpose is just to test JLayer functionality, it will be removed when ApiMusic id working fine
                FileInputStream fis     = new FileInputStream("C:\\Users\\khadre\\Documents\\NetBeansProjects\\BitMusic\\BitMusic\\bitmusic\\hmi\\modules\\playbar\\songitems\\ilikeit.mp3");
                BufferedInputStream bis = new BufferedInputStream(fis);
                player = new Player(bis);
                player.play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(PlayBarController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                System.out.println("---- Exception : FILE NOT FOUND");
            }*/
        }
    }

    public class StopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Stop");


            // Stops or pauses a song that is being played
              // we pause the song
             WindowComponent win = WindowComponent.getInstance();
             win.getApiMusic().pauseOrStopSong();
             resume = true;
             stop = true;
             play=false;
             pause=false;
        }
    }

    public class DownloadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Download");

            // Plays the next song
        }
    }

    // Pour 'écouter' le temps de lecture du son et l'afficher sur la slider
    public class SoundTimeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            // TODO
        }

    }
}
