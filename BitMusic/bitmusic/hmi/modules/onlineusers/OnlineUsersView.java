/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.onlineusers;

import bitmusic.hmi.patterns.AbstractView;
import bitmusic.hmi.patterns.ButtonColumn;
import bitmusic.hmi.patterns.Observable;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author unkedeuxke
 */
public final class OnlineUsersView extends AbstractView<OnlineUsersController> {

    private final String type = "EAST";

    private final JLabel onlineUsersLabel = new JLabel("En ligne :");
    private JTable table;
    private JScrollPane onlineUsersTablePane;

    public OnlineUsersView() {
        super();
    }

    Action infos = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Infos detected !!!");
            /*JTable table = (JTable)e.getSource();
            int modelRow = Integer.valueOf( e.getActionCommand() );
            ((DefaultTableModel)table.getModel()).removeRow(modelRow);*/
        }
    };

    Action mp3 = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- MP3 detected !!!");
            /*JTable table = (JTable)e.getSource();
            int modelRow = Integer.valueOf( e.getActionCommand() );
            ((DefaultTableModel)table.getModel()).removeRow(modelRow);*/
        }
    };

    @Override
    public void initPanel() {
        System.out.println("--- OnlineUsersView.initPanel()");

        Dimension d = new Dimension(80, 20);
        this.onlineUsersLabel.setSize(d);

        // Initialisation de la JTable avec le OnlineUsersTableModel du Model
        this.table = new JTable(this.getController().getModel().getModeleTable());

        // Attache des listeners aux colonnes concernées
        ButtonColumn infosColumn = new ButtonColumn(this.table, this.infos, 1);
        ButtonColumn mp3Column = new ButtonColumn(this.table, this.mp3, 2);

        this.onlineUsersTablePane = new JScrollPane(this.table);

        GroupLayout layout = new GroupLayout(this.getPanel());
        this.getPanel().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(onlineUsersLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(onlineUsersTablePane)
                )
         );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
               .addComponent(onlineUsersLabel)
               .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(onlineUsersTablePane)
               )
        );
    }

    @Override
    public String getType() {
       return type;
    }

    @Override
    public void update(Observable obj, String str) {
        System.out.println("----- OnlineUsersView.update() : " + str);
        this.onlineUsersTablePane.setViewportView(this.table);
    }
}