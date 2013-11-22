/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmusic.hmi.modules.onlineusers;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Kevin
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
    @Override
    public JButton getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocus, int row, int col) {
        this.setEnabled(true);
        this.setFocusable(false);
        this.setFocusPainted(true);
        String valeur = ((AbstractButton) value).getText();
        this.setText((value != null) ? valeur : "");

        return this;
    }
}
