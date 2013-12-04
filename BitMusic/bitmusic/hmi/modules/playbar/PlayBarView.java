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

    private JSlider playBar = new JSlider(0, 1);

    public PlayBarView() {
        super();
   }

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


        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(this.stopButton)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.playButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.downloadButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(this.playBar))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.stopButton)
                .addComponent(this.playButton)
                .addComponent(this.downloadButton)
                .addComponent(this.playBar))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, this.playButton, this.stopButton);
        layout.linkSize(SwingConstants.HORIZONTAL, this.playButton, this.downloadButton);

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JButton getDownloadButton() {
        return downloadButton;
    }

    public ImageIcon getPlayIcon() {
        return playIcon;
    }

    public void setPlayIcon(ImageIcon playIcon) {
        this.playIcon = playIcon;
        this.playButton.setIcon(this.playIcon);
    }

    public ImageIcon getStopIcon() {
        return stopIcon;
    }

    public void setStopIcon(ImageIcon stopIcon) {
        this.stopIcon = stopIcon;
    }

    public ImageIcon getDownloadIcon() {
        return downloadIcon;
    }

    public void setDownloadIcon(ImageIcon downloadIcon) {
        this.downloadIcon = downloadIcon;
    }

    public ImageIcon getPauseIcon() {
        return pauseIcon;
    }

    public void setPauseIcon(ImageIcon pauseIcon) {
        this.pauseIcon = pauseIcon;
    }

    public JSlider getPlayBar() {
        return playBar;
    }

    public void setPlayBar(JSlider playBar) {
        this.playBar = playBar;
    }



    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- PlayBarView.update()");
        if ( this.getController().getModel().isPlaying() ) {
            //Si c'est en lecture : on affiche le bouton pause
            this.playButton.setIcon(pauseIcon);
        }
        else {
            //si c'est pas en lecture on affiche le bouton play
            this.playButton.setIcon(playIcon);
        }
    }


}
