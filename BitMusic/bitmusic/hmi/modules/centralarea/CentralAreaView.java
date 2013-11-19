/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.centralarea;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.Observable;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author unkedeuxke
 */
public final class CentralAreaView extends AbstractView<CentralAreaController> {

    private static final String type = "CENTER";

    public CentralAreaView() {
        super();
    }

    @Override
    public void initPanel() {
        System.out.println("--- CentralAreaView.initPanel()");

        JTabbedPane tabbedPane = new JTabbedPane();


        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Tab 1", null, panel1,
                "Does nothing");


        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", null, panel2,
                "Does twice as much nothing");


        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", null, panel3,
                "Still does nothing");


        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        //panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", null, panel4,
                "Does nothing at all");


        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        this.getPanel().add(tabbedPane);
        // TODO
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }



    @Override
    public String getType() {
        return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- CentralAreaView.update()");
    }
}
