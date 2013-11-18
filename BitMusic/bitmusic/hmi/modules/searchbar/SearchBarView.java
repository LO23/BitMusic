/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.searchbar;

import bitmusic.hmi.patterns.AbstractView;
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
    private final JLabel searchLabel = new JLabel("Recherche...");
    private final JTextField searchField = new JTextField("Recherche...");
    private final JButton researchButton = new JButton("Rechercher");
    private final ButtonGroup groupeRadio = new ButtonGroup();
    private final JRadioButton aucunButton = new JRadioButton("Aucun", true),
                               titreButton = new JRadioButton("Par titre", false),
                               auteurButton = new JRadioButton("Par auteur", false),
                               tagButton = new JRadioButton("Par tag", false);



    public SearchBarView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- SearchBarView.initPanel()");

        Dimension d = new Dimension(80, 20);

        this.filtreLabel.setSize(d);
        this.researchButton.setSize(d);
        this.aucunButton.setSize(d);
        this.titreButton.setSize(d);
        this.auteurButton.setSize(d);
        this.tagButton.setSize(d);

        this.searchLabel.setSize(d);
        this.searchField.setColumns(10);

        this.researchButton.addActionListener(this.getController().new ResearchListener());

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

         layout.setHorizontalGroup(layout.createSequentialGroup()

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(searchLabel)
                    .addComponent(filtreLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(researchButton)
                     .addComponent(aucunButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(titreButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(auteurButton)
                )

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                      .addComponent(tagButton)
                )
                )
                /*.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                     .addComponent(searchField)
                     .addComponent(researchButton)
                     .addComponent(aucunButton)
                     .addComponent(titreButton)
                     .addComponent(auteurButton)
                     .addComponent(tagButton)

                )*/

        );
         layout.setVerticalGroup(layout.createSequentialGroup()

               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLabel)
                    .addComponent(searchField)
                    .addComponent(researchButton)
                    )
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(filtreLabel)
                    .addComponent(aucunButton)
                    .addComponent(titreButton)
                    .addComponent(auteurButton)
                    .addComponent(tagButton)
                    )
        );

         layout.linkSize(SwingConstants.HORIZONTAL, searchLabel, searchField, researchButton);
        layout.linkSize(SwingConstants.HORIZONTAL, filtreLabel, aucunButton, titreButton, auteurButton, tagButton);

    }

     public JLabel getfiltreLabel() {
        return this.filtreLabel;
    }

      public JLabel getsearchLabel() {
        return this.searchLabel;
    }

      public JButton getresearchButton() {
        return this.researchButton;
    }

      public JTextField getsearchField() {
        return this.searchField;
    }


    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- SearchBarView.update()");
    }
}
