/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author delbouki
 * il manque le champs tags
 */
public final class EditSongPopUpView extends AbstractView<EditSongPopUpController> {

    private final String type = "POPUP";
    private final JLabel editSongLabel = new JLabel("Editer un morceau");
    private final JLabel titleLabel = new JLabel("Titre");
    private final JTextField titleField = new JTextField("");
    private final JLabel artisteLabel = new JLabel("Auteur");
    private final JTextField artisteField = new JTextField("");
    private final JLabel albumLabel = new JLabel("Album");
    private final JTextField albumField = new JTextField("");
    private final JLabel fileLabel = new JLabel("Fichier");
    private final JButton filebrowseButton = new JButton("Parcourir...");
    private final JButton validateButton = new JButton("Valider");
    private final JButton resetButton = new JButton("Réinitialiser");

    public EditSongPopUpView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- EditSongPopUpView.initPanel()");
        final Dimension d = new Dimension(80, 20);

        this.editSongLabel.setSize(d);
        this.titleLabel.setSize(d);
        this.titleField.setSize(d);
        this.artisteLabel.setSize(d);
        this.artisteField.setSize(d);
        this.albumLabel.setSize(d);
        this.albumField.setSize(d);
        this.fileLabel.setSize(d);
        this.filebrowseButton.setSize(d);
        this.validateButton.setSize(d);
        this.resetButton.setSize(d);
        //champs tags manquant

        filebrowseButton.addActionListener(this.getController().new fileBrowseListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(editSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(artisteLabel)
                    .addComponent(albumLabel)
                    .addComponent(fileLabel)
                    .addComponent(validateButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleField)
                    .addComponent(artisteField)
                    .addComponent(albumField)
                    .addComponent(filebrowseButton)
                    .addComponent(resetButton)
                )
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(editSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(artisteLabel)
                    .addComponent(artisteField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(albumLabel)
                    .addComponent(albumField)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fileLabel)
                    .addComponent(filebrowseButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(validateButton)
                    .addComponent(resetButton)
                )
        );
        layout.linkSize(SwingConstants.HORIZONTAL, titleLabel, titleField);
        layout.linkSize(SwingConstants.HORIZONTAL, artisteLabel, artisteField);
        layout.linkSize(SwingConstants.HORIZONTAL, albumLabel, albumField);
        layout.linkSize(SwingConstants.HORIZONTAL, fileLabel, filebrowseButton);

    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- EditSongPopUpView.update()");
    }
}
