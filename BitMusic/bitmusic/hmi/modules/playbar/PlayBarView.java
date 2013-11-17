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
import javax.swing.JButton;

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

        final Dimension d = new Dimension(80, 20);

        this.playButton.setSize(d);
        this.stopButton.setSize(d);
        this.downloadButton.setSize(d);

         GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(this.stopButton)
                .addComponent(this.playButton)
                .addComponent(this.downloadButton))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
        );

        // TODO
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- PlayBarView.update()");
    }
}
