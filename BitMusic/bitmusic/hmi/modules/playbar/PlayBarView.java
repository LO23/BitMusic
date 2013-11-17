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
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author unkedeuxke
 */
public final class PlayBarView extends AbstractView<PlayBarController> {

    private final String type = "SOUTH";
    // Ces boutons deviendront plutard des images cliquables
    private final JButton playButton = new JButton("Play");
    private final JButton stopButton = new JButton("Stop");
    private final JButton downloadButton = new JButton("Download");
    // TODO playing bar

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

        /*GridLayout layout = new GridLayout(0,2);
        this.getPanel().setLayout(layout);
        this.getPanel().add(this.stopButton);
        this.getPanel().add(this.playButton);
        this.getPanel().add(this.downloadButton);*/
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
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.stopButton)
                .addComponent(this.playButton)
                .addComponent(this.downloadButton))
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

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- PlayBarView.update()");
    }
}
