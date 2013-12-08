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


    public SearchBarView() {
        super();
    }

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

        //this.searchLabel.setSize(d);
        this.searchField.setColumns(10);

        groupeRadio.add(noneButton);
        groupeRadio.add(titleButton);
        groupeRadio.add(authorButton);
        groupeRadio.add(tagButton);

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
            )
        );

        layout.linkSize(SwingConstants.HORIZONTAL,  searchField, researchButton);
        layout.linkSize(SwingConstants.HORIZONTAL, filtreLabel, noneButton, titleButton, authorButton, tagButton);
    }

    public JTextField getSearchField() {
        return this.searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public ButtonGroup getGroupeRadio() {
        return this.groupeRadio;
    }

    public void setGroupeRadio(ButtonGroup groupeRadio) {
        this.groupeRadio = groupeRadio;
    }

    public JRadioButton getNoneButton() {
        return this.noneButton;
    }

    public JRadioButton getTitleButton() {
        return this.titleButton;
    }

    public JRadioButton getAuthorButton() {
        return this.authorButton;
    }

    public JRadioButton getTagButton() {
        return this.tagButton;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- SearchBarView.update() -> " + str);
    }
}
