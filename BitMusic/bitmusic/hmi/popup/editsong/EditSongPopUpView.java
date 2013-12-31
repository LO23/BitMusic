/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.editsong;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import bitmusic.music.data.Song;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * View class of EditSongPopUp
 * @author IHM
 */
public final class EditSongPopUpView extends AbstractView<EditSongPopUpController> {

    private final String type = "POPUP";
    private final int parentTabId;
    private final JLabel importSongLabel = new JLabel("<html><u>Editer un morceau</u></html>");
    private final JLabel titleLabel = new JLabel("Titre (*)");
    private JTextField titleField = new JTextField("");
    private final JLabel artistLabel = new JLabel("Artiste (*)");
    private JTextField artistField = new JTextField("");
    private final JLabel albumLabel = new JLabel("Album");
    private JTextField albumField = new JTextField("");
    private final JLabel fileLabel  = new JLabel("Fichier (*)");
    private JTextField fileField = new JTextField("");
    private final JLabel tagLabel = new JLabel("Tags");
    private final JButton fileBrowseButton = new JButton("Parcourir...");
    private final JButton editButton = new JButton("Editer");
    private final JButton cancelButton = new JButton("Annuler");
    private JTextField newTagField = new JTextField("");
    private JButton addTagButton = new JButton("Ajouter");
    private JLabel infoClickLabel = new JLabel("(ctrl+clic : sélectionner plusieurs tags)");
    private final JLabel infoLabel = new JLabel("(*) Champs obligatoires");

    private ArrayList<JTextField> listCompulsoryFields = new ArrayList();

    private JList tagList = new JList();
    private JScrollPane tagsTablePane = new JScrollPane(this.tagList);

    /**
     * Constructor of EditSongPopUpView
     * @param parentTabId
     */
    public EditSongPopUpView(int parentTabId) {
        super();
        this.parentTabId = parentTabId;
    }

    /**
     * Initializes the view of EditSongPopUp
     */
    @Override
    public void initPanel() {
        System.out.println("--- EditSongPopUpView.initPanel()");

        Song song = this.getController().getModel().getSong();
        DefaultListModel listTagsModel = this.getController().getModel().getListModel();

        this.titleField.setText(song.getTitle());
        this.artistField.setText(song.getArtist());
        this.fileField.setText(WindowComponent.getInstance().getApiMusic().getSongFile(song.getSongId()));
        this.albumField.setText(song.getAlbum());
        this.tagList.setModel(listTagsModel);
        this.tagsTablePane.setViewportView(this.tagList);

        this.listCompulsoryFields.add(titleField);
        this.listCompulsoryFields.add(artistField);
        this.listCompulsoryFields.add(fileField);

        this.fileBrowseButton.addActionListener(this.getController().new FileBrowseListener());
        this.cancelButton.addActionListener(this.getController().new CancelListener());
        this.editButton.addActionListener(this.getController().new EditListener());
        this.addTagButton.addActionListener(this.getController().new AddNewTagListener());
        this.fileField.setEditable(false);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addComponent(artistLabel)
                            .addComponent(albumLabel)
                            .addComponent(fileLabel)
                            .addComponent(tagLabel)
                            .addComponent(infoLabel))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(newTagField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addTagButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleField)
                                    .addComponent(artistField)
                                    .addComponent(albumField)
                                    .addComponent(fileField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(fileBrowseButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(infoClickLabel)
                                    .addComponent(tagsTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(importSongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importSongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(artistLabel)
                    .addComponent(artistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(albumLabel)
                    .addComponent(albumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileLabel)
                    .addComponent(fileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileBrowseButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tagLabel)
                    .addComponent(newTagField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTagButton))
                .addGap(18, 18, 18)
                .addComponent(tagsTablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoClickLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(cancelButton)
                    .addComponent(infoLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    /**
     * Returns the type of the PopUp
     * The type of the PopUp refers to its location in the screen
     * @return type
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Shows a message of update on the console
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- EditSongPopUpView.update() -> " + str);

        this.tagList.setModel(this.getController().getModel().getListModel());
        this.tagsTablePane.setViewportView(this.tagList);
    }

    /**
     * Returns the title of a song
     * @return JTextField titleField
     */
    public JTextField getTitleField() {
        return titleField;
    }

    /**
     * Updates the title of a song
     * @param titleField
     */
    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
    }

    /**
     * Returns the artist of a song
     * @return artistField
     */
    public JTextField getArtistField() {
        return artistField;
    }

    /**
     * Updates the artist of a song
     * @param artistField
     */
    public void setArtistField(JTextField artistField) {
        this.artistField = artistField;
    }

    /**
     * Returns the title of an album
     * @return albumField
     */
    public JTextField getAlbumField() {
        return albumField;
    }

    /**
     * Updates the title of an album
     * @param albumField
     */
    public void setAlbumField(JTextField albumField) {
        this.albumField = albumField;
    }

    /**
     * Returns the path of the new song
     * @return JTextField fileField
     */
    public JTextField getFileField() {
        return fileField;
    }

    /**
     * Updates the path of a song
     * @param fileField
     */
    public void setFileField(JTextField fileField) {
        this.fileField = fileField;
    }

    /**
     * Returns a tag of a song
     * @return newTagField
     */
    public JTextField getNewTagField() {
        return newTagField;
    }

    /**
     * Updates a tag of a song
     * @param newTagField
     */
    public void setNewTagField(JTextField newTagField) {
        this.newTagField = newTagField;
    }

    /**
     * Returns the add tag button
     * @return JButton AddTagButton
     */
    public JButton getAddTagButton() {
        return addTagButton;
    }

    /**
     * Updates the add tag button
     * @param addTagButton
     */
    public void setAddTagButton(JButton addTagButton) {
        this.addTagButton = addTagButton;
    }

    /**
     * Returns informations about tags
     * @return infoClickLabel
     */
    public JLabel getInfoClickLabel() {
        return infoClickLabel;
    }

    /**
     * Updates informations about tags
     * @param infoClickLabel
     */
    public void setInfoClickLabel(JLabel infoClickLabel) {
        this.infoClickLabel = infoClickLabel;
    }

    /**
     * Returns a list of compulsory fields
     * @return listCompulsoryFields
     */
    public ArrayList<JTextField> getListCompulsoryFields() {
        return listCompulsoryFields;
    }

    /**
     * Updates a list of compulsory fields
     * @param listCompulsoryFields
     */
    public void setListCompulsoryFields(ArrayList<JTextField> listCompulsoryFields) {
        this.listCompulsoryFields = listCompulsoryFields;
    }

    /**
     * Returns a tag list
     * @return tagList
     */
    public JList getTagList() {
        return tagList;
    }

    /**
     * Updates a tag list
     * @param tagList
     */
    public void setTagList(JList tagList) {
        this.tagList = tagList;
    }

    /**
     *
     * @return tagsTablePane
     */
    public JScrollPane getTagsTablePane() {
        return tagsTablePane;
    }

    /**
     * Updates the scroll pane
     * @param tagsTablePane
     */
    public void setTagsTablePane(JScrollPane tagsTablePane) {
        this.tagsTablePane = tagsTablePane;
    }

    /**
     * Returns the parent id of the current tab
     * @return parentTabId
     */
    public int getParentTabId() {
        return parentTabId;
    }
}
