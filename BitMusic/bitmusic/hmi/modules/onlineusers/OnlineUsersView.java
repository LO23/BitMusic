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
import javax.swing.table.DefaultTableModel;

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

    Action delete = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- delete détecté !!!");
            JTable table = (JTable)e.getSource();
            int modelRow = Integer.valueOf( e.getActionCommand() );
            ((DefaultTableModel)table.getModel()).removeRow(modelRow);
        }
    };

    @Override
    public void initPanel() {
        System.out.println("--- OnlineUsersView.initPanel()");

        Dimension d = new Dimension(80, 20);
        this.onlineUsersLabel.setSize(d);

        this.table = new JTable(this.getController().getModel().getModeleTable());

        ButtonColumn infosColumn = new ButtonColumn(this.table, this.delete, 1);
        ButtonColumn mp3Column = new ButtonColumn(this.table, this.delete, 2);

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
        this.table.setModel(this.getController().getModel().getModeleTable());
        this.onlineUsersTablePane.setViewportView(this.table);
    }
}