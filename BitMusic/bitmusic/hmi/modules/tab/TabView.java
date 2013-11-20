/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author unkedeuxke
 */
public final class TabView extends AbstractView<TabController> {

    private final String type = "TAB";

    public TabView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- TabView.initPanel()");

        JPanel jPanel = this.getPanel();
        //Ajouter tout à ce panel !

        JLabel filler = new JLabel("Affichage...");
        //filler.setHorizontalAlignment(JLabel.CENTER);
        //jPanel.setLayout(new GridLayout(1, 1));
        jPanel.add(filler);

    }

    @Override
    public String getType() {
       return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- TabView.update()");
    }
}
