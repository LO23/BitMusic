/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hebergui <hebergui.utc@gmail.com>
 */
public class ImportSongDynamicObject extends AbstractTableModel {

    private ArrayList<String> listTags = new ArrayList<>();
    private final String[] header = {"Tags"};

    public ImportSongDynamicObject() {
        super();
        this.listTags.add("Tag1");
        this.listTags.add("Tag2");
    }

    @Override
    public int getRowCount() {
        return this.listTags.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.listTags.get(rowIndex);
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addTag(String tag) {
        this.listTags.add(tag);

        fireTableRowsInserted(this.listTags.size() -1, this.listTags.size() -1);
    }

    public void removeTag(int rowIndex) {
        this.listTags.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void removeAllTags() {
        for (int i=0; i<this.listTags.size(); i++)
            this.removeTag(i);
    }

    public ArrayList<String> getListTags() {
        return this.listTags;
    }

    public void setListTags(ArrayList<String> listTags) {
        this.removeAllTags();
        this.listTags = listTags;
    }

}
