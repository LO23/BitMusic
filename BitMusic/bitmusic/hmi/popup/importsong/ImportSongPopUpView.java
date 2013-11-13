/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author unkedeuxke
 */
public final class ImportSongPopUpView extends AbstractView<ImportSongPopUpController> {

    private final String type = "CENTER";
    private final JLabel importSongLabel = new JLabel("Importer un morceau");
    private final JLabel titleLabel = new JLabel("Titre (*)");
    private final JTextField titleField = new JTextField("");
    private final JLabel artistLabel = new JLabel("Artiste (*)");
    private final JTextField artistField = new JTextField("");
    private final JLabel albumLabel = new JLabel("Album");
    private final JTextField albumField = new JTextField("");
    private final JLabel fileLabel  = new JLabel("Fichier (*)");
    private final JLabel tagLabel = new JLabel("Tags");
    private final JLabel infoLabel = new JLabel("*Champs obligatoires");
    private final JButton fileBrowseButton = new JButton("Parcourir...");
    private final JButton submitButton = new JButton("Soumettre");
    private final JButton cancelButton = new JButton("Annuler");

    private ImportSongDynamicObject modeleTable = new ImportSongDynamicObject();
    private JTable table = new JTable(this.modeleTable);
    private JScrollPane tagsTablePane;

    public ImportSongPopUpView() {
        super();
    }

        @Override
    public void initPanel() {
        System.out.println("--- ImportSongPopUpView.initPanel()");

        Dimension d = new Dimension(80, 20);

        this.importSongLabel.setSize(d);

        this.titleLabel.setSize(d);
        this.titleField.setColumns(10);

        this.artistLabel.setSize(d);
        this.artistField.setColumns(10);

        this.albumLabel.setSize(d);
        this.albumField.setColumns(10);

        this.fileLabel.setSize(d);
        this.fileBrowseButton.setSize(d);
        this.fileBrowseButton.addActionListener(this.getController().new FileBrowseListener());

        this.tagLabel.setSize(d);
        this.tagsTablePane = new JScrollPane(this.table);

        this.submitButton.setSize(d);

        this.cancelButton.setSize(d);

        this.infoLabel.setSize(d);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(importSongLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(artistLabel)
                    .addComponent(albumLabel)
                    .addComponent(fileLabel)
                    .addComponent(tagLabel)
                    .addComponent(submitButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(titleField)
                    .addComponent(artistField)
                    .addComponent(albumField)
                    .addComponent(fileBrowseButton)
                    .addComponent(tagsTablePane)
                    .addComponent(cancelButton)
                )
                .addComponent(infoLabel)

        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
               .addComponent(importSongLabel)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(artistLabel)
                    .addComponent(artistField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(albumLabel)
                    .addComponent(albumField)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fileLabel)
                    .addComponent(fileBrowseButton)
               )
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tagLabel)
                    .addComponent(tagsTablePane)
               )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton)
               )
               .addComponent(infoLabel)

        );

        layout.linkSize(SwingConstants.HORIZONTAL, titleLabel, titleField);
        layout.linkSize(SwingConstants.HORIZONTAL, artistLabel, artistField);
        layout.linkSize(SwingConstants.HORIZONTAL, albumLabel, albumField);
        layout.linkSize(SwingConstants.HORIZONTAL, fileLabel, fileBrowseButton);
        layout.linkSize(SwingConstants.HORIZONTAL, tagLabel, tagsTablePane);
        layout.linkSize(SwingConstants.HORIZONTAL, submitButton, cancelButton);

        // TO FINISH AND TEST
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- ImportSongPopUpView.update()");
    }
}
