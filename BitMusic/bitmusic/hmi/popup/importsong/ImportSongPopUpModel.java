/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.patterns.AbstractModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
public final class ImportSongPopUpModel extends AbstractModel {

    private ImportSongDynamicObject modeleTable = new ImportSongDynamicObject();

    public ImportSongPopUpModel() {
        super();
    }

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

    public void addTag(String tag) {
        this.modeleTable.addTag(tag);
        this.notifyObservers("ADD_TAG");
    }

    public void removeTag(String tagId) {
        ArrayList<String> listAllTags = this.modeleTable.getListTags();

        boolean tagRemoved = false;
        for ( int i=0; i<listAllTags.size(); i++) {
            if (listAllTags.get(i).equals(tagId)) {
                listAllTags.remove(i);
                tagRemoved = true;
            }
        }

        if (tagRemoved == true) {
            this.notifyObservers("REMOVE_TAG");
        }
        else {
            System.out.println("--- Error: Tag doesn't exist");
        }
    }

    public void setListTags(ArrayList<String> listTags) {
        this.modeleTable.setListTags(listTags);
        this.notifyObservers("SET_LIST_TAGS");
    }

    public ImportSongPopUpModel.ImportSongDynamicObject getModeleTable() {
        return this.modeleTable;
    }

    public void setModeleTable(ImportSongPopUpModel.ImportSongDynamicObject modeleTable) {
        this.modeleTable = modeleTable;
    }

}
