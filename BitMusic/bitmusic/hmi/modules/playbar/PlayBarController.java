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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    /**
     *
     * @param model
     * @param view
     */
    public PlayBarController(final PlayBarModel model, final PlayBarView view) {
        super(model, view);
    }

    /**
     *
     */
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
                        PlayBarController.this.sliderUpdater(win);
                    }
                };
                PlayBarController.this.startThread(r);
            }
        }
    }

    public void sliderUpdater(WindowComponent win) {
        JSlider playBar = win.getPlayBarComponent().getView().getPlayBar();
        playBar.setMaximum(win.getApiMusic().getNumberOfFrame());
        while( PlayBarController.this.getModel().isPlaying() ) {
            playBar.setValue(win.getApiMusic().getCurrentFrame());
        }
    }

    public void startThread(Runnable r) {
        //PlayBarController.this.sliderThread.interrupt();
        PlayBarController.this.sliderThread = new Thread(r);
        PlayBarController.this.sliderThread.setName("SliderThread");
        PlayBarController.this.sliderThread.setPriority(Thread.MAX_PRIORITY);
        PlayBarController.this.sliderThread.start();
    }

    /**
     *
     */
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

    /**
     *
     */
    public class DownloadListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Download");

            // Downloads the song
        }
    }

    // Pour 'écouter' le temps de lecture du son et l'afficher sur la slider

    /**
     *
     */

    public class SoundTimeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            // TODO
        }

    }

    /**
     *
     */
    public class CursorListener implements MouseListener {

        final WindowComponent win = WindowComponent.getInstance();

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        // move the slider to the value that a user clicks on and plays from that
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("---- Mouse pressed on Slider");
            JSlider playBar = win.getPlayBarComponent().getView().getPlayBar();
            double p = e.getPoint().getX();
            double percent = p / ((double) playBar.getWidth());
            int range = playBar.getMaximum() - playBar.getMinimum();
            double newVal = range * percent;
            int result = (int)(playBar.getMinimum() + newVal);

            if ( !PlayBarController.this.getModel().isPlaying() ) {
                PlayBarController.this.getModel().setIsPlaying(true);
                Runnable r = new Runnable() {
                    public void run() {
                        PlayBarController.this.sliderUpdater(win);
                    }
                };
                PlayBarController.this.startThread(r);
            }

            win.getApiMusic().playSongFromSpecificFrame(result);
            System.out.println("---- Result = " + result +"\n");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }
}
