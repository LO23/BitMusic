/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.ratesong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author unkedeuxke
 */
public final class RateSongPopUpView extends AbstractView<RateSongPopUpController> {

    private final String type = "POPUP";
    private final JLabel rateSongLabel = new JLabel("Noter un morceau");
    private final JButton validateButton = new JButton("Valider");
    private final JButton cancelButton = new JButton("Annuler");

    public RateSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- RateSongPopUpView.initPanel()");

        final Dimension d = new Dimension(80, 20);

        this.rateSongLabel.setSize(d);
        this.validateButton.setSize(d);
        this.cancelButton.setSize(d);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(rateSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(validateButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(rateSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(validateButton)
                    .addComponent(cancelButton)
                )
        );

        // TODO : étoiles de notation manquantes
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- RateSongPopUpView.update()");
    }
}
