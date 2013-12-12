/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.tab;

import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.ButtonColumn;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author unkedeuxke
 */
public final class TabView extends AbstractView<TabController> {

    private final String type = "TAB";

    private Integer tabId;

    private String title;
    private JLabel labelTitle;
    private JButton btnClose = new JButton("x");
    private JPanel panelTab;

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration

    /**
     *
     */
    public TabView() {
        super();
    }

    /**
     *
     */
    @Override
    public void initPanel() {
        System.out.println("--- TabView.initPanel()");

        Integer nextTabId = WindowComponent.getInstance().getCentralAreaComponent().getView().getTabCounter();

        // Initialisation de l'ID de l'onglet
        this.tabId = nextTabId;

        // Initialisation du titre de l'onglet
        this.title = "Tab#" + nextTabId;
        this.labelTitle = new JLabel(title);

        // Attache du listener pour supprimer cet onglet
        this.btnClose.addActionListener(this.getController().new CloseTabListener());

        // Création et gestion de l'onglet en lui-même (petite partie du haut)
        this.panelTab = new JPanel(new GridBagLayout());
        panelTab.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        this.panelTab.add(this.labelTitle, gbc);
        gbc.gridx++;
        gbc.weightx = 0;
        panelTab.add(this.btnClose, gbc);

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable(this.getController().getModel().getModeleTable());
        jTable1.addMouseListener(this.getController().new DoubleClickListener());
        jScrollPane1.setViewportView(jTable1);


        // Attache des listeners aux colonnes concernées
        ButtonColumn editerColumn = new ButtonColumn(this.jTable1, this.getController().getEditer(), 3);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
        ButtonColumn supprimerColumn = new ButtonColumn(this.jTable1, this.getController().getSupprimer(), 4);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(5);
        ButtonColumn infosColumn = new ButtonColumn(this.jTable1, this.getController().getInfos(), 5);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
        ButtonColumn noterColumn = new ButtonColumn(this.jTable1, this.getController().getNoter(), 6);
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(5);
        ButtonColumn sauvegarderColumn = new ButtonColumn(this.jTable1, this.getController().getSauvegarder(), 7);
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(5);
        // Il faut peut-être une colonne pour commenter ?

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        this.getPanel().setPreferredSize(new Dimension(800, 400));

    }

    /**
     *
     * @return
     */
    public String getTitle() {
       return this.title;
    }

    /**
     *
     * @param newTitle
     */
    public void setTitle(final String newTitle) {
       this.title = newTitle;
    }

    /**
     *
     * @return
     */
    public JLabel getLabelTitle() {
        return this.labelTitle;
    }

    /**
     *
     * @param newLabelTitle
     */
    public void setLabelTitle(final JLabel newLabelTitle) {
        this.labelTitle = newLabelTitle;
    }

    /**
     *
     * @return
     */
    public JButton getBtnClose() {
        return this.btnClose;
    }

    /**
     *
     * @param newBtnClose
     */
    public void setBtnClose(final JButton newBtnClose) {
        this.btnClose = newBtnClose;
    }

    /**
     *
     * @return
     */
    public JPanel getPanelTab() {
        return this.panelTab;
    }

    /**
     *
     * @param newPanelTab
     */
    public void setPanelTab(final JPanel newPanelTab) {
        this.panelTab = newPanelTab;
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
        System.out.println("----- TabView.update() -> " + str);

        // On "force" l'actualisation immédiate du TableModel (utile dans le cas d'un clic sur "MySongs" juste après le lancement de l'application)
        this.getController().getModel().getModeleTable().fireTableDataChanged();
    }

    /**
     *
     * @return
     */
    public Integer getTabId() {
        return this.tabId;
    }

    /**
     *
     * @param tabId
     */
    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    /**
     *
     * @return
     */
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     *
     * @param jScrollPane1
     */
    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     *
     * @return
     */
    public JTable getjTable1() {
        return jTable1;
    }

    /**
     *
     * @param jTable1
     */
    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }


}
