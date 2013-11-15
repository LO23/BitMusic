/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.popup.importsong;

import bitmusic.hmi.patterns.AbstractModel;
import java.util.ArrayList;

/**
 *
 * @author unkedeuxke
 */
public final class ImportSongPopUpModel extends AbstractModel {

    private ImportSongDynamicObject modeleTable = new ImportSongDynamicObject();

    public ImportSongPopUpModel() {
        super();
    }

    public void addTag(String user) {
        ArrayList<String> listTags = this.modeleTable.getListTags();

        listTags.add(user);
        this.notifyObservers("ADD_TAG");
    }

    public void removeTag(String tag) {
        ArrayList<String> listTags = this.modeleTable.getListTags();

        boolean tagRemoved = false;
        String tempTag;
        for ( int i=0; i<listTags.size(); i++) {
            tempTag = listTags.get(i);
            if (listTags.get(i).equals(tempTag)) {
                listTags.remove(i);
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

    public ArrayList<String> getListTags() {
        return this.modeleTable.getListTags();
    }

    public void setListTags(ArrayList<String> listTags) {
        this.modeleTable.setListTags(listTags);
    }

    public ImportSongDynamicObject getModeleTable() {
        return modeleTable;
    }

    public void setModeleTable(ImportSongDynamicObject modeleTable) {
        this.modeleTable = modeleTable;
    }
}
