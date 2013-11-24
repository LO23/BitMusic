/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.patterns.AbstractModel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author unkedeuxke
 */
public final class ImportSongPopUpModel extends AbstractModel {

    private DefaultListModel listModel = new DefaultListModel();

    public ImportSongPopUpModel() {
        super();
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel listModel) {
        this.listModel = listModel;

        this.notifyObservers("SET_LIST_TAGS");
    }

    public void setListModel(ArrayList<String> listTags) {
        for ( int i=0; i<listTags.size(); i++ ){
            this.listModel.addElement(listTags.get(i));
        }

        this.notifyObservers("SET_LIST_TAGS");
    }

    public void addTag(String tag) {
        this.listModel.addElement(tag);
        this.notifyObservers("ADD_TAG");
    }

    public void removeTag(String tag) {
        boolean tagRemoved = false;
        for ( int i=0; i<listModel.size(); i++) {
            if (listModel.get(i).equals(tag)) {
                listModel.remove(i);
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

}
