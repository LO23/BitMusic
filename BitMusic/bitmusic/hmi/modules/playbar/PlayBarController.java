/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.music.player.BitMusicPlayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarController extends AbstractController<PlayBarModel, PlayBarView> {

    private Thread sliderThread = null;

    public PlayBarController(final PlayBarModel model, final PlayBarView view) {
        super(model, view);
    }

    public class PlayListener implements ActionListener  {

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( PlayBarController.this.getModel().getSong() == null ) {
                JOptionPane.showMessageDialog(
                         null,
                         "Aucune musique n'a été chargée",
                         "Erreur",
                         JOptionPane.ERROR_MESSAGE);
                return;
            }

            BitMusicPlayer bitMusic = BitMusicPlayer.getInstance();
            final WindowComponent win = WindowComponent.getInstance();

            if ( PlayBarController.this.getModel().isPlaying() ) {
                //La musique est en lecture : il faut faire une pause !
                System.out.println("---- Clic sur le bouton Pause");
                PlayBarController.this.getModel().setIsPlaying(false);
                PlayBarController.this.getModel().setFrame(win.getApiMusic().getCurrentFrame());
                win.getApiMusic().pause();
                PlayBarController.this.sliderThread.interrupt();
            }
            else {
                //La musique n'est pas en lecture : il faut la lire
                System.out.println("---- Clic sur le bouton Play");
                PlayBarController.this.getModel().setIsPlaying(true);
                JSlider playBar = win.getPlayBarComponent().getView().getPlayBar();
                int frame = PlayBarController.this.getModel().getFrame();

                if ( frame == 0 ) {
                    //La musique n'a jamais encore été lue
                    win.getApiMusic().playSong(PlayBarController.this.getModel().getSong());
                }
                else {
                    //La musique a été mise sur pause, on reprend la lecture
                    win.getApiMusic().playSongFromSpecificFrame(frame);
                }

                Runnable r = new Runnable() {
                    public void run() {
                        JSlider playBar = win.getPlayBarComponent().getView().getPlayBar();
                        playBar.setMaximum(win.getApiMusic().getNumberOfFrame());
                        while( PlayBarController.this.getModel().isPlaying() ) {
                            playBar.setValue(win.getApiMusic().getCurrentFrame());
                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(PlayBarController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                };
                PlayBarController.this.sliderThread = new Thread(r);
                PlayBarController.this.sliderThread.setName("SliderThread");
                PlayBarController.this.sliderThread.setPriority(Thread.MAX_PRIORITY);
                PlayBarController.this.sliderThread.start();
            }
        }
    }

    public class StopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Stop");
            if ( PlayBarController.this.sliderThread != null ) {
                PlayBarController.this.getModel().setIsPlaying(false);
                WindowComponent win = WindowComponent.getInstance();
                PlayBarController.this.getModel().setFrame(0);
                win.getApiMusic().stop();
                PlayBarController.this.sliderThread.interrupt();
                win.getPlayBarComponent().getView().getPlayBar().setValue(0);
            }
        }
    }

    public class DownloadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Download");

            // Downloads the song
        }
    }

    // Pour 'écouter' le temps de lecture du son et l'afficher sur la slider
    // Bonne idée. Mais la prochaine fois, let me know you wrote this ;)
    public class SoundTimeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            // TODO
        }

    }
}
