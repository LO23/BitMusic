/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.patterns.Observable;
import bitmusic.hmi.patterns.AbstractView;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


/**
 *
 * @author unkedeuxke
 */
public final class SearchBarView extends AbstractView<SearchBarController> {

    private final String type = "NORTH";
    private final JLabel filtreLabel = new JLabel("Filtre :");
   // private final JLabel searchLabel = new JLabel("Recherche...");
    private JTextField searchField = new JTextField("");
    private final JButton researchButton = new JButton("Rechercher");
    private ButtonGroup groupeRadio = new ButtonGroup();
    private JRadioButton noneButton = new JRadioButton("Aucun", true);
    private JRadioButton titleButton = new JRadioButton("Par titre", false);
    private JRadioButton authorButton = new JRadioButton("Par auteur", false);
    private JRadioButton tagButton = new JRadioButton("Par tag", false);
    private JRadioButton albumButton = new JRadioButton("Par album", false);

    /**
     *
     */
    public SearchBarView() {
        super();
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- SearchBarView.initPanel()");

        Dimension d = new Dimension(80,20);

        //this.filtreLabel.setSize(d);
        this.researchButton.setSize(d);
        this.noneButton.setSize(d);
        this.titleButton.setSize(d);
        this.authorButton.setSize(d);
        this.tagButton.setSize(d);
        this.albumButton.setSize(d);

        //this.searchLabel.setSize(d);
        this.searchField.setColumns(10);

        groupeRadio.add(noneButton);
        groupeRadio.add(titleButton);
        groupeRadio.add(authorButton);
        groupeRadio.add(tagButton);
        groupeRadio.add(albumButton);

        this.researchButton.addActionListener(this.getController().new ResearchListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(searchField)
                .addComponent(filtreLabel)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(researchButton)
                .addComponent(noneButton)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(titleButton)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(authorButton)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(tagButton)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(albumButton)
            )

        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(searchField)
                .addComponent(researchButton)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(filtreLabel)
                .addComponent(noneButton)
                .addComponent(titleButton)
                .addComponent(authorButton)
                .addComponent(tagButton)
                .addComponent(albumButton)
            )
        );

        layout.linkSize(SwingConstants.HORIZONTAL,  searchField, researchButton);
        layout.linkSize(SwingConstants.HORIZONTAL, filtreLabel, noneButton, titleButton, authorButton, tagButton);
    }

    /**
     *
     * @return
     */
    public JTextField getSearchField() {
        return this.searchField;
    }

    /**
     *
     * @param searchField
     */
    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    /**
     *
     * @return
     */
    public ButtonGroup getGroupeRadio() {
        return this.groupeRadio;
    }

    /**
     *
     * @param groupeRadio
     */
    public void setGroupeRadio(ButtonGroup groupeRadio) {
        this.groupeRadio = groupeRadio;
    }

    /**
     *
     * @return
     */
    public JRadioButton getNoneButton() {
        return this.noneButton;
    }

    /**
     *
     * @return
     */
    public JRadioButton getTitleButton() {
        return this.titleButton;
    }

    /**
     *
     * @return
     */
    public JRadioButton getAuthorButton() {
        return this.authorButton;
    }

    /**
     *
     * @return
     */
    public JRadioButton getTagButton() {
        return this.tagButton;
    }

    /**
     *
     * @return
     */
    public JRadioButton getAlbumButton() {
        return this.albumButton;
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
     * @param obj
     * @param str
     */
    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- SearchBarView.update() -> " + str);
    }
}
