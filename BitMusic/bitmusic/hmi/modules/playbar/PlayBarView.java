/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarView extends AbstractView<PlayBarController> {

    private final String type = "SOUTH";
    // Ces boutons deviendront plutard des images cliquables
    private ImageIcon playIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/playicon.png"));
    private JButton  playButton = new JButton(playIcon);

    private ImageIcon stopIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/stopicon.png"));
    private JButton stopButton = new JButton(stopIcon);

    private ImageIcon downloadIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/downloadicon.png"));
    private JButton downloadButton = new JButton(downloadIcon);

    private ImageIcon pauseIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/pauseicon.png"));

    private JLabel currentSong = new JLabel("Aucune musique chargée...");

    private JSlider playBar = new JSlider(0, 1);

    /**
     *
     */
    public PlayBarView() {
        super();
   }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- PlayBarView.initPanel()");

        final Dimension d = new Dimension(40, 10);

        this.playButton.setSize(d);
        this.stopButton.setSize(d);
        this.downloadButton.setSize(d);

        /*playButton.setBorder(BorderFactory.createEmptyBorder());
        stopButton.setBorder(BorderFactory.createEmptyBorder());
        downloadButton.setBorder(BorderFactory.createEmptyBorder());*/
        downloadButton.setContentAreaFilled(false);
        playButton.setContentAreaFilled(false);
        stopButton.setContentAreaFilled(false);


        this.playButton.addActionListener(getController().new PlayListener());
        this.stopButton.addActionListener(getController().new StopListener());
        this.downloadButton.addActionListener(getController().new DownloadListener());
        this.playBar.addMouseListener(getController().new CursorListener());


        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.stopButton)
                .addComponent(this.playButton)
                .addComponent(this.downloadButton)
                .addComponent(this.playBar))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.currentSong))
        );

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.stopButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.playButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.downloadButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(this.playBar)
                .addComponent(this.currentSong))
            );

    }

    /**
     *
     * @return
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     *
     * @return
     */
    public JButton getPlayButton() {
        return playButton;
    }

    /**
     *
     * @return
     */
    public JButton getStopButton() {
        return stopButton;
    }

    /**
     *
     * @return
     */
    public JButton getDownloadButton() {
        return downloadButton;
    }

    /**
     *
     * @return
     */
    public ImageIcon getPlayIcon() {
        return playIcon;
    }

    /**
     *
     * @param playIcon
     */
    public void setPlayIcon(ImageIcon playIcon) {
        this.playIcon = playIcon;
        this.playButton.setIcon(this.playIcon);
    }

    /**
     *
     * @return
     */
    public ImageIcon getStopIcon() {
        return stopIcon;
    }

    /**
     *
     * @param stopIcon
     */
    public void setStopIcon(ImageIcon stopIcon) {
        this.stopIcon = stopIcon;
    }

    /**
     *
     * @return
     */
    public ImageIcon getDownloadIcon() {
        return downloadIcon;
    }

    /**
     *
     * @param downloadIcon
     */
    public void setDownloadIcon(ImageIcon downloadIcon) {
        this.downloadIcon = downloadIcon;
    }

    /**
     *
     * @return
     */
    public ImageIcon getPauseIcon() {
        return pauseIcon;
    }

    /**
     *
     * @param pauseIcon
     */
    public void setPauseIcon(ImageIcon pauseIcon) {
        this.pauseIcon = pauseIcon;
    }

    /**
     *
     * @return
     */
    public JSlider getPlayBar() {
        return playBar;
    }

    /**
     *
     * @param playBar
     */
    public void setPlayBar(JSlider playBar) {
        this.playBar = playBar;
    }

    /**
     *
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- PlayBarView.update() -> " + str);
        PlayBarModel model = this.getController().getModel();
        String text = model.getSong().getArtist() + " - " + model.getSong().getTitle();
        this.currentSong.setText(text);
        if ( model.isPlaying() ) {
            //Si c'est en lecture : on affiche le bouton pause
            this.playButton.setIcon(pauseIcon);
        }
        else {
            //si c'est pas en lecture on affiche le bouton play
            this.playButton.setIcon(playIcon);
        }
    }


}
