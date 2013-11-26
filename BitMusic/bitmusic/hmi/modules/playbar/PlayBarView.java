/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.playbar;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
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
    private ImageIcon playIcon ;
    private JButton playButton;

    private ImageIcon stopIcon ;
    private JButton stopButton ;

    private ImageIcon downloadIcon ;
    private JButton downloadButton ;

    private ImageIcon pauseIcon;

    private JSlider playBar ;
    // TODO playing bar

    public PlayBarView() {
        super();

        playIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/playicon.png"));
        playButton = new JButton(playIcon);

        stopIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/stopicon.png"));
        stopButton = new JButton(stopIcon);

        downloadIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/downloadicon.png"));
        downloadButton = new JButton(downloadIcon);

        pauseIcon = new ImageIcon(this.getClass().getResource("/bitmusic/hmi/modules/playbar/icons/pauseicon.png"));

        playBar = new JSlider(0, 10, 0);


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

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- PlayBarView.update()");
    }


}
